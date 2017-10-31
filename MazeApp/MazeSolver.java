

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
    Square[][] goThrough;
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
    
    /**
     * Goes through the maze backwards to determine if the path has been completed
     */
    boolean isSolved(){
        Square backwards = maze.getEnd().previous();
        if(backwards == null) return false; //tests square before end
        else{
            while (backwards.getType() != 2 && backwards.getType() != 1){ //tests backward path
                backwards.setType(13);
                backwards = backwards.previous();
            }
        }
        return true;
    }
    
    String getPath(){    
        Square[][] goThrough = maze.getMaze(); // create array to go through the squares
        if (isSolved()){
             for (int x = 0; x < maze.getRows();  x++){ // go through rwos
                 for (int y = 0; y < maze.getCols(); y++){ // go through cols
                     if (goThrough[x][y].getType() == 6)
                        getPathSTR += ("["+ x +", " + y + "]"); // add coordinate to  path
                                         }                                   
                                        }
        }
        return getPathSTR;
        }

    Square step(){
        /**         
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
        if(this.isEmpty())
        {
            return null; // tests as false in isSolved
        }
        forStep = next();       // set next square     
        if (forStep.getType() == 3){ // test if finsih, return if true
            return forStep;
        }
        
        if(forStep != null){
         for(Square sq : maze.getNeighbors(forStep)){ // goes through neighbors of current square
             sq.setPrev(forStep); // sets previous to last square
             if(sq.getType() == 3)
                return forStep; //return end
             else{
                System.out.println("Step is running");
                sq.setType(11);//sets to on worklist
                add(sq); //adds square to the worklist in maze
                    }
            
         }
            
         if (forStep.getType() == 11) // if on worklist
           forStep.setType(12);   //sets the type of current square to EXPLORED
        
        }    
        return forStep;
    }

    void solve(){ // MAZE APP DOES NOT USE THE MAZESOLVER SOLVE METHOD!
       /* add(maze.getStart());
        while (isSolved() == false){

                this.step();  */                      
        }
    }


