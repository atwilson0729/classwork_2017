/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atwil
 */
public class LinkedStackTest {
    
    public LinkedStackTest() {
    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() throws Exception {
        System.out.println("pop");
        LinkedStack<String> instance = new LinkedStack();
        assertTrue(instance.isEmpty());
        instance.push("Quote1");
        assertFalse(instance.isEmpty());
        Object expResult = "Quote1";
        Object result = instance.pop();
        assertTrue(instance.isEmpty());
        assertEquals(expResult, result);
    }


    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() throws Exception{
        System.out.println("push");
        LinkedStack<String> instance = new LinkedStack();
        assertTrue(instance.isEmpty());
        instance.push("Quote1");
        assertFalse(instance.isEmpty());
        Object expResult = "Quote1";
        Object result = instance.peek();
        assertFalse(instance.isEmpty());
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("peek");
        LinkedStack<String> instance = new LinkedStack();
        assertTrue(instance.isEmpty());
        instance.push("Quote1");
        assertFalse(instance.isEmpty());
        Object expResult = "Quote1";
        Object result = instance.peek();
        assertEquals(expResult, result);
    }
    
}
