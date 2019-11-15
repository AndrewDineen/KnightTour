
package KnightTour;
import java.util.*;
/**
*  This is a solution to the famous Knight's Problem                                     
*  A Chessboard size is specified by the user, the knight visits all squares                                                            
*  No square can be visited more than once
*/

public class KnightUser {
    public static void main(String[] args)
    {
      
            Knight testBoard = null;
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter the dimensions of the board (n x m), along with the row and column of the starting position, ex:5 5 2 3");
            try
            {
                testBoard = new Knight(userInput);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.err.print("This board size is not valid, please enter only positive integer values");
                System.exit(0);
            }
            if (!testBoard.isOK (testBoard.getStart()))
            {
                System.out.println ("This is not a valid start... please try another");
                System.exit(0);
            }
            else
            {
                if(searchTour(testBoard))
                {                
                    System.out.println ("the board size has a solution! \n" + testBoard);
                }
                else
                {
                    System.out.println ("the board size has no solution...");
                }
            } 
            
            
            

        
        
    }
    /**
     * gets the start and feeds it to the recursive algorithm
     * @param board
     * @return
     */
    public static boolean searchTour(Knight board)
    {
        Position start = board.getStart();
        board.markAsPossible(start);
        BackTrack backTrack = new BackTrack(board);
        return board.isGoal(start) || backTrack.tryToReachGoal(start);
    }
}
