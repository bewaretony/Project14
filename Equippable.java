
/**
 * Write a description of class Equippable here.
 * @author Anthony Luo, Johnn Shieh
 */
public class Equippable extends Item
{
    /**
     * Constructor for objects of class Equippable
     */
    public Equippable(String name, String description)
    {
        super(name, description);
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getName(){
        return name;
    }
}
