package jsta586.dao;

import jsta586.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ExcursionDAO extends JpaRepository<Excursion, Long> {


}
