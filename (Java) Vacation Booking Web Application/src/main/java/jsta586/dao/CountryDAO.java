package jsta586.dao;

import jsta586.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CountryDAO extends JpaRepository<Country, Long> {

}
