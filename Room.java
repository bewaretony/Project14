
/**
 * Write a description of class Room here.
 * @author Anthony Luo and John Shieh
 * @version (a version number or a date)
 */
public class Room
{
    private String d;
    private String n;
    private Item[] stuff;
    private Character[] people;
    private Room north;
    private Room south;
    private Room west;
    private Room east;
    private Room up;
    private Room down;
    
    public Room(Item[] s, Character[] p, String n, String d) {
        this.d = d;
        this.n = n;
        this.stuff = s;
        this.people = p;
        
    }
    
    public String getDescription() {
        return d;
    }
    public String getName() {
        return n;
    }
    public Room setNorth(Room x) {
        this.north = x;
        return north;
    }
    public Room setWest(Room x) {
        this.west = x;
        return west;
    }
    public Room setEast(Room x) {
        this.east = x;
        return east;
    }
    public Room setSouth(Room x) {
        this.south = x;
        return south;
    }
    public Room setUp(Room x){
        this.up = x;
        return up;
    }
    public Room setDown(Room x){
        this.down = x;
        return down;
    }    
    public Room goNorth() {
        return north;
    }
    public Room goSouth() {
        return south;
    }
    public Room goWest() {
        return west;
    }
    public Room goEast() {
        return east;
    }
    public Room goUp(){
        return up;
    }
    public Room goDown(){
        return down;
    }
    
    }
