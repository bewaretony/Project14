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
        while((input.compareTo("quit") != 0) && (input.compareTo("exit") != 0)){
            String[] cmd = input.split(" ");
            cmd[0] = cmd[0].toLowerCase();
            if((cmd[0].compareTo("go") == 0) && (cmd.length == 2)){
                input = cmd[1];
            }
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
        score = score + s;
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
                    System.out.println("What do you want to attack the " + character.getName() + " with?");
                    Scanner kbReader1 = new Scanner(System.in);
                    String input1 = kbReader1.nextLine().toLowerCase();
                    Item item = player.verifyItem(input1);
                    if(item != null){
                        currentRoom.attackCharacter(character, item, player);
                    }
                    else{
                        System.out.println("The item " + input1 + " could not be found in your inventory.");
                    }
                }
                else{
                    System.out.println("The character " + input + " could not be found.");
                }
                return;
            }
            if (cmd.length == 2){
                Character character = currentRoom.verifyCharacter(cmd[1]);
                if(character != null){
                    System.out.println("What do you want to attack the " + character + " with?");
                    Scanner kbReader1 = new Scanner(System.in);
                    String input1 = kbReader1.nextLine().toLowerCase();
                    Item item = player.verifyItem(input1);
                    if(item != null){
                        currentRoom.attackCharacter(character, item, player);
                    }
                    else{
                        System.out.println("The item " + input1 + " could not be found in your inventory.");                        
                    }
                }
                else{
                    System.out.println("The character " + cmd[1] + " could not be found.");                    
                }
                return;
            }
            Character character = currentRoom.verifyCharacter(cmd[1]);
            if (character == null) {
                System.out.println("The character " + cmd[1] + " could not be found.");   
                return;
            }
            Item itemInventory = player.verifyInventory(cmd[3]);
            if (itemInventory ==  null){
                System.out.println("The item " + cmd[3] + " could not be found in your inventory.");   
                return;                
            }
            if ((character != null) && (itemInventory != null)){
                currentRoom.attackCharacter(character, itemInventory, player);
            }
            else{
                System.out.println("The " + character + " or " + itemInventory + " was not found.");
            }
            return;
        }
        //NEED TO GET EXAMINE TO WORK ON CHARACTERS I.E. BOXES
        if (cmd[0].compareTo("examine") == 0){
            if(cmd.length == 1) {
                System.out.println(currentRoom.getDescription());
                Character[] mobs = currentRoom.getCharacters();
                for(int i = 0; i < mobs.length; i ++) {
                    if (mobs[i]!= null) {
                        if(mobs[i].attackable() == true) {

                            System.out.println(mobs[i].getLocation());
                        }
                    }
                }
                Item[] stuff = currentRoom.getStuff();
                for(int i = 0; i < stuff.length; i ++) {
                    if (stuff[i]!= null) {
                        System.out.println(stuff[i].getLocation());
                    }
                }
            }
            else if(cmd.length == 2) {
                Item item = currentRoom.verifyItemRoom(cmd[1]);
                Character charcheck = currentRoom.verifyCharacter(cmd[1]);
                Item itemRoom = player.verifyItem(cmd[1]);
                if(item != null) {
                    for(int i = 0; i < currentRoom.getStuff().length; i++) {
                        Item[] stuff = currentRoom.getStuff();
                        String name = stuff[i].getName().toLowerCase();
                        if(name.equals(cmd[1])) {
                            System.out.println(stuff[i].getDescription());
                        }
                    }
                    return;
                }
                else if(item == null) {
                    System.out.println("You cannot examine this item. (You may not have the item, or this item does not exist)");
                }

                else if(itemRoom != null) {
                    for(int i = 0; i < currentRoom.getStuff().length; i++) {
                        Item[] stuff = player.getPlayerInventory();
                        String name = stuff[i].getName().toLowerCase();
                        if(name.equals(cmd[1])) {
                            System.out.println(stuff[i].getDescription());
                        }
                    }
                }
                else {
                    System.out.println("You cannot examine this item. (You may not have the item, or this item does not exist)");
                }
            }

            else if(cmd.length > 2) {
                System.out.println("Blizzard servers have crashed!(I don't know what the command means.)");
            }

            return;
        }
        if (cmd[0].compareTo("take") == 0){
            if(cmd.length > 2){
                System.out.println("Blizzard servers have crashed!(I don't know what the command means.)");
                return;
            } 
            //instanceof stuff
            Character character = currentRoom.verifyCharacter(cmd[1]);
            if(character != null){
                System.out.println("You cannot take a character.");
                return;
            }
            if(cmd.length == 1){
                System.out.println("What item do you want to take?");
                Scanner kbReader = new Scanner(System.in);
                String input = kbReader.nextLine().toLowerCase();
                Item itemRoom1 = currentRoom.verifyItemRoom(input);
                if(itemRoom1 != null){
                    currentRoom.addItems(input, player);
                }
                else{
                    System.out.println("The item could not be found.");
                }
                return;
            }
            Item itemRoom = currentRoom.verifyItemRoom(cmd[1]);
            String itemName = cmd[1].toLowerCase();            
            if(itemRoom != null){
                currentRoom.addItems(itemName, player);
            }
            else{
                System.out.println("The item could not be found.");
            }
            return;
        }
        if (cmd[0].compareTo("drop") == 0){
            Item itemRoom = player.verifyItem(cmd[1]);
            return;
        }
        if (cmd[0].compareTo("use") == 0){
            Character character1 = currentRoom.verifyCharacter(cmd[1]);
            Item itemInventory = player.verifyInventory(cmd[1]);
            Character character3 = currentRoom.verifyCharacter(cmd[3]);
            if(cmd.length == 1){
                System.out.println("What item do you want to use?");
            }
            if(itemInventory != null){
                if(cmd.length == 2){
                    System.out.println("What do you want to use the " + cmd[1] + " on?");
                    System.out.print(">");
                    Scanner kbReader = new Scanner(System.in);
                    String input = kbReader.nextLine().toLowerCase();
                    Character character = currentRoom.verifyCharacter(input);
                    if(character != null){
                        currentRoom.useItem(itemInventory, character);
                    }
                }
            }
            if(itemInventory != null && character3 != null){
                currentRoom.useItem(itemInventory, character3);
            }            
        }
        if (cmd[0].compareTo("north") == 0){
            if(cmd.length > 1){
                System.out.println("Blizzard servers have crashed!(I don't know what the command means.)");
            }
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
        Item[] spawnItems = new Item[25];
        Character[] spawnCharacter = new Character[0];
        spawnItems[0] = new Item("tattered-book", "WELCOME TO HERO OF THE HEARTH. \nHero of the Hearth is a game by Blizzzard (The extra z is intended) that will be released Soon^TM \nIn Hero of the Hearth, players explore the land of King Gaben as they fight minions and monsters, while finding golden treasures. \nHero of the Hearth was created by John Shieh and Anthony Luo",0,"There is a tattered book on the floor");
        Room spawn = new Room(spawnItems, spawnCharacter, "Spawn Point", "You are in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle.");

        //clearing next to spawn
        Item[] clearingItems = new Item[25];
        Character[] cspawnItems = new Character[0];
        Room clearingSpawn = new Room(clearingItems, cspawnItems, "Clearing", "You are in a clearing in the middle of a gorge. You see a cave to your east. You hear a faint rumble and a voice seems to be saying: \"EVERYONE GET IN HERE\"");

        //cave room 
        Item[] caveItems = new Item[25];
        caveItems[0]= new Item("stones", "Some random stones.", 0, "There are a pile of stones on the floor" );
        Character[] caveCharacters = new Character[0];
        Room cave = new Room(caveItems, caveCharacters, "Cave in the Gorge", "You are in  a dark cave.");

        //castle entrance
        Item[] castleEntranceItems = new Item[25];
        Character[] castleCharacters = new Character[0];
        Room castleEntrance = new Room(castleEntranceItems, castleCharacters, "Castle entrance", "You are next to the castle. You see the entrance to a giant, ruined castle.");

        //castle first room
        Item[] cfrI = new Item[25]; // do doors count as a character? --- ahhh doors that need keys are characters  -- ma
        cfrI[0] = new Item("bottle-of-beer", "The brand of the beer is Ancient Brewmaster", 101 , "There is a bottle-of-beer on the floor");
        Character[] cfrC = new Character[1];  //temp
        cfrC[0] = new Character("painting-door", "This seems to be a painting-door", false, 418098, 4);
        Room castleRoomFirst = new Room(cfrI, cfrC, "Castle Hall", "You are in a large hall. There is a painting of Reynad. Ahead of you is a large room with 3 doors.");

        //castle seconds room
        Item[] csrI = new Item[25];
        csrI[0]= new Item("Totem", "This is Stoneclaw Totem", 0, "There is a totem on the ground");
        Character[] csrC = new Character[3];
        csrC[0] = new Character("left-door", "The left-door is green and purple and says BLACKROCK MOUNTAIN . It does not seem to be locked",false, 5268, 4);
        csrC[1] = new Character("right-door", "The right-door is orange and black and says CURSE OF NAXXRAMUS. The door has a keyhole that is in the shape of a pyramid", true, 40, 2);
        csrC[2] = new Character("blue-door", "The blue-door says LEAGUE OF EXPLORERS. The door has a keyhole that is in the shape of a hat", true, 60, 1);
        Room castleRoomSecond = new Room(csrI, csrC, "Castle Second Room", "You walk into a large room. There are 3 doors, one on your west which is unlocked, one to your north and one to your east of you.");

        //LEFT WING STUFF IS HERE

        //left wing first room
        Item[] lwfr = new Item[25];
        Character[] leftwingfirstroomC = new Character[1];
        lwfr[0] = new Item("Explorers-Hat", "This seems to be a hat that gives you more swag", 0,"There is an Explorers-hat lying on the floor");
        lwfr[1] = new Item("Painting-of-Kolento", "Examining the painting reveals nothing unusual.", 0, "There is a painting-of-kolento in the room");
        leftwingfirstroomC[0] = new Character("Loose-floorboard", "The loose-floorboard is disguised as a trap door.", true, 10, 6);
        Room leftwingfirstroom = new Room(lwfr, leftwingfirstroomC, "large-room", "You enter a dark room. You can see the faint outlines of a hallway leading beyond. There is a loose floorboard");

        //leftwing hallwayOne
        Item[] LWH1I = new Item[25];
        Character[] LWH1C = new Character[0];
        Room LWH1 = new Room( LWH1I, LWH1C, "hallway", "you are in a dark hallway");

        //leftiwng hallwayTwo
        Item[] LWH2I = new Item[25];

        Character[] LWH2C = new Character[0];
        Room LWH2 = new Room( LWH2I, LWH2C, "hallway", "you are in a dimly lit hallway");

        //deathpit
        Item[] LWH2DI = new Item[25];
        Character[] LWH2DC = new Character[0];
        Room LWH2D = new Room( LWH2DI, LWH2DC, "castle-ruins", "you fall off a cliff and die"); //kill command needed

        //leftwing hallwayThree
        Item[] LWH3I = new Item[25];
        Character[] LWH3C = new Character[0];
        Room LWH3 = new Room( LWH3I, LWH3C, "hallway", "you are in a dimly lit hallway");

        //leftwing torch room
        Item[] LWTRI = new Item[25];
        LWTRI[0] = new Item("Lava-Torch", "This seems to be a 'Lava-Torch' that is loosely attached to the wall", 300, "There is a 'Lava-torch' on your left");
        LWTRI[1] = new Item("Forgotten-Torch", "This seems to be a 'Forgotten-Torch' that is loosely attached to the wall", 301, "There is a 'Forgotten-torch' on your right");  //grim patron needs Forgotten Torchto be killed. FROM 
        Character[] LWTRC = new Character[0];
        Room LWTR = new Room(LWTRI, LWTRC, "Room", "You are in a large room.");

        //hallway to akk room
        Item[] AKKHI = new Item[25];
        Character[]AKKHC = new Character[0];
        Room AKKH = new Room(AKKHI, AKKHC, "tunnel", "You are in a round tunnel.");

        //leftwing arena knife + key to monkey-key room
        Item[] AKKI = new Item[35];
        AKKI[0] = new Item("water-bottle", "This is a water bottle from 'Water Elemental'", 102, "There is a water-bottle on the floor");
        AKKI[1] = new Item("golden-key", "This is a key that seems to be made of gold", 15, "There is a shiny-key on the floor"); //this is the key to the door in RFLHAT
        AKKI[2] = new Item("stone-knife", "This is a stone knife made by 'SI:7 Agent'", 300, "There is a stone-knife on the ground");
        Character[] AKKC = new Character[0];
        Room AKK = new Room(AKKI, AKKC, "Alchemy-lab", "You are in a the ruins of an alchemy lab");

        //left hall after torch
        Item[] LHATI = new Item[25];
        Character[]LHATC = new Character[0];
        Room LHAT = new Room(LHATI, LHATC, "Large-Hallway", "You are a large hallway.");

        //right fork after LHAT
        Item[] RFLHATI = new Item[25];
        Character[]RFLHATC = new Character[1];
        RFLHATC[0] = new Character("golden-door", "This is a door that is made out of solid gold. There is an inscription that reads 'Elise Starseeker'", true, 15, 2);
        Room RFLHAT = new Room(RFLHATI, RFLHATC, "Balcony" , "You are in the balcony of a large arena. A voice below shouts  \"EVERYBODY GET IN HERE\". There is a golden-door next to you" );

        //left fork after LHAT
        Item[] LFLHATI = new Item[25];
        Character[]LFLHATC = new Character[0];
        Room LFLHAT = new Room(LFLHATI, LFLHATC, "Hallway", "You are in a hallway, however it reveals a dead end.");

        //arena entrance hall (Room) front
        Character[]AEHFC = new Character[1];
        Item[] largebox = new Item[25];
        largebox[0] = new Item("monkey-key", "This seems to be a key with a monkey engraving", 20, "There is a monkey-key in the box");
        Room AEHF = new Room(largebox , AEHFC, "Hallway", "You are in a hall. There is a large box on the floor");

        //front room after arena entrance hall
        //ADD LOOK METHOD
        Item[] FRAEI = new Item[35];
        FRAEI[0] = new Item("table", "there is nothing special about this table", 0, "");          
        FRAEI[1] = new Item("coins", "this is a large coin with a spiral in the center", 90, "There is a coin in the cabinet");
        FRAEI[0] = new Item("dagger", "The dagger has a label that says Only designed to be used twice", 300, "There is a dagger in the cabinet");
        Room FRAE = new Room(FRAEI, new Character[0], "front room", "You are in a room and you see a cabinet and a table.");

        //balcony to arena room 1
        Item[] BAR1I = new Item[25];
        Character[]BAR1C = new Character[0];
        Room BAR1 = new Room(BAR1I, BAR1C, "Hallway", "You are in a hallway in the Arena.");

        //balcony to arena room 2
        Item[] BAR2I = new Item[25];
        Character[]BAR2C = new Character[0];
        Room BAR2 = new Room(BAR2I, BAR2C, "Hallway", "You are backstage in the Arena");

        //Arena grim patron
        Item[] AGRI = new Item[100];
        Character[] AGRC = new Character[1];
        Item[] patron = new Item[1];
        patron[0] = new Item("Patron-key", "This is the key to the trapdoor", 10, "There is a Patron-key on the ground");
        AGRC[0] = new Character("grim-patron", "If you dont kill this minion with the right weapon, you will die", "There is a grim-patron in the center of the arena", patron, 3, 3, 301); //need torch from LWTR ROOM 
        Room AGR = new Room(AGRI, AGRC, "Arena", "You are in the arena");

        //UNDERGROUND

        //hallway down
        Item[] HDI = new Item[25];
        Character[] HDC = new Character[0];
        Room HD = new Room(HDI, HDC, "pathway", "you are standing on a steep set of stairs");

        //downstairs central station
        Item[] DCSI =  new Item[25];
        Character[] DCSC = new Character[1];
        DCSC[0] = new Character("red-door", "this is a solid red door", true, 31, 2); 
        Room DCS = new Room(DCSI, DCSC, "Grand-hall", "You are in a grand hall. There is a red door to the east");

        //fireball room next to DCS
        Item[] FBRI = new Item[25];
        FBRI[0] = new Item("fire-ball", "This seems to be a weapon of sorts", 305, "There is a fire-ball attached to the ceiling");
        FBRI[1] = new Item("ball-of-fire", "This seems to be a decoration of some sort", 0, "There is a ball-of-fire attached to the ceiling");
        Character[] FBRC = new Character[2];
        FBRC[0] = new Character("brown-door", "This seems to be a door with monkey engravings.", true, 20, 1);
        FBRC[1] = new Character("golden-door", "This seems to be a solid gold door", true, 30, 4);
        Room FBR = new Room(FBRI, FBRC, "Glowing-Room", "You are in a room with a brown-door to your north and a golden-door to your west");

        //monkey part room
        Item[] MMRI = new Item[25];
        MMRI[0] = new Item("Golden-key", "There is another key made of solid gold", 30, "There is a golden-key on the floor");
        MMRI[1] = new Item("Monkey-tail", "This is a golden monkey tail", 91, "There is a Monkey-tail on the floor");
        Character[] MMRC = new Character[0];
        Room MMR = new Room(MMRI, MMRC, "Strange-Room", "You are in a room that is covered in rubble");

        //monkey head hall room
        Item[] MHHRI = new Item[25];
        Character[] MHHRC = new Character[1];
        MHHRC[0] = new Character("tattered-door", "This seems to be a tattered-door", false, 6345, 4);
        Room MHHR = new Room(MHHRI, MHHRC, "Center-Room", "You are in a large room. There is a tattered-door to your west");

        //death trap 2
        Item[] DT2I = new Item[25];
        Character[] DT2C = new Character[0];
        Room DT2 = new Room(DT2I, DT2C, "Death-pit", "You fall into a large acid pit and die");  //dead 

        //monkey head room
        Item[] bin = new Item[25];
        bin[0] = new Item("golden-key", "This seems to be a golden-key with a mountain engraving on it", 47, "There is a golden-key in the bin");
        bin[1] = new Item("monkey-head", "This seems to be a golden monkey-head", 92, "There is a monkey-head in the bin");
        Room MHR =  new Room(bin, new Character[0], "Monkey-room", "You are in a room with various ruined objects. There is a bin in the room");

        //B-key room --key 31
        Item[] BKRI = new Item[25];
        BKRI[0] = new Item("Red-Key", "This is a plain Red-Key", 31, "There is a Red-Key on the ground");
        Room BKR = new Room(BKRI, new Character[0], "Orange-Room", "You are in a completely orange room.");

        //frostbolt room
        Item[] FBR2I = new Item[25];
        FBR2I[0] = new Item("frost-bolt", "This seems to be a powerful weapon", 350, "There is a frost-bolt on the ceiling");
        FBR2I[1] = new Item("bolt-of-frost", "This seems to be a decorative item", 0, "There is a bolt-of-frost attached to the wall");
        Room FBR2 = new Room(FBR2I, new Character[0], "Blue-Room", "You are in a blue room.");

        //pre-rag room
        Room RPR = new Room(new Item[25], new Character[0], "Black-Room", "You walk into a black room. A sign on the wall says \"Beware of Ragnaros\"");

        //deathpit 3
        Room DT3 = new Room(new Item[25], new Character[0], "Death-Pit 3", "You fall off into a lava pit and die"); //DEATH HERE

        //RAGNAROS FIGHT
        Item[] RFRI = new Item[90];
        Item[] RAGIT = new Item[2];
        Character[] RFRC = new Character[1];
        RAGIT[0] = new Item("Green-key", "This seems to be a green-key with an inscription that says 'CURSE OF THE NAXX' on it'", 40, "There is a green key in the center of the room");
        RAGIT[1] = new Item("Pedastal", "This seems to be a pedestal with an incription that say 'GOLDEN MONKEY' on it", 93, "There is a pedastal floating above the ground");
        RFRC[0] = new Character("Ragnaros", "Ragnaros is a powerful minion! You will die if you do not use the correct weapon", "Ragnaros is in the center of the room", RAGIT, 80, 1, 350);
        Room RFR = new Room(RFRI, RFRC, "Jousting Arena", "You are in a jousting arena");

        //RIGHTWING

        //right wing first room
        Room RWFR = new Room(new Item[25], new Character[0], "NAXX-Hall", "You are in a green and purple central hall");

        //right hall 1
        Room RH1 = new Room(new Item[25], new Character[0], "Hallway", "you are in a long hallway.");

        //right hall 2
        Room RH2 = new Room(new Item[25], new Character[0], "Hallway", "You are in a long hallway. You can see the castle courtyard."); 

        //right hall transition (RHB)
        Room RHB = new Room(new Item[25], new Character[0], "Sunlit-Room", "You are in a sunlit room.");

        //Both doors right wing
        Character[] MEI = new Character[2];
        MEI[0] = new Character("Veiled-door", "This is a veiled-door. There is nothing special about this door", true, 51, 3);
        MEI[1] = new Character("Oak-door", "This is a sturdy Oak-door", true, 47, 2);
        Room ME = new Room(new Item[25], MEI, "Chamber-of-Secrets", "you are in a chamber. There are two doors. One is a Veiled-door to the south and another is an Oak-door to the east");

        //hallway to the MAPR
        Room MHW = new Room(new Item[25], new Character[0], "Hallway", "You are in a golden hallway");

        //Monkey arm room
        Item[] painting = new Item[25];
        painting[0] = new Item("Monkey-arm", "These are a pair of golden monkey-arm", 94, "There is a monkey arm inside the secret comparment of the painting");
        Room MAR = new Room(painting, new Character[0], "Art Gallery", "You are in a room. There is a painting on the wall");

        //D key room
        Item[] DKRI = new Item[25];
        DKRI[0] = new Item("Purple-Key", "This a Purple-key with a goblet inscribed on it", 54, "There is a Purple-key on the floor");
        Room DKR = new Room(DKRI, new Character[0], "Oak-Room", "You are in a all-wood room");

        //Loatheb Hall 1
        Room LH1 = new Room(new Item[25], new Character[0], "Hallway", "you are in a green hallway");

        //Loatheb Hall 2
        Room LH2 = new Room(new Item[25], new Character[0], "Hallway", "you are in a green and purple hallway");

        //Loatheb Room
        Character[] LRC  = new Character[1];
        Item[] Loatheb = new Item[2];
        Loatheb[0] = new Item("Bronze-Key", "This is a key made out of bronze", 56, "There is a Bronze-Key on the ground");
        Loatheb[1] = new Item("BGH-Sword", "This is the BIG GAME HUNTER SWORD", 347, "There is BGH-Sword on the ground");
        LRC[0] = new Character("Loatheb", "Loatheb is a fearsome minion. If you do not kill him with the right weapon you will die", "Loatheb is in the middle of the room", Loatheb, 3, 30, 305);
        Room LR = new Room(new Item[50], LRC, "Giant-Hall", "You are in the middle of a giant hall.");

        //DEAD END
        Room DEM = new Room(new Item[25], new Character[0], "Dead End", "You walk into a room that is a dead end");

        //deathpit next to RH5
        Room DT4 = new Room(new Item[25], new Character[0], "Sinkhole", "You walk into a sinkhole and die");

        //Right hallway 4
        Room RH4 = new Room(new Item[25], new Character[0], "Hallway", "You are in a stained glass hallway");

        //Right hallway 5
        Room RH5 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway");

        //goblet room hall
        Character[] GRHC = new Character[1];
        GRHC[0] = new Character("Purple-door", "This a purple door", true, 54, 4);
        Room GRH = new Room(new Item[25], GRHC, "Purple-Room", "You are in a purple room. There is a purple door to your west");

        //goblet room
        Item[] GRI = new Item[25];
        GRI[0] = new Item("Goblet", "This seems to be a goblet made out of solid gold", 95, "There is a goblet on the ground");
        Room GR = new Room(GRI, new Character[0], "Castle Safe", "You are in the castle safe");

        //Right hallway 6
        Room RH6 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway");

        //Right wing stairs
        Character[] RWSC = new Character[1];
        RWSC[0] = new Character("Bronze-door", "This is a solid bronze. It seems to be leading upstairs", true, 56, 5);
        Room RWS = new Room(new Item[25], RWSC, "Bronze Room", "You are in a bronze room. There is a bronze door");

        //Veil door key 51
        Item[] VDKI = new Item[25];
        VDKI[0] = new Item("shrouded-key", "This seems to be a key made out of some light-absorbing material", 51, "There is a shrouded-key on the ground");
        Room VDK = new Room(VDKI, new Character[0], "Mysterious Room", "You are in a strange, dark room");

        //Flame cannon room
        Item[] FCRI = new Item[25];
        FCRI[0] = new Item("Cannon-of-flames", "This seems to be a decorative object", 0, "There is a Cannon-of-flames on the wall");
        FCRI[1] = new Item("Flame-cannon",  "This seems to be a powerful weapon", 327, "There is a Flame-cannon on the ceiling");
        Room FCR = new Room(FCRI, new Character[0], "Ancient Lab", "You are in the ruins of a ancient lab"); 

        //STAIRWELL1
        Room RWU1 = new Room(new Item[25], new Character[0], "Stairwell", "You are in a stairwell");

        //landing

        Room RWU2 = new Room(new Item[25], new Character[0], "Landing", "You are at the top of a set of stairs");
        
        //right hallway to the south (balcony)
        Room BBC = new Room(new Item[25], new Character[0], "Balcony", "You on a balcony");
        
        //hallway before darkbomb room (DBR)
        Room RWU4 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway. You can see the castle grounds out the window.");
        

        //weapons storage DBR
        Item[] DBRI = new Item[25];
        DBRI[0]  =new Item("Darkbomb", "This seems to be a powerful bomb that still works!", 337, "There is a darkbomb on the ground");
        Room DBR = new Room(DBRI, new Character[0], "Weapons storage", "You are in a ruins of a weapons storage room"); 

        //CER Castle edge death room
       Room CER = new Room(new Item[25], new Character[0], "Castle grounds", "You have fallen off the edge of the castle into a Twisting Nether and died");
        

        //Balcony room number 2 with coghammer
        Item[] BBC1I = new Item[25];
        BBC1I[0] = new Item("Coghammer", "This is a Coghammer. There is nothing special about this weapon", 369, "There is a coghammer on the railing");
        Room BBC1 = new Room(BBC1I, new Character[0], "Balcony", "You are the partly constructed area of the balcony");

        //balcony room number 3 
        Room BBC2 = new Room(new Item[25], new Character[0], "Scenic Overlook", "You are in a bright room. You can see the spawn point out the window ");
        
        //kelthuzad entrance
        Character[] KEC= new Character[1];
        KEC[0] = new Character("silver-door", "This is a silver door which seems to be made out of silver", true, 43, 2);
        Room KE = new Room(new Item[25], KEC, "Scenic Overlook", "You are in a large circular room. There is a silver door to the east");
        
        //kel thuzad room
        Character[] KTC = new Character[1];
        Item[] KelI = new Item[2];
        KelI[0] = new Item("Gold-key", "This is a golden key", 70, "There is a golden key on the floor");
        KelI[1] = new Item("Legendary-Gem", "This is a yellow LEGENDARY GEM", 96, "There is a legendary-gem on the floor");
        KTC[0] = new Character("Kel'Thuzad", "Kel'Thuzad is a fearsome minion that will kill you instantly if you do not use the correct weapon", "Kel'Thuzad is in the center of the chamber", KelI, 30, 4, 327);
        
        //leper gnome room
        Item[] LGI = new Item[1];
        LGI[0] = new Item("Platinum-key", "This is a platinum-key", 63, "There is a platinum key on the ground");
        Character[] LGC = new Character[1];
        LGC[0] = new Character("Leper-Gnome", "This is Leper-Gnome. He will kill you if you do not use the correct weapon you will die", "There is a Leper Gnome in the room", LGI, 20, 2, 369);
        Room LGR = new Room(new Item[25], LGC, "Battle-Training-Room", "You are in an ancient battle training room");
        
        //leper gnome dead end
        Room LGDE = new Room(new Item[25], new Character[0], "Hallway", "You are in a dead end");
        
        //leper gnome dead end 1
         Room LGDE1 = new Room(new Item[25], new Character[0], "Room", "You are in a dead end");
        
        //platinum door room
        Character[] PDRC = new Character[1];
        PDRC[0] = new Character("Platinum-door", "This is a solid platinum door", true, 63, 4);
        
        //acid pit 2 death room
        Room AP2D = new Room(new Item[25], new Character[0], "Twisting Nether", "You fall into an Twisting Nether, you die");
        
        //platinum door hallway 1
        Room PDH1 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway(lmao)");
        
        //platinum door hallway 2
        Room PDH2 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway(Woot)");
        
        //platinum door hallway 3
        Room PDH3 = new Room(new Item[25], new Character[0], "Hallway", "You are in a hallway(lol)");
        
        //mana crystals room
        Item[] MCRI = new Item[25];
        MCRI[0] = new Item("Mana-Crystals", "These some blue mana crystals", 97, "There are blue mana-crystals on the floor");
        Room MCR = new Room(MCRI, new Character[0], "Gem-Room", "You walk into an ancient gem collection");
        
        //Pyroblast Room -- used to kill mysterious cahllenger
        Item[] PRI = new Item[25];
        PRI[0] = new Item("Pyroblast", "This is a powerful spell", 392, "There is a pyroblast on the floor");
        Room PR = new Room(PRI, new Character[0], "flame-room", "You walk into a ancient flame room");
        
        //Silver key room -- kelthuzad
        Item[] SKRI = new Item[25];
        SKRI[0] = new Item("silver-key", "this is a silver key", 43, "There is a silver key on the floor");
        Room SKR = new Room(SKRI, new Character[0], "Glass Room", "You walk into a glass room");
        
       
        //Intial setup
        Item[] PlayerIn = new Item[10];
        player = new Player("Hero", "A buff dude", PlayerIn, 100);
        System.out.println("Welcome to HERO OF THE HEARTH");
        System.out.println("You are in a forest. Ahead of you there is a clearing, and in the distance you can see a ruined castle. You see a tattered book lying along the road.");        
        currentRoom = spawn;
        //CENTER CASTLE
        spawn.setNorth(clearingSpawn);
        clearingSpawn.setSouth(spawn);
        castleEntrance.setSouth(clearingSpawn);
        clearingSpawn.setNorth(castleEntrance);
        clearingSpawn.setEast(cave);
        cave.setWest(clearingSpawn);
        castleEntrance.setNorth(castleRoomFirst);
        castleRoomFirst.setSouth(castleEntrance);
        castleRoomFirst.setNorth(castleRoomSecond);
        castleRoomSecond.setWest(leftwingfirstroom);
        castleRoomSecond.setEast(RWFR);

        //LEFTWING
        leftwingfirstroom.setEast(castleRoomSecond);
        LWH1.setEast(leftwingfirstroom);
        leftwingfirstroom.setWest(LWH1);
        LWH1.setWest(LWH2);
        LWH2.setEast(LWH1);
        LWH2.setNorth(LWH2D);
        LWH2D.setSouth(LWH2);
        LWH3.setEast(LWH2);
        LWH2.setWest(LWH3);
        LWH3.setWest(LWTR);
        LWTR.setEast(LWH3);
        LWTR.setNorth(AKKH);
        AKKH.setSouth(LWTR);
        AKKH.setNorth(AKK);
        AKK.setSouth(AKKH);
        LWTR.setSouth(LHAT);
        LHAT.setNorth(LWTR);
        LHAT.setWest(LFLHAT);
        LFLHAT.setEast(LHAT);
        LHAT.setEast(RFLHAT);
        RFLHAT.setWest(LHAT);
        RFLHAT.setEast(AEHF);
        AEHF.setWest(RFLHAT);
        AEHF.setSouth(FRAE);
        FRAE.setNorth(AEHF);
        RFLHAT.setSouth(BAR1);
        BAR1.setNorth(RFLHAT);
        BAR1.setEast(BAR2);
        BAR2.setWest(BAR1);
        BAR2.setNorth(AGR);
        AGR.setSouth(BAR2);

        //underground - leftwing
        leftwingfirstroom.setDown(HD);
        HD.setUp(leftwingfirstroom);
        HD.setNorth(DCS);
        DCS.setSouth(HD);
        DCS.setWest(FBR);
        FBR.setEast(DCS);
        FBR.setNorth(MMR);
        MMR.setSouth(FBR);
        FBR.setWest(MHHR);
        MHHR.setEast(FBR);
        MHHR.setSouth(MHR);
        MHR.setNorth(MHHR);
        MHHR.setWest(DT2);
        MHR.setWest(DT2);
        DCS.setNorth(BKR);
        BKR.setSouth(DCS);
        BKR.setNorth(FBR2);
        FBR2.setSouth(BKR);
        BKR.setEast(DT3);
        DCS.setEast(RPR);
        RPR.setWest(DCS);
        RPR.setNorth(DT3);
        RPR.setSouth(RFR);
        RFR.setNorth(RPR);

        //RIGHTWING
        RWFR.setWest(castleRoomSecond);
        RH1.setSouth(RWFR);
        RWFR.setNorth(RH1);
        RH1.setNorth(RH2);
        RH2.setSouth(RH1);
        RH2.setNorth(RHB);
        RHB.setSouth(RH2);
        RHB.setEast(ME);
        ME.setWest(RHB);
        ME.setSouth(DKR);
        ME.setEast(MHW);
        MHW.setWest(ME);
        MHW.setEast(MAR);
        MAR.setWest(MHW);
        DKR.setNorth(ME);
        DKR.setEast(LH1);
        DKR.setSouth(DEM);
        DEM.setNorth(DKR);
        LH1.setWest(DKR);
        LH1.setNorth(LH2);
        LH2.setSouth(LH1);
        LH2.setWest(LR);
        LR.setEast(LH2);

        //
        RWFR.setSouth(RH4);
        RH4.setNorth(RWFR);
        RH4.setEast(RH5);
        RH5.setWest(RH4);
        RH5.setNorth(DT4);
        RH5.setSouth(GRH);
        GRH.setNorth(RH5);
        GRH.setWest(GR);
        GR.setEast(GRH);
        RH5.setEast(RH6);
        RH6.setWest(RH5);
        RH6.setNorth(VDK);
        VDK.setSouth(RH6);
        VDK.setWest(DT4);
        RH6.setEast(RWS);
        RWS.setWest(RH6);
        VDK.setEast(FCR);
        FCR.setWest(VDK);
    }
}

