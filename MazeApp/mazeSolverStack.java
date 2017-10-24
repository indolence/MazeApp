

/**
 * Write a description of class mazeSolverStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mazeSolverStack extends MazeSolver
{
    MyStack<Square> stack = new MyStack();
    Maze maze = new Maze();
    
    /**
     * Default constructor for objects of class mazeSolverStack
     */
    public mazeSolverStack()
    {
        super(maze);
    }
    
    public void add(Square sq) {
       stack.push(sq);
    }
    
    public void makeEmpty()
    {
        stack.empty();
    }
    
    public Square next(){
        return stack.remove();
    }
    
    public boolean isEmpty(){
        if (stack.isEmpty())
            return true;
        return false;
    }

}
