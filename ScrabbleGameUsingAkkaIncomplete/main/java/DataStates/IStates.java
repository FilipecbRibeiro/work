/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStates;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public interface IStates extends Serializable {
//
    IStates start(); 
    IStates firstplay(String text,char posit,int posxx, int posyy);
    IStates drawTile();
    IStates play (String text,char letter,String wordtoform );

}
