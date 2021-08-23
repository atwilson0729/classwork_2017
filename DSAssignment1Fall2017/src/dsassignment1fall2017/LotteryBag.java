/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment1fall2017;
import java.util.*;

/**
 *
 * @author Andrew Wilson
 * @version 2017-09-21
 * @param <T>
 */
public class LotteryBag<T extends Comparable<T>> implements BagADT<T>
{
    /**
     * This ArrayList functions as the lottery bag for whatever object
     * type is passed into the class
     */
    ArrayList<T> bag;
    /**
     * Default constructor for the Lottery bag takes no parameters and 
     * creates an ArrayList 
     */
    public LotteryBag()
    {
        bag = new ArrayList<>();
    }
    
    /**
     * Overloaded constructor that takes in a T object and creates 
     * an ArrayList and adds the T to the ArrayList
     * @param t 
     */
    public LotteryBag(T t)
    {
        bag = new ArrayList<>();
        bag.add(t);
    }
     /**
     * Adds the 'element' to the bag. Bags don't care if an object
     * already exists in the bag, duplicate are allowed. Also it
     * does not matter where the element is added, beginning, end,
     * an empty slot, up to you.
     *
     * To add an element, the bag must make sure that it has enough
     * space to hold the new element. This routine should not fail
     * because the bag is full, the bag should always grow to accommodate
     * adds.
     * 
     * @param t
     * @precondition element != null
     */
    @Override
    public void add(T t)
    {
        bag.add(t);
    }

    /**
     * Removes an element randomly and returns it
     * @precondition precondition: (!isEmpty())
     * @return object removed from bag
     */
    @Override
    public T remove()
    {
        Random rand = new Random();
        int r;
        if (this.isEmpty())
        {
            return null;
        }
        else
        {
            r = rand.nextInt(this.size());
        }
        return bag.remove(r);
    }

    /**
     * Returns true if this bag contains 'target', false otherwise
     * @param target
     * @precondition target != null
     * @return boolean true if bag contains it, false otherwise
     */    
    @Override
    public boolean contains(T target)
    {
        //return bag.contains(target);
        for (T t : bag)
        {
            if (t.compareTo(target) == 0)
            {
                return true;                
            }
        }
        return false;
    }

    /**
     * Returns true if this bag contains no elements (i.e. size() == 0)
     * @return boolean true if the bag is empty, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return bag.isEmpty();
    }

    /**
     * Returns the number of elements in the bag. Note that this the
     * number of elements stored in the bag, not the size of the
     * array to hold elements.
     * @return int for the size of the collection/bag
     */
    @Override
    public int size()
    { 
        return bag.size();
    }

    /**
     * Returns a string representation of this bag, for debugging purposes
     * @return a string
     */
    @Override
    public String toString()
    {
        String bagStr = new String();
        for (T t: bag)
        {
            bagStr += t.toString() + "\n";
        }
        return bagStr;
    }
    
    /**
     * allows 3 elements to be selected from the bag, 
     * and then the highest  value element 
     * (based on using the elements’ compareTo method)
     * is returned
     * @return T, a generic object
     */
    public T pick3()
    {
        if (bag.isEmpty())
        {
            return null;
        }        
        else if (bag.size() == 1)
        {
            return bag.remove(0);
        }
        else if (bag.size() == 2)
        {
            T t1 = this.remove();
            T t2 = this.remove();            
            
            if (t1.compareTo(t2) == 1)
            {
                this.add(t2);
                return t1;
            }
            else if (t2.compareTo(t1) == 1)
            {
                this.add(t1);
                return t2;
            }
        }
        else if (bag.size() > 2)
        {
            T t1 = this.remove();
            T t2 = this.remove();
            T t3 = this.remove();
            
            System.out.println("\n" + t1 + "\n" + t2 + "\n" + t3 + "\n");
            
            if (t1.compareTo(t2) == 1 && t1.compareTo(t3) == 1)
            {
                this.add(t2);
                this.add(t3);
                return t1;
            }
            else if (t2.compareTo(t1) == 1 && t2.compareTo(t3) == 1)
            {
                this.add(t1);
                this.add(t3);
                return t2;
            }
            else if (t3.compareTo(t1) == 1 && t3.compareTo(t2) == 1)
            {
                this.add(t1);
                this.add(t2);
                return t3;
            }
            else
            {
                return t1;
            }
        }
        return null;
    }
            
}
