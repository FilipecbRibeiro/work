//package com.lightbend.akka.sample;
//
//import akka.actor.AbstractActor;
//import akka.actor.ActorRef;
//import akka.actor.Props;
//import akka.event.Logging;
//import akka.event.LoggingAdapter;
//import akka.japi.pf.ReceiveBuilder;
//
//
//import java.io.IOException;
// 
// 
////#printer-messages
//public class Printer extends AbstractActor {
// 
//     private  ActorRef startgame ;
//     private Game game ; 
//    
//    public static Props props(Game game, ActorRef startgame) {
//           return Props.create(Printer.class, () -> new Printer(game, startgame));
//    }
////#printer-messages
//   
//
//
//     static public Props props() {
//    return Props.create(Printer.class, () -> new Printer());
//  }   
// 
//   
//  
//
//   
//
//    public LoggingAdapter getLog() {
//        return log;
//    }
//
//    public void setLog(LoggingAdapter log) {
//        this.log = log;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//  //#printer-messages
//  static public class GreetingScore {
//    public  int score=0;
//    
//    public GreetingScore(int score) {
//      this.score = score;
//    }
//
//    
//  }
//  static public class GreetingWord
//  {
//      public  String message = "" ; 
//    
//      public GreetingWord(String message) {
//      this.message= message ;
//        
//    }
//  }
//   static public class StartGame 
//  {
//    public Game gamee;
//    private ActorRef actor  ;
//      public StartGame(Game game) throws IOException {
//          System.out.println("vou entrar");  
//           game = new Game();
//            gamee= game; 
//            
//             System.out.println("printing num 25->  "+ game.getNum());
//            
//            
//            
//    }
//
//     
//   
//   }
//   
//   static public class Gamecontinuewhotogreet {
//    public final Game game;
//
//    public Gamecontinuewhotogreet(Game game) {
//        this.game = game;
//      
//    }
//  }
//   
// static public class GamesWho {
//    public GamesWho() {
//    }
//  }
//    public Printer( )
//    {
//        
//       
//    }
//   public Printer(Game game, ActorRef printerActor)
//  {
//    this.game = game ;
//      System.out.println("primeiro");
//   this.startgame= printerActor;
//  }
//
//  //#printer-messages
//
//  private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
//  
//
//
//  @Override
//  public Receive createReceive() {
//
//           ReceiveBuilder builder = ReceiveBuilder.create();
//
//           builder.match(StartGame.class,( StartGame here) ->
//         {
//          
//                    System.out.println("Recebi jogo " + here.gamee.getConta());
//
//                    
//        log.info("something->" + here.gamee.getNum());
//                     getSender().tell(here, getSelf());
//        
//        
//                     
//         });
//     
//        
//           
//           
//           return builder.build();
//           
//           
//   
//  }
//}