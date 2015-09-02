
package atmproject2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jastark
 */
public class ATMProject2 extends javax.swing.JDialog implements ActionListener{

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JButton withdraw;
    private final JButton deposit;
    private final JButton transfer;
    private final JButton balance;
    private final JTextField textField;
    private final JRadioButton savings;
    private final JRadioButton checking;
    static Account checkingAcct;
    static Account savingsAcct;
    
      
       //constructor to create the GUI
       public ATMProject2(){
           
           frame.setLayout(null);
           
           panel.setLayout(new FlowLayout());
           panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
          
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
           frame.setTitle("ATM Machine"); 
           frame.setSize(400,400);
           frame.setLocationRelativeTo(null);
           
           withdraw = new JButton("Withdraw");
           transfer = new JButton("Transfer");
           deposit = new JButton("Deposit");
           balance = new JButton("Balance");
           checking = new JRadioButton("Checking");
           savings = new JRadioButton("Savings");
           textField = new JTextField();
           
           ButtonGroup group = new ButtonGroup();
           group.add(savings);
           group.add(checking);
           
           withdraw.setActionCommand("Withdraw");
           transfer.setActionCommand("Transfer");
           deposit.setActionCommand("Deposit");
           balance.setActionCommand("Balance");
           savings.setActionCommand("Savings");
           checking.setActionCommand("Checking");
           withdraw.setActionCommand("Withdraw");
           withdraw.addActionListener(ATMProject2.this);
           transfer.addActionListener(ATMProject2.this);
           deposit.addActionListener(ATMProject2.this);
           balance.addActionListener(ATMProject2.this);
           checking.addActionListener(ATMProject2.this);
           savings.addActionListener(ATMProject2.this);
           textField.addActionListener(ATMProject2.this);
           
           
           
           
           withdraw.setSize(150,50);
           withdraw.setLocation(20,20);
           deposit.setSize(150,50);
           deposit.setLocation(200,20);
           transfer.setSize(150,50);
           transfer.setLocation(20,100);
           balance.setSize(150,50);
           balance.setLocation(200,100);
           panel.setBounds(0, 200, 400, 100);
           textField.setBounds(20,300,340,20);
           
           panel.add(checking);
           panel.add(savings);
       
           frame.add(withdraw);
           frame.add(transfer);
           frame.add(deposit);
           frame.add(balance);
           frame.add(panel);
           frame.add(textField);
           frame.setVisible(true);
       }
       
       /**Provides the actions performed by each button
       *@param e An ActionEvent that corresponds to a particular button
       */
       @Override
       public void actionPerformed(ActionEvent e){
           
           String event = e.getActionCommand();
           switch (event) {
               case "Withdraw":
                   String text = textField.getText();
                   if(isNumeric(text) == true){
                       if(isIncrementOf20(text) == true){
                           if(checking.isSelected()){
                               try {
                                   checkingAcct.withdraw(Double.parseDouble(textField.getText()));
                               } catch (InsufficientFunds ex) {
                                   
                               }
                            if(savings.isSelected()){
                               try {
                                   savingsAcct.withdraw(Double.parseDouble(textField.getText()));
                               } catch (InsufficientFunds ex) {
                               }
                           }
                           }
                       }
                   }
                   if(checkingAcct.getWithdrawals()+savingsAcct.getWithdrawals() > 4){
                       if(checking.isSelected()){
                           try{
                               checkingAcct.serviceFee();
                           }
                           catch (InsufficientFunds ex){
                               }
                       }
                       if(savings.isSelected()){
                           try{
                               savingsAcct.serviceFee();
                           }
                           catch (InsufficientFunds ex){
                               }
                       }
                   }
                   textField.setText("");
                   break;
                   
               case "Deposit":
                 try{
                 if(textField.getText().equals("") || isNumeric(textField.getText()) == false){  
                     textField.setText("");
                    break;
                 }
                 }
                 catch(NumberFormatException nfe){
                     System.out.println("hi");
                 }
                   if(checking.isSelected() == true){
                       checkingAcct.deposit(Double.parseDouble(textField.getText()));
                   }
                   else if(savings.isSelected() == true){
                       savingsAcct.deposit(Double.parseDouble(textField.getText()));
                   }
                   textField.setText("");
                 
                   break;
               case "Transfer":
                   if(textField.getText().equals("") || isNumeric(textField.getText()) == false){  
                     textField.setText("");
                     break;
                   }
                   if(checking.isSelected() == true){
                      
                    try {
                         savingsAcct.withdraw(Double.parseDouble(textField.getText()));
                         checkingAcct.deposit(Double.parseDouble(textField.getText()));
                    } catch (InsufficientFunds ex) {
                        }
                   }
                   
                   if(savings.isSelected() == true){
                      
                    try {
                         checkingAcct.withdraw(Double.parseDouble(textField.getText()));
                         savingsAcct.deposit(Double.parseDouble(textField.getText()));
                    } catch (InsufficientFunds ex) {
                        }
                     
                   }
                   textField.setText("");
                   break;
               case "Balance":
                   
                   double b;
                   if(checking.isSelected() == true){
                       b=checkingAcct.getBalance();
                       JOptionPane.showMessageDialog(frame, "Current Balance:  "+b);
                   }
                   else if(savings.isSelected() == true){
                       b=savingsAcct.getBalance();
                       JOptionPane.showMessageDialog(frame, "Current Balance:  "+b);
                   }
                   else{
                       JOptionPane.showMessageDialog(frame, "Please Select an Account");
                   }
                   textField.setText("");
                   
                   break;
               
           }
       }
       
      /**Method to check if the text is numeric
       *@param str String value that is evaluated to be numeric or not.
       *@return boolean Whether the str parameter is numeric or not.
       */
      public boolean isNumeric(String str){  
            try  
            {  
               double d = Double.parseDouble(str);  
            }  
             catch(NumberFormatException nfe)  
            {  
               JOptionPane.showMessageDialog(frame, "Please Enter a Valid Numerical Value"); 
               textField.setText("");
               return false;
             }  
              return true;
        }
      
      /**Method to check if the text is an increment of 20
       *@param str String value that is evaluated to be an increment of 20 or not.
       *@return boolean Whether the str parameter is an increment of 20 or not.
       */
      public boolean isIncrementOf20(String str){  
         
        double d = Double.parseDouble(str); 
        if(d%20 != 0){
            JOptionPane.showMessageDialog(frame, "Please Enter a Number That is a Multiple of 20");
            textField.setText("");
            return false;
        } 
        return true;
              
        }
      
    /**Main method to create account objects and ATMProject2 object that initializes the GUI
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ATMProject2 project = new ATMProject2();
        checkingAcct = new Account(0);
        savingsAcct = new Account(0);
        
    }
    
}
