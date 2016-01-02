
/**
 * Write a description of class Armor here.
 * @author John Shieh, Anthony Luo
 */
public class Armor extends Equippable
{
    public Armor(String name, String description, int use, String location){
        super(name, description, use, location);
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getName(){
        return name;
    }
}
