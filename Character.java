/**
 * Write a description of class Character here.
 * @author Anthony Luo, John Shieh 
 */
public class Character
{
    // instance variables - replace the example below with your own
    private String name = "";
    private String description = "";
    private Item[] inventory;
    private int health;
    private boolean locked;
    private int keynumber;
    private String location;
    private boolean door;

    /**
     * Constructor for objects of class Character
     */
    public Character(String name, String description, Item[] inventory, int health, String location){
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.health = health;
        this.location = location;
        this.door = false;
    }

    public Character(String name,String description, boolean locked, int keynumber, String location) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.keynumber = keynumber;
        this.location = location;
        this.door = true;
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

}
