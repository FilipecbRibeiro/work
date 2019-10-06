package com.lightbend.akka.sample;
import DataGui.GameData;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
//#greeter-messages




public class WordMessage extends AbstractActor {
  private final ActorRef printerActor;
    private String message= "";
    private String complete = "";
//#greeter-messages
  static public Props props(String message, ActorRef printerActor) {
    return Props.create(WordMessage.class, () -> new WordMessage(message, printerActor));}
  static public class WhoToGreet {
    public final String who;
public WhoToGreet(String who) {
        this.who = who ;}}
  static public class Greet {
    public Greet() { }}
  public WordMessage(String message, ActorRef printerActor) {
    this.message = message;
    this.printerActor = printerActor;}
  @Override
  public AbstractActor.Receive createReceive() {
    return receiveBuilder()
        .match(WhoToGreet.class, wtg -> { 
            this.complete =  message + wtg.who ;    })
        .match(Greet.class, x -> {
         printerActor.tell(new GameData.GreetingWord(complete ), getSelf());
        }) .build(); }}