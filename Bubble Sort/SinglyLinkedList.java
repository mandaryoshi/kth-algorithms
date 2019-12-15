package bubblesort;



public class SinglyLinkedList {
    
    public Node head;
    public int size;

    

    public Node getFirst(){
        return head;
    }
    
    public void add(int data){
        if (head == null){
            Node n = new Node(data);
            n.next = head;
            head = n;
            size++;
        }
        else {
            Node n = new Node(data);
            Node currentNode = head;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = n;
            size++;
        
        }
    }
    
    
    public int get(Node node){
       return node.data;
    }
    

    public int size(){
        return size;
    }
    
    
    public void swap(Node currentNode, Node nextNode){
        int temp = currentNode.data;
        currentNode.data = nextNode.data;
        nextNode.data = temp;
    
    }
   
    
    public void printlist(){
        Node position = head;
        while (position != null){
            System.out.print(position.data + ", ");
            position = position.next;
        }
    
    }
    
}

