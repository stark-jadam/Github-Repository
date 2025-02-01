package jsta586.dao;

import jsta586.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DivisionDAO extends JpaRepository<Division, Long> {


}
