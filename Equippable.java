
/**
 * Write a description of class Equippable here.
 * @author Anthony Luo, Johnn Shieh
 */
public class Equippable extends Item
{
    /**
     * Constructor for objects of class Equippable
     */
    public Equippable(String name, String description, int use, String location)
    {
        super(name, description, use, location);
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getUse() {
        return use;
    }

    public String getLocation() {
        return location;

    }
}
