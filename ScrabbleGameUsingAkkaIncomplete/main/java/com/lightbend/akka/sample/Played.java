/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Played {

    private ArrayList<ArrayList<Tile>> played = new ArrayList<ArrayList<Tile>>();
    private ArrayList<Character> position = new ArrayList<Character>();
    private ArrayList<Tile> jogadastemp = new ArrayList<Tile>();
    private int posxtemp =0;
    private int posytemp = 0;
    private char tempPosition= ' ';
    private String wordtemp  =" ";
    
    public Played() {

    }

    public ArrayList<ArrayList<Tile>> getJogadas() {
        return played;
    }

    public void setJogadas(ArrayList<ArrayList<Tile>> jogadas) {
        this.played = jogadas;
    }

    public void imprimeinfo() {
      
        for (int i = 0; i < played.size(); i++) {
          
            for (int j = 0; j < played.get(i).size(); j++) {

           

            }
            System.out.println("\n");
        }
    }

    boolean existwordchoosen(String tw) {
   
        String string   = new String();
     
        for (int i= 0 ; i < played.size(); i++)
        {
            jogadastemp= new ArrayList<>();
       
            for(int j = 0 ; j< played.get(i).size();j++ )
            {
                string += played.get(i).get(j).getLetter();
                jogadastemp.add(played.get(i).get(j));
                tempPosition= position.get(i);
            }   
           

            if(string == null ? tw == null : string.equals(tw)){
             
                wordtemp=string;
                return true;
            }
                
            else
                string= new String();
        }
        
        
        
        
        
        
       return false ;
    }
    
    public Tile getTile(char  c)
            
    {
       for (Tile tl : jogadastemp)
       {
           if( tl.getLetter()== c)
               return tl;
       }
       return null;
    }


    public ArrayList<Character> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Character> position) {
        this.position = position;
    }

    public ArrayList<Tile> getJogadastemp() {
        return jogadastemp;
    }

    public void setJogadastemp(ArrayList<Tile> jogadastemp) {
        this.jogadastemp = jogadastemp;
    }

    public int getPosxtemp() {
        return posxtemp;
    }

    public void setPosxtemp(int posxtemp) {
        this.posxtemp = posxtemp;
    }

    public int getPosytemp() {
        return posytemp;
    }

    public void setPosytemp(int posytemp) {
        this.posytemp = posytemp;
    }

    public char getTempPosition() {
        return tempPosition;
    }

    public void setTempPosition(char tempPosition) {
        this.tempPosition = tempPosition;
    }

    public String getWordtemp() {
        return wordtemp;
    }

    public void setWordtemp(String wordtemp) {
        this.wordtemp = wordtemp;
    }

}
