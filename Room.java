
/**
 * Write a description of class Room here.
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
        return north;
    }

    public Room goSouth() {
        if(south == null){
            System.out.println("You cannot go this way.");
            return this;
        }            
        return south;
    }

    public Room goWest() {
        if(west == null){
            System.out.println("You cannot go this way.");
            return this;
        }            
        return west;
    }

    public Room goEast() {
        if(east == null){
            System.out.println("You cannot go this way.");
            return this;
        }            
        return east;
    }

    public Room goUp(){
        if(up == null){
            System.out.println("You cannot go this way.");
            return this;
        }           
        return up;
    }

    public Room goDown(){
        if(down == null){
            System.out.println("You cannot go this way.");
            return this;
        }           
        return down;
    }

    public Character verifyCharacter(String characterName) {
        for (int i=0; i < people.length; i++) {
            String name = people[i].getName().toLowerCase();
            if (name.compareTo(characterName.toLowerCase()) == 0) {
                //System.out.println("character found");
                return people[i];
            }
        }
        //System.out.println("character NOT found");
        return null;
    }

    public Item verifyItem(String itemName) {
        for (int i = 0;i < stuff.length;i++){
            String name = stuff[i].getName().toLowerCase();
            if (name.compareTo(itemName.toLowerCase()) == 0) {
                return stuff[i];
            }
        }
        return null;
    }
    
    public void useItem(Item item, Character character){
        System.out.println("Used " + item.getName() + " on " + character.getName());
    }
}
