

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
    
    /**
     * Default constructor for objects of class Square
     */
    public Square(int row, int col, int type)
    {
        this.row = row;
        this.col = col;
        this.type = type;               
    }
    
    /**
     * toString
     * @return - print type of current square
     */
    public String toString(){
        
        switch (this.type){
            case 10: return "_";
            case 11: return "o";
            case 12: return "-";
            case 13: return "x";
            case 1: return "#";
            case 2: return "S";
            case 3: return "E";
        }
        return "What?";               
    }
    
    /**
     * getRow
     * @return row of current square
     */
    public int getRow(){
        return this.row;
    }
    
    /**
     * get Col
     * @return column of current square
     */
    public int getCol(){
        return this.col;
    }
    
    /**
     * getType
     * @return type of current square
     */
    public int getType(){
        return this.type;
    }

    

}
