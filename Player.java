import java.util.*;
/**
 * Abstract class Player - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Player
{   
    protected int visionLimit;
    protected Dice dice;
    protected int start,next,prev;//starting next and previous nodes
    protected int remaining; //remaining steps to complete path
    protected Maze maze;

    protected Hashtable<Integer,Integer> distances ;
    protected Hashtable<Integer,Integer> previous ;
    protected Hashtable<Integer,Boolean> visited ;

    protected boolean exitFound = false;
    protected boolean exitReached = false;

    public Player(int visionLimit,int diceLimit, int start, Maze maze){
        this.visionLimit = visionLimit;
        this.dice = new Dice(diceLimit);
        this.start = start;
        this.maze=maze;
        this.distances = new Hashtable<Integer,Integer>(maze.nbNodes());
        this.previous = new Hashtable<Integer,Integer>(maze.nbNodes());
        this.visited = new Hashtable<Integer,Boolean>(maze.nbNodes());
        
        //choose an initial direction
        remaining=0;
        next=getNext(maze,start);
        prev=0;
        
    }

    protected int getNext(Maze maze, int start){
        if(maze.getNode(start).isExit()){
            return 0;
        }
        distances = new Hashtable<Integer,Integer>(maze.nbNodes());
        visited = new Hashtable<Integer,Boolean>(maze.nbNodes());
        previous = new Hashtable<Integer,Integer>(maze.nbNodes());
        //calculate paths
        getNextShort(maze,start);

        

        int exit=0;// exit node

        //check if exit is within limit
        for(int i = 1; i<=distances.size();i++){
            if(distances.get(i)<=visionLimit){
                if(maze.getNode(i).isExit()){
                    exitFound = true;
                    exit=i;
                    break;
                }
            }
        }

        int dir;// next direction

        //found exit
        if(exitFound){
            int j=exit;
            if(previous.get(j)!=start){
                while(j!=start){
                    j=previous.get(j);
                    //if the previous is the start then j is the direction to go to
                    if(previous.get(j)==start){
                        break;
                    }
                }
            }
            dir=j;
        }else{
            //find direction
            dir = find(start);
        }
        
        if(dir==0)return 0;
        //save previous
        if(dir!=prev) prev=start;
        //update remaining step (weight of path)
        remaining = distances.get(dir);
        
        return dir ;
    }

    //find shortest path to the other nodes (mainly to find exit)
    protected void getNextShort(Maze maze, int start){
        for (int i=1; i<=maze.nbNodes(); i++){    // Initialize
            distances.put(i,visionLimit+1);
            previous.put(i,0);
            visited.put(i,false);
        }
        distances.put(start,0);
        for (int i=1; i<=maze.nbNodes(); i++) {  // Process the vertices
            int v = minVertex(distances,visited);     // Find next-closest vertex
            visited.put(v,true);

            ArrayList<Integer> nList = maze.getNeighbours(v);
            for (int j=0; j<nList.size(); j++) {
                int w = nList.get(j);
                if (distances.get(w) > (distances.get(v) + maze.getNode(v).getWeight(w))){
                    distances.put(w,distances.get(v) + maze.getNode(v).getWeight(w));
                    previous.put(w,v);
                }
            }
        }

    }

    // Find the unvisited vertex with the smalled distance(for mainly exit)
    protected int minVertex(Hashtable<Integer,Integer> distances,Hashtable<Integer,Boolean> visited) {
        int min = Integer.MAX_VALUE;  // Initialize v to any unvisited vertex;
        int min_index = 0;
        for (int i=1; i<=maze.nbNodes(); i++){
            if(visited.get(i) == false && distances.get(i) <= min){
                min = distances.get(i);
                min_index = i;
            }
        }
        return min_index;
    }


    //play turn
    public void play(){
        int steps = dice.roll();
        while(steps>=remaining){
            if(next==0)return;//stuck
            steps= steps-remaining;
            start= next;
            if(maze.getNode(start).isExit())return;
            next = getNext(maze,start);
            if(next ==0){
                return;
            }
        }
        if(steps<remaining){
            remaining=remaining-steps;
            steps=0;
        }
    }
    
    public String getInfo(){
        
        return "current Position: "+start;
    }
    
    
    public int getNext(){
        return next;
    }
    
    public int getStart(){
        return start;
    }
    
    public void setExitReached(){
        exitReached=true;
    }
    
    public boolean getExitReached(){
        return exitReached;
    }
    
    protected abstract int find(int start);
}
