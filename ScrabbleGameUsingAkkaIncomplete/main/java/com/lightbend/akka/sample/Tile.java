/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import java.io.Serializable;
import javax.smartcardio.Card;

/**
 *
 * @author Asus
 */
public class Tile implements Serializable{
  //  private final int MAX = 3;
   
    private  int serie = 0 ;
    private int point = 0 ;
    private char letter= ' ';
    private int posx = 0 ;
    private int posy = 0 ;
//    private int dia ;
  
   private String s;
    public Tile (char letter,int point)
    {
        this.letter= letter;
        this.point = point; 
    
    }
  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.serie;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (this.serie != other.serie) {
            return false;
        }
        return true;
    }
    
     
    
//    public void setactionPoint(int num)
//    {
//        actionpointallowance= num;
//    }
//    public int getactionPoint()
//    {
//        return actionpointallowance;
//    }
//    public boolean getShow()
//    {
//        return show;
//    }
//    
//    public int getSerie()
//    {
//        return serie;
//    }
//    public void setSerie(int num)
//    {
//        serie = num ; 
//    }
//    public void aconteceEventodiaum(GameData b )
//    {
//        
//    }
//    public void aconteceEventodiadois(GameData b )
//    {
//        
//    }
//    public void aconteceEventodiatres(GameData b )
//    {
//        
//    }
//    public void aplicaFigurasCartaum(GameData b)
//    {
//        
//    }
//    public void aplicaFigurasCartadois(GameData b)
//    {
//        
//    }
//    public void aplicaFigurasCartatres(GameData b)
//    {
//        
//    }

    public int getSerie() {
        return serie;
    }

    public int getPoint() {
        return point;
    }

    public char getLetter() {
        return letter;
    }

    public String getS() {
        return s;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

}


