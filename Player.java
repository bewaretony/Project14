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
    
    public Player(String name, Item[] startingInventory, String description){
        
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