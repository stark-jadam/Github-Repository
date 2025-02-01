package jsta586.dao;

import jsta586.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VacationDAO extends JpaRepository<Vacation, Long> {


}
