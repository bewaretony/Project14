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
                System.out.println("What do you want to attack?");
                Scanner kbReader = new Scanner(System.in);
                String input = kbReader.nextLine().toLowerCase();
                Character character = currentRoom.verifyCharacter(input);
                if(character != null){
                    System.out.println("What do you want to attack the " + character + " with?");
                    Scanner kbReader = new Scanner(System.in);
                    String input = kbReader.nextLine().toLowerCase();
                    Character character1 = currentRoom.verifyCharacter(input);                    
                }
                return;
            }
            Character character = currentRoom.verifyCharacter(cmd[1]);
            Item itemInventory = player.verifyInventory(cmd[3]);
            if (character != null && itemInventory != null){
                //if(character.door() = true;)
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
            if(itemInventory != null && character3 != null){
                currentRoom.useItem(itemInventory, character3);
            }
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
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
        if (cmd[0].compareTo("east") == 0){
            Room currentRoom1 = currentRoom.goEast();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
        if (cmd[0].compareTo("west") == 0){
            Room currentRoom1 = currentRoom.goWest();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
        if (cmd[0].compareTo("up") == 0){
            Room currentRoom1 = currentRoom.goUp();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
        if (cmd[0].compareTo("down") == 0){
            Room currentRoom1 = currentRoom.goDown();
            if (currentRoom != currentRoom1){
                System.out.println(currentRoom1.getName());
                System.out.println(currentRoom1.getDescription());
                Character[] mobs = currentRoom1.getCharacters();

                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }

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
        caveItems[0]= new Item("castle-key", "This seems to be the key to the castle", 1, "There is a key on the floor");
        caveItems[1]= new Item("stones", "Some random stones.", 0, "There are a pile of stones on the floor" );
        Character[] caveCharacters = new Character[0];
        Room cave = new Room(caveItems, caveCharacters, "Cave in the Gorge", "You enter a dark cave.");

        //castle entrance
        Item[] castleEntranceItems = new Item[0];
        Character[] castleCharacters = new Character[1];
        castleCharacters[0] = new Character("castle-door", "The door is made of cast iron and is impurtable. There is a key hole in the center.", true, 1, 1);
        Room castleEntrance = new Room(castleEntranceItems, castleCharacters, "Castle entrance", "You see the entrance to a giant, ruined castle.");

        //castle first room
        Item[] cfrI = new Item[1]; // do doors count as a character? --- ahhh doors that need keys are characters  -- ma
        cfrI[0] = new Item("bottle of beer", "The brand of the beer is Ancient Brewmaster", 0, "There is a bottle of beer on the floor");
        Character[] cfrC = new Character[1];  //temp
        cfrC[0] = new Character("painting door", "This seems to be a door that is disguised as a painting", false, 418098, 4);
        Room castleRoomFirst = new Room(cfrI, cfrC, "Castle Hall", "You walk into a large hall. There is a painting of Reynad. Ahead of you is a large room with 3 doors.");

        //castle seconds room
        Item[] csrI = new Item[1];
        csrI[0]= new Item("Totem", "This is Stoneclaw Totem", 0, "There is a totem on the ground");
        Character[] csrC = new Character[3];
        csrC[0] = new Character("left door", "The door is green and purple and says BLACKROCK MOUNTAIN . It does not seem to be locked",false, 5268, 4);
        csrC[1] = new Character("right door", "The door is orange and black and says CURSE OF NAXXRAMUS. The door has a keyhole that is in the shape of a pyramid", true, 30, 2);
        csrC[2] = new Character("door", "The door is blue and brown and says LEAGUE OF EXPLORERS. The door has a keyhole that is in the shape of a hat", true, 60, 1);
        Room castleRoomSecond = new Room(csrI, csrC, "Castle Second Room", "You walk into a large room with three doors on each side. There are 3 doors, one on your left, right and infront of you.");

        //LEFT WING STUFF IS HERE

        //left wing first room
        Item[] lwfr = new Item[2];
        Character[] leftwingfirstroomC = new Character[1];
        lwfr[0] = new Item("Explorers Hat", "This seems to be a hat that gives you more HEALTH?!", 0,"There is a dusty hat lying on the floor");
        lwfr[1] = new Item("Painting of Kolento", "Examining the painting reveals nothing unusual.", 0, "There is a painting in the room");
        leftwingfirstroomC[0] = new Character("Loose floorboard", "The loose floorboard is disguised as a trap door that appears to be locked", true, 10, 6);  //wierd error here
        Room leftwingfirstroom = new Room(lwfr, leftwingfirstroomC, "left wing first room", "You enter a dark room. You can see the faint outlines of a hallway leading beyond. There is a loose floorboard");

        //leftwing hallwayOne
        Item[] LWH1I = new Item[0];
        Character[] LWH1C = new Character[0];
        Room LWH1 = new Room( LWH1I, LWH1C, "leftwing hall 1", "you are in a dark hallway");

        //leftiwng hallwayTwo
        Item[] LWH2I = new Item[0];
        Character[] LWH2C = new Character[0];
        Room LWH2 = new Room( LWH2I, LWH2C, "leftwing hall 2", "you are in a dark hallway");

        //deathpit
        Item[] LWH2DI = new Item[0];
        Character[] LWH2DC = new Character[0];
        Room LWH2D = new Room( LWH2DI, LWH2DC, "castle ruins", "you fall off a cliff and die"); //kill command needed

        //leftwing hallwayThree
        Item[] LWH3I = new Item[0];
        Character[] LWH3C = new Character[0];
        Room LWH3 = new Room( LWH3I, LWH3C, "leftwing hall 3", "you are in a dimly lit hallway");

        //leftwing torch room
        Item[] LWTRI = new Item[2];
        LWTRI[0] = new Item("torch left", "This seems to be a lava torch that is loosely attached to the wall", 300, "There is a torch on your left");
        LWTRI[1] = new Item("torch right", "This seems to be a 'Forgotten Torch' that is loosely attached to the wall", 301, "There is a torch on your right");  //grim patron needs weapon 301 to be killed
        Character[] LWTRC = new Character[0];
        Room LWTR = new Room(LWTRI, LWTRC, "Room", "You enter a large room.");

        //leftwing arena water station
        //TODO LATER 

        //left hall after torch
        Item[] LHATI = new Item[0];
        Character[]LHATC = new Character[0];
        Room LHAT = new Room(LHATI, LHATC, "Large Hallway", "You enter a large hallway.");

        //right fork after LHAT
        Item[] RFLHATI = new Item[0];
        Character[]RFLHATC = new Character[0];
        Room RFLHAT = new Room(RFLHATI, RFLHATC, "Balcony" , "You are in the balcony of a large arena. A voice below shouts  \"EVERYBODY GET IN HERE\"");

        //left fork after LHAT
        Item[] LFLHATI = new Item[0];
        Character[]LFLHATC = new Character[0];
        Room LFLHAT = new Room(LFLHATI, LFLHATC, "Hallway", "You enter the hallway, however it reveals a dead end.");

        //arena entrance hall (Room) front
        Item[] AEHFI = new Item[0];
        Character[]AEHFC = new Character[1];
        Item[] largebox = new Item[1];
        largebox[0] = new Item("map to the golden monkey", "you take out a scroll. It says that it is a Map to the Golden Monkey", 0, "There are scrolls in the box");
        AEHFC[0] = new Character("box", "You look into the box which reveals a large amount of scrolls.", largebox);
        Room AEHF = new Room(AEHFI , AEHFC, "hall/room after the entrance.", "You are in a hall. There is a large box on the floor");

        //front room after arena entrance hall
        //ADD LOOK METHOD
        Item[] FRAEI = new Item[1];
        FRAEI[0] = new Item("table", "there is nothing special about this table", 0, "");
        Character[] FRAEC = new Character[2];
        Item[] cabinet = new Item[2];
        cabinet[1] = new Item("bag of coins", "this is a bag of 50 coins", 0, "There is a bag of coins in the cabinet");
        cabinet[0] = new Item("dagger", "The dagger has a label that says Only designed to be used twice", 300, "There is a dagger in the cabinet");
        FRAEC[0] = new Character("cabinet", "you open the cabinet which reveals a dagger and a sack of coins", cabinet);
        Item[] Boom = new Item[0]; //TEST 
        FRAEC[1] = new Character("Boom", "This is Dr. Boom and he has two boom bots.",  "Dr. Boom is standing in the center of the Room", Boom, 100, 7);  //TEST
        Room FRAE = new Room(FRAEI, FRAEC, "front room", "You walk into a room and you see a cabinet and a table.");

        //balcony to arena room 1
        Item[] BAR1I = new Item[0];
        Character[]BAR1C = new Character[0];
        Room BAR1 = new Room(BAR1I, BAR1C, "Hallway", "You are in a hallway in the Arena.");
        
        //balcony to arena room 2
        Item[] BAR2I = new Item[0];
        Character[]BAR2C = new Character[0];
        Room BAR2 = new Room(BAR2I, BAR2C, "Hallway", "You are backstage in the Arena");
        
        //Arena grim patron
        Item[] AGRI = new Item[100];
        Character[] AGRC = new Character[1];
        Item[] patron = new Item[1];
        patron[0] = new Item("B-key", "This is the key to the trapdoor", 10, "There is a key on the ground");
        AGRC[0] = new Character("grim patron", "If you dont kill this minion in one hit, another grim patron will be summoned", "There is a grim patron in the center of the arena", patron, 3, 10);
        Room AGR = new Room(AGRI, AGRC, "Arena", "You enter the arena");
        
        //UNDERGROUND
        
        

        
        System.out.println("You spawn in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road.");        
        currentRoom = spawn;
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        clearingSpawn.setEast(cave);
        cave.setWest(clearingSpawn);
        castleEntrance.setNorth(castleRoomFirst);
        castleRoomFirst.setSouth(castleEntrance);
        
        

    }
}
