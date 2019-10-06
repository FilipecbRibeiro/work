///*/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.lightbend.akka.sample;
//
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import java.io.IOException;
//
///**
// *
// * @author Asus
// */
//public class Tese {
//
//    /**
//     * @param args the command line arguments
//     * @throws java.io.IOException
//     */
//    public static void main(String[] args) throws IOException {
//             final ActorSystem system = ActorSystem.create("helloakka");
//    try {
//      //#create-actors
//      final ActorRef printerActor =
//        system.actorOf(Printer.props(), "printerActor");
//      final ActorRef howdyGreeter =
//        system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter");
//      final ActorRef helloGreeter =
//        system.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
//      final ActorRef goodDayGreeter =
//        system.actorOf(Greeter.props("Good day", printerActor), "goodDayGreeter");
//      //#create-actors
//
//      //#main-send-messages
//      howdyGreeter.tell(new Greeter.WhoToGreet("Akka"), ActorRef.noSender());
//      howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
//
//      howdyGreeter.tell(new Greeter.WhoToGreet("Lightbend"), ActorRef.noSender());
//      howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
//
//      helloGreeter.tell(new Greeter.WhoToGreet("Java"), ActorRef.noSender());
//      helloGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
//
//      goodDayGreeter.tell(new Greeter.WhoToGreet("Play"), ActorRef.noSender());
//      goodDayGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
//      //#main-send-messages
//
//      System.out.println(">>> Press ENTER to exit <<<");
//      System.in.read();
//    } catch (IOException ioe) {
//    } finally {
//      system.terminate();
//    }
//
//            // TODO code application logic here
//    }
//
//}*/