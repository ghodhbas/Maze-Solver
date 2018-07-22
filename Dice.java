import java.util.*;
/**
 * controls dice behaviour
 */
public class Dice
{
    Random r;
    int limit;
    /**
     * Constructor for objects of class Dice
     */
    public Dice(int limit)
    {
        r = new Random();
        this.limit = limit;
    }
    
    /**
     * Constructor for objects of class Dice
     */
    public Dice(int seed,int limit)
    {
        r = new Random(seed);
        this.limit = limit;
    }
    
    /**roll a number betwee 1 and the limit*/
    public int roll(){
        return r.nextInt(limit)+1;
    }
}
