
/**
 This Class represents a undirected edge of the maze graph
 */
public class MazePath
{
    private int destination, steps;
    /**
     * Constructor for objects of class MazePath
     */
    public MazePath(int destination, int steps)
    {
        this.destination = destination;
        this.steps = steps;
    }

    /**get key of destination node*/
    public int getDestination(){
        return destination;
    }
    
    /**get steps needed to complete of path (weith of edge)*/
    public int getSteps(){
        return steps;
    }
    
    /**get steps needed to complete of path (weith of edge)*/
    public void setSteps(int i){
        this.steps = i;
    }
    
    /**return a string representaion of the path*/
    public String toString(){
        return destination+"("+steps+")";
    }
}
