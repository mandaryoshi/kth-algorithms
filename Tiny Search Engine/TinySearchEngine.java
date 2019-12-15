package com.mycompany.tinysearchengine;


import java.util.*;
import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.*;
import com.mycompany.tinysearchengine.Indexing.*;

public class TinySearchEngine implements TinySearchEngineBase{

    private Indexing index = new Indexing();
    

    public static void main(String[] args) throws Exception{
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        Driver.run(searchEngine);
    }

    
    @Override
    public void insert(Word word, Attributes atrbts) {
         String wordName = word.word;
         Document doc = atrbts.document;
         
        
         if(doc != null){
            index.add(word, atrbts);

         }
         
    }

    @Override
    public List<Document> search(String string) {

        ArrayList<WordsWithAttr> Results = new ArrayList();

        String [] words = string.split("\\s+");
        
        String property = "";
        String direction = "";
        
        if (words.length >= 4){
            if (words[words.length-3].equals("orderBy")) {
                property = words[words.length -2];
                direction = words[words.length -1];
            }
        String[] properties = new String[]{"count", "popularity", "occurrence"};
        String[] directions = new String[]{"asc", "desc"};
        
        
        for (int i = 0; i < properties.length-1; i++) {
            if (property.equals(properties[i]));
                property = properties[i];
        }
        
        for (int i = 0; i < directions.length-1; i++) {
            if (direction.equals(directions[i]));
                direction = directions[i];
        }
        
        String [] wordsToSearch = new String[words.length-3];
        for (int i = 0; i < words.length-3; i++) {
            wordsToSearch[i] = words[i];
        }
            

        for (String word : wordsToSearch){
            int result = binarySearch(word);
                if (result != -1)
                    for (WordsWithAttr wordInIndex: index.allWords.get(result)) {
                        Results.add(wordInIndex);
                    }
        }
        }
        else
            
            for (String word : words){
            int result = binarySearch(word);
                if (result != -1)
                    for (WordsWithAttr wordInIndex: index.allWords.get(result)) {
                        Results.add(wordInIndex);
                    }
        }
            
        
        
        
        
        
        bubbleSort(Results, property, direction);
        
        ArrayList<Document> finalResults = new ArrayList();
        
        for (WordsWithAttr wordInIndex : Results){
            finalResults.add(wordInIndex.attributes.document);
        }
         

        ArrayList<Document> finalList = new ArrayList<>(new LinkedHashSet<>(finalResults));
        
        
        
        
        
        return finalList;
    }
    
    public int binarySearch(String key) {
        int lo = 0;
        int hi =  index.allWords.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compare = key.compareTo(index.allWords.get(mid).get(0).word.word);
            if      (compare < 0) hi = mid - 1;
            else if (compare > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    
    public void bubbleSort(ArrayList<WordsWithAttr> list, String property, String direction){
        int dir = 1;
         if (direction.equals("desc")) {
            dir = -1;
        }
        
        boolean expression;
        int R = list.size() -2;
        boolean swapped = true;
        
        while (R >= 0 && swapped == true){
            swapped = false;
            for (int i = 0; i <= R; i++){ 
                
                expression = (list.get(i).attributes.document.name.compareTo(list.get(i+1).attributes.document.name)) > 0;
                
                if (property.equals("popularity")) {
                    expression = list.get(i).attributes.document.popularity > list.get(i+1).attributes.document.popularity;
                }
                
                if (property.equals("occurrence")) {
                    expression = list.get(i).attributes.occurrence > list.get(i+1).attributes.occurrence;
                }
                
                if (dir != 1) expression = !expression;
                
                if (expression == true){
                    swapped = true;
                    WordsWithAttr temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i + 1, temp);
                }
            }
        R--;
        }
        
    }

}