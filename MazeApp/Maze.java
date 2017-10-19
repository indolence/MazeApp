import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.util.NoSuchElementException;
import java.util.ArrayList;

       

/**
 * Stores layout of a maze.
 *
 * Elizabeth Cone
 */
public class Maze
{
    private Square[][] maze;
    private Square[][] backupMaze;
    File load;
    int numRows = 0;
    int numCols = 0;   
    int newType = 0;
    Scanner in = null;
    Square toReturn;
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Maze testMaze = new Maze(); //TESTER
        testMaze.loadMaze();    //TESTER
        System.out.print(testMaze); //TESTER
        System.out.print(testMaze.getNeighbors(testMaze.maze[0][0]));   //TESTER
        System.out.print(testMaze.getStart());
        System.out.print(testMaze.getEnd());
        
    }
    
    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
        numRows = 0;    // set variables for no reason honestly
        numCols = 0;
    }

    /**
     * Loads the maze from the specified file
     *
     * @param  fname  the name of the file containing the maze to be loaded
     * @return    true if the maze was successfully loaded; otherwise, false
     */
    public boolean loadMaze() throws FileNotFoundException
    {
        
        JFileChooser filepicker = new JFileChooser();   // create file picker
        if (filepicker.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)     // make sure valid file
             load = filepicker.getSelectedFile(); // select file to load
             
        Scanner mazeIter = new Scanner(load);   // create iterator for maze 
        numRows = Integer.parseInt(mazeIter.next());    // set rows to first int in maze file
        numCols = Integer.parseInt(mazeIter.next());    // set columns to 2nd int in maze file
        
        this.maze = new Square[numRows][numCols];   // initialize maze
        this.backupMaze = new Square[numRows][numCols]; // initialize backupMaze

        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {                
                maze[row][col] = new Square(row, col, Integer.parseInt(mazeIter.next())); // populate maze
                backupMaze[row][col] = maze[row][col];  //populate backupMaze
            }
        }
             
        return true; // return true once maze is loaded
             
            }
        

    /**
     * Returns a list of the neighbors of the specified square
     *
     * @param  sq  the square whose neighbors to return
     * @return    a list of the neighbors of the specified square
     */
    public ArrayList<Square> getNeighbors(Square sq)
    {
        
        ArrayList<Square> toReturn = new ArrayList(); //creatre arrayList to return
        if (sq.getRow()-1 >= 0) // test north
            toReturn.add(maze[sq.getRow()-1][sq.getCol()]); // if true add north to array
            
        if (sq.getCol()+1 <= numCols)   // test east
            toReturn.add(maze[sq.getRow()][sq.getCol()+1]); // if true add east to array
            
        if (sq.getRow() <= numRows )    // test south
            toReturn.add(maze[sq.getRow()+1][sq.getCol()]);     //if true add south to array
            
        if (sq.getCol()-1 >= 0) // test west
            toReturn.add(maze[sq.getRow()][sq.getCol()-1]); // if true add west to array
            
        return toReturn; // return array
    }

    /**
     * Returns the start square
     *
     * @return    the start square
     */
    public Square getStart()
    {
        toReturn = null; //refresh toReturn square to make sure there are no weird results from previous calls
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {       // loop through maze         
                if(maze[row][col].getType() == 2){// if type = 2 (start), true
                    toReturn = maze[row][col];
                    // if true, set this square to the return
                }
            }
        }
        return toReturn; // return square
    }    


    /**
     * Returns the finish square
     *
     * @return    the finish square
     */
    public Square getEnd()
    {
        toReturn = null; // reset square to prevent screwy results from previous calls
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {      // loop through maze          
                if(maze[row][col].getType() == 3){ // if type = 3 (exit), true
                    toReturn = maze[row][col]; // if true set square to return                 
                }
            }
        }
        return toReturn;
    }   


    /**
     * Returns the maze back to the initial state after loading.
     *
     */
    public void reset()
    {
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {   //loop through maze             
                maze[row][col] = backupMaze[row][col];  // set each square equal to corresponding square in backup          
            }
        }
    }


    /**
     * toString
     *
     * @return    string representation of the maze
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for( int row = 0; row < this.maze.length; row++ )
        {
            for( int col = 0; col < this.maze[row].length; col++ )
            {
                sb.append( this.maze[row][col].toString() + " " );
            }
            sb.append( "\n" );
        }

        return new String( sb );
    }

}
