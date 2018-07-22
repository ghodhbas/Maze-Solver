import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MazeNodeTest.
 *
 */
public class MazeNodeTest
{
    /**
     * Default constructor for test class MazeNodeTest
     */
    public MazeNodeTest()
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
    public void test(){
        ArrayList<MazePath> paths = new ArrayList<MazePath>();
        paths.add(new MazePath(2,10));
        paths.add(new MazePath(5,4));
        paths.add(new MazePath(3,12));
        paths.add(new MazePath(8,9));
        paths.add(new MazePath(10,10));
        
        MazeNode node = new MazeNode(1,paths);
        System.out.println(node);
    }
    
    @Test
    public void testWeight(){
        ArrayList<MazePath> paths = new ArrayList<MazePath>();
        paths.add(new MazePath(4,4));
        paths.add(new MazePath(3,3));
        paths.add(new MazePath(6,5));
        paths.add(new MazePath(5,2));
        
        MazeNode node = new MazeNode(2,paths);
        System.out.println(node.getWeight(4));
        System.out.println(node.getWeight(3));
        System.out.println(node.getWeight(5));
        System.out.println(node.getWeight(6));
    }
}
