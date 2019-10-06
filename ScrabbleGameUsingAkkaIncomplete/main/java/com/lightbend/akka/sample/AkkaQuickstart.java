package com.lightbend.akka.sample;

import DataGui.GameData;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.io.IOException;

public class AkkaQuickstart  {




   public static void main(String[] args)throws IOException {
    
        
     final ActorSystem system = ActorSystem.create("helloakka");
    
   
      
      final ActorRef ola = system.actorOf(GameData.props(),"actoramedata");
   
      int score = 0 ; 

     
       System.out.println(">>> Press ENTER to exit <<<");
   }
}
