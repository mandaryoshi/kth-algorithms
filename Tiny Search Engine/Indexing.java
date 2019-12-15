/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tinysearchengine;

import java.util.*;
import se.kth.id1020.util.*;

/**
 *
 * @author Mandarin
 */
public class Indexing {
    
    public ArrayList<ArrayList<WordsWithAttr>> allWords = new ArrayList();
    
    
    public class WordsWithAttr {
        public Word word;
        public Attributes attributes;
        
        public WordsWithAttr (Word word, Attributes attributes){
            this.word = word;
            this.attributes = attributes;
        }
    }
    
    public void add (Word word, Attributes atrbts){
        WordsWithAttr wordList = new WordsWithAttr(word, atrbts);
        
        int pos = binarySearchForAdd(word.word);
        
        boolean wordExists = false;
        if (pos < this.allWords.size()) {
            wordExists = this.allWords.get(pos).get(0).word.word.equals(word.word);
        }
        
        if (wordExists == true) {
            this.allWords.get(pos).add(wordList);
        } else {
            ArrayList <WordsWithAttr> newList = new ArrayList();
            newList.add(wordList);
            this.allWords.add(pos, newList);
        }
    }
    
    public int binarySearchForAdd(String word){
        int lo = 0;
        int hi = this.allWords.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comparison = word.compareTo(this.allWords.get(mid).get(0).word.word);
            if      (comparison < 0) hi = mid - 1;
            else if (comparison > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

}
