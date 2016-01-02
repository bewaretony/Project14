/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    private Equippable[] equipped;
    private Item[] inventory;
    private String name;
    private String description;
    private int health;
    public Player(String name, String description, Item[] startingInventory, int health){
        this.name = name;
        this.description = description;
        this.health = health;
        
        
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void attack(Character target){
        
    }
    
    public void equip(Equippable equipment){
    }
}