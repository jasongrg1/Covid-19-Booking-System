/**
 * The type Room.
 */
public class Room {

    private String code;

    private int capacity;

    /**
     * Print room template string.
     *
     * @return Template for room details.
     */
    public String printRoomTemplate() {
        String RoomTemplate = " | " + code + " |  capacity: " + capacity + " |";

        return RoomTemplate;
    }

    /**
     * Constructor to instantiate a room.
     *
     * @param code     code of room.
     * @param capacity capacity of room.
     */
    public Room(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
    }


    /**
     * getter for code.
     *
     * @return code of room object.
     */
    public String getCode() {
        return code;
    }

    /**
     * getter for capacity of room.
     *
     * @return capacity of room object.
     */
    public int getCapacity() {
        return capacity;
    }
}