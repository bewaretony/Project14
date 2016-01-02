
/**
 * Write a description of class Item here.
 * @author John Shieh, Anthony Luo
 */
public class Item
{
    String name = "";
   String description = "";
     int keynumber = 0;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int keynumber)
    {
        this.name = name;
        this.description = description;
        this.keynumber = keynumber;
        //IF AN OBJECT IS NOT A KEY THE KEYNUMBER IS 0
    }
   
    

    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
}
