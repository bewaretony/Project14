
/**
 * Write a description of class Armor here.
 * @author John Shieh, Anthony Luo
 */
public class Armor extends Equippable
{
    public Armor(String name, String description, int use){
        super(name, description, use);
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getName(){
        return name;
    }
}
