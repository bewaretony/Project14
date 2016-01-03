/**
 * Write a description of class Character here.
 * @author Anthony Luo, John Shieh 
 */
public class Character
{
    private String name = "";
    private String description = "";
    private Item[] inventory;
    private int health;
    private boolean locked;
    private int keynumber;
    private String location;
    private boolean door;
    private boolean attackable;
    private int direction;

    /**
     * Constructor for objects that attack and can be attacked
     */
    public Character(String name, String description, String location, Item[] inventory, int health, int attack){
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.health = health;
        this.location = location;
        this.door = false;
        this.attackable = true;
    }
    /**
     * Constructor for objects that cannot be attacked (furniture)
     */
    
    public Character(String name, String description, Item[] inventory) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.door = false;
        this.attackable = false;
    }
    
    /**
     * Constructor for Doors
     */
    public Character(String name,String description, boolean locked, int keynumber, int direction) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.keynumber = keynumber;
        this.door = true;
       this.attackable = false;
       this.direction = direction;
    }

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }
    
    public String getLocation() {
        return this.location;
    }

    public String talk(String dialogue){
        return dialogue;
    }

    public int getKeyNumber() {
        return this.keynumber;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean getLocked() {
        return locked;
    }
    
    public void dHealth() {
        this.health = this.health-1;
    }
    
    public boolean door() {
        return this.door;
    }
    
    public boolean attackable() {
        return this.attackable;
       
    }
    
    public void unlock() {
        this.locked = false;
    }
}

