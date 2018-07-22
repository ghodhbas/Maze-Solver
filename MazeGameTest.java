

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MazeGameTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MazeGameTest
{
    /**
     * Default constructor for test class MazeGameTest
     */
    public MazeGameTest()
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
    public void testConstructor(){
        MazeGame game = new MazeGame("maze.txt","start.txt");
        System.out.println(game.maze);
        System.out.println();
    }
}
