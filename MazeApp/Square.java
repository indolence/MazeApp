

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square
{
    /** description of instance variable x (add comment for each instance variable) */
    private int col, row, type; String toPrint;
    public static final int UNEXPLORED = 10;
    public static final int ON_WORK_LIST = 11;
    public static final int EXPLORED = 12;
    public static final int ON_PATH = 13;
    public static final int WALL = 1;
    public static final int START = 2;
    public static final int EXIT = 3;
    
    private Square previous;
    
    /**
     * Default constructor for objects of class Square
     */
    public Square(int row, int col, int type)
    {
        this.row = row;
        this.col = col; // set data types
        this.type = type;               
    }
    
    /**
     * toString
     * @return - print type of current square
     */
    public String toString(){
        
        switch (this.type){
            case 0: return "_"; // return empty space
            case 11: return "o"; // return on work list
            case 12: return "-"; // return explored
            case 13: return "x"; // return on path
            case 1: return "#"; // return wall
            case 2: return "S"; //return start
            case 3: return "E"; // return exit
        }
        return "What?";               
    }
    
    /**
     * getRow
     * @return row of current square
     */
    public int getRow(){
        return this.row; // return row
    }
    
    /**
     * get Col
     * @return column of current square
     */
    public int getCol(){
        return this.col; // return col
    }
    
    /**
     * getType
     * @return type of current square
     */
    public int getType(){
        return this.type; // return type
    }
    
    /**
     * setType
     * @modifies current square type
     */
    public void setType(int newType){
        type = newType; // return type
    }
    
    public void setPrev(Square sq){ // sets previous square
        previous = sq;
    }
    
    public Square previous(){ // returns previous
        return previous;
    }

    

}
