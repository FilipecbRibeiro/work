package com.lightbend.akka.sample;

import DataGui.GameData;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;


//#greeter-messages
public class Score extends AbstractActor {

  private int score= 0 ; 
  private final ActorRef printerActor;
 
    private int scoregreeting  = 0;
//#greeter-messages
  static public Props props(int score, ActorRef printerActor) {
    return Props.create(Score.class, () -> new Score(score, printerActor)); }

  static public class WhoToGreet {
    public final int who;
    public WhoToGreet(int who) {
        this.who = who; }
  }
  static public class Greet {
    public Greet() { }
  }
  public Score(int score, ActorRef printerActor) {
    this.score = score;
    this.printerActor = printerActor;
  }
  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(WhoToGreet.class, wtg -> {
          this.scoregreeting = score  + wtg.who;
        })
        .match(Greet.class, x -> {   
          printerActor.tell(new GameData.GreetingScore(scoregreeting), getSelf()); 
        })
        .build();
  }
}

