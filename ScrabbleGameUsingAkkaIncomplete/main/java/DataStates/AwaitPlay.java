/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStates;

import com.lightbend.akka.sample.*;

/**
 *
 * @author Asus
 */
public class AwaitPlay extends StateAdapter {

    public AwaitPlay(Game game) {
        super(game);
    }

    @Override
    public IStates play(String text, char letter,String wordtoform) {
       
       getGameData().makeplay2(text,letter, wordtoform);
       
       getGameData().loopplay();
      
        return new AwaitDrawTile(getGameData());
    }
   
}
