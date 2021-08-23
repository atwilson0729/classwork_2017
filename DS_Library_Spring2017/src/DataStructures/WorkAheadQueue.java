package DataStructures;
import java.util.*;

/**
 *
 * @author atwil
 * @param <T>
 * @version 2017-10-19
 */
public class WorkAheadQueue<T> implements WorkAheadQueueADT<T> {
    private LinearNode<T> front;
    private LinearNode<T> back;
    private int numNodes;
    private ArrayList<LinearNode<T>> frontFive = new ArrayList<LinearNode<T>>();
    private ArrayList<LinearNode<T>> nodeList = new ArrayList<LinearNode<T>>();
    private ArrayList<LinearNode<T>> dequeued = new ArrayList<LinearNode<T>>();
    
    /**
     * default constructor for the WorkAheadQueue, 
     * sets nodes to zero and front and back to null
     */
    public WorkAheadQueue() {
        numNodes = 0;
        front = null;
        back = null;
    }
    
    /**
     * Enqueue() adds the given object to the queue, 
     * and adds it to the frontFive if it is in the front
     * @param item the generic object added to queue
     */
    @Override
    public void enqueue(T item) {
        LinearNode<T> temp = new LinearNode<>(item);
        if (frontFive.size() <= 5) {
            frontFive.add(temp);
        }
        nodeList.add(temp);
        if (back == null) {
            back = temp;
            front = temp;
            numNodes++;
            return;
        }
        back.setNext(temp);
        back = temp;
        
        
        numNodes++;
    }
    
    /**
     * Dequeue() removes the first item from the queue and returns it
     * Precondition: queue is not empty
     * @return T the removed element
     * @throws EmptyCollectionException if queue is empty
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Work Ahead Queue");
        }
        T element;
        if (dequeued.contains(front)) {            
            front = front.getNext();
            element = front.getElement();
            front = front.getNext();
        }
        else {
            element = front.getElement();
            front = front.getNext();
        }
        
        numNodes--;
        frontFive.remove(0);
        if (numNodes >= 5) {
            frontFive.add(nodeList.get(5));
        }
        nodeList.remove(0);
        return element;
    }
    
    /**
     * First() returns the first element in the queue
     * Precondition: queue is not empty
     * @return T - generic object in the front
     * @throws EmptyCollectionException if queue is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Work Ahead Queue");
        }
        if (dequeued.contains(front)) {
            front = front.getNext();
        }
        T item = front.getElement();
        return item;
    }
    
    /**
     * Removes and returns the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @param pos the passed in index of the element to be removed
     * @return T the element removed from the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     * 
     */
    @Override
    public T dequeue(int pos) throws EmptyCollectionException, 
            InvalidArgumentException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Work Ahead Queue");
        }
        if (pos > 4 || pos > frontFive.size() || pos < 0) {
            throw new InvalidArgumentException("Work Ahead Queue");
        }
        if (pos == 0)
        {
            return this.dequeue();
        }
        T removed = nodeList.get(pos).getElement();
        dequeued.add(nodeList.remove(pos));
        frontFive.remove(pos);
        if (numNodes > 5)
        {
            frontFive.add(nodeList.get(5));
        }
        numNodes--;
        return removed;
    }
    
    /**
     * Returns (without removing) the element that is at place x in the queue.
     * Precondition: x must be less than 5, x must be less than size
     * Note: indexing from 0: 0 == front element, 1 == second element, etc.
     * @return T the element at the front of the queue
     * @throws EmptyCollectionException if the queue is empty
     * @throws InvalidArgumentException if x > 4, or x > size of collection
     * @param pos the specified index of the element to return
     */
    @Override
    public T first(int pos)throws EmptyCollectionException, 
            InvalidArgumentException {
        if (numNodes == 0) {
            throw new EmptyCollectionException("Work Ahead Queue");
        }
        if (pos > 4 || pos > numNodes) {
            throw new InvalidArgumentException("Work Ahead Queue");
        }
        T item = frontFive.get(pos).getElement();
        return item;
    }
    
    /**
     * Returns an ArrayList of the first five nodes in the queue.
     * @return ArrayList<LinearNode<T>>[] array of nodes
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public ArrayList<LinearNode<T>> firstFive() 
            throws EmptyCollectionException {        
        if (numNodes == 0) {
            throw new EmptyCollectionException("Work Ahead Queue");
        }
        for (int i = 0; i < frontFive.size(); i++)
        {
            System.out.println(frontFive.get(i).getElement());
        }
        return frontFive;        
    }
    
    /**
     * Returns true or false depending on if queue is empty
     * @return boolean whether or not queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (numNodes == 0);
    }
    
    /**
     * Returns the amount of items in the queue
     * @return int - the size of the queue
     */
    @Override
    public int size() {
        return numNodes;
    }
    
    /**
     * Returns a formatted version of the queue
     * @return String - the string representation of a queue
     */
    @Override
    public String toString() {
        String str = "";
        LinearNode frontNode = front;
        int count = numNodes;
        while (count > 0) {
            str += (frontNode.getElement().toString() + ", ");
            frontNode = frontNode.getNext();
            count--;
        }
        return str;
    }
    
}
