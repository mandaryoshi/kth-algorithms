package bubblesort;

public class BubbleSort {

    
    public static void BubbleSort(SinglyLinkedList list){
        int size = list.size();
        int R = size-2;
        boolean swapped = true;
        int count = 0;
        
        while (R >= 0 && swapped == true){
            swapped = false;
            Node CurrentPos = list.getFirst();
            for (int i = 0; i <= R; i++){ 
                if (list.get(CurrentPos) > list.get(CurrentPos.next)){
                    swapped = true;
                    list.swap(CurrentPos,CurrentPos.next);
                    CurrentPos = CurrentPos.next;
                    count++;
                }
            }
        R--;
        }
        System.out.println("Number of swaps completed = " + count);
    }
    
    public static void main(String[] args) {
        SinglyLinkedList test = new SinglyLinkedList();
        test.add(9);
        test.add(8);
        test.add(7);
        test.add(6);
        test.add(5);
        test.add(4);
        test.add(3);
        test.add(2);
        
        test.printlist();
        
        System.out.println();
       
        //BubbleSort(test);
        
        System.out.println();
        
        //test.printlist();
        
        System.out.println();
        
        //System.out.println(InversionCount.InversionCount(test));

    }
    
    
    
}
