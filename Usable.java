    
/**
 * Write a description of class Usable here.
 * @author John Shieh, Anthony Luo
 */
public class Usable extends Item
{
    /**
     * Constructor for objects of class Usable
     */
    public Usable(String name, String description, int use, String location)
    {
        super(name, description, use, location);
    }

    public String getDescription(){
        return description;
    }
    
    public String getName(){
        return name;
    }
    public void use() {
        
    }
    
    public void use(Character target) {
        
    }
}
