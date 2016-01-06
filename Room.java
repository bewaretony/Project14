/** Write a description of class Room here.
 * @author Anthony Luo and John Shieh
 * @version (a version number or a date)
 */
public class Room
{
    private String d;
    private String n;
    private Item[] stuff;
    private Character[] people;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private Room up;
    private Room down;

    public Room(Item[] s, Character[] p, String n, String d) {
        this.d = d;
        this.n = n;
        this.stuff = s;
        this.people = p;

    }

    public Item[] getStuff() {
        return this.stuff;
    }

    public Character[] getCharacters() {
        return this.people;
    }

    public String getDescription() {
        return d;
    }

    public String getName() {
        return n;
    }

    public Room setNorth(Room x) {
        this.north = x;
        return north;
    }

    public Room setWest(Room x) {
        this.west = x;
        return west;
    }

    public Room setEast(Room x) {
        this.east = x;
        return east;
    }

    public Room setSouth(Room x) {
        this.south = x;
        return south;
    }

    public Room setUp(Room x){
        this.up = x;
        return up;
    }

    public Room setDown(Room x){
        this.down = x;
        return down;
    }    

    public Room goNorth() {
        if(north == null){
            System.out.println("You cannot go this way.");
            return this;
        }
        if(blockedByDoor(1) == true){
            return this;
        }
        return north;
    }

    public Room goSouth() {
        if(south == null){
            System.out.println("You cannot go this way.");
            return this;
        }    
        if(blockedByDoor(3) == true){
            return this;
        }        
        return south;
    }

    public Room goWest() {
        if(west == null){
            System.out.println("You cannot go this way.");
            return this;
        }            
        if(blockedByDoor(4) == true){
            return this;
        }       
        return west;
    }

    public Room goEast() {
        if(east == null){
            System.out.println("You cannot go this way.");
            return this;
        }            
        if(blockedByDoor(2) == true){
            return this;
        }        
        return east;
    }

    public Room goUp(){
        if(up == null){
            System.out.println("You cannot go this way.");
            return this;
        }           
        if(blockedByDoor(5) == true){
            return this;
        }        
        return up;
    }

    public Room goDown(){
        if(down == null){
            System.out.println("You cannot go this way.");
            return this;
        }           
        if(blockedByDoor(6) == true){
            return this;
        }        
        return down;
    }

    public Character verifyCharacter(String characterName) {
        for (int i=0; i < people.length; i++) {
            if(people[i] == null){
                continue;
            }
            String name = people[i].getName().toLowerCase();
            if (name.compareTo(characterName.toLowerCase()) == 0) {
                //System.out.println("character found");
                return people[i];
            }
        }
        //System.out.println("character NOT found");
        return null;
    }

    public void useItem(Item item, Character character){
        if(character.door() == true){
            if(character.getLocked() == true){
                if(item.getUse() == character.getKeyNumber()){
                    character.unlock();
                    System.out.println("The door has been unlocked and opened.");
                }
            }
            else{
                System.out.println("The door has been opened.");
            }
        }
        System.out.println("Used " + item.getName() + " on " + character.getName());
    }

    private boolean blockedByDoor(int direc){
        for(int i = 0;i < people.length; i++){
            String name = people[i].getName().toLowerCase();
            if(name.contains("door")){
                if ((people[i].direction ==direc) && (people[i].getLocked())){
                    String[] dir = {"", "north", "east", "south", "west", "up", "down"};
                    System.out.println("The "+dir[direc]+" direction is blocked by the locked " + name);
                    return true;
                }
            }
        }
        return false;
    }

    private void removeItems(Character character){
        Item[] items = character.getInventory();
        for(int i = 0;i < items.length;i++){
            if(items[i] != null){
                for(int j = 0;i < stuff.length;i++){
                    if(stuff[j] == null){
                        stuff[j] = items[i];
                        items[i] = null;
                    }
                }
            }
        }
    }

    public void attackCharacter(Character character, Item item, Player player){
        if(character.attackable() == false){
            System.out.println("You cannot attack " + character.getName() + ".");
            return;
        }        
        if(character.getHealth() > 1){
            character.dHealth();
            System.out.println(character.getName() + " is still alive. Keep attacking it.");
        }
        else{
            for (int i=0; i < people.length; i++) {
                if(people[i] == null){
                    continue;
                }
                String name = people[i].getName().toLowerCase();
                if (name.compareTo(character.getName().toLowerCase()) == 0) {
                    removeItems(people[i]);
                    people[i] = null;
                    for(int x = 0; x < stuff.length; x++ ) {
                        System.out.println(stuff[i].getLocation());
                        return;
                    }
                }
                System.out.println("The " + character.getName() + " has been slain.");

            }
        }
    }

    public Item verifyItemRoom(String itemName) {
        for (int i=0; i < stuff.length; i++) {
            if(stuff[i] != null){
                String name = stuff[i].getName().toLowerCase();
                if (name.compareTo(itemName.toLowerCase()) == 0) {
                    return stuff[i];
                }
            }
        }
        return null;
    }

    public void addItems(String itemName, Player player){
        Item[] items = player.getPlayerInventory();
        for(int i = 0;i < items.length;i++){
            if(items[i] == null){
                for(int j = 0;j < stuff.length;j++){
                    if(stuff[j] != null){
                        String name = stuff[j].getName().toLowerCase();
                        if(name.compareTo(itemName.toLowerCase()) == 0){
                            items[i] = stuff[j];
                            stuff[j] = null;
                            System.out.println("Taken.");
                        }
                    }
                }
            }
        }
    }
}