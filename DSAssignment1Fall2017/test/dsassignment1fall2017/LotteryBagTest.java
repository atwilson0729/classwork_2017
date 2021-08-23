/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment1fall2017;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atwil
 */
public class LotteryBagTest {
    
    public LotteryBagTest() {
    }

    /**
     * Test of add method, of class LotteryBag.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        LotteryBag bag = new LotteryBag();
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        LotteryTicket t2 = new LotteryTicket(114010, "Lotto");
        LotteryTicket t3 = new LotteryTicket(140981, "Powerball");
        
        //bag should be empty
        assertEquals(0, bag.size());
        
        //add lotto ticket
        bag.add(t1);
        
        //wallet should not be empty
        assertEquals(1, bag.size());
        
        //add another
        bag.add(t2);
        
        //wallet should have two
        assertEquals(2, bag.size());
        
        //add another
        bag.add(t3);
        
        //wallet should have 3
        assertEquals(3, bag.size());
        
        //check that second ticket is second and third ticket is third
        assertEquals(bag.bag.get(1), t2);
        assertEquals(bag.bag.get(2), t3);
    }

    /**
     * Test of remove method, of class LotteryBag.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        LotteryBag bag = new LotteryBag();
        
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        LotteryTicket t2 = new LotteryTicket(114010, "Lotto");
        
        //add lotto tickets
        bag.add(t1);
        bag.add(t2);
        
        //remove added tickets
        Comparable rt1 = bag.remove();
        Comparable rt2 = bag.remove();
        
        //bag should be empty
        assertEquals(0, bag.size());
         
    }

    /**
     * Test of contains method, of class LotteryBag.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        LotteryBag bag = new LotteryBag();

        //create new ticket
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        
        //since ticket isn't added, expected result is false
        boolean expResult = false;
        //result is whether bag contains ticket
        boolean result = bag.contains(t1);
        //bag should not contain ticket
        assertEquals(expResult, result);
        
        //add ticket to bag
        bag.add(t1);
        //since ticket is added, expected result is true
        expResult = true;
        //result is whether bag contains ticket
        result = bag.contains(t1);
        //bag should contain ticket
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class LotteryBag.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LotteryBag bag = new LotteryBag();
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        
        //bag should be empty
        assertEquals(true, bag.isEmpty());
        
        //add ticket to bag
        bag.add(t1);
        
        //bag should not be empty
        assertEquals(false, bag.isEmpty());
    }

    /**
     * Test of size method, of class LotteryBag.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LotteryBag bag = new LotteryBag();
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        LotteryTicket t2 = new LotteryTicket(114010, "Lotto");

        //add two tickets to the bag
        bag.add(t1);
        bag.add(t2);
        
        //set expected size
        int expSize = 2;
        
        //bag should be 2 tickets large
        assertEquals(expSize, bag.size());
    }

    /**
     * Test of toString method, of class LotteryBag.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LotteryBag bag = new LotteryBag();
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        
        //add ticket to bag
        bag.add(t1);
        
        //expected result is the string of the ticket
        String expResult = "Daily lottery ticket worth $12000!\n";
        //result is the ticket from bag
        String result = bag.toString();
        //should print the same string
        assertEquals(expResult, result);
    }

    /**
     * Test of pick3 method, of class LotteryBag.
     */
    @Test
    public void testPick3() {
        System.out.println("pick3");
        LotteryBag bag = new LotteryBag();
        LotteryTicket t1 = new LotteryTicket(12000, "Daily");
        LotteryTicket t2 = new LotteryTicket(140235, "Lotto");
        LotteryTicket t3 = new LotteryTicket(299999, "Powerball");
        
        //if is empty
        assertEquals(null, bag.pick3());
        
        //add one ticket to bag
        bag.add(t1);
        
        //if bag has one ticket, ticket should be the added ticket
        assertEquals(t1, bag.pick3());
        
        //add another ticket to bag, add back removed tickets
        bag.add(t1);
        bag.add(t2);
        
        //if bag has two tickets, ticket returned should be t2 because it is the larger ticket
        assertEquals(t2, bag.pick3());
        
        //add another ticket to bag, add back removed tickets
        bag.add(t2);
        bag.add(t3);
        
        //if bag has 3 tickets, ticket returned should be t3 becauuse it is the larger ticket
        assertEquals(t3, bag.pick3());
        
    }
    
}
