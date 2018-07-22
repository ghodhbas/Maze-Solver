import java.util.*;
/**
 * A player that follow the critical path
 */
public class PlayerLong extends Player
{
   
    /**
     * Constructor for objects of class PlayerLong
     */
    public PlayerLong(int visionLimit,int diceLimit, int start, Maze maze)
    {
        super(visionLimit,diceLimit,start,maze);
    }

    /**find max distance and returnthe the direction to go to*/
    protected int find(int start){
        int index=0;
        int maxDistance = 0;
        for(int i=1;i<=distances.size();i++){
            if(i==prev){
                continue;//don't go back to the same node
            }
            if((maxDistance<distances.get(i)) && (i != start) &&(distances.get(i)<=visionLimit)){
                maxDistance = distances.get(i);
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
