/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGui;

import DataStates.IStates;
import akka.actor.ActorRef;
import com.lightbend.akka.sample.Game;
import java.io.IOException;
import java.util.Observable;

/**
 *
 * @author Asus
 */
public class ObservableGame extends Observable {
 
    private GameData gamedata  ;
   
    
    public ObservableGame(GameData gamedata)
    {
        this.gamedata= gamedata;
    }

    
    public Game getGame()
    {
        return gamedata.getGame();
    }
    public GameData getGameData()
    {
        return gamedata;
        
    }
    
    public void setGameData(GameData gamedata)
    {
        this.gamedata =gamedata;
        setChanged();
        notifyObservers();
        
    }
    
    public IStates getState()
    {
        return gamedata.getState();
    }
    
    public void setStates(IStates state)
    {
        this.gamedata.setState(state);
        setChanged();
        notifyObservers();
    }
        public void  start()
    {
        gamedata.startGame();
        
        setChanged();
        notifyObservers();
    }
            public void firstplay(String text,char posit,int posxx,int posyy)
    {
        gamedata.firstplay(text,posit,posxx,posyy);
        setChanged();
        notifyObservers();
    }
                   public void play(String text,char letter,String wordtoform)
    {
        gamedata.play(text,letter,wordtoform);
        setChanged();
        notifyObservers();
    }
    public void draw()
    {
        gamedata.drawTile();
        setChanged();
        notifyObservers();
    }
    

}
