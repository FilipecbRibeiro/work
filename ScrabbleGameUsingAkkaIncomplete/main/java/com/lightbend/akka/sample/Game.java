/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class Game {

    /**
     * @param args the command line arguments
     */
    private  Board board;
   
    private ArrayList<Tile> letterss = new ArrayList<Tile>();
    private Played played;
    private Player player;
    private char nextplay = new Character(' ');
    private int num = 0 ;
    private int posx= 0 ;
    private int posy = 0 ; 
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Tile> getLetterss() {
        return letterss;
    }

    public void setLetterss(ArrayList<Tile> letterss) {
        this.letterss = letterss;
    }

    public Played getPlayed() {
        return played;
    }

    public void setPlayed(Played played) {
        this.played = played;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public char getNextplay() {
        return nextplay;
    }

    public void setNextplay(char nextplay) {
        this.nextplay = nextplay;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getNewword() {
        return newword;
    }

    public void setNewword(String newword) {
        this.newword = newword;
    }

    public ArrayList<Tile> getTemp() {
        return temp;
    }

    public void setTemp(ArrayList<Tile> temp) {
        this.temp = temp;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Dictionary getDic() {
        return dic;
    }

    public void setDic(Dictionary dic) {
        this.dic = dic;
    }

    public List<Actor> getListofactors() {
        return listofactors;
    }

    public void setListofactors(List<Actor> listofactors) {
        this.listofactors = listofactors;
    }

    private boolean pass = false;
    String newword = new String();
    private ArrayList<Tile> temp = new ArrayList<Tile>();

    int conta = 1;
    private Dictionary dic;
    private List<Actor> listofactors ; 


    public Game() throws IOException {
     
        board = new Board();
        player = new Player();
        dic = new Dictionary();
      
        listofactors= new ArrayList<>();
        played = new Played();
       
       Setup();
      
    }

   public  void loopplay() {


       

    }

  public  void createTiles() {

        for (int ii = 0; ii < 101; ii++) {
            if (ii <= 9) {
                Tile a = new TileA('a', 1);
                letterss.add(a);
            } else if (ii <= 11) {
                Tile b = new TileB('b', 3);
                letterss.add(b);
            } else if (ii <= 13) {
                Tile c = new TileC('c', 3);
                letterss.add(c);
            } else if (ii <= 17) {
                Tile d = new TileD('d', 2);
                letterss.add(d);
            } else if (ii <= 29) {
                Tile e = new TileE('e', 1);
                letterss.add(e);
            } else if (ii <= 31) {
                Tile f = new TileF('f', 4);
                letterss.add(f);
            } else if (ii <= 34) {
                Tile g = new TileG('g', 2);
                letterss.add(g);
            } else if (ii <= 36) {
                Tile h = new TileH('h', 4);
                letterss.add(h);
            } else if (ii <= 45) {
                Tile i = new TileI('i', 1);
                letterss.add(i);
            } else if (ii <= 46) {
                Tile j = new TileJ('j', 8);
                letterss.add(j);
            } else if (ii <= 47) {
                Tile k = new TileK('k', 5);
                letterss.add(k);
            } else if (ii <= 51) {
                Tile l = new TileL('l', 1);
                letterss.add(l);
            } else if (ii <= 53) {
                Tile m = new TileM('m', 3);
                letterss.add(m);
            } else if (ii <= 59) {
                Tile n = new TileN('n', 1);
                letterss.add(n);
            } else if (ii <= 67) {
                Tile o = new TileO('o', 1);
                letterss.add(o);
            } else if (ii <= 69) {
                Tile p = new TileP('p', 3);
                letterss.add(p);
            } else if (ii <= 70) {
                Tile q = new TileQ('q', 10);
                letterss.add(q);
            } else if (ii <= 76) {
                Tile r = new TileR('r', 1);
                letterss.add(r);
            } else if (ii <= 80) {
                Tile s = new TileS('s', 1);
                letterss.add(s);
            } else if (ii <= 86) {
                Tile t = new TileT('t', 1);
                letterss.add(t);
            } else if (ii <= 90) {
                Tile u = new TileU('u', 1);
                letterss.add(u);
            } else if (ii <= 92) {
                Tile v = new TileV('v', 4);
                letterss.add(v);
            } else if (ii <= 94) {
                Tile w = new TileW('w', 4);
                letterss.add(w);
            } else if (ii <= 95) {
                Tile x = new TileX('x', 8);
                letterss.add(x);
            } else if (ii <= 97) {
                Tile y = new TileY('y', 4);
                letterss.add(y);
            } else if (ii <= 98) {
                Tile z = new TileZ('z', 10);

            } else if (ii <= 100) {
                Tile spc = new TileZspace(' ', 0);
                letterss.add(spc);
            }

        }

    }

    public void getcharchoosen(String text) {
        boolean flag = false;
     
        
        do {
           
           
            
            flag = player.verifytiles(text);

            //VALIDATION FOR DICTIONARY!!!!!!!!!! ERRO NA ESCOLHA DE LETRAS// flag = dic.verifyword(newword);
            newword = text;
            played.setWordtemp(text);

        } while (flag == false);

    }

   public void makeplay2(String text,char letter,String wordtoform) {
      String word = " ";
        String word2 = " ";
        int line = 0;
        int writerposition = 0;
        int colm = 0;
        char posi = ' ';
        boolean tempflag = false;
        boolean tempflag2 = false;
        Tile neutral;
        String temp = " ";
        Tile aux = new Tile(' ',0);
        played.imprimeinfo();
        do {

            
            tempflag = played.existwordchoosen(text);

        } while (tempflag == false);

        do {

           
         
            posi = letter;
            tempflag2 = verify(played.getJogadastemp(), posi);
            neutral = played.getTile(posi);
            
            line = played.getTile(posi).getPosx();
            colm = played.getTile(posi).getPosy();
        } while (tempflag2 == false);

        nextplay = posi;

        boolean flag = false;
      

        do {
            
          
          
            aux= neutral;
            flag = player.verifytiles2(wordtoform,letter,aux);

          //VALIDATION FOR DICTIONARY!!!!!!!!!! // flag = dic.verifyword(newword);
        } while (flag == false);
        
        writerposition -= player.tilesbeforeneutral(letter);

        for (int i = 0; i < player.getYourRacktempo().size(); i++) {

            {
                if (played.getTempPosition() == 'h' || played.getTempPosition() == 'H') {

                      if (i < player.tilesbeforeneutral(letter)) {
                        board.setPositionBoard(line, colm + writerposition, player.getYourRacktempo().get(i));
                        player.getYourRacktempo().get(i).setPosx(line);
                        player.getYourRacktempo().get(i).setPosy(colm + writerposition);

                    } else if (i == player.tilesbeforeneutral(letter)) {
                        writerposition++;
                        continue;
                    } else {
                        board.setPositionBoard(line, colm + writerposition, player.getYourRacktempo().get(i));
                        player.getYourRacktempo().get(i).setPosx(line);
                        player.getYourRacktempo().get(i).setPosy(colm + writerposition);

                    }
                    writerposition++;
                }
                if (played.getTempPosition() == 'v' || played.getTempPosition() == 'V') {

                         if (i < player.tilesbeforeneutral(letter)) {
                        board.setPositionBoard(line + writerposition, colm, player.getYourRacktempo().get(i));
                        player.getYourRacktempo().get(i).setPosx(line + writerposition);
                        player.getYourRacktempo().get(i).setPosy(colm);

                    } else if (i == player.tilesbeforeneutral(letter)) {
                        writerposition++;
                        continue;
                    } else {
                        board.setPositionBoard(line + writerposition, colm, player.getYourRacktempo().get(i));
                        player.getYourRacktempo().get(i).setPosx(line + writerposition);
                        player.getYourRacktempo().get(i).setPosy(colm);

                    }
                    
                    
                    
                 
                    
             
                    writerposition++;
                }
            }
        }

        played.getJogadas().add(player.getYourRacktempo());
        played.getPosition().add(posi);
        board.refresh();
   //     board.printBoard();
        for (int i = 0; i < player.getYourRacktempo().size(); i++) {
            player.refreshHand(player.getYourRacktempo().get(i));
        }
      
        player.playerTilenext(letterss);

        player.printplayerTiles();
        System.out.println("\nScore do player -> " + player.getScore() + "\n");

    }

    public void Setup() {
 
        createTiles();
        letterss = player.playerTiles(letterss);
   

    }
    
    
    
    public int givenumbersforguix(int posxx)
    {
       int x = 10;
        for ( int i = 0 ; i< posxx ; i++)
        {
            if(i == posxx )
            {
                return x ;
            }
            else 
                x +=101;
        }
        
      
        return x;
    }
     public int givenumbersforguiy(int posyy)
    {
        int y = 10;
        for ( int i = 0 ; i< posyy ; i++)
        {
            if(i == posyy )
            {
                return y ;
            }
            else 
                y +=58;
        }
        
     
        return y;
    }
    public void makefirstplay(String text, char posit, int posxx, int posyy) {
        
        char posi = ' ';
        
        getcharchoosen(text);

   
       posi = posit;
     
        for (int i = 0; i < player.getYourRacktempo().size(); i++) {
             if (posi == 'h' || posi == 'H') {
             if (i == 0) {
                    board.setPositionBoard(posxx, posyy, player.getYourRacktempo().get(i));
                    player.getYourRacktempo().get(i).setPosx(posxx);
                    player.getYourRacktempo().get(i).setPosy(posyy);

                } else {
                    board.setPositionBoard(posxx + i, posyy, player.getYourRacktempo().get(i));
                    player.getYourRacktempo().get(i).setPosx(posxx + i);
                    player.getYourRacktempo().get(i).setPosy(posyy);

                }

            }
            if (posi == 'v' || posi == 'V') {
               
                    if (i == 0) {
                    board.setPositionBoard(posxx, posyy, player.getYourRacktempo().get(i));
                    player.getYourRacktempo().get(i).setPosx(posxx);
                    player.getYourRacktempo().get(i).setPosy(posyy);
                    
                } else {
                    board.setPositionBoard(posxx, posyy + i, player.getYourRacktempo().get(i));
                    player.getYourRacktempo().get(i).setPosx(posxx);
                    player.getYourRacktempo().get(i).setPosy(posyy + i);
                }
            }

        }
        
        played.getJogadas().add(player.getYourRacktempo());
        played.getPosition().add(posi);
        played.imprimeinfo();
        board.refresh();
      //  board.printBoard();

        for (int i = 0; i < player.getYourRacktempo().size(); i++) {
            player.refreshHand(player.getYourRacktempo().get(i));
        }
        
        player.playerTilenext(letterss);

        player.printplayerTiles();
         setNum(25);
        System.out.println("\nScore do player -> " + player.getScore() + "\n");
     
    }

    private boolean verify(ArrayList<Tile> letter, char posi) {

        for (Tile l : letter) {
            if (l.getLetter() == posi) {
                played.setPosxtemp(l.getPosx());
                played.setPosytemp(l.getPosy());
                return true;
            }
        }

        return false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
