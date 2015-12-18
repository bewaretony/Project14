
/**
 * Write a description of class Room here.
 * 
 * @author Anthony Luo and John Shieh
 * @version (a version number or a date)
 */
public class Room
{
    private String d;
    private String n;
    
    public Room(Item[]s, Character[] p, String n, String d) {
        this.d = d;
    }
    
    public String getDescription() {
        return d;
    }
    
    public Room setNorth(Room x) {
        Room North = x;
        return North;
    }
    public Room setWest(Room x) {
        Room West = x;
        return West;
    }
    public Room setEast(Room x) {
        Room East = x;
        return East;
    }
    public Room setSouth(Room x) {
        Room South = x;
        return South;
    }
    
    }
