
/**
 * Write a description of class Main here.
 * 
 * @author Anthony Luo and John Shieh
 * @version 6 Marshmallow
 */
public class Main
{
    // instance variables - replace the example below with your own
    
    public static void main(String[] args) {
        
    }
    public static void addScore(int s) {
        
        
    }
    public static void readCommand(String command) {
        
    }
    public static Room currentRoom() {
        
    }
    public static Player location() {
        
    }
    public static int score() {
        
    }
    public static void setup() {
        Room spawn = new Room();
        Item[] spawnitems = new Item[0];
        
        Room clearingspawn = new Room();
        Room castleentrance = new Room();
        spawn.setNorth(clearingspawn);
        clearingspawn.setSouth(spawn);
        castleentrance.setSouth(clearingspawn);
        clearingspawn.setNorth(castleentrance);
        
    }
}
