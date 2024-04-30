/**
 * The type Booking.
 */
public class Booking {

    private BookableRoom bookableRoom;

    private AssistantOnShift assistantOnShift;

    private String bookingDate;

    private String bookingTimeSlot;

    private String bookingStatus;

    private String roomCode;

    private String studentEmail;

    /**
     * Print booking template string.
     *
     * @return String of template for booking details.
     */
    public String printBookingTemplate() {
        String bookingTemplate = " | " + bookingDate + " " + bookingTimeSlot + " | " + this.assistantOnShift.getAssistant().getEmail() + " | " +
                this.bookableRoom.getRoom().getCode() + " | " + studentEmail + " |";
        return bookingTemplate;
    }

    /**
     * Constructor for instantiating a booking.
     *
     * @param bookableRoom     bookable room of booking.
     * @param assistantOnShift assistant on shift of booking.
     * @param bookingDate      date of booking.
     * @param bookingTimeSlot  timeslot of booking.
     * @param bookingStatus    status of bookings.
     * @param roomCode         room code of booking.
     * @param studentEmail     student email of booking.
     */
    public Booking(BookableRoom bookableRoom, AssistantOnShift assistantOnShift, String bookingDate, String bookingTimeSlot,
                      String bookingStatus, String roomCode, String studentEmail) {
        this.bookableRoom = bookableRoom;
        this.assistantOnShift = assistantOnShift;
        this.bookingDate = bookingDate;
        this.bookingTimeSlot = bookingTimeSlot;
        this.bookingStatus = bookingStatus;
        this.roomCode = roomCode;
        this.studentEmail = studentEmail;
    }

    /**
     * getter for status of booking.
     *
     * @return status of booking.
     */
    public String getBookingStatus(){
        return bookingStatus;
    }

    /**
     * setter for bookable room.
     *
     * @param bookableRoom bookable room of booking.
     */
    public void setBookableRoom(BookableRoom bookableRoom){
        this.bookableRoom = bookableRoom;
    }

    /**
     * setter for assistant on shift.
     *
     * @param assistantOnShift assistant on shift of booking.
     */
    public void setAssistantOnShift(AssistantOnShift assistantOnShift){
        this.assistantOnShift = assistantOnShift;
    }

    /**
     * setter for booking date.
     *
     * @param bookingDate of booking.
     */
    public void setBookingDate(String bookingDate){
        this.bookingDate = bookingDate;
    }

    /**
     * setter for booking timeslot.
     *
     * @param bookingTimeSlot timeslot of booking.
     */
    public void setBookingTimeSlot(String bookingTimeSlot){
        this.bookingTimeSlot = bookingTimeSlot;
    }

    /**
     * setter for booking status.
     *
     * @param bookingStatus status of booking.
     */
    public void setBookingStatus(String bookingStatus){
        this.bookingStatus = bookingStatus;
    }

    /**
     * setter for room code.
     *
     * @param roomCode room code of booking.
     */
    public void setRoomCode(String roomCode){
        this.roomCode = roomCode;
    }

    /**
     * setter for student email.
     *
     * @param studentEmail student email of booking.
     */
    public void setStudentEmail(String studentEmail){
        this.studentEmail = studentEmail;
    }

}
