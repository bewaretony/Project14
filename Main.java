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
            //method that waits 1-2 seconds before clearing screen
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
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You walk into a clearing in the middle of a gorge. You see a cave to your right. You hear a faint rumble and a voice seems to be saying: \"EVERYONE GET IN HERE\"");

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
        
        //LEFT WING STUFF IS HERE
        
        //left wing first room
        Item[] lwfr = new Item[0];
        Character[] leftwingfirstroomC = new Character[2];
        Item[] trapdoor = new Item[0];
        Item[] painting = new Item[1];
        painting[1] = new Item("Explorers Hat", "You find an explorers hat. Wearing this gives you more swag *TO BE CHANGED LATER*");
        leftwingfirstroomC[0] = new Character("trap door", "you open the trap door and you see stairs descending down into total darkness", trapdoor);  //wierd error here
        leftwingfirstroomC[1] = new Character("painting", "opening the painting reveals a hat", painting);
        Room leftwingfirstroom = new Room(lwfr, leftwingfirstroomC, "left wing first room", "You enter a dark room. You can see the faint outlines of a hallway leading beyond");
        
        //leftwing hallwayOne
        Item[] LWH1I = new Item[0];
        Character[] LWH1C = new Character[0];
        Room LWH1 = new Room( LWH1I, LWH1C, "leftwing hall 1", "you enter the hallway");
        
        //leftiwng hallwayTwo
        Item[] LWH2I = new Item[0];
        Character[] LWH2C = new Character[0];
        Room LWH2 = new Room( LWH2I, LWH2C, "leftwing hall 2", "as you travel further down the hallway you can see a faint light at the end");
        
        //leftwing hallwayThree
        Item[] LWH3I = new Item[0];
        Character[] LWH3C = new Character[0];
        Room LWH3 = new Room( LWH3I, LWH3C, "leftwing hall 3", "the light grows stronger and ahead you can see a room lit by torches");
        
        //leftwing torch room
        Item[] LWTRI = new Item[2];
        LWTRI[0] = new Item("torch left", "with a great effort, you take a torch off the wall");
        LWTRI[1] = new Item("torch right", "with a great effort, you take a torch off the wall");
        Character[] LWTRC = new Character[0];
        Room LWTR = new Room(LWTRI, LWTRC, "torch room leading to arena", "You enter a large room with torches on each side. You can see a hallway to your right and a dark chamber infront of you");
        
        //leftwing arena water station
        //TODO LATER 
        
        //left hall after torch
        Item[] LHATI = new Item[0];
        Character[]LHATC = new Character[0];
        Room LHAT = new Room(LHATI, LHATC, "left hall torch room", "You enter a large hallway, which reveals a hallway on your left and right.");
        
        //right fork after LHAT
        Item[] RFLHATI = new Item[0];
        Character[]RFLHATC = new Character[0];
        Room RFLHAT = new Room(RFLHATI, RFLHATC, "right fork after hall" , "Taking the right fork, you enter the balcony of a large arena. A voice below shouts  \"EVERYBODY GET IN HERE\"");
        
        //left fork after LHAT
        Item[] LFLHATI = new Item[0];
        Character[]LFLHATC = new Character[0];
        Room LFLHAT = new Room(LFLHATI, LFLHATC, "left fork after hall", "You take the left fork, however it reveals a dead end.");
        
        //front room after arena entrance
        Item[] FRAEI = new Item[0];
        Character[] FRAEC = new Character[1];
        Item[] FRAECI = new Item[2];
        FRAECI[1] = new Item("bag of coins", "you take the bag of golden coins");
        FRAECI[0] = new Item("dagger", "you grab the half broken dagger and put it into your sack. You note that there is a label that says \"Only designed to be used twice\"");
        FRAEC[0] = new Character("cabinet", "you open the cabinet which reveals a dagger and a sack of coins", FRAECI);                  
        Room FRAE = new Room(FRAEI, FRAEC, "front room", "You walk into a room and you see a cabinet and a table.");
        
        
        
        
        
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
