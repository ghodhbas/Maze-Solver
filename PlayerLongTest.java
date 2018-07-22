
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerLongTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerLongTest
{
    /**
     * Default constructor for test class PlayerLongTest
     */
    public PlayerLongTest()
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
        exit.add(20);
        exit.add(5);

        Maze maze = new Maze("maze.txt",exit);
        PlayerLong player = new PlayerLong(34,12,15,maze);
        System.out.println();
        System.out.println(player.getNext(maze,40));
    }

    @Test
    public void testPlay(){

        ArrayList<Integer> exit = new ArrayList<Integer>();
        exit.add(20);
        exit.add(5);

        Maze maze = new Maze("maze.txt",exit);
        PlayerLong player = new PlayerLong(34,10,47,maze);
        int i =0;
        while(player.getNext()!=0 && i<10){
            System.out.println();
            System.out.println("round "+i);
            System.out.println();
            System.out.println("current node: "+player.start);
            System.out.println("next node: "+player.next);
            player.play();
            if(exit.contains(player.start))break;
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
