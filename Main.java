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
    static Player player;
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
            if (cmd.length == 1){
                System.out.println("Attack what?");
                return;
            }
            Character character = currentRoom.verifyCharacter(cmd[1]);
            Item itemInventory = player.verifyInventory(cmd[3]);
            if (character != null && itemInventory != null){
                //if(character.door() = true;)
                if(character.attackable() == false){
                    System.out.println("You cannot attack " + cmd[1] + ".");
                    return;
                }
                if(character.getHealth() > 0){
                    character.dHealth();
                }
                else{
                    System.out.println("The " + character + " has been slain.");
                }
            }
            else{
                System.out.println("The " + character + " or " + itemInventory + " was not found.");
            }
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
            Item itemRoom = currentRoom.verifyItem(cmd[1]);
            return;
        }
        if (cmd[0].compareTo("use") == 0){
            Character character1 = currentRoom.verifyCharacter(cmd[1]);
            Item itemInventory = player.verifyInventory(cmd[1]);
            Character character3 = currentRoom.verifyCharacter(cmd[3]);
            if(itemInventory != null){
                if(cmd.length == 2){
                    System.out.println("On what?");
                    System.out.print(">");
                    Scanner kbReader = new Scanner(System.in);
                    String input = kbReader.nextLine().toLowerCase();
                    Character character = currentRoom.verifyCharacter(input);
                    if(character != null){
                        currentRoom.useItem(itemInventory, character);
                    }
                }
            }
        }
        if (cmd[0].compareTo("north") == 0){
            Room currentRoom1 = currentRoom.goNorth();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                Item[] stuff = currentRoom1.getStuff();
                for(int i = 0; i < stuff.length; i ++) {
                    if (stuff[i]!= null) {
                        System.out.println(stuff[i].getLocation());
                    }
                }
                currentRoom = currentRoom1;
            }
            return;
        }    
        if (cmd[0].compareTo("south") == 0){
            Room currentRoom1 = currentRoom.goSouth();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }         
            return;
        }     
        if (cmd[0].compareTo("east") == 0){
            Room currentRoom1 = currentRoom.goEast();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }          
            return;
        }        
        if (cmd[0].compareTo("west") == 0){
            Room currentRoom1 = currentRoom.goWest();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }         
            return;
        }      
        if (cmd[0].compareTo("up") == 0){
            Room currentRoom1 = currentRoom.goUp();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                currentRoom = currentRoom1;
            }        
            return;
        }
        if (cmd[0].compareTo("down") == 0){
            Room currentRoom1 = currentRoom.goDown();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
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
        spawnItems[0] = new Item("book", "WELCOME TO HERO OF THE HEARTH. \nHero of the Hearth is a game by Blizzzard (The extra z is intended) that will be released Soon^TM \nIn Hero of the Hearth, players explore the land of King Gaben as they fight minions and monsters, while finding golden treasures. \nHero of the Hearth was created by John Shieh and Anthony Luo",0,"There is a tattered book on the floor");
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn Point", "You spawn in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle.");

        //clearing next to spawn
        Item[] clearingItems = new Item[0];
        Character[] cspawnItems = new Character[0];
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You walk into a clearing in the middle of a gorge. You see a cave to your right. You hear a faint rumble and a voice seems to be saying: \"EVERYONE GET IN HERE\"");

        //cave room 
        Item[] caveItems = new Item[2];
        caveItems[0]= new Item("key", "This seems to be the key to the castle", 1, "\nThere is a key on the floor");
        caveItems[1]= new Item("stones", "Some random stones.", 0, "\nThere are a pile of stones on the floor" );
        Character[] caveCharacters = new Character[0];
        Room cave = new Room(caveItems, caveCharacters, "Cave in the Gorge", "You enter a dark cave.");

        //castle entrance
        Item[] castleEntranceItems = new Item[0];
        Character[] castleCharacters = new Character[1];
        castleCharacters[0] = new Character("castle-door", "The door is made of cast iron and is impurtable. There is a key hole in the center.", true, 1);
        Room castleEntrance = new Room(castleEntranceItems, castleCharacters, "Castle entrance", "You see the entrance to a giant, ruined castle.");

        //castle first room
        Item[] cfrI = new Item[1]; // do doors count as a character? --- ahhh doors that need keys are characters  -- ma
        cfrI[0] = new Item("bottle of beer", "The brand of the beer is Ancient Brewmaster", 0, "\nThere is a bottle of beer on the floor");
        Character[] cfrC = new Character[1];  //temp
        cfrC[0] = new Character("painting door", "This seems to be a door that is disguised as a painting", false, 418098);
        Room castleRoomFront = new Room(cfrI, cfrC, "Castle Hall", "You walk into a large hall. There is a painting of Reynad. Ahead of you is a large room with 3 doors.");

        //castle seconds room
        Item[] csrI = new Item[1];
        csrI[0]= new Item("Totem", "This is Stoneclaw Totem", 0, "There is a totem on the ground");
        Character[] csrC = new Character[3];
        csrC[0] = new Character("left door", "The door is green and purple and says CURRSE OF THE NAXX. It does not seem to be locked",false, 5268);
        csrC[1] = new Character("right door", "The door is orange and black and says BLACROCK MOUNTAIN. The door has a keyhole that is in the shape of a pyramid", true, 30);
        csrC[2] = new Character("door", "The door is blue and brown and says LEAGUE OF EXPLORERS. The door has a keyhole that is in the shape of a hat", true, 60);
        Room castleRoomSecond = new Room(csrI, csrC, "Castle Second Room", "You walk into a large room with three doors on each side. There are 3 doors, one on your left, right and infront of you.");

        //LEFT WING STUFF IS HERE

        //left wing first room
        Item[] lwfr = new Item[2];
        Character[] leftwingfirstroomC = new Character[1];
        lwfr[0] = new Item("Explorers Hat", "This seems to be a hat that gives you more HEALTH?!", 0,"There is a dusty hat lying on the floor");
        lwfr[1] = new Item("Painting of Kolento", "Examining the painting reveals nothing unusual.", 0, "There is a painting in the room");
        leftwingfirstroomC[0] = new Character("Loose floorboard", "The loose floorboard is disguised as a trap door that appears to be locked", true, 4);  //wierd error here
        Room leftwingfirstroom = new Room(lwfr, leftwingfirstroomC, "left wing first room", "You enter a dark room. You can see the faint outlines of a hallway leading beyond. \nThere is a loose floorboard");

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
        LWTRI[0] = new Item("torch left", "This seems to be a lava torch that is loosely attached to the wall", 3, "There is a torch on your left");
        LWTRI[1] = new Item("torch right", "This seems to be a Flaming Torch that is loosely attached to the wall", 3, "There is a torch on your right");
        Character[] LWTRC = new Character[0];
        Room LWTR = new Room(LWTRI, LWTRC, "torch room leading to arena", "You enter a large room. You can see a hallway to your right and a dark chamber infront of you");

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

        //arena entrance hall (Room) front
        Item[] AEHFI = new Item[0];
        Character[]AEHFC = new Character[1];
        Item[] largebox = new Item[1];
        largebox[0] = new Item("map to the golden monkey", "you take out a scroll which reveals a map. It says that it is a Map to the Golden Monkey", 0);
        AEHFC[0] = new Character("box", "You look into the box which reveals a large amount of scrolls.", largebox, 100000);
        Room AEHF = new Room(AEHFI , AEHFC, "hall/room after the entrance.", "You travel down a several flight of stairs. At the bottom you find a large box");

        //front room after arena entrance hall
        //ADD LOOK METHOD
        Item[] FRAEI = new Item[0];
        Character[] FRAEC = new Character[1];
        Item[] cabinet = new Item[2];
        cabinet[1] = new Item("bag of coins", "this is a bag of 50 coins", 0);
        cabinet[0] = new Item("dagger", "you grab the half broken dagger and put it into your sack. You note that there is a label that says \"Only designed to be used twice\"", 0);
        FRAEC[0] = new Character("cabinet", "you open the cabinet which reveals a dagger and a sack of coins", cabinet, 100000);                  
        Room FRAE = new Room(FRAEI, FRAEC, "front room", "You walk into a room and you see a cabinet and a table.");

        System.out.println("You spawn in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road.");        
        currentRoom = spawn;
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        clearingSpawn.setEast(cave);
        cave.setSouth(clearingSpawn);

    }
}
