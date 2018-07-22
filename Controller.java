
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    public static void main(String[] args){
        MazeGame game = new MazeGame(args[0],args[1],Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        game.run();
    }
}
