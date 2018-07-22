
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MazeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MazeTest
{
    /**
     * Default constructor for test class MazeTest
     */
    public MazeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testMazeConstructor(){
        ArrayList<Integer> exit = new ArrayList<Integer>();
        exit.add(1);
        exit.add(2);
        
        Maze maze = new Maze("maze.txt",exit);
        System.out.println(maze);
        /**assertTrue(maze.getNode(16).isExit());
        assertTrue(maze.getNode(155).isExit());
        assertTrue(maze.getNode(3).isExit());
        assertTrue(maze.getNode(176).isExit());
        assertFalse(maze.getNode(123).isExit());
        */
    }
    
    @Test
    public void testNeighbours(){
        ArrayList<Integer> exit = new ArrayList<Integer>();
         exit.add(1);
        exit.add(2);
        
        Maze maze = new Maze("maze.txt",exit);
        
        ArrayList<Integer> neighbours = maze.getNeighbours(49);
        System.out.println(neighbours);
    }
    
}
