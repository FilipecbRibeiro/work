/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import java.io.IOException;

/**
 *
 * @author Asus
 */
public class Board {

    public static final int N = 15;
    private static char[][] board = new char[N][N];
    
 
    private String[] row = new String[2 * N + 1];
    private String border = "";
    private int[] vector = new int[N];
    private String spaces = "|  ";
    private String[][] bonustiles = new String[15][15];

    Board() throws IOException {
        initializate();
    }
    
    
    
   
   public static char[][] getBoard() {
        return board;
    }

    public static void setBoard(char[][] aBoard) {
        board = aBoard;
    }
    public  void setPositionBoard(int line,int column,Tile tl)
    {
        board[line][column]= tl.getLetter();
    }
    
    private void initializate() {


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }
        board[7][7] = '*';


        for (int i = 0; i < N; i++) {

            border += "+----";
        }
        border += "+";

        for (int i = 0; i < 2 * N + 1; i += 2) {
            row[i] = border;
        }

        row[2 * N] = border;
        for (int i = 0; i < N; i++) {
            //left bar

            String spaces = "|  ";
        
            for (int j = 0; j < N; j++) {
                spaces += board[i][j];
                spaces += " |  ";
            }
            
            row[2 * i + 1] = spaces;

        }

    }

    void printBoard() {
        System.out.print("  A    B    C    D     E    F    G    H    I    J    K    L    M    N   O\n");

        System.out.println("Board 2 3: " + board[2][3]);
        for (int i = 0; i < 2 * N + 1; i++) {

            System.out.println(row[i]);
        }
    }

    void refresh() {
        for (int i = 0; i < N; i++) {

            String spaces = "|  ";
            for (int j = 0; j < N; j++) {
                spaces += board[i][j];
                spaces += " |  ";
            
            }
            row[2 * i + 1] = spaces;
            
        }

    }
    boolean validateboard( int i , int j, char h, String word)
            
    {
        if(h == 'h' || h == 'H'){
            for( int k = 0 ; k< word.length();k++)
            { 
               if (k == 0) {
                if( board [i][j] != ' ')
                    return false;
                else
                    return true;
                  }
               else
               {
                    if( board [i][j+k] != ' ')
                    return false;
                else
                    return true;
               }
            }
        }
        else
         if(h == 'v' || h == 'V'){
            for( int k = 0 ; k< word.length();k++)
            { 
               if (k == 0) {
                if( board [i][j] != ' ')
                    return false;
                else
                    return true;
                  }
               else
               {
                    if( board [i+k][j] != ' ')
                    return false;
                else
                    return true;
               }
            }
            }
         
             return false;
        
    }

    public String[] getRow() {
        return row;
    }

    public void setRow(String[] row) {
        this.row = row;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public String getSpaces() {
        return spaces;
    }

    public void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    public String[][] getBonustiles() {
        return bonustiles;
    }

    public void setBonustiles(String[][] bonustiles) {
        this.bonustiles = bonustiles;
    }
   
    
}
