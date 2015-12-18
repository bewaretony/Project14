
/**
 * Write a description of class Item here.
 * @author John Shieh, Anthony Luo
 */
public class Item
{
    // instance variables - replace the example below with your own
    public String name;
    public String description;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
}
