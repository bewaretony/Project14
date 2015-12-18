
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
    private Item[] stuff;
    private Character[] people;
    private Room North;
    private Room South;
    private Room West;
    private Room East;
    
    public Room(Item[] s, Character[] p, String n, String d) {
        this.d = d;
        this.n = n;
        this.stuff = s;
        this.people = p;
        
    }
    
    public String getDescription() {
        return d;
    }
    
    public Room setNorth(Room x) {
        this.North = x;
        return North;
    }
    public Room setWest(Room x) {
        this.West = x;
        return West;
    }
    public Room setEast(Room x) {
        this.East = x;
        return East;
    }
    public Room setSouth(Room x) {
        this.South = x;
        return South;
    }
    public Room goNorth() {
        return North;
    }
    public Room goSouth() {
        return South;
    }
    public Room goWest() {
        return West;
    }
    public Room goEast() {
        return East;
    }
    
    
    }
