/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcertTicket;

import org.junit.Test;
import static org.junit.Assert.*;
import  java.util.Date;

/**
 *
 * @author atwil
 */
public class WalletTestfake {
    
    public WalletTestfake() {
    }

    /**
     * Test of add method, of class Wallet.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Wallet wallet = new Wallet();
        ConcertTicket ct1 = new ConcertTicket("Phish", new Date("09/29/2016"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Beyonce", new Date("09/31/2016"), 20);

        //wallet should be empty at first
        assertEquals(0, wallet.getSize());
        
        //add a concert ticket
        wallet.add(ct1);
        
        //wallet should not be empty
        assertEquals(1, wallet.getSize());
        
        //add another
        wallet.add(ct2);
        
        //wallet should have 2
        assertEquals(2, wallet.getSize());
        
        //check that the second ticket is the second ticket in the wallet
        assertTrue(wallet.tickets[1].compareTo(ct2) == 0);
    }

    /**
     * Test of resize method, of class Wallet.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        Wallet instance = new Wallet();
        instance.resize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Wallet.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Wallet instance = new Wallet();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Wallet.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Wallet instance = new Wallet();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
