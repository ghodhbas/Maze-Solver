import java.io.*;
import java.util.*;
/**
 * read the file containing the maze config and intitialize the date
 *
 */
public class MazeReader
{
    Scanner reader1,reader2;
    /**
     * Constructor for objects of class MazeReader
     */
    public MazeReader(String fileName)
    {   try{
            reader1 = new Scanner(new FileReader(fileName));
            reader2 = new Scanner(new FileReader(fileName));
        }catch(Exception e){
            System.out.println("error loading maze");
        }
    }

    /**get the maximum number of nodes inthe graph*/
    public int loadNbOfNodes(){
        int max = 0;
        while(reader1.hasNextLine()){
            String line = reader1.nextLine();

            //split the line into blocks
            String[] parts = line.split(" ");

            //get info
            int start = Integer.parseInt(parts[0]);
            int destination = Integer.parseInt(parts[2]);

            if(max < start){max=start;};
            if(max < destination) {max=destination;};
        }
        return max;
    }

    /**get info of each line*/
    public ArrayList<Integer> getLine(){
        ArrayList<Integer> array = new ArrayList<Integer>();

        String line = reader2.nextLine();

        //split the line into blocks
        String[] parts = line.split(" ");

        //get info
        array.add(Integer.parseInt(parts[0]));
        array.add(Integer.parseInt(parts[2]));
        array.add(Integer.parseInt(parts[3]));

        return array;
    }

    public boolean hasNextLine(){
        return reader2.hasNextLine();
    }
}
