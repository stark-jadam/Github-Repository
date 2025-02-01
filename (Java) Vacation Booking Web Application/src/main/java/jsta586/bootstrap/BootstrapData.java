package jsta586.bootstrap;


import jsta586.dao.CustomerDAO;
import jsta586.dao.DivisionDAO;
import jsta586.entities.Customer;
import jsta586.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerDAO customerDAO;
    private final DivisionDAO divisionDAO;


    public BootstrapData(CustomerDAO customerDAO, DivisionDAO divisionDAO){
        this.customerDAO = customerDAO;
        this.divisionDAO = divisionDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        //Creates 5 customers, pulls 5 Divisions from database

        Division division1 = divisionDAO.findById(3L).orElse(null);
        Division division2 = divisionDAO.findById(15L).orElse(null);
        Division division3 = divisionDAO.findById(6L).orElse(null);
        Division division4 = divisionDAO.findById(31L).orElse(null);
        Division division5 = divisionDAO.findById(42L).orElse(null);

        Customer jason = new Customer("Jason", "Michaels",
                "1616 Burberry Lane", "89234", "684-888-2552", division1);

        Customer peter = new Customer("Peter", "Matthews",
                "9090 Sycamore Lane", "67234", "493-843-9077", division2);

        Customer beth = new Customer("Beth", "Driscol",
                "89 Mockingbird Way", "98823", "223-643-3588", division3);

        Customer lola = new Customer("Lola", "Little",
                "404 Unfounded Blvd", "04939", "867-355-7775", division4);

        Customer mike = new Customer("Mike", "Jones",
                "808 S Houston Blvd ", "99342", "281-330-8004", division5);

        // adds the customers to the divisions, and adds them to the database
        division1.add(jason);
        division2.add(peter);
        division3.add(beth);
        division4.add(lola);
        division5.add(mike);
        divisionDAO.save(division1);
        divisionDAO.save(division2);
        divisionDAO.save(division3);
        divisionDAO.save(division4);
        divisionDAO.save(division5);
    }
}
