package jsta586.dao;

import jsta586.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CustomerDAO extends JpaRepository<Customer, Long> {


}
