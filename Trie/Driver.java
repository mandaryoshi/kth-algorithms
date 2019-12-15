package trie;

import edu.princeton.cs.introcs.In;
import java.util.*;
import java.net.URL;

public class Driver {

   public static void main(String[] args) {
      
       CountingTrie trie = new CountingTrie();
       
       URL url = ClassLoader.getSystemResource("kap1.txt");

      if (url != null) {
         System.out.println("Reading from: " + url);
      } else {
         System.out.println("Couldn't find file: kap1.txt");
      }

      In input = new In(url);

      while (!input.isEmpty()) {
         String line = input.readLine().trim();
         String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");
         String lastOfLine = words[words.length - 1];

         if (lastOfLine.endsWith(".")) {
            words[words.length - 1] = lastOfLine.substring(0, lastOfLine.length() - 1);
         }

         for (String word : words) {
            String word2 = word.replaceAll("\"|\\(|\\)", "");

            if (word2.isEmpty()) {
               continue;
            }
            
            //word2 = word2.toLowerCase();
            
            System.out.println(word2);
            // Add the word to the trie
            trie.put(word2);
         }
      }
   //Perform analysis
       /*System.out.println("Words with highest frequency: ");
       Frequencies.HighestLowestFrequency();
       
       System.out.println("Words with lowest frequency: ");
       Frequencies.HighestLowestFrequency();
       
       System.out.println("Prefix of length 2 frequency: ");
       Frequencies.PrefixFrequency();
       
       System.out.println("Most common first letter: ");
       Frequencies.FirstLetterFrequency();*/
      /*
      CountingTrie trie = new CountingTrie();
   
   

        trie.put("a");
        trie.put("ab");
        trie.put("ac");
        trie.put("b");
        trie.put("ba");
        trie.put("bad");
        trie.put("baf");
        

        System.out.println("1 if the value is present: " + trie.get("a"));
        
        
        System.out.println("Count: " + trie.count("b"));
        System.out.println("Distinct: " + trie.distinct("b"));
        
        
        System.out.println(trie.keysWithPrefix("ba"));
        //System.out.println(trie.Iterator(""));
        */
    }
}
