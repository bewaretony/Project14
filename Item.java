
/**
 * Write a description of class Item here.
 * @author John Shieh, Anthony Luo
 */
public class Item
{
    String name = "";
   String description = "";
     int use = 0;
     String location = "";
     

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int use, String location)
    {
        this.name = name;
        this.description = description;
        this.use = use;
        this.location = location;
        //IF AN OBJECT IS NOT A KEY THE KEYNUMBER IS 0
    }
   
    public int getUse() {
        return this.use;
    }
    
    public String getLocation() {
        return this.location;
    }

    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
}
