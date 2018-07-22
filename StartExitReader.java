import java.util.*;
import java.io.*;
/**
 * reads startexit file and save the exit and start nodes
 */
public class StartExitReader
{
    Scanner reader;
    private int start;
    private ArrayList<Integer> exit= new ArrayList<Integer>();
    /**
     * Constructor for objects of class StartExitReader
     */
    public StartExitReader(String startexit)
    {
        try{
            reader = new Scanner(new FileReader(startexit));
        }catch(Exception e){
            System.out.println("error reading startexit file ");
        }
    }

    public void init(){
        
        while(reader.hasNextLine()){
            String line = reader.nextLine();

            //split the line into blocks
            String[] parts = line.split(" ");            

            if(parts[0].equalsIgnoreCase("start:")){
                start = Integer.parseInt(parts[1]);
            }
            if(parts[0].equalsIgnoreCase("exit:")){
                for(int i=1;i<parts.length;i++){
                    exit.add(Integer.parseInt(parts[i]));
                }
            }
        }
    }
    
    public int getStart(){
        return start;
    }
    
    public ArrayList<Integer> getExit(){
        return exit;
    }
}
