
import java.util.*;
import java.util.NoSuchElementException;


/**
 * Write a description of class MyQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyQueue<T> implements QueueADT<T>
{
    LinkedList<T> queue = new LinkedList<>();
    Node node = new Node();
    private Node first;
    private Node last;

    /**
     * Default constructor for objects of class MyQueue
     */
    public MyQueue()
    {
        first = null;
        last = null;
    }
    
    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    public void enqueue(T item){    
      Node newnode = new Node(); // Creates new Node
      newnode.data = item; //Puts Data into node
      if(isEmpty()){ //Sees if the node is empty
        first = newnode;} //if node is empty then head is the node
      else{
        last.next = newnode; //if node is not empty then the tail need to point 
                             // to this
        }
      last = newnode; // tail is now equal to this node                  
    }
    
    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() throws NoSuchElementException{
      if(isEmpty()){ // checks to see if empty and if it is thows exception
          throw new NoSuchElementException();
      }
      T item = (T)first.data; //takes data from head
      first = first.next; //makes second in line new head
      return item; //sends back the data
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public T front() throws NoSuchElementException{
      if(isEmpty()){ // checks to see if empty and if it is thows exception
          throw new NoSuchElementException();
      }      
      return (T)first;
    }
    
    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    public int size(){
        int counter;
        return counter;
    }
    
    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty(){
        if (first == null)
            return true;
            
        return false;
    }
    
    /**
     * Clear out the data structure
     */
    public void clear(){
    }

}

//Class Node
   class Node{
       public Object data;
       public Node next;
    }