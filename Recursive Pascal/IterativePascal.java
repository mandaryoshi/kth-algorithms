package recursivepascal;

public class IterativePascal extends ErrorPascal implements Pascal {
    
    public void printPascal (int n){
        
        ErrorPascal(n);
        boolean up = false;
        
        if (up){
            for(int i = 0; i <= n; i++){   
                for(int j = 0; j <= i; j++){
                    System.out.print(binom(i,j) + " "); 
                }
                System.out.println();
            }
        }
        else {
            for(int i = 0; n >= i; n--){   
                for(int j = 0; j <= n; j++){
                    System.out.print(binom(n,j) + " "); 
                }
                System.out.println();
            }
        }
    }

    public int binom (int n, int k){
        
        int count = 1;
        if (k == 0 || k == n){
            return 1;   
        }
        else {
            for (int i = 1; i <= k; i++){
            count = count * (n-i+1)/i;
            }
        }    
        return count;
    }
    
}