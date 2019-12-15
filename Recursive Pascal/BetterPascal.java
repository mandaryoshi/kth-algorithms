package recursivepascal;

public class BetterPascal extends ErrorPascal implements Pascal {
        
    public void printPascal (int n){
        
        ErrorPascal(n);
        
        int z = n+2;
        
        long [][] arr = new long [z][z];
        
        for (int i = 0; i < z; i++){
            for (int j = 1; j <= i; j++){
                if (i == j){
                    arr [i][j] = 1;
                }
                else if (i == 0) {
                    arr [i][j] = 1;
                }
                else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        /*long [] pascal = new long[n+1];
        if (n == 0) {
           pascal[0] = 1;
           return pascal;
        }   
        pascal[0] = 1;
        pascal[n] = 1;
        long [] temp = printPascal(n-1);
        
        for (int i = 1; i < temp.length; i++) {
            pascal[i] = temp[i] + temp[i-1];
        }
        return pascal; */
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
