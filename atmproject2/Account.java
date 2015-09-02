
package atmproject2;

/**
 *
 * @author Jastark
 */
public class Account {
    
    private double balance;
    private int withdrawals;
    
    /**Constructor that initializes instance variables
    * @param initialBalance Double that creates an initial balance for the account
    */
    public Account(double initialBalance){
        
        balance = initialBalance;
        withdrawals = 0;
      
    }
    
    /**Returns the balance of the account
     * @return double The balance of the account
     */
    public double getBalance(){
        
        return balance;
    }
    
    /**Adds to the balance of the account
     * @param amount The amount to deposit into the account
     */
    public void deposit(double amount){
        
        balance += amount;
        
    }
    
    /**Returns the balance of the account
     * @param amount The amount to withdraw from the account
     * @throws atmproject2.InsufficientFunds error if account doesn't have enough funds to withdraw amount
     */
    public void withdraw(double amount) throws InsufficientFunds{
        
        if(amount > balance){
            throw new InsufficientFunds("Insufficient Funds");
        }
        else{
            balance -= amount;
            withdrawals++;
        }
        
    } 
    /**
     * Returns the number of times money has been withdrawn from the selected account
     * @return int The number of times money has been withdrawn from the selected account
     */
    public int getWithdrawals(){
        return withdrawals;
    }
    
    /**
     * Withdraws the service fee from the selected account
     * @throws InsufficientFunds error if there are insufficient funds to withdraw the service fee
     */
    public void serviceFee() throws InsufficientFunds{
        if(1.5 > balance){
            throw new InsufficientFunds("Insufficient Funds");
        }
        else{
            balance -= 1.5;
        }
    }
}
