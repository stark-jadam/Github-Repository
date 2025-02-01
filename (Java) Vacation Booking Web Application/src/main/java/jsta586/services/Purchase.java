package jsta586.services;

import jsta586.entities.Cart;
import jsta586.entities.CartItem;
import jsta586.entities.Customer;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;


}
