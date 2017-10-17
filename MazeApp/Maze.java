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
    File load;
    
    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
    }

    /**
     * Loads the maze from the specified file
     *
     * @param  fname  the name of the file containing the maze to be loaded
     * @return    true if the maze was successfully loaded; otherwise, false
     */
    public boolean loadMaze(String fname) throws FileNotFoundException
    {
        int numRows = 0;
        int numCols = 0;   
        int newType = 0;
        Scanner in = null;
        
        JFileChooser filepicker = new JFileChooser();
        if (filepicker.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
             load = filepicker.getSelectedFile();
             
        Scanner mazeIter = new Scanner(load);
        numRows = Integer.parseInt(mazeIter.next());
        numCols = Integer.parseInt(mazeIter.next());
        
        this.maze = new Square[numRows][numCols];

        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {                
                maze[row][col] = new Square(row, col, Integer.parseInt(mazeIter.next()));
            }
        }
             
        return true;
             
            }
        

    /**
     * Returns a list of the neighbors of the specified square
     *
     * @param  sq  the square whose neighbors to return
     * @return    a list of the neighbors of the specified square
     */
    public ArrayList<Square> getNeighbors(Square sq)
    {
        ArrayList<Square> toReturn = new ArrayList();
        if (maze[sq.getRow()-1][sq.getCol()] != null)
            toReturn.add(maze[sq.getRow()-1][sq.getCol()]);
        if (maze[sq.getRow()][sq.getCol()+1] != null)
            toReturn.add(maze[sq.getRow()+1][sq.getCol()]);
        if (maze[sq.getRow()-1][sq.getCol()] != null)
            toReturn.add(maze[sq.getRow()-1][sq.getCol()]);     
        if (maze[sq.getRow()][sq.getCol()-1] != null)
            toReturn.add(maze[sq.getRow()-1][sq.getCol()]);
            
        return toReturn;
    }

    /**
     * Returns the start square
     *
     * @return    the start square
     */


    /**
     * Returns the finish square
     *
     * @return    the finish square
     */


    /**
     * Returns the maze back to the initial state after loading.
     *
     */


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
