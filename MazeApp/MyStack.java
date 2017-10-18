import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementation of a stack
 *
 * @author
 * @version 1
 */
public class MyStack<T> implements StackADT<T>
{
    private ArrayList<T> stack;
    T toReturn;

    /**
     * Constructor
     *
     */
    public MyStack()
    {
        this.stack = new ArrayList<T>();
    }

    /**
     * Add an item onto the stack
     * @param item the data item to add (of type T)
     */
    public void push(T toAdd){        
        this.stack.add(0, toAdd);
    }

    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() throws NoSuchElementException
    {
        if (isEmpty())        
            throw new NoSuchElementException();
        return this.stack.remove(0);        
    }

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T top() throws NoSuchElementException
    {
        if (isEmpty())        
            throw new NoSuchElementException();        
        return this.stack.get(0);
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size()
    {   
        int counter = 0;         
       for (T element : this.stack)
        {
            counter++;            
        }
        return counter;
    }

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        if(this.stack.size() == 0)
            return true;
        return false;
    }

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        this.stack.clear();
    }

    public String toString()
    {
        int counter = 0;
        String str = "[";
       for (T element : this.stack)
        {
            str += " " + this.stack.get(counter) + " ";             
        }
        str += "]";

        return str;
    }
}
