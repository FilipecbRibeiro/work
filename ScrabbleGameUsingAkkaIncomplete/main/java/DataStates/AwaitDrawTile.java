/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStates;

import com.lightbend.akka.sample.Game;

/**
 *
 * @author Asus
 */
public class AwaitDrawTile  extends StateAdapter{
   
   public AwaitDrawTile(Game game)
   {
       super(game);
   }
   
   
   
   @Override
   public IStates drawTile()
   {
       
       
       
       if( getGameData().getNum()==0)
       return new AwaitFirstPlay(getGameData());
       else
       {   //getGameData().loopplay();
          
           return new AwaitPlay(getGameData());
       }

}
}
