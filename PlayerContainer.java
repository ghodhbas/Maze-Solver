import java.util.*;
/**
 *Contains the players in the game
 */
public class PlayerContainer
{
    ArrayList<Player> playerContainer;
    /**
     * Constructor for objects of class PlayerContainer
     */
    public PlayerContainer(int nbPlayer)
    {
        playerContainer = new ArrayList<Player>(nbPlayer);
    }
    
    /**add player to the container*/
    public void addPlayer(Player p){
        playerContainer.add(p);
    }
    
    /**get player at position i*/
    public Player getPlayer(int i){
        if(i>=playerContainer.size() || i<0)return null;
        return playerContainer.get(i);
    }   
    
    public void removePlayer(int i){
        playerContainer.remove(i);
    }   
    
    public int getSize(){
        return playerContainer.size();
    }
    
}
