package jsta586.services;

import jakarta.transaction.Transactional;
import jsta586.dao.CartDAO;
import jsta586.dao.CustomerDAO;
import jsta586.entities.Cart;
import jsta586.entities.CartItem;
import jsta586.entities.Customer;
import jsta586.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerDAO customerDAO;
    private CartDAO cartDAO;

    @Autowired
    public CheckoutServiceImpl(CustomerDAO customerDAO, CartDAO cartDAO){

       this.cartDAO = cartDAO;
       this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        //retrieve cart info from dto
        Cart cart = purchase.getCart();

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cartItems
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));

        //populate cart with cartItem and customer
        cart.setCartItem(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        //set cart status to 'ordered'
        cart.setStatus(StatusType.ordered);

        //populate customer with cart
        Customer customer = purchase.getCustomer();
        customer.add(cart);

        //if statement to return empty cart message if no cart items added to purchase
        if(purchase.getCartItems().isEmpty()) {

            return new PurchaseResponse("Cart is Empty");
        }
        //if cart is not empty, saves the cart to db and returns an order tracking number
        else{
            //save to database
            cartDAO.save(cart);

            //return response
            return new PurchaseResponse(orderTrackingNumber);
        }
    }

    private String generateOrderTrackingNumber() {


        //Generate random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
