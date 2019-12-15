package trie;

import java.util.*;

public class CountingTrie implements Iterable <Map.Entry<String, Integer>>{

    private Node root;

    @Override
    public Iterator<Map.Entry<String, Integer>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private static class Node{
        private int value;
        private final Node [] next = new Node[256];
    }
    
    public CountingTrie(){}
    
    
    //GET METHOD
    
    public int get(String key){
        Node node = get(root, key);
        if(node == null){return 0;}
        return node.value;
    }
    
    private Node get(Node node, String key){
        if (node == null){
            return null;
        }
        if(0 == key.length()){
            return node;
        }
        char c = key.charAt(0);
        return get(node.next[c], key.substring(1));
    }
    
    
    //PUT METHOD
    
    
    public void put(String key){
        root = put(root, key);
    }
    
    private Node put(Node node, String key){
        if (node == null){
            node = new Node();
        }

        if (0 == key.length()){
            if (node.value == 0){
                node.value = 1;
                
            }
            else {
                node.value = node.value + 1;
                
            }
            return node;
        }
        if (key.charAt(0)< 0 || key.charAt(0) > 255){
            return new Node();
        }
        int c = key.charAt(0);
        node.next[c] = put(node.next[c], key.substring(1));
        return node;
    }

    //COUNT METHOD
    
    public int count(String prefix){
        Node start = get(root, prefix);
        return count(start);
    }
    
    private int count(Node node){
        if (node == null){
            return 0;
        }
        int total = node.value;
        for (int i = 0; i < 256; i++){
            total += count(node.next[i]);
        }
        return total;
    }
    
    //DISTINCT METHOD
    
    public int distinct(String prefix){
        int sum = 0;
        Node node = get(root, prefix);
        if(node != null) {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    sum = sum + distinct(node.next[i]);
                }
            }
        }
        return sum;
    }
    
    private int distinct(Node node){
        int sum = 0;
        if(node.value > 0){
            sum++;
        }
        for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null) {
                    sum = sum + distinct(node.next[i]);
                }
            }
        return sum;
    }
    
    //ITERATOR METHOD

    public Map<String,Integer> keysWithPrefix(String prefix) {
        Map<String,Integer> sort = new HashMap<>();
        collect(get(root, prefix), prefix, sort);
        return sort;
    }
    
    private void collect(Node node, String prefix, Map<String,Integer> results){
        if (node == null) return;
        if (node.value != 0) results.put(prefix,node.value);
        for (char c = 0; c < 256; c++){
            collect(node.next[c], prefix + c, results);
        }
    }
    
    /*
        public Iterator<Map.Entry<String, Integer>> Iterator(String prefix) {
        Map<String, Integer> Sorted = new TreeMap<>(keys(prefix));
        Iterator<Map.Entry<String, Integer>> iterator = Sorted.entrySet().iterator();
        return iterator;
    }*/
}
