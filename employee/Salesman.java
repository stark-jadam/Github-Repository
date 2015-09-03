
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
public class Salesman extends Employee {
    
    private final String name;
    private final int monthlySalary;
    private final int annualSales;
    
    /**
     * Constructor method to set instance variables
     * @param name The salesman name
     * @param monthlySalary The monthly salary of the salesman
     * @param annualSales The annual sales of the salesman
     */
    public Salesman(String name, int monthlySalary, int annualSales){
        
        super(name, monthlySalary);
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.annualSales = annualSales;
        
    }
    
    /**
     * Method that returns the annual salary of the salesman
     * @return int The annual salary of the salesman
     */
    @Override
    public int annualSalary(){
        
        int commission = (int)Math.round(annualSales*0.02);
        int baseSalary = super.annualSalary();
        
        if(commission > 20000){
            commission = 20000;
        }
        
        return baseSalary+commission;
    }
    
    /**
     * Method that returns a string representation of the salesman's name, monthly salary, and their annual sales
     * @return String String representation of salesman's name, monthly salary, and their annual sales
     */
    @Override
    public String toString(){
        
        return name+" earns $"+monthlySalary+" per month and has $"+annualSales+" in annual sales.";
    }
   
}



