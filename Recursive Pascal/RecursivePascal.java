package recursivepascal;

import java.math.*;

public class RecursivePascal extends ErrorPascal implements Pascal {
 
    public void printPascal (int n){
        
        ErrorPascal(n);
        boolean up = false;
        
        if (up){
            for(int i = 0; i <= n; i++){   
             System.out.print(binom(n, i) + " "); 
            }
            System.out.println();
            if (n > 0)
                printPascal(n-1);
        }
        
        else {
            if (n > 0)
                printPascal (n-1);
            for(int i = 0; i <= n; i++){   
             System.out.print(binom(n, i) + " "); 
            }
            System.out.println();
        }
    }
    
    public int binom (int n, int k){
        //n choose k = (n-1 choose k-1) + (n-1 choose k)
        //initial values n choose 0 = n choose n = 1

        if((k == 0) || (n == k)){
            return 1;
        }
        else {
           return (binom(n-1,k-1) + binom(n-1, k));
        }
    }
}
