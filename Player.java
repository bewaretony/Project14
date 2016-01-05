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
    private String name;
    private String description;
    private int health;
    public Player(String name, String description, Item[] startingInventory, int health){
        this.name = name;
        this.description = description;
        this.health = health;   
        this.inventory = startingInventory;

    }

    public Item[] getPlayerInventory(){
        return this.inventory;
    }

    public Item verifyItem(String itemName) {
        for (int i = 0;i < inventory.length;i++){
            if(inventory[i] !=null){
                String name = inventory[i].getName().toLowerCase();
                if (name.equals(itemName.toLowerCase())) {
                    return inventory[i];
                }

            }
        }
        return null;
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

    public Item verifyInventory(String itemName){
        for(int i = 0;i < this.inventory.length; i++){
            String name = inventory[i].getName().toLowerCase();
            if(name.compareTo(itemName.toLowerCase()) == 0){
                return inventory[i];
            }
        }
        return null;
    }

    public int getHealth() {
        return this.health;
    }

    public void loseHealth(int i) {
        this.health = this.health-i;
    }
}