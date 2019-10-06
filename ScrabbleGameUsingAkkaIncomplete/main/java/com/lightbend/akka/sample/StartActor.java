//package com.lightbend.akka.sample;
//
//
//import akka.actor.AbstractActor;
//import akka.actor.ActorRef;
//import akka.actor.Props;
//import akka.japi.pf.ReceiveBuilder;
//
//
////#greeter-messages
//public class StartActor extends AbstractActor {
////#greeter-messages
//    private final ActorRef printerActor ;
//  private int score= 0 ; 
//  
// 
//    private int scoregreeting  = 0;
//  private String greeting = "";
//  private Game game ; 
//
//  static public Props props(Game game, ActorRef printerActor) {
//    return Props.create(StartActor.class, () -> new StartActor(game, printerActor));
//  }
//
// 
//
//    public String getGreeting() {
//        return greeting;
//    }
//
//    public void setGreeting(String greeting) {
//        this.greeting = greeting;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//
//
//  //#greeter-messages
//  static public class Gamestartwhotogreet {
//    public final Game game;
//
//    public Gamestartwhotogreet(Game game) {
//        this.game = game;
//      
//    }
//  }
////
////   static public class ContinueGame 
////  {
////      Game game;
////
////     
////      public ContinueGame(Game game)  {
////          
////          this.game = game ; 
////          System.out.println("ALTOSFILMES");
////         // game.LoopPlay();
////         
////            
////        
////    }
////      
////      
////  }
//  static public class GameWho {
//    public GameWho() {
//    }
//  }
//  //#greeter-messages
//
////  static public class WhoToGreet {
////    public final int who;
////
////    public WhoToGreet(int who) {
////        this.who = who;
////    }
////  }
////
////  
////  static public class Greet {
////    public Greet() {
////      
////    }
////  }
////  
//  public StartActor(Game game, ActorRef printerActor)
//  {
//      this.game = game;
//     this.printerActor=printerActor;
//        System.out.println("proooops2222");
//   //  setGame(game);
//  }
//
//  @Override
//  public Receive createReceive() {
//  ReceiveBuilder builder= ReceiveBuilder.create();
//       builder.match(Gamestartwhotogreet.class, wtg -> {
//           System.out.println("who to greet from game");
//            this.game = wtg.game;
//            setGame(game);
//         //setGame(game);
//        });
//       builder.match(GameWho.class, x->{
//            System.out.println("vou enviar o jogo aqui");
//            
//   //    printerActor.tell(new StartGame(game), getSelf());
//       });
////             builder.match(ContinueGame.class, continuegame->{
////          System.out.println("sadasdasdasd" +continuegame.game.conta);
////           System.out.println("cheguei!!!!!!!!!!!!!!!!");
////      });
//
//
//     return builder.build();
////#greeter-send-message
////        }).match(WhoToGreet.class,wtg->{
////           // System.out.println("who to greet score");
////        this.scoregreeting = score +wtg.who;
////        }).match(Greet.class, x->{
////           // System.out.println("sending score"); 
////            printerActor.tell(new GreetingScore(69), getSelf());
////             
////        })
//            
//     
//  }
////#greeter-messages
//
//    
//}
////#greeter-messages
