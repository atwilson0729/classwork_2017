/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcertTicket;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atwil
 */
public class WalletTest {
    
    public WalletTest() {
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
     * Test of remove method, of class Wallet.
     */
    @Test
    public void testRemove() {
        System.out.println("add");
        
        Wallet wallet = new Wallet();
        ConcertTicket ct1 = new ConcertTicket("Phish", new Date("09/29/2016"), 18.5);
        ConcertTicket ct2 = new ConcertTicket("Beyonce", new Date("09/31/2016"), 20);
        
        //add ConcertTickets
        wallet.add(ct1);
        wallet.add(ct2);
        
        //now remove them
        ConcertTicket ct2Removed = wallet.remove();
        ConcertTicket ct1Removed = wallet.remove();
        
        //wallet should now be empty
        assertEquals(0,wallet.getSize());
        
        //check to make sure being removed in correct order
        assertTrue(ct1.compareTo(ct1Removed) == 0);
        
        
    }

    
    
}
