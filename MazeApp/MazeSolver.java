

/**
 * Write a description of abstract class MazeSolver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MazeSolver
{
    Maze maze;
    boolean solved;
    String getPathSTR;
    Square forStep;
    //You're doing it wrong
    //Please go away
    //You're way too close
    //Thanks
    
        
    MazeSolver(Maze newMaze){
        this.maze = newMaze;
        this.solved = false;
        this.makeEmpty();
        this.add(this.maze.getStart() );
    }
    
    abstract void makeEmpty();    

    abstract boolean isEmpty();    

    abstract void add(Square sq);    
    
    abstract Square next();    

    boolean isSolved(){
        return solved;
    }
    
    String getPath(){      
        return getPathSTR;
        }
                    
                
            
        
    

    Square step(){
        /**
         * At the start

         * Create an (empty) worklist (stack/queue) of locations to explore.
         * Add the start location to it.
         * Each step thereafter

         * Is the worklist empty? If so, the exit is unreachable; terminate the algorithm.
         * Otherwise, grab the "next" location to explore from the worklist.
         * Does the location correspond to the exit square? If so, the finish was reachable; terminate the algorithm and output the path you found.
         * Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
         * compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls, and
         * add them to the worklist for later exploration provided they have not previously been added to the worklist.
         * Also, record the fact that you've explored this location so you won't ever have to explore it again. Note that a location is considered "explored" once its neighbors have been put on the worklist. 
         * The neighbors themselves are not "explored" until they are removed from the worklist and checked for their neighbors.
         */
        // check if the maze cannot be solved
        if( this.isEmpty() )
        {
            return null;
        }
        
        for (Square sq : this.maze.getNeighbors(sq)){              
            if (sq.getType == 3){
                return sq;
            }
        }
            
            if (this.maze.getNeighbors == null){
        }
                
              
            this.add(sq);
        

    
        return forStep;
    }

    void solve(){
    }

}
