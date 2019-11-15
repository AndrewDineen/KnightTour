/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KnightTour;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dineena
 */
public class KnightUserTest {
    
    @Test
    public void testSearchTour(){
     String input = "5 5 0 0";
     Scanner testInput = new Scanner(input);
     Knight testKnight = new Knight(testInput);
     assertEquals(true, KnightUser.searchTour(testKnight));
    }
    
}
