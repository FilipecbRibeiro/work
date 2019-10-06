package com.lightbend.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

//#greeter-messages
public class Continue extends AbstractActor {
//#greeter-messages
    private final ActorRef printerActor ;
 
  private String greeting = "";
  private Game game ; 

  static public Props props(Game game, ActorRef printerActor) {
    return Props.create(Continue.class, () -> new Continue(game, printerActor));
  }

 

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

  //#greeter-messages
  static public class Gamestartwhotogreet {
    public final Game game;

    public Gamestartwhotogreet(Game game) {
        this.game = game;
      
    }
  }

  static public class GameWho {
    public GameWho() {
    }
  }
  //#greeter-messages

  
  
  public Continue(Game game, ActorRef printerActor)
  {
      this.game = game;
     this.printerActor =printerActor;
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(Gamestartwhotogreet.class, wtg -> {
          this.game = wtg.game;
          setGame(game);
        })
        .match(GameWho.class, x->{
          //#greeter-send-message
           
        })  
        .build();
  }

    
}
//#greeter-messages
