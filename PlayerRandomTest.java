
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerRandomTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerRandomTest
{
    /**
     * Default constructor for test class PlayerRandomTest
     */
    public PlayerRandomTest()
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
    public void testNextDir(){
        ArrayList<Integer> exit = new ArrayList<Integer>();
        exit.add(1);

        Maze maze = new Maze("maze.txt",exit);
        PlayerRandom player = new PlayerRandom(20,3,49,maze);
        System.out.println(player.getNext(maze,49));
    }

    @Test
    public void testPlay(){

        ArrayList<Integer> exit = new ArrayList<Integer>();
        exit.add(20);
        exit.add(5);

        Maze maze = new Maze("maze.txt",exit);
        PlayerRandom player = new PlayerRandom(15,5,36,maze);
        int i =0;
        while(player.getNext()!=0 && i<10){
            System.out.println();
            System.out.println("round "+i);
            System.out.println();
            System.out.println("current node: "+player.start);
            System.out.println("next Node: "+player.next);
            player.play();

            if(maze.getNode(player.getStart()).isExit())break;
            i++;
        }
        if(player.getNext()==0){
            System.out.println("player stuck");
        }
        if(maze.getNode(player.getStart()).isExit()){
            System.out.println("exit reached");
        }
    }
}
