/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author atwil
 */
public class WorkAheadQueueTest  {
    
    public WorkAheadQueueTest() {
    }

    /**
     * Test of enqueue method, of class WorkAheadQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        String str = "egg";
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(str);
        assertEquals(1, instance.size());
        
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    @Test
    public void testDequeue_0args() throws Exception {
        System.out.println("dequeue");
        WorkAheadQueue instance = new WorkAheadQueue();
        
        try {
            instance.dequeue();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        
        Object expResult = "beepis";
        instance.enqueue("beepis");
        instance.enqueue("another beepis");
        assertEquals(2, instance.size());
        Object result = instance.dequeue();
        assertEquals(1, instance.size());
        assertEquals(expResult, result);
        expResult = "another beepis";
        result = instance.dequeue();
        assertEquals(expResult, result);
        assertEquals(0, instance.size());
    }

    /**
     * Test of first method, of class WorkAheadQueue.
     */
    @Test
    public void testFirst_0args() throws Exception {
        System.out.println("first");        
        WorkAheadQueue instance = new WorkAheadQueue();
        try {
            instance.first();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        Object expResult = "stringy";
        instance.enqueue("stringy");
        Object result = instance.first();
        assertEquals(expResult, result);
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    @Test
    public void testDequeue_int() throws Exception {
        System.out.println("dequeue");
        WorkAheadQueue instance = new WorkAheadQueue();
        try {
            instance.dequeue(0);
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        int pos = 3;    
        instance.enqueue("one");
        instance.enqueue("two");
        instance.enqueue("three");
        instance.enqueue("four");
        instance.enqueue("five");
        Object expResult = "four";
        Object result = instance.dequeue(pos);
        assertEquals(expResult, result);
        try {
            instance.dequeue(6);
        }
        catch (Exception e) {
            assertTrue(e instanceof InvalidArgumentException);
        }
        
    }

    /**
     * Test of first method, of class WorkAheadQueue.
     */
    @Test
    public void testFirst_int() throws Exception {
        System.out.println("first");
        WorkAheadQueue instance = new WorkAheadQueue();
        try {
            instance.dequeue(0);
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }        
        ArrayList<String> results = new ArrayList<String>();     
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        String five = "5";
        instance.enqueue(one);
        instance.enqueue(two);
        instance.enqueue(three);
        instance.enqueue(four);
        instance.enqueue(five);
        results.add(one);
        results.add(two);
        results.add(three);
        results.add(four);
        results.add(five);
        
        String expResult = "1";
        assertEquals(expResult, instance.first(0));
        
        instance.dequeue();
        instance.dequeue(2);
        
        results.remove(0);
        results.remove(2);
        
        expResult = "3";
        assertEquals(expResult, instance.first(1));
        
        try {
            instance.first(6);
        }
        catch (Exception e) {
            assertTrue(e instanceof InvalidArgumentException);
        }
    }

    /**
     * Test of firstFive method, of class WorkAheadQueue.
     */
    @Test
    public void testFirstFive() throws Exception {
        System.out.println("firstFive");
        WorkAheadQueue instance = new WorkAheadQueue();
        try {
            instance.firstFive();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        ArrayList<String> results = new ArrayList<String>(); 
        instance.enqueue("one");
        instance.enqueue("two");
        instance.enqueue("three");
        instance.enqueue("four");
        instance.enqueue("five");
        
        instance.dequeue();
        instance.dequeue(2);
        
        results = instance.firstFive();       
        
        assertTrue(results.size() > 0);
    }

    /**
     * Test of isEmpty method, of class WorkAheadQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue("item");
        boolean result = instance.isEmpty();
        try {
            instance.dequeue();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        assertFalse(result);
        try {
            instance.dequeue();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
        result = instance.isEmpty();
        assertTrue(result);
    }

    /**
     * Test of size method, of class WorkAheadQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue("one");
        instance.enqueue("two");
        instance.enqueue("three");
        instance.enqueue("four");
       // instance
        int expResult = 4;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class WorkAheadQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue("one");
        instance.enqueue("two");
        instance.enqueue("three");
        instance.enqueue("four");
        instance.enqueue("five");
        String expResult = "one, two, three, four, five, ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
