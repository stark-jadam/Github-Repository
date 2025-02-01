package jsta586.dao;

import jsta586.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CartDAO extends JpaRepository<Cart, Long> {


}
