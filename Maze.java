import java.util.*;
/**
 * this class contains the different nodes in the maze and manipulates them
 */
public class Maze
{
    private Hashtable<Integer,MazeNode> nodeList;
    /**
     * Constructor for objects of class Maze
     */
    public Maze(int n)
    {
        nodeList= new Hashtable<Integer,MazeNode>(n);
        //create n nodes
        for(int i=1;i<=n;i++){
            nodeList.put(i,new MazeNode(i, new ArrayList<MazePath>()));
        }
    }

    /** construct maze from a text file*/
    public Maze(String fileName, ArrayList<Integer> exit){
        MazeReader reader = new MazeReader(fileName);
        //create nodes 
        int n = reader.loadNbOfNodes();

        nodeList = new Hashtable<Integer,MazeNode>(n);
        for(int i=1;i<=n;i++){
            nodeList.put(i,new MazeNode(i, new ArrayList<MazePath>()));
        }


        //create paths between nodes
        while(reader.hasNextLine()){
            ArrayList<Integer> array = reader.getLine();   
            //create path at node1
            addPath(array.get(0),array.get(1),array.get(2));

        }

        //mark exit nodes
        for(int j=0;j<exit.size();j++){
            if((exit.get(j)<=nodeList.size())&&((exit.get(j)>=1))){
                nodeList.get(exit.get(j)).setExit();
            }
        }
        
    }

    /**create an edge between two node*/
    public boolean addPath(int node1,int node2, int steps){
        //extreme cases
        if( (node1>nodeList.size()) || (node1 < 1) || (node2>nodeList.size()) || (node2 < 1)){
            return false;
        }

        //if path exists
        if(nodeList.get(node1).contains(node2)){
            //update steps
            nodeList.get(node1).updatePath(node2,steps);
            nodeList.get(node2).updatePath(node1,steps);
            return true;
        }

        //create paths
        MazePath path1 = new MazePath(node2,steps);
        MazePath path2 = new MazePath(node1,steps);
        //assign paths to nodes       
        nodeList.get(node1).addPath(path1);
        nodeList.get(node2).addPath(path2);
        return true;
    }

    /**get the neighbours of a node*/
    public ArrayList<Integer> getNeighbours(int node){
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        for(int i=0;i<nodeList.get(node).getPaths().size();i++){
            neighbours.add(nodeList.get(node).getPaths().get(i).getDestination());
        }
        return neighbours;
    }

    /**return node with key i*/
    public MazeNode getNode(int i){
        return nodeList.get(i);
    }

    /**return number of nodes in the maze*/
    public int nbNodes(){
        return nodeList.size();
    }

    /**return a string representation of the maze*/
    public String toString(){
        String s="";

        for(int i =1; i<=nodeList.size();i++){
            s += nodeList.get(i).toString()+"\n";
        }
        return s;
    }
}
