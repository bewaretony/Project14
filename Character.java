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

    /**
     * Constructor for objects of class Character
     */
    public Character(String name, String description, Item[] inventory, int health){
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.health = health;
    }

    public Character(String name,String description, boolean locked, int keynumber) {
        this.name = name;
        this.description = description;
        this.locked = locked;
        this.keynumber = keynumber;
    }

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
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
    
    
}
