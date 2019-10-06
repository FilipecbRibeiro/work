/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lightbend.akka.sample;

import DataGui.GameData;
import akka.actor.AbstractActor;
import akka.actor.Props;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class GameDataIT {
    
    public GameDataIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of props method, of class Printer.
     */
    @Test
    public void testProps() {
        System.out.println("props");
        Props expResult = null;
        Props result = GameData.props();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of propss method, of class Printer.
     */
//    @Test
//    public void testPropss() {
//        System.out.println("propss");
//        Props expResult = null;
//        Props result = GameD.propss();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createReceive method, of class Printer.
     */
    @Test
    public void testCreateReceive() throws IOException {
        System.out.println("createReceive");
        GameData instance = new GameData();
        AbstractActor.Receive expResult = null;
        AbstractActor.Receive result = instance.createReceive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
