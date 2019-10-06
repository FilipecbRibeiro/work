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
public class StateAdapter implements IStates {

    private Game game;

    public StateAdapter(Game game) {
        this.game = game;
    }

    public Game getGameData() {
        return game;
    }

    public void setGameData(Game game) {
        this.game = game;
    }

    @Override
    public IStates start() {
        return this;
    }

    @Override
    public IStates firstplay(String text, char posit, int posxx, int posyy) {
        return this;
    }

    @Override
    public IStates drawTile() {

        return this;

    }

    /**
     *
     * @param text
     * @param posit
     * @param letter
     * @return
     */
    @Override
    public IStates play(String text, char letter,String wordtoform)
    {
        return this;
    }
}
