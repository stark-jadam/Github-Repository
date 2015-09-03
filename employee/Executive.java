
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

public class Executive extends Employee{
    
    private final String name;
    private final int monthlySalary;
    private final int stockPrice;
    
    /**
     * Constructor method to set instance variables
     * @param name The executive's name
     * @param monthlySalary The executive's monthly salary
     * @param stockPrice The current stock price for the company
     */
    public Executive(String name, int monthlySalary, int stockPrice){
        
        super(name, monthlySalary);
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.stockPrice = stockPrice;
        
    }
    
    /**
     * Method that returns the annual salary of the executive
     * @return int The annual salary plus any bonuses
     */
    @Override
    public int annualSalary(){
        
        int bonus = 0;
        int baseSalary = super.annualSalary();
        
        if(stockPrice > 50){
            bonus = 30000;
        }
        
        return baseSalary+bonus;
    }
    
    /**
     * Method that returns a string representation of the executives name, monthly salary, and stock price
     * @return String A string representation of the executive's name, monthly salary, and the current stock price of the company
     */
    @Override
    public String toString(){
        
        return name+" earns $"+monthlySalary+" per month and the stock price is $"+stockPrice+".";
    }
}
