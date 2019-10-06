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
public class AwaitBeginning extends StateAdapter {

    public AwaitBeginning(Game game) {
        super(game);
    }

    @Override
    public IStates start() {

       
     
    
        return new AwaitFirstPlay(getGameData());
    }
   
}
