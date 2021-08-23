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
public class LinkedBinarySearchTreeTest {
    
    public LinkedBinarySearchTreeTest() {
    }

    /**
     * Test of addElement method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testAddElement() {
        System.out.println("addElement");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        String expResult = "Hello";
        String expResult2 = "Guten Tag";
        instance.addElement("Hello");
        Boolean result = false;
        assertEquals(1, instance.size());
        instance.addElement("Bonjour");
        assertEquals(2, instance.size());
        BTNode<String> node = new BTNode<String>(expResult);
        try
        {
            result = instance.contains(expResult);
        }
        catch (Exception e)
        {
            assertTrue(e instanceof EmptyCollectionException);
        }
        assertEquals(true, result);
        
    }

    /**
     * Test of removeElement method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveElement() throws Exception {
        System.out.println("removeElement");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            String error  = instance.removeElement("Hi");
        }
        catch (Exception e)
        {
            assertTrue(e instanceof ElementNotFoundException);
        }
        String expResult = "Hello";
        instance.addElement(expResult);
        assertEquals(1, instance.size());
        Object result = instance.removeElement(expResult);
        assertEquals(0, instance.size());
        assertEquals(expResult, result);
    }

    /**
     * Test of removeAllOccurrences method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveAllOccurrences() throws Exception {
        System.out.println("removeAllOccurrences");
        Object targetElement = null;
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            instance.removeAllOccurrences("Hi");
        }
        catch (Exception e)
        {
            assertTrue(e instanceof ElementNotFoundException);
        }
        instance.addElement("Hello");
        instance.addElement("Bonjour");
        instance.addElement("Guten Tag");
        instance.addElement("Hello");
        assertEquals(4, instance.size());
        instance.removeAllOccurrences("Hello");
        assertEquals(2, instance.size());
    }

    /**
     * Test of removeMin method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testRemoveMin() throws Exception {
        System.out.println("removeMin");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            String error  = instance.removeMin();
        }
        catch (Exception e)
        {
            assertTrue(e instanceof EmptyCollectionException);
        }
        instance.addElement("A");
        instance.addElement("B");
        instance.addElement("C");
        instance.addElement("D");
        String result = instance.removeMin();
        String expResult = "A";
        assertEquals(expResult, result);
        assertEquals(3, instance.size());
        
    }

    /**
     * Test of findMin method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testFindMin() throws Exception {
        System.out.println("findMin");
         LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            String error  = instance.removeMin();
        }
        catch (Exception e)
        {
            assertTrue(e instanceof EmptyCollectionException);
        }
        instance.addElement("A");
        instance.addElement("B");
        instance.addElement("C");
        instance.addElement("D");
        String result = instance.findMin();
        String expResult = "A";
        assertEquals(expResult, result);
        assertEquals(4, instance.size());
    }
    
        /**
     * Test of contains method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testContains() throws Exception {
        System.out.println("removeAllOccurrences");
        Object targetElement = null;
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("Hi");
        assertTrue(instance.contains("Hi"));
    }

        /**
     * Test of find method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("removeAllOccurrences");
        Object targetElement = null;
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            Object error  = instance.find("Hi");
        }
        catch (Exception e)
        {
            assertTrue(e instanceof ElementNotFoundException);
        }
        instance.addElement("Hi");
        Object expResult = "Hi";
        assertEquals(expResult, instance.find("Hi"));
    }
    
        /**
     * Test of nodeDepth method, of class LinkedBinarySearchTree.
     */
    @Test
    public void testNodeDepth() throws Exception {
        System.out.println("removeAllOccurrences");
        Object targetElement = null;
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        try
        {
            int error  = instance.nodeDepth("Hi");
        }
        catch (Exception e)
        {
            assertTrue(e instanceof ElementNotFoundException);
        }
        instance.addElement("A");
        instance.addElement("B");
        int result = instance.nodeDepth("B");
        assertEquals(1, result);
    }


}
