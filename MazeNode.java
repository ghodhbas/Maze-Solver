import java.util.*;
/**
 *represents a node in the graph where direction choice must be made
 */
public class MazeNode
{
    private int nodeNb;
    private ArrayList<MazePath> paths;
    private boolean exit = false;
    /**
     * Constructor for objects of class MazeNode
     */
    public MazeNode(int nodeNb , ArrayList<MazePath> paths)
    { this.nodeNb = nodeNb;
      this.paths = paths;
    }

    /**get the node number (key)*/
    public int getNodeNb(){
        return nodeNb;
    }
    
    /**add a path*/
    public void addPath(MazePath path){
        paths.add(path);
    }
    
    public int getWeight(int destination){
        for(int i=0;i<paths.size();i++){
            if(paths.get(i).getDestination() ==destination){
                return paths.get(i).getSteps();
            }
        }
        return 999999;
    }
     /**get the node number (key)*/
    public ArrayList<MazePath> getPaths(){
        return paths;
    }
    
    /**check if node has an already existing path to a certain node*/
    public boolean contains(int destination){
        int i=0;
        while(i<paths.size()){
            if(paths.get(i).getDestination() == destination){
                return true;
            }
            i++;
        }
        return false;
    }
    
    /**update weight of a path*/
    public boolean updatePath(int destination, int steps){
        int i=0;
        while(i<paths.size()){
            if(paths.get(i).getDestination() == destination){
                paths.get(i).setSteps(steps);
                return true;
            }
            i++;
        }
        return false;
    }
    
    /**set a node to an exit node*/
    public boolean isExit(){
        return this.exit;
    }
    
    /**set a node to an exit node*/
    public void setExit(){
        this.exit = true;
    }
    
   
    
    public String toString(){
        String s="Node "+ nodeNb +": ";
        int i;
        for(i=0;i<paths.size();i++){
            s += paths.get(i).toString()+", ";
        }
        
        return s;
    }
}
