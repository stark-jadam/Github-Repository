
package project3gui;

/**
 *
 * @author Jonathan Stark
 */
public class Sequence {
    
    private static int efficiency;
   
    /**Constructor to initialize instance variable
    */
    public Sequence(){
        efficiency = 0;
    }
    
    /**Computes nth term iteratively, where the nth term is 2 times the previous number plus the next previous number
     * @param n The term to be evaluated
     * @return int The value of the nth term, calculated iteratively
    */
    public static int computeIterative(int n){
        
        efficiency = 0;
        int[] s = new int[n+1];
            
        for(int i = 0; i <= n; i++){
            if(i==0){
                s[i]=0;
            }
            else if(i==1){
                s[i]=1;
            }
            else{
                s[i] = (s[i-1]*2 + s[i-2]);
            }
            
            efficiency++;
            }
        
        return s[n];
        
    }
    
    /**Helper method for recursive() method
    * @param n The term to be evaluated 
    * @return int The value of the nth term, calculated recursively
    */
        public static int computeRecursive(int n){
            efficiency = 0;
            return recursive(n);
        
       
    }
    
    /**Computes nth term recursively, where the nth term is 2 times the previous number plus the next previous number
     * @param n The term to be evaluated
     * @return int The value of the nth term, calculated recursively
    */
    private static int recursive(int n){
        efficiency++;
        if(n <= 1){
           return n;
        }
        
        return recursive(n-1)*2+recursive(n-2);
        
    }
    
    /**
     * Returns the value of the efficiency counter
     * @return int The efficiency counter
     */
    public static int getEfficiency(){
        return efficiency;
    }
    
}
    

