/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thisPC
 */
public class SwipeTest {
    
    public SwipeTest() {
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
     * Test of getId method, of class Swipe.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Swipe instance = new Swipe();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardId method, of class Swipe.
     */
    @Test
    public void testGetCardId() {
        System.out.println("getCardId");
        Swipe instance = new Swipe();
        String expResult = "";
        String result = instance.getCardId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCardId method, of class Swipe.
     */
    @Test
    public void testSetCardId() {
        System.out.println("setCardId");
        String cardId = "";
        Swipe instance = new Swipe();
        instance.setCardId(cardId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoom method, of class Swipe.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        Swipe instance = new Swipe();
        String expResult = "";
        String result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoom method, of class Swipe.
     */
    @Test
    public void testSetRoom() {
        System.out.println("setRoom");
        String room = "";
        Swipe instance = new Swipe();
        instance.setRoom(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwipeDateTime method, of class Swipe.
     */
    @Test
    public void testGetSwipeDateTime() {
        System.out.println("getSwipeDateTime");
        Swipe instance = new Swipe();
        Calendar expResult = null;
        Calendar result = instance.getSwipeDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Swipe.
     */
    @Test
    public void testToString_char() {
        System.out.println("toString");
        char delimiter = ' ';
        Swipe instance = new Swipe();
        String expResult = "";
        String result = instance.toString(delimiter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Swipe.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Swipe instance = new Swipe();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Swipe.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Swipe instance = new Swipe();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Swipe.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Swipe compareSwipe = null;
        Swipe instance = new Swipe();
        int expResult = 0;
        int result = instance.compareTo(compareSwipe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of formatSwipeDateTime method, of class Swipe.
     */
    @Test
    public void testFormatSwipeDateTime() {
        System.out.println("formatSwipeDateTime");
        Calendar calendar = null;
        String expResult = "";
        String result = Swipe.formatSwipeDateTime(calendar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Swipe.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        Swipe instance = new Swipe();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
