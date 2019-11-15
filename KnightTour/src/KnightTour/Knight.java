/*
 * The Knight class creates a Knight object based on scanner data
 * Takes in board size and starting position
 * Marks squares in the grid (2D array) with values depending on how they are evaluated
 */
package KnightTour;

import java.util.*;

public class Knight implements Application{
     private int TOTAL_SQUARES = 0;
     private int counter = 0;

     protected Position start;
          
     protected int[][] grid;
     
     /**
      *  constructor that creates the grid of user specified size and start position
      * @param scanner - takes in the user input scanner
      */
     public Knight(Scanner scanner) 
     {
         try
         {
          grid = new int[scanner.nextInt()][scanner.nextInt()];
          
         }
         catch(NegativeArraySizeException e)
         {
           System.err.print("This board size is not valid, please enter only positive integer values");
         }
          start = new Position (scanner.nextInt(), scanner.nextInt());
          TOTAL_SQUARES = grid.length * grid[0].length;
          
      }

     /**
      * 
      * @return - returns the starting position
      */
     public Position getStart()
     {
         return start;
     } 
     
     /**
      * 
      * @return returns a deep copy of the grid 
      */
     public int[][] getGrid()
     {
       int[][] gridCopy = new int[grid.length][grid[0].length];
       
       for (int i = 0; i < grid.length; i++)
         for (int j = 0; j < grid[i].length; j++)
            gridCopy[i][j] = grid[i][j];
              
       return gridCopy;
     }
     /**
      * 
      * @param pos - takes in the new position
      * @return - checks if the move is valid
      */
     @Override
      public boolean isOK (Position pos)
      { 
         
         return pos.getRow() >= 0 && pos.getRow() < grid.length 
                 && pos.getColumn() >= 0 && pos.getColumn() < grid[0].length && grid[pos.getRow()][pos.getColumn()] == 0;
      }
       /**
        * 
        * @param pos - has to take in position to appease the interface
        * @return - returns true if the goal has been met
        */
       @Override
       public boolean isGoal (Position pos)
       {
             return counter == TOTAL_SQUARES;
       
       } 
       /**
        * returns the state of the grid
        * @return - returns the grid in the form of a string
        */
     @Override
       public String toString () 
       {
           String result = "\n";

         for (int[] grid1 : grid) {
             for (int column = 0; column < grid [0].length; column++) {
                 result += String.valueOf(grid1[column]) + ' ';
             }
             result += "\n";
         } // for row = 0
           return result;
        } // method toString


     /**
      * 
      * @param pos - position of the square
      * @return - a KnightIterator object
      */
     @Override
       public Iterator<Position> iterator (Position pos) 
       {
           return new KnightIterator (pos);
       } 
    
    /**
     * marks current position with the counter value
     * @param pos - the current square
     */
    @Override
    public void markAsPossible(Position pos) {
        grid[pos.getRow()][pos.getColumn()] = ++counter; 
    }
    /**
     * overwrites the space with 0 is the space doesn't work
     * @param pos - the current square position
     */
    @Override
    public void markAsDeadEnd(Position pos) {
        grid[pos.getRow()][pos.getColumn()] = 0;
        counter--;
    }

       /**
        * KnightIterator nested class
        */
       protected class KnightIterator implements Iterator<Position> 
       {
           protected static final int MAX_MOVES = 8;

           protected int row,
                         column,
                         count;

          /**
           * constructor initializes row, column, and count based on the position object
           * @param pos 
           */
           public KnightIterator (Position pos) 
           {
               row = pos.getRow();
               column = pos.getColumn();
               count = 0;
           }
           /**
            * checks if all the moves from the current position have been tried
            * @return 
            */
           @Override
           public boolean hasNext () 
           {
                return count < MAX_MOVES;
           }
           /**
            * tries the next move
            * @return - the next position to try
            */
           @Override
           public Position next () 
           {
                Position nextPosition = new Position();
                switch (count++) 
                {
                  case 0: nextPosition = new Position (row - 2, column + 1); //up 2, right 1
                          break;
                  case 1: nextPosition = new Position (row - 2, column - 1); //up 2, left 1
                          break;
                  case 2: nextPosition = new Position (row - 1, column + 2); //up 1, right 2
                            break;
                  case 3: nextPosition = new Position (row - 1, column - 2); //up 1, left 2
                            break;
                  case 4: nextPosition = new Position (row + 1, column + 2);//down 1, right 2
                            break;
                  case 5: nextPosition = new Position(row + 1, column - 2);//down 1, left 2
                            break;
                  case 6: nextPosition = new Position(row + 2, column + 1);//down 2, right 1
                            break;
                  case 7: nextPosition = new Position(row + 2, column - 1);//down 2, left 1
                            break;
                }                
                return nextPosition;
           } 
  
           @Override
           public void remove () 
           { 
                
                throw new UnsupportedOperationException(); 
            } 

        } 

}
