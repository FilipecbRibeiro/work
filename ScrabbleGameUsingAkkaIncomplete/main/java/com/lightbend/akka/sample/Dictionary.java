/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Asus
 */
public class Dictionary {

    private ArrayList<String> words = new ArrayList<String>();

    //public static final String filee = "dc.txt";
    private Set<String> dic;

    public Dictionary() throws IOException {

        dic = new LinkedHashSet<>();
        loadWords();
    }

    private void loadWords() throws FileNotFoundException, IOException {
        File file= new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\teste\\src\\teste\\dc.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            dic.add(st);
        }
    }

    public void printwords() {

        for (String dc : dic) {
     

        }
    }
   boolean  verifyword(String st)
    {
        
       for(String dc: dic)
       {
           
           if(dc.contains(st))
           {    
               return true;
           }
       }
      
       return false;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public Set<String> getDic() {
        return dic;
    }

    public void setDic(Set<String> dic) {
        this.dic = dic;
    }

}
