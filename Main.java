import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Main here.
 * @author Anthony Luo and John Shieh
 * @version 6 Marshmallow
 */
public class Main
{
    static int score = 0;
    static Room currentRoom;
    public static void main(String[] args) {
        
            setup();
            Scanner kbReader = new Scanner(System.in);
            System.out.print(">");
            String input = kbReader.nextLine().toLowerCase();
            while(input.compareTo("exit") != 0){
                readCommand(input);
                System.out.print(">");            
                input = kbReader.nextLine().toLowerCase();
            }
            System.out.println("Bye!");
           for(int i =1; i < 1000000; i++) {
               int lol = 432145;
               lol = (lol/i)*(int)Math.pow(lol,i);
            }
            System.out.print('\u000C');
        }
    

        public static void addScore(int s) {
        score += s;
    }

    public static void readCommand(String command) {
        String[] cmd = command.split(" ");
        cmd[0] = cmd[0].toLowerCase();
        if (cmd[0].compareTo("attack") == 0){
            System.out.println("add something here for attack.......");
            return;
        }
        if (cmd[0].compareTo("say") == 0){
            System.out.println("add something fere for say.......");
            return;
        }
        if (cmd[0].compareTo("examine") == 0){
            System.out.println("add something here for examine.......");
            return;
        }
        if (cmd[0].compareTo("take") == 0){
            System.out.println("add something here for examine.......");
            return;
        }
        if (cmd[0].compareTo("use") == 0){
            System.out.println("add something here for examine.......");
            return;
        }        
        if (cmd[0].compareTo("north") == 0){
            Room currentRoom1 = currentRoom.goNorth();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }
            return;
        }    
        if (cmd[0].compareTo("south") == 0){
            Room currentRoom1 = currentRoom.goSouth();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }         
            return;
        }     
        if (cmd[0].compareTo("east") == 0){
            Room currentRoom1 = currentRoom.goEast();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }          
            return;
        }        
        if (cmd[0].compareTo("west") == 0){
            Room currentRoom1 = currentRoom.goWest();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }         
            return;
        }      
        if (cmd[0].compareTo("up") == 0){
            Room currentRoom1 = currentRoom.goUp();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }        
            return;
        }
        if (cmd[0].compareTo("down") == 0){
            Room currentRoom1 = currentRoom.goDown();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }           
            return;
        }    
        System.out.println("Blizzard servers have crashed!(I don't know what the command means.)");
        return;
    }

    public static void setup() {
        //NOTE TO SELF: ADD GRIM PATRON SOMEWHERE IN THE GAME

        //spawn
        Item[] spawnItems = new Item[1];
        Character[] spawnCharacter = new Character[0];
        spawnItems[0] = new Item("book", "Welcome! My name is the Innkeeper and I am here to guide you.");
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn point", "You spawn in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road.");

        //clearing next to spawn
        Item[] clearingItems = new Item[0];
        Character[] cspawnItems = new Character[0];
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You walk into a clearing in the middle of a gorge. You see a cave to your right. In the distance a voice yells \"EVERYONE GET IN HERE\"");

        //cave room 
        Item[] caveItems = new Item[2];
        caveItems[0]= new Item("key", "This is the key to the castle.");
        caveItems[1]= new Item("stones", "Some random stones.");
        Character[] caveCharacters = new Character[0];
        Room cave = new Room(caveItems, caveCharacters, "Cave in the Gorge", "You enter a dark cave. You see a pile of stones on the left and a shiny object on the right.");

        //castle entrance
        Item[] castleEntranceItems = new Item[0];
        Character[] castleCharacters = new Character[1];
        Room castleEntrance = new Room(castleEntranceItems, castleCharacters, "Castle entrance", "You see the entrance to a giant, ruined castle. The door is locked.");

        //castle first room
        Item[] cfrI = new Item[1]; // do doors count as a character? --- ahhh doors that need keys are characters  -- ma
        cfrI[0] = new Item("bones", "You take a big bone and put it in your sack");
        Character[] cfrC = new Character[0];  //temp
        Room castleRoomFront = new Room(cfrI, cfrC, "Castle Hall", "You walk into a large hall. Ahead of you is a large room with 3 doors. You see a pile of bones on your left and a painting on your right.");

        //castle seconds room
        Item[] csrI = new Item[1];
        csrI[0]= new Item("stones", "Tou see a pile of stones to your right.");
        Character[] csrC = new Character[3];
        Item[] left = new Item[0];
        Item[] front = new Item[0];
        Item[] right = new Item[0];
        csrC[0] = new Character("left door", "You see a locked door on your left.", left);
        csrC[1] = new Character("right door", "You see a locked door on your right.", right);
        csrC[2] = new Character("door", "You see a locked door in front of you.", front);
        Room castleRoomSecond = new Room(csrI, csrC, "Castle Second Room", "You walk into a large room with three doors on each side. You see a pile of stones on your right.");

        //left wing first room
        
        
        
        System.out.println("Welcome to Hearthbone. \nYou spawn in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road.");        
        currentRoom = spawn;
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        clearingSpawn.setEast(cave);
        cave.setSouth(clearingSpawn);

    }
}
