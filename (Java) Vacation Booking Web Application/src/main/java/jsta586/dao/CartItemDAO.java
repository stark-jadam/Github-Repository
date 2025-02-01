package jsta586.dao;

import jsta586.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartItemDAO extends JpaRepository<CartItem, Long>{

}
