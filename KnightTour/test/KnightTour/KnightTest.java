/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KnightTour;

import java.util.Iterator;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author dineena
 */
public class KnightTest {
    Knight testKnight;
    Position start;
    int[][] grid;
    /**
     *
     */
    @Before
 public void first(){
     String input = "5 5 0 0";
     Scanner testInput = new Scanner(input);
     testKnight = new Knight(testInput);
     start = testKnight.getStart();
 }
   

    @Test
    public void testGetStart() {
        assertEquals(0, start.getRow());
        assertEquals(0, start.getColumn());
        
    }
    @Test
    public void testGetGrid() {
        grid = testKnight.getGrid();
        assertEquals(5, grid.length);
        assertEquals(5, grid[0].length);
    }
    @Test
    public void testIsOK() {
        assertEquals(true, testKnight.isOK(start));
    }
    @Test
    public void testIsGoal() {
        assertEquals(false, testKnight.isGoal(start));
    }
    @Test
    public void testMarkAsPossible() {
        testKnight.markAsPossible(start);
        int[][] newGrid = testKnight.getGrid();
        assertEquals(1, newGrid[0][0]);
    }
    @Test
    public void testMarkAsDeadEnd() {
        testKnight.markAsDeadEnd(start);
        int[][] newGrid = testKnight.getGrid();
        assertEquals(0, newGrid[0][0]);
    }
    @Test
    public void testToString() {
        System.out.println(testKnight.toString());
    }
    @Test
    public void testIterator() {
        Iterator<Position> itr = testKnight.iterator(start);
        assertEquals(true, itr.hasNext());
    }
}
