/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    private Equippable[] equipped;
    private Item[] inventory;
    
    public Player(String name, Item[] startingInventory){
        
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