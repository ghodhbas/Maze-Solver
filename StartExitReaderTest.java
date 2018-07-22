

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StartExitReaderTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StartExitReaderTest
{
    /**
     * Default constructor for test class StartExitReaderTest
     */
    public StartExitReaderTest()
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
    public void testExitReader(){
        StartExitReader read = new StartExitReader("start.txt");
        read.init();
        System.out.println("start: "+read.getStart());
        System.out.println("exit: "+read.getExit());
        
    }
}
