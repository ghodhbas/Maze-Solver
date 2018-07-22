import java.util.*;
/**
 * A player that picks a direction randomly from the set of node in its vision field
 */
public class PlayerRandom extends Player
{
    private Random r; //randomnumber generator
    /**
     * Constructor for objects of class PlayerRandom
     */
    public PlayerRandom(int visionLimit,int diceLimit, int start, Maze maze)
    {super(visionLimit,diceLimit,start,maze);
        r= new Random();
    }

    protected int find(int start){
               
        ArrayList<Integer> neighbours = maze.getNeighbours(start);
        int dir = r.nextInt(neighbours.size());
        int previousCount=0; //counts how many times the previous node is picked
        while((distances.get(dir)>visionLimit) || (dir == start) || (dir == prev)){
            if(dir==0) break; // node doesn't have neighbours
            dir = r.nextInt(neighbours.size()); 
            //if previous node is picked 20 times in a row then it most certainly means that's the only direction to go to
            if(dir==prev)previousCount++;
            if(previousCount == 20)break;
        }
        
        
        return dir;
    }
}
