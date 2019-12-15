package com.mycompany.tinysearchengine;

import java.util.*;
import se.kth.id1020.util.*;

public interface TinySearchEngineBase {
    
    //Build the index
    public void insert(Word word, Attributes attr);

    //Searching
    public List<Document> search(String query);
}
