
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
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn point", "Where the player spawns");
        Item[] spawnItems = new Item[1];
        spawnItems[1] = new Item("leaflet", "tells the player what to do");
        Character[] spawnCharacter = new Character[0];
        Room clearingSpawn = new Room();
        Room castleEntrance = new Room();
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        
    }
}
