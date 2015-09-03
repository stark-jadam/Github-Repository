
package employee;

/**
 *
 * @author Jonathan Stark
 * CMIS 242 Intermediate Programming
 * Project 1
 * 05/21/2015
 * Created with Netbeans IDE 8.0.2
 * 
 */
public class Employee {

    private final String name;
    private final int monthlySalary;
    
    /**
     * Constructor to initialize instance variables
     * @param name The name of the employee
     * @param monthlySalary The monthly salary of the employee
     */
    public Employee(String name, int monthlySalary){
        
        this.name = name;
        this.monthlySalary = monthlySalary;
 
    }
    
    /**
     * Method that returns the annual salary of the employee 
     * @return int The annual salary of the employee
     */
    public int annualSalary(){
        
        return monthlySalary*12;
        
    }
    
    /**
     * Method that returns string representation of the employee and their monthly salary
     * @return String A string representation of the employee and their monthly salary
     */
    @Override
    public String toString(){
        
        return name+" earns $"+monthlySalary+" per month.";
    }
    
}
