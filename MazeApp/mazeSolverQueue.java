

/**
 * Write a description of class mazeSolverQueue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mazeSolverQueue extends MazeSolver
{
    public MyQueue<Square> queue;
    Maze maze = new Maze();
    
    /**
     * Default constructor for objects of class mazeSolverQueue
     */
    public mazeSolverQueue(Maze maze)
    {
        super(maze);
    }
    
    public void add(Square sq) {
       queue.enqueue(sq);
    }
    
    public void makeEmpty()
    {
        queue = new MyQueue();
    }
    
    public Square next(){
        return queue.dequeue();
    }
    
    public boolean isEmpty(){
        if (queue.isEmpty())
            return true;
        return false;
    }

    

}
