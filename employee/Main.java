
package employee;
import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Jonathan Stark
 * CMIS 242 Intermediate Programming
 * Project 1
 * 05/21/2015
 * Created with Netbeans IDE 8.0.2
 * 
 */

public class Main {

    /**
     * Main method that reads in employees from employee.txt and generates a report
     * @param args the command line argument
     */
    
    public static void main(String[] args){
        
        Employee[] employee2014 = new Employee[10];
        Employee[] employee2015 = new Employee[10];
        String[] input = new String[4];
        String currentLine;
        int employee2014Count = 0;
        int employee2015Count = 0;
        FileReader fr;
        BufferedReader br;
        
        
        try{
            fr = new FileReader("employee.txt");
            br = new BufferedReader(fr);
            
            //loop reading each line in the file and assigning line to currentLine
            for(currentLine = br.readLine(); currentLine!=null; currentLine = br.readLine()){
                
                StringTokenizer st = new StringTokenizer(currentLine);
                
                
                if(st.nextToken().equals("2014")){
                    for(int i=0; st.hasMoreTokens()!=false; i++){
                        input[i] = st.nextToken();
                        
                    }
                   
                    switch (input[0]) {
                        case "Employee":
                            employee2014[employee2014Count] = new Employee(input[1],Integer.parseInt(input[2]));
                            break;
                        case "Salesman":
                            employee2014[employee2014Count] = new Salesman(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                            break;
                        case "Executive":
                            employee2014[employee2014Count] = new Executive(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                            break;
                    }
                    employee2014Count++;
                }
                else{
                    for(int i=0; st.hasMoreTokens()!=false; i++){
                        input[i] = st.nextToken();
                        
                    }
                   
                    switch (input[0]) {
                        case "Employee":
                            employee2015[employee2015Count] = new Employee(input[1],Integer.parseInt(input[2]));
                            break;
                        case "Salesman":
                            employee2015[employee2015Count] = new Salesman(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                            break;
                        case "Executive":
                            employee2015[employee2015Count] = new Executive(input[1],Integer.parseInt(input[2]),Integer.parseInt(input[3]));
                            break;
                    }
                    employee2015Count++;
                }
                
                
            }
            
            br.close();
        }
        catch(IOException e){
            System.out.println("File not written");
        }
        
       
        
        //Generating the report
        employee2014Count = 0;
        employee2015Count = 0;
        int totalSalaries = 0;
        System.out.println("2014 Employee Data");
        System.out.println("-------------------");
        
        while(employee2014[employee2014Count]!=null){
            System.out.println(employee2014[employee2014Count].toString()+"  They had an annual salary of $"+employee2014[employee2014Count].annualSalary()+".");
            totalSalaries+=employee2014[employee2014Count].annualSalary();
            employee2014Count++;
        }
        System.out.println("\nThe Average Salary for 2014 is $"+(totalSalaries/(employee2014Count)));
        
        totalSalaries = 0;
        System.out.println("\n\n2015 Employee Data");
        System.out.println("-------------------");
        while(employee2015[employee2015Count]!=null){
            System.out.println(employee2015[employee2015Count].toString()+"  They had an annual salary of $"+employee2015[employee2015Count].annualSalary()+".");
            totalSalaries+=employee2015[employee2015Count].annualSalary();
            employee2015Count++;
        }
        System.out.println("\nThe Average Salary for 2015 is $"+(totalSalaries/(employee2015Count)));
    }
    
}
