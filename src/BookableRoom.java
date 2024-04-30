/**
 * The type Bookable room.
 */
public class BookableRoom {

    private Room room;

    private int occupancy;

    private String bookableRoomStatus;

    private String bookableRoomDate;

    private String bookableRoomTimeSlot;


    /**
     * Print bookable room template string.
     *
     * @return Template for a bookable room.
     */
    public String printBookableRoomTemplate() {
        String bookableRoomTemplate = " | " + bookableRoomDate + " " + bookableRoomTimeSlot + " | " + bookableRoomStatus +
                " | " + this.room.getCode() + " | occupancy: " + occupancy + " |";
        return bookableRoomTemplate;
    }

    /**
     * Constructor with date and timeslot used when matching date and time during booking.
     *
     * @param bookableRoomDate     date
     * @param bookableRoomTimeSlot timeslot
     */
    public BookableRoom(String bookableRoomDate, String bookableRoomTimeSlot) {
        this.bookableRoomDate = bookableRoomDate;
        this.bookableRoomTimeSlot = bookableRoomTimeSlot;
    }

    /**
     * Constructor for instantiating a bookable room.
     *
     * @param room                 room of bookable room.
     * @param occupancy            occupancy of bookable room.
     * @param bookableRoomStatus   status of bookable room.
     * @param bookableRoomDate     date of bookable room.
     * @param bookableRoomTimeSlot timeslot for bookable room.
     */
    public BookableRoom(Room room, int occupancy, String bookableRoomStatus, String bookableRoomDate, String bookableRoomTimeSlot) {
        this.room = room;
        this.occupancy = occupancy;
        this.bookableRoomStatus = bookableRoomStatus;
        this.bookableRoomDate = bookableRoomDate;
        this.bookableRoomTimeSlot = bookableRoomTimeSlot;
    }

    /**
     * Gets room.
     *
     * @return room of bookable room.
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Gets bookable room time slot.
     *
     * @return timeslot for bookable room.
     */
    public String getBookableRoomTimeSlot() {
        return bookableRoomTimeSlot;
    }

    /**
     * Gets bookable room status.
     *
     * @return status of bookable room.
     */
    public String getBookableRoomStatus() {
        return bookableRoomStatus;
    }

    /**
     * Gets bookable room date.
     *
     * @return date of bookable room.
     */
    public String getBookableRoomDate() {
        return bookableRoomDate;
    }

    /**
     * Gets occupancy.
     *
     * @return occupancy of bookable room.
     */
    public int getOccupancy() {
        return occupancy;
    }

    /**
     * setter for occpancy.
     *
     * @param occupancy occupancy of bookable room.
     */
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    /**
     * setter for status.
     *
     * @param bookableRoomStatus status of bookable room.
     */
    public void setBookableRoomStatus(String bookableRoomStatus) {
        this.bookableRoomStatus = bookableRoomStatus;
    }

    /**
     * setter for date.
     *
     * @param bookableRoomDate date of bookable room.
     */
    public void setBookableRoomDate(String bookableRoomDate) {
        this.bookableRoomDate = bookableRoomDate;
    }

    /**
     * setter for timeslot.
     *
     * @param bookableRoomTimeSlot timeslot of bookable room.
     */
    public void setBookableRoomTimeSlot(String bookableRoomTimeSlot) {
        this.bookableRoomTimeSlot = bookableRoomTimeSlot;
    }


    /**
     * Added bookable room string string.
     *
     * @return String for successful booking.
     */
    public String addedBookableRoomString() {
        String addedBookableRoomString = "Bookable Room added successfully:\n";
        addedBookableRoomString += this.printBookableRoomTemplate();
        addedBookableRoomString += "\nPlease, enter one of the following:\n\n";
        addedBookableRoomString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\nseparated by a white space.\n";
        addedBookableRoomString += "0. Back to main menu.\n-1. Quit application.\n";
        return addedBookableRoomString;
    }

    /**
     * Print date time template string.
     *
     * @return Template for date and timeslot.
     */
    public String printDateTimeTemplate() {
        String dateTimeTemplate = bookableRoomDate + " " + bookableRoomTimeSlot;
        return dateTimeTemplate;
    }


}