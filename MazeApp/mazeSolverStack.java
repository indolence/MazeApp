

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
    public mazeSolverStack(Maze maze)
    {
        super(maze);
    }
    
    public void add(Square sq) {
       stack.push(sq);
    }
    
    public void makeEmpty()
    {
        stack = new MyStack();
    }
    
    public Square next(){
        return stack.pop();
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
