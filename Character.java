
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

    /**
     * Constructor for objects of class Character
     */
    public Character(String name, String description, Item[] inventory){
        this.name =  name;
        this.description = description;
        this.inventory = inventory;
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
}
