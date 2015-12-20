
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
        Item[] spawnItems = new Item[1];
        Character[] spawnCharacter = new Character[0];
        spawnItems[0] = new Item("book", "");
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn point", "You spawn in forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road");
        Item[] clearingItems = new Item[0];
        Character[] cspawnItems = new Character[0];
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You are in a clearing in the middle of a gorge. You see cave to your right");
        Item[2] ecastleItems = new Item[2];
        ecastleItems[0]= new Item("book"
        Room castleEntrance = new Room();
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        
    }
}
