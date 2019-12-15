package recursivepascal;

public class Driver {
    
    public static void main(String[] args) {

        new RecursivePascal().printPascal(50);
        
        new BetterPascal().printPascal(50);
        
        new IterativePascal().printPascal(50);
        
        /*int temp = new IterativePascal().binom(10, 5);
        System.out.println(temp);*/

        /*int n = 20;
        int y = 1;
        if (y == 1) { 
            for (int i = 0; i <= n; i++) 
                System.out.println(Arrays.toString(printPascal(i)));
        }
        else {
            for (int i = n; 0 <= i; i--) 
                System.out.println(Arrays.toString(printPascal(i)));
        }*/    
    }
}
