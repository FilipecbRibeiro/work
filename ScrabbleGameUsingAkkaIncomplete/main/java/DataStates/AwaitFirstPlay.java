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
public class AwaitFirstPlay extends StateAdapter {

    public AwaitFirstPlay(Game game) {
     super(game);
    }

    /**
     *
     * @param text
     * @param posit
     * @param posxx
     * @param posyy
     * @return
     */
    @Override
  public IStates firstplay(String text,char posit,int posxx, int posyy )  {
      
      
        
  
        
      getGameData().makefirstplay(text, posit,posxx,posyy);
      getGameData().getPlayer().getYourRacktempo();
      getGameData().givenumbersforguix(posxx);
      getGameData().givenumbersforguiy(posyy);
      
      return new AwaitDrawTile(getGameData());
  }
    
    
}
