/*444444444444444
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGui;

import DataStates.AwaitBeginning;
import DataStates.IStates;
import GuiStates.ScrabbleFrame;
import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.lightbend.akka.sample.Game;
import com.lightbend.akka.sample.Player;
import com.lightbend.akka.sample.Score;
import com.lightbend.akka.sample.Tile;
import com.lightbend.akka.sample.WordMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Asus //
 */
public class GameData extends AbstractActor implements Serializable {

    ObservableGame ob;

    private Game game;
    private IStates state;

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    final ActorSystem system = ActorSystem.create("helloakka");
    ActorRef getscore
            = system.actorOf(Score.props(0, this.getSelf()), "Score");
    ActorRef getWord = system.actorOf(WordMessage.props(" ", this.getSelf()), "Word");

    static public Props props() {
        return Props.create(GameData.class, () -> new GameData());
    }

    public GameData() throws IOException {

        game = new Game();
        state = new AwaitBeginning(game);
        ob = new ObservableGame(this);
        new ScrabbleFrame(ob);

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;

    }

    public IStates getState() {
        return state;
    }

    public void setState(IStates state) {
        this.state = state;
    }

    public void startGame() {
        setState(getState().start());
    }

    public void firstplay(String text, char posit, int posxx, int posyy) {
        setState(getState().firstplay(text, posit, posxx, posyy));

    }

    public void play(String text, char letter, String wordtoform) {
        setState(getState().play(text, letter, wordtoform));
    }

    public void drawTile() {
        setState(getState().drawTile());
    }

    public ArrayList<Tile> getPlayerRack() {
        return game.getPlayer().getYourRack();
    }

    public ArrayList<Tile> getPlayerRacktemp() {
        return game.getPlayer().getYourRacktempo();
    }

    public Player getPlayer() {
        return game.getPlayer();

    }

    public void actorsendmessage() {

        getscore.tell(new Score.WhoToGreet(getGame().getPlayer().getScore()), this.getSelf());
        getscore.tell(new Score.Greet(), Actor.noSender());
        String txt = "";
        for (int i = 0; i < getGame().getPlayed().getJogadas().size(); i++) {

            for (int j = 0; j < getGame().getPlayed().getJogadas().get(i).size(); j++) {
                txt += getGame().getPlayed().getJogadas().get(i).get(j).getLetter();
            }

        
        getWord.tell(new WordMessage.WhoToGreet(txt), this.getSelf());
        getWord.tell(new WordMessage.Greet(), this.getSelf());
        txt = new String();}
    }

    static public class GreetingScore {

        public int score = 0;

        public GreetingScore(int score) {

            this.score = score;
        }

    }

    static public class GreetingWord {

        public String message = "";

        public GreetingWord(String message) {

            this.message = message;

        }
    }

    @Override
    public Receive createReceive() {
        ReceiveBuilder builder = ReceiveBuilder.create();
        builder.match(GreetingScore.class, greeting -> {

            log.info("Score-> " + greeting.score);

        });
        builder.match(GreetingWord.class, greeting -> {

            log.info("Word--- > " + greeting.message);

        });

        return builder.build();
    }

}
