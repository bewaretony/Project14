    
/**
 * Write a description of class Usable here.
 * @author John Shieh, Anthony Luo
 */
public class Usable extends Item
{
    /**
     * Constructor for objects of class Usable
     */
    public Usable(String name, String description, int use)
    {
        super(name, description, use);
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
