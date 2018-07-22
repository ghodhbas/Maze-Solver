import java.util.*;
/**
 * This player follow dijkestra shortest path algorithm to decide the direction
 */
public class PlayerShort extends Player
{

    /**
     * Constructor for objects of class PlayerShort
     */
    public PlayerShort(int visionLimit,int diceLimit, int start, Maze maze)
    { super(visionLimit,diceLimit,start,maze);
      
    }

    /**find direction to go to*/
    protected int find(int start){
        int index=0;
        int minDistance = Integer.MAX_VALUE;
        for(int i=1;i<=distances.size();i++){
            if(i==prev)continue;//don't go back to the same node
            if((minDistance>distances.get(i)) && (i != start)&& (distances.get(i)<=visionLimit)){
                minDistance = distances.get(i);
                index = i;
            }
        }
        
        //the only way is to the previous
        if(prev !=0 && index==0 && distances.get(prev)<=visionLimit){
            index=prev;
        }
        return index;
    }

}
