package recursivepascal;

abstract class ErrorPascal implements Pascal {
    
    
    public void ErrorPascal(int n){
        if (n < 0){
            System.out.println("invalid input, n < 0");
        }
        
    }
    
    public void ErrorBinom (int n, int k){
        if (k < 0 || k > n){
            System.out.println("invalid input for binomial coefficient");
        }
    }
}
