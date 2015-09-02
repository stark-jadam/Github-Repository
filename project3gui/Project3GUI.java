
package project3gui;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Jonathan Stark
 */
public class Project3GUI extends javax.swing.JDialog implements ActionListener{
    //instance variables
    private final JFrame frame;
    private JPanel panel;
    private final JRadioButton recursiveButton;
    private final JRadioButton iterativeButton;
    private final JButton computeButton;
    private final JTextField nTextField;
    private final JTextField resultTextField;
    private final JTextField efficiencyTextField;
    private static Sequence sequence;
    
    /**
     * 
     * constructor to create GUI
     */
    public Project3GUI(){
       
        frame = new JFrame();
           frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
           frame.setTitle("Project 3"); 
           frame.setSize(300,200);
           frame.setLocationRelativeTo(null);
        recursiveButton = new JRadioButton("Recursive");
        iterativeButton = new JRadioButton("Iterative");
        computeButton = new JButton("Compute");
        nTextField = new JTextField();
        resultTextField = new JTextField();
        efficiencyTextField = new JTextField();
        
        ButtonGroup group = new ButtonGroup();
        group.add(recursiveButton);
        group.add(iterativeButton);
        iterativeButton.setSelected(true);
        
        iterativeButton.setActionCommand("iterative");
        recursiveButton.setActionCommand("recursive");
        computeButton.setActionCommand("compute");
        iterativeButton.addActionListener(Project3GUI.this);
        recursiveButton.addActionListener(Project3GUI.this);
        computeButton.addActionListener(Project3GUI.this);
        
        
        
        frame.setLayout(new GridLayout(6,2,3,3));
        
        frame.add(new JLabel(""));
        frame.add(iterativeButton);
        frame.add(new JLabel(""));
        frame.add(recursiveButton);
        frame.add(new JLabel("Enter n: (1-25)"));
        frame.add(nTextField);
        frame.add(new JLabel(""));
        frame.add(computeButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultTextField);
        frame.add(new JLabel("Efficiency:"));
        frame.add(efficiencyTextField);
        frame.addWindowListener(new WindowAdapterImpl());
       
        frame.setVisible(true);
    }
    
   
    //checks if the input data is numeric
    public boolean isNumeric(String str){  
            try  
            {  
               double d = Double.parseDouble(str);  
            }  
             catch(NumberFormatException nfe)  
            {  
               JOptionPane.showMessageDialog(frame, "Please Enter a Valid Numerical Value"); 
               nTextField.setText("");
               return false;
             }  
              return true;
        }
    //main method to create Project3GUI object
    public static void main(String[] args) {
        // TODO code application logic here
        Project3GUI foo = new Project3GUI();
        
    }

    //action performed when compute is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
         String event = e.getActionCommand();
         String text;
         String result;
         
         switch (event){
             
             case "compute":
                 
                 text = nTextField.getText();
                 if(isNumeric(text) == false) break;
                 
                 if(iterativeButton.isSelected()){
                     result = ""+Sequence.computeIterative(Integer.parseInt(text));
                 }
                 else if(recursiveButton.isSelected()){
                     result = ""+Sequence.computeRecursive(Integer.parseInt(text));
                 }
                 else{
                     result = "";
                 }
                 resultTextField.setText(result);
                 efficiencyTextField.setText(""+Sequence.getEfficiency());
                 break;
         }
    }

    //class that defines a windowAdapter to override windowClosing method to perform function on window close
    private static class WindowAdapterImpl extends WindowAdapter {

        public WindowAdapterImpl() {
        }
        
        @Override
        public void windowClosing(WindowEvent e){
            try {
                int iterativeE;
                int recursiveE;
                FileWriter fw = new FileWriter("Efficiency Values.csv");
                for(int n = 0; n <= 10; n++){
                    Sequence.computeIterative(n);
                    iterativeE = Sequence.getEfficiency();
                    Sequence.computeRecursive(n);
                    recursiveE = Sequence.getEfficiency();
                    fw.write(n+","+iterativeE+","+recursiveE+"\n");
                }
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Project3GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
  
    
}
