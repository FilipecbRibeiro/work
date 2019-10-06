package com.lightbend.akka.sample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class Player {

    private ArrayList<Tile> yourRack = new ArrayList<Tile>();
    private ArrayList<Character> yourRacktemp = new ArrayList<Character>();
    private ArrayList<Tile> yourRacktempo = new ArrayList<Tile>();
       private ArrayList<Tile> deletedha = new ArrayList<Tile>();
    private char newtile = ' ';
    private int score = 0;
    private Tile ntile  = new TileNeutral (' ',0 );
    private Tile neutral= new TileNeutral('*',0);
    private int posxx=0;
    private int numberofiteractions = 0 ; 
    
    
    ArrayList playerTiles(ArrayList<Tile> letters) {
        for (int y = 0; y < 7; y++) {
            int rand = getRand(letters.size());
            yourRack.add(letters.get(rand));
          
            letters.remove(rand);
            
        }

        for (int z = 0; z < 7; z++) {
         
            letters.remove(z);
            
        }
        
        
        System.out.println();
        printplayerTiles();

        return letters;
    }
    void getdeleted(Tile a)
    {
        
        deletedha.add(a);
    }
    
    void refreshHand(Tile tl) {

        yourRacktemp = new ArrayList<Character>();
        deletedha = new ArrayList<Tile>();
        for (int i = 0; i < yourRack.size(); i++) {
            if (!yourRacktemp.contains(tl.getLetter())) {
                if (yourRack.get(i).getLetter() == tl.getLetter()) {
                     yourRacktemp.add(tl.getLetter());
                    yourRack.remove(i);
                  
                    getdeleted(tl);
                }
            }

        }
        numberofiteractions  =yourRack.size();
      
    }

    ArrayList playerTilenext(ArrayList<Tile> letters) {

        int rand = getRand(letters.size());
        yourRack.add(letters.get(rand));
        newtile = letters.get(rand).getLetter();
        letters.remove(rand);
     
  ntile= letters.get(rand);
        
     
        return letters;
    }

    void printplayerTiles() {
        for (Tile cv : yourRack) {
            System.out.println(cv.getLetter() + "-> " + cv.getPoint());
        }
    }

    boolean searchrepetitivestiles(char sc) {

        if (yourRacktemp.contains(sc)) {
            return false;
        } else {
            return true;
        }
    }
    int occurences(char a,String tw)
    {
        int count = 0 ;
        for ( int i  =0 ; i<tw.length(); i++)
        {
            if( a == tw.charAt(i))
                count++;
        }
        return count;
    }

        
    
    boolean verifytiles(String tw) {
        int count = 0;
        int countit= 0;
        yourRacktemp = new ArrayList<Character>();
        yourRacktempo = new ArrayList<Tile>();
        int o  = 0 ; 

        for(int i  = 0  ; i< yourRack.size(); i++)
        {
                  
            yourRacktemp.add(yourRack.get(i).getLetter());
        }
        
        for ( int i  = 0 ; i< tw.length();i++)
        {
        
            if(yourRacktemp.contains((char)tw.charAt(i)))
            {
               
                             o  = position(yourRack, tw.charAt(i)); 
           
               
                if( o!= -1){
                     yourRacktempo.add(yourRack.get(o));
                     score += yourRack.get(o).getPoint();
                }
                
            }
        }
        
     for ( Tile to : yourRacktempo)
        {   
            
       
        }

        if(tw.length()==yourRacktempo.size())
            return true;
        else
            return false;
  
    }

     boolean verifytiles2(String tw,char letter,Tile neutrall) {
        int count = 0;
        int countit= 0;
        yourRacktemp = new ArrayList<Character>();
        yourRacktempo = new ArrayList<Tile>();
        
        int o  = 0 ; 

        for(int i  = 0  ; i< yourRack.size(); i++)
        {
                  
            yourRacktemp.add(yourRack.get(i).getLetter());
        }
        
        for ( int i  = 0 ; i< tw.length();i++)
        {
           
            if(yourRacktemp.contains((char)tw.charAt(i)))
            {
               
                             o  = position(yourRack, tw.charAt(i)); 
                
               
                if( o!= -1){
                     yourRacktempo.add(yourRack.get(o));
                     score += yourRack.get(o).getPoint();
                }
                
            }
            if(tw.charAt(i)== '*')
            {
               
                yourRacktempo.add(neutrall);
                posxx=i;
            }
          

        }
         
        for ( Tile to : yourRacktempo)
        {   
           System.out.println("--> " + to.getLetter());
        }
       
              
                     
                     

            return true;

  
    }
     
     
     public int tilesbeforeneutral(char letter)
     {
         int count = 0;
         for (Tile tl: yourRacktempo)
         {
             if(tl.getLetter()!=letter)
                 count++;
             else
                 return count;
         }
         System.out.println("ENVIAR COUNT " + count);
         return count;
     }
    public int getRand(int max) {

        Random rand = new Random();
        return rand.nextInt(max);

    }

    public ArrayList<Tile> getYourRack() {
        return yourRack;
    }

    public void setYourRack(ArrayList<Tile> yourRack) {
        this.yourRack = yourRack;
    }

    public char getNewtile() {
        return newtile;
    }

    public void setNewtile(char newtile) {
        this.newtile = newtile;
    }

    public ArrayList<Character> getYourRacktemp() {
        return yourRacktemp;
    }

    public void setYourRacktemp(ArrayList<Character> yourRacktemp) {
        this.yourRacktemp = yourRacktemp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Tile> getYourRacktempo() {
        return yourRacktempo;
    }

    public void setYourRacktempo(ArrayList<Tile> yourRacktempo) {
        this.yourRacktempo = yourRacktempo;
    }

    private int position(ArrayList<Tile> yourRack, char charAt) {
        
        for (  int i = 0 ; i< yourRack.size(); i++)
        {
            if ( yourRack.get(i).getLetter()== charAt)
            {
                return i;
            }
        }
        return -1 ; 
    }

    public Tile getNeutral() {
        return neutral;
    }

    public void setNeutral(Tile neutral) {
        this.neutral = neutral;
    }

    public int getPosxx() {
        return posxx;
    }

    public void setPosxx(int posxx) {
        this.posxx = posxx;
    }

    public ArrayList<Tile> getDeletedha() {
        return deletedha;
    }

    public void setDeletedha(ArrayList<Tile> deletedha) {
        this.deletedha = deletedha;
    }

    public int getNumberofiteractions() {
        return numberofiteractions;
    }

    public void setNumberofiteractions(int numberofiteractions) {
        this.numberofiteractions = numberofiteractions;
    }

    public Tile getNtile() {
        return ntile;
    }

    public void setNtile(Tile ntile) {
        this.ntile = ntile;
    }
    
}
