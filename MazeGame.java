import java.util.*;
/**
Conttrols the game progress
 */
public class MazeGame
{
    private Maze maze;
    private PlayerContainer container;
    private Scanner readInput;
    private boolean quit;
    /**
     * Constructor for objects of class MazeGame
     */
    public MazeGame(String fileName, String startexit,int visionLimit,int diceLimit )
    { 
        StartExitReader startReader = new StartExitReader(startexit);
        //load info about start and exit nodes
        startReader.init();

        //build maze and mark exit nodes
        maze = new Maze(fileName,startReader.getExit());

        container = new PlayerContainer(3);

        //add player and fetch for their parameters
        //playerShort
        container.addPlayer(new PlayerShort(visionLimit,diceLimit,startReader.getStart(),maze));
        //playerShort
        container.addPlayer(new PlayerLong(visionLimit,diceLimit,startReader.getStart(),maze));
        //playerShort
        container.addPlayer(new PlayerRandom(visionLimit,diceLimit,startReader.getStart(),maze));

        //reader for user input
        try{
            readInput = new Scanner(System.in);
        }catch(Exception e){
            System.out.print("wrong user input");
        }
    }

    public void run(){
        System.out.println("Welcome To the most incredible maze game where you just type letters!");
        System.out.println("the player have already been created:");
        System.out.println("    player 1 follows the shortest path");
        System.out.println("    player 2 follows the longest path");
        System.out.println("    player 3 chooses the path randomly");
        System.out.println("Type x - To exit the program");
        System.out.println("     c - To continue to run the program without stopping");
        System.out.println("     p - To print the position of every player");
        System.out.println("     i - To play a round");
        System.out.println();

        quit = false;
        while(!quit){
            System.out.println("type one of the letters above");
            String s = readInput.next();

            if(s.equalsIgnoreCase("x"))break;

            //run till no longer can play
            if(s.equalsIgnoreCase("c")){
                quit = playAll();
            }

            //print positions of the players
            if(s.equalsIgnoreCase("p")){
                System.out.println(getPlayersInfo());
            }

            //print positions of the players
            if(s.equalsIgnoreCase("i")){
                playRound();
            }

        }

        System.out.println("Game is Over");
    }

    public void playRound(){
        for(int i=0;i<container.getSize();i++){
            container.getPlayer(i).play();
            System.out.println("Player "+i +"played");
            System.out.println();
        }
    }

    public boolean playAll(){
        boolean loop=true;
        while(loop){
            //play a round¨for every player 
            for(int i=0;i<container.getSize();i++){
                if(container.getPlayer(i).getExitReached()){
                    continue;
                }
                container.getPlayer(i).play();
                System.out.println("Player "+i +" played");
                

                if(maze.getNode(container.getPlayer(i).getStart()).isExit()){
                    System.out.println("Player "+i +" reached exit");
                    System.out.println();
                    container.getPlayer(i).setExitReached();
                    if(container.getSize()==0)break;
                }
                if(container.getPlayer(i).getNext()==0){
                    container.getPlayer(i).setExitReached();//to terminate the loop
                    System.out.println("Player "+i +" is stuck and cannot move thus will be removed from game");
                }
            }

            for(int j=0;j<container.getSize();j++){
                if(!container.getPlayer(j).getExitReached()){
                    break;
                }
                //all the player have exited
                if(j==container.getSize()-1){
                    loop=false;
                }
            }
        }
        //game ended
        quit=true;
        return quit;
    }
    
    /**return a string containing the players' positions*/
    public String getPlayersInfo(){
        String s="";
        for(int i=0;i<container.getSize();i++){
            s=s+"Player "+i+" is currently at node "+container.getPlayer(i).getInfo()+"\n";
        }
        return s;
    }
}
