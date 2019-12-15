package bubblesort;


public class InversionCount {
    
    
    public static int InversionCount(SinglyLinkedList list){
    
        
        int R = list.size()-2;
        int r = list.size();
        int counter = 0;
        Node CurrentPos = list.getFirst();
        
        for (int i = 0; i <= R; i++){
            for (int j = i+1; j < r; j++){
                if (list.get(CurrentPos) > list.get(CurrentPos.next)){
                    counter++;     
                }
            }
            CurrentPos = CurrentPos.next;    
        }
        return counter;
    }
    
    
}

    /*
      Based on 
      int counter = 0;
        int [] ar = {9,8,7,6,5,4,3,2};
        for (int i = 0; i < ar.length-1; i++){
            for (int j = i+1; j < ar.length; j++){
                if(ar[i]>ar[j]){
                    counter++;
                }
            }
        }
        System.out.println();
      System.out.println(counter);
      */


