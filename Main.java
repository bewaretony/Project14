import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Main here.
 * 
 * @author Anthony Luo and John Shieh
 * @version 6 Marshmallow
 */
public class Main
{
    static int score = 0;
    public static void main(String[] args) {
        setup();
        Scanner kbReader = new Scanner(System.in);
        String input = kbReader.nextLine().toLowerCase();
        while(input != "exit"){
            readCommand(input);
            input = kbReader.nextLine().toLowerCase();
        }
    }
    public static void addScore(int s) {
        score += s;
    }
    public static void readCommand(String command) {
        String[] cmd = command.split(" ");
    }
    public static Room currentRoom() {
        
    }
    public static Player location() {
        
    }
    public static void setup() {
       //spawn
        Item[] spawnItems = new Item[1];
        Character[] spawnCharacter = new Character[0];
        spawnItems[0] = new Item("book", "Welcome! My name is the Innkeeper and I am here to guide ");
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn point", "You spawn in forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road");
        //clearing next to spawn
        Item[] clearingItems = new Item[0];
        Character[] cspawnItems = new Character[0];
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You are in a clearing in the middle of a gorge. You see cave to your right");
       //cave room 
        Item[] caveItems = new Item[2];
        caveItems[0]= new Item("key", "This is the key to the castle");
        caveItems[1]= new Item("stones", "some random stones");
        Character[] caveCharacters = new Character[0];
        Room cave = new Room(caveItems, caveCharacters, "Cave in the Gorge", "You enter a dark cave. You see a pile of stones on the left and a shiny object on the right");
        //castle entrance
        
        Room castleEntrance = new Room();
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        
        
    }
}
