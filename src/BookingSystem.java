import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Booking system.
 */
public class BookingSystem {

    private ArrayList<BookableRoom> bookableRooms;

    private ArrayList<AssistantOnShift> assistantsOnShift;

    private ArrayList<Booking> bookings;


    /**
     * Constructor for instantiating the booking system.
     *
     * @param bookableRooms     list of bookable rooms.
     * @param assistantsOnShift list of assistants on shift.
     * @param bookings          list of bookings.
     */
    public BookingSystem(ArrayList<BookableRoom> bookableRooms, ArrayList<AssistantOnShift> assistantsOnShift, ArrayList<Booking> bookings) {
        this.bookableRooms = bookableRooms;
        this.assistantsOnShift = assistantsOnShift;
        this.bookings = bookings;
    }


    /**
     * getter for list of bookable rooms.
     *
     * @return array list of bookable rooms.
     */
    public ArrayList<BookableRoom> getBookableRooms() {
        return bookableRooms;
    }

    /**
     * getter for list of assistants on shift.
     *
     * @return array list of assistants on shift.
     */
    public ArrayList<AssistantOnShift> getAssistantsOnShift() {
        return assistantsOnShift;
    }

    /**
     * getter for list of bookings.
     *
     * @return array list of bookings.
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * method for checking the validity of date input.
     *
     * @param date date input from user.
     * @return whether the date is valid or not in boolean.
     */
    public boolean checkDateValidity(String date) {
        String datePattern = "\\d{2}/\\d{2}/\\d{4}";
        return date.matches(datePattern);

    }

    /**
     * method for checking the validity of time input.
     *
     * @param time time input from user.
     * @return whether the time input is valid or not in boolean.
     */
    public boolean checkTimeValidity(String time) {
        int a = 0;
        String[] times = {"07:00", "08:00", "09:00"};
        for (int i = 0; i < times.length; i++) {
            if (time.equals(times[i])) {
                a++;
            }
        }

        return a == 1;

    }

    /**
     * This method prints the String for main menu of the booking app.
     */
    public void loadMainMenu() {
        String mainMenu = "University of Knowledge - COVID test";
        mainMenu += "\n" + "\n" + "Manage Bookings" + "\n" + "\n";
        mainMenu += "Please, enter the number to select your option:" + "\n" + "\n";
        mainMenu += "To manage Bookable Rooms:" + "\n" + "1. List" + "\n" + "2. Add" + "\n" + "3. Remove" + "\n";
        mainMenu += "To manage Assistants on Shift:" + "\n" + "4. List" + "\n" + "5. Add" + "\n" + "6. Remove" + "\n";
        mainMenu += "To manage Bookings:" + "\n" + "7. List" + "\n" + "8. Add" + "\n" + "9. Remove" + "\n" + "10. Conclude" + "\n";
        mainMenu += "After selecting one the options above, you will be presented other screens." + "\n";
        mainMenu += "If you press 0, you will be able to return to this main menu." + "\n";
        mainMenu += "Press -1 (or ctrl+c) to quit this application." + "\n";
        System.out.println(mainMenu);
    }


    /**
     * This method shows the list of bookable rooms.
     */
    public void listBookableRooms() {
        String listBookableRoomsString = "University of Knowledge - COVID test";
        listBookableRoomsString = listBookableRoomsString + "\n" + "\n" + "List of Bookable Rooms:\n";
        int a = 10;
        for (int i = 0; i < bookableRooms.size(); i++) {
            a++;
            listBookableRoomsString += a + "." + this.bookableRooms.get(i).printBookableRoomTemplate() + "\n";
        }
        listBookableRoomsString += "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
        System.out.println(listBookableRoomsString);
    }

    /**
     * Adds bookable room to the list of bookable rooms.
     *
     * @param date String representing date of bookable room.
     * @param time String representing time of bookable room.
     * @param room room associated with the bookable room.
     */
    public void addBookableRoom(String date, String time, Room room) {
        BookableRoom bookableRoom1 = new BookableRoom(room, 0, "EMPTY", date, time);
        bookableRooms.add(bookableRoom1);
        System.out.println(bookableRoom1.addedBookableRoomString());
    }

    /**
     * Method for removing a bookable room if input from user for removing bookable room is valid.
     * Also prints information following the removal of the bookable room.
     *
     * @param bookableRoom bookable room that is being removed.
     */
    public void removeBookableRoom(BookableRoom bookableRoom){
        BookableRoom bookableRoom1 = bookableRoom;
        bookableRooms.remove(bookableRoom);
        String latestRemovedBookableRoomString = "Bookable Room removed successfully:\n";
        latestRemovedBookableRoomString += bookableRoom1.printBookableRoomTemplate();
        latestRemovedBookableRoomString += "\nPlease, enter one of the following:\n\n";
        latestRemovedBookableRoomString += "The sequential ID to select the bookable room to be removed.\n";
        latestRemovedBookableRoomString += "0. Back to main menu.\n-1. Quit application.\n";
        clearTerminal();
        removeBookableRoomsString();
        System.out.println(latestRemovedBookableRoomString);
    }

    /**
     * Remove bookable room error string string.
     *
     * @return String for invalid input for removing bookable room.
     */
    public String removeBookableRoomErrorString(){
        String removeBookableRoomErrorString = "Error!\nInvalid sequential ID.\n";
        removeBookableRoomErrorString += "Please, enter one of the following:\n\n";
        removeBookableRoomErrorString += "The sequential ID to select the bookable room to be removed.\n";
        removeBookableRoomErrorString += "0. Back to main menu.\n -1. Quit application.\n";
        return removeBookableRoomErrorString;
    }

    /**
     * Prints String containing information for removal on bookable room.
     */
    public void removeBookableRoomsString() {
        String removeBookableRoomsString = "University of Knowledge - COVID test\n\n" + "List of Empty Bookable Rooms:\n";
        int a = 10;
        for (int i = 0; i < bookableRooms.size(); i++) {
            if (bookableRooms.get(i).getBookableRoomStatus().equals("EMPTY")) {
                a++;
                removeBookableRoomsString += a + "." + this.bookableRooms.get(i).printBookableRoomTemplate() + "\n";
            }
        }
        removeBookableRoomsString += "Removing bookable room\n\n" + "Please, enter one of the following:\n\n";
        removeBookableRoomsString += "The sequential ID to select the bookable room to be removed.\n";
        removeBookableRoomsString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        System.out.println(removeBookableRoomsString);
    }

    /**
     * Shows list of assistants on shift to user.
     */
    public void listAssistantsOnShift() {
        String listAssistantsOnShiftString = "University of Knowledge - COVID test\n\n" + "List of Assistant on Shifts:\n";
        int a = 10;
        for (int i = 0; i < assistantsOnShift.size(); i++) {
            a++;
            listAssistantsOnShiftString += a + "." + this.assistantsOnShift.get(i).printAssistantOnShiftTemplate() + "\n";
        }
        listAssistantsOnShiftString += "\n" + "0. Back to main menu." + "\n" + "-1. Quit application." + "\n";
        System.out.println(listAssistantsOnShiftString);
    }

    /**
     * Method for adding assistant on shift after valid input.
     *
     * @param assistant assistant for assistant on shift.
     * @param date      date of assistant on shift.
     */
    public void addAssistantOnShift(Assistant assistant, String date) {
        AssistantOnShift assistantOnShift1 = new AssistantOnShift(assistant, date, "FREE", "07:00");
        AssistantOnShift assistantOnShift2 = new AssistantOnShift(assistant, date, "FREE", "08:00");
        AssistantOnShift assistantOnShift3 = new AssistantOnShift(assistant, date, "FREE", "09:00");
        assistantsOnShift.add(assistantOnShift1);
        assistantsOnShift.add(assistantOnShift2);
        assistantsOnShift.add(assistantOnShift3);
        String addedAssistantOnShiftString = "Assistant on Shift added successfully:\n";
        addedAssistantOnShiftString += assistantOnShift1.printAssistantOnShiftTemplate() + "\n";
        addedAssistantOnShiftString += assistantOnShift2.printAssistantOnShiftTemplate() + "\n" + assistantOnShift3.printAssistantOnShiftTemplate();
        addedAssistantOnShiftString += "\nPlease, enter one of the following:\n\n";
        addedAssistantOnShiftString += "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.\n";
        addedAssistantOnShiftString += "0. Back to main menu.\n-1. Quit application.\n";
        System.out.println(addedAssistantOnShiftString);
    }

    /**
     * Method for removing assistant on shift after valid input.
     *
     * @param assistantOnShift assistant on shift that is removed.
     */
    public void removeAssistantOnShift(AssistantOnShift assistantOnShift){
        AssistantOnShift assistantOnShift1 = assistantOnShift;
        assistantsOnShift.remove(assistantOnShift);
        String latestRemovedAssistantOnShiftString = "Assistant on Shift removed successfully:\n\n";
        latestRemovedAssistantOnShiftString += assistantOnShift1.printAssistantOnShiftTemplate();
        latestRemovedAssistantOnShiftString += "\nPlease, enter one of the following:\n\n";
        latestRemovedAssistantOnShiftString += "The sequential ID to select the assistant on shift to be removed.\n\n";
        latestRemovedAssistantOnShiftString += "0. Back to main menu.\n-1. Quit application.\n";
        clearTerminal();
        System.out.println(removeAssistantsOnShiftString());
        System.out.println(latestRemovedAssistantOnShiftString);
    }

    /**
     * Remove assistant on shift error string string.
     *
     * @return String for invalid input for removing assistant on shift.
     */
    public String removeAssistantOnShiftErrorString() {
        String removeAssistantOnShiftErrorString = "Error!\nInvalid sequential ID.\n";
        removeAssistantOnShiftErrorString += "Please, enter one of the following:\n\n";
        removeAssistantOnShiftErrorString += "The sequential ID to select the assistant on shift to be removed.\n\n";
        removeAssistantOnShiftErrorString += "0. Back to main menu.\n -1. Quit application.\n";
        return removeAssistantOnShiftErrorString;
    }


    /**
     * Remove assistants on shift string string.
     *
     * @return String containing information for removal of assistant on shift.
     */
    public String removeAssistantsOnShiftString() {
        String removeAssistantsOnShiftString = "University of Knowledge - COVID test\n\n" + "List of Free Assistant on Shifts:\n";
        int a = 10;
        for (int i = 0; i < assistantsOnShift.size(); i++) {
            if (assistantsOnShift.get(i).getAssistantOnShiftStatus().equals("FREE")) {
                a++;
                removeAssistantsOnShiftString = removeAssistantsOnShiftString + a + "." + this.assistantsOnShift.get(i).printAssistantOnShiftTemplate() + "\n";
            }
        }
        removeAssistantsOnShiftString += "Removing assistant on shift\n\n" + "Please, enter one of the following:\n\n";
        removeAssistantsOnShiftString += "The sequential ID to select the assistant on shift to be removed.\n";
        removeAssistantsOnShiftString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return removeAssistantsOnShiftString;
    }

    /**
     * Shows information for accessing list of bookings to user.
     */
    public void listBookings() {
        String listBookingsString = "University of Knowledge - COVID test\n\n";
        listBookingsString += "Select which booking to list:\n";
        listBookingsString += "1. All\n" + "2. Only bookings status:SCHEDULED\n" + "3. Only bookings status:COMPLETED\n";
        listBookingsString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        System.out.println(listBookingsString);
    }

    /**
     * Shows list of all bookings to user.
     */
    public void listAllBookings() {
        String listAllBookings = "List of ALL Bookings:\n";
        for (int i = 0; i < bookings.size(); i++) {
            listAllBookings += this.bookings.get(i).printBookingTemplate() + "\n";
        }
        listAllBookings += "0. Back to main menu.\n" + "-1. Quit application.\n";
        System.out.println(listAllBookings);
    }

    /**
     * Shows list of scheduled bookings.
     */
    public void listScheduledBookings() {
        String listScheduledBookings = "List of SCHEDULED Bookings:\n";
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingStatus().equals("SCHEDULED")) {
                listScheduledBookings += this.bookings.get(i).printBookingTemplate() + "\n";
            }
        }
        listScheduledBookings += "0. Back to main menu.\n" + "-1. Quit application.\n";
        System.out.println(listScheduledBookings);
    }

    /**
     * Shows list of completed bookings.
     */
    public void listCompletedBookings() {
        String listCompletedBookings = "List of COMPLETED Bookings:\n";
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingStatus().equals("COMPLETED")) {
                listCompletedBookings += this.bookings.get(i).printBookingTemplate() + "\n";
            }
        }
        listCompletedBookings += "0. Back to main menu.\n" + "-1. Quit application.\n";
        System.out.println(listCompletedBookings);
    }

    /**
     * Here, a list of available dates and times are made using list of bookable rooms and list of assistants on shift.
     * List of dates and times are made from free assistant on shifts and empty or available bookable rooms.
     *
     * @return String with list of available dates and times for bookings.
     */
    public String addBookingString() {
        ArrayList<BookableRoom> matchedDateTimes = new ArrayList<>();
        for (int i = 0; i < bookableRooms.size(); i++) {
            if (!bookableRooms.get(i).getBookableRoomStatus().equals("FULL")) {
                for (int j = 0; j < assistantsOnShift.size(); j++) {
                    if (assistantsOnShift.get(j).getAssistantOnShiftStatus().equals("FREE")) {
                        if (bookableRooms.get(i).getBookableRoomTimeSlot().equals(assistantsOnShift.get(j).getAssistantOnShiftTimeSlot())
                                && bookableRooms.get(i).getBookableRoomDate().equals(assistantsOnShift.get(j).getAssistantOnShiftDate())) {
                            BookableRoom bookableRoom1 = new BookableRoom(bookableRooms.get(i).getBookableRoomDate(), bookableRooms.get(i).getBookableRoomTimeSlot());
                            matchedDateTimes.add(bookableRoom1);
                        }
                    }
                }   // above, list containing matching dates and timeslots are made using free assistants of shift and empty or available bookable rooms.
            }
        }

        String addBookingString = "University of Knowledge - COVID test\n\nAdding booking (appointment for a COVID test) to the system\n\n";
        addBookingString += "List of available time-slots:\n";
        int a = 10;
        int n = matchedDateTimes.size();
        BookableRoom temp = new BookableRoom(null, null);
        for (int i = 0; i < chronologicalOrder(matchedDateTimes, temp).size(); i++) {       // In this line, function for sorting list of dates and times in chronological order is called.
            a++;
            addBookingString += a + "." + matchedDateTimes.get(i).printDateTimeTemplate() + "\n";
        }
        addBookingString += "\nPlease, enter one of the following:\n";
        addBookingString += "The sequential ID of an available time-slot and the student email, separated by a white space.\n";
        addBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookingString;
    }


    /**
     * Add booking string 2 string.
     *
     * @return same string as above without the title in string.
     */
    public String addBookingString2() {
        ArrayList<BookableRoom> matchedDateTimes = new ArrayList<>();
        for (int i = 0; i < bookableRooms.size(); i++) {
            if (!bookableRooms.get(i).getBookableRoomStatus().equals("FULL")) {
                for (int j = 0; j < assistantsOnShift.size(); j++) {
                    if (assistantsOnShift.get(j).getAssistantOnShiftStatus().equals("FREE")) {
                        if (bookableRooms.get(i).getBookableRoomTimeSlot().equals(assistantsOnShift.get(j).getAssistantOnShiftTimeSlot())
                                && bookableRooms.get(i).getBookableRoomDate().equals(assistantsOnShift.get(j).getAssistantOnShiftDate())) {
                            BookableRoom bookableRoom1 = new BookableRoom(bookableRooms.get(i).getBookableRoomDate(), bookableRooms.get(i).getBookableRoomTimeSlot());
                            matchedDateTimes.add(bookableRoom1);
                        }
                    }
                }
            }
        }
        String addBookingString = "List of available time-slots:\n";
        int a = 10;
        BookableRoom temp = new BookableRoom(null, null);
        for (int i = 0; i < matchedDateTimes.size(); i++) {
            a++;
            addBookingString += a + "." + chronologicalOrder(matchedDateTimes, temp).get(i).printDateTimeTemplate() + "\n";
        }
        addBookingString += "\nPlease, enter one of the following:\n";
        addBookingString += "The sequential ID of an available time-slot and the student email, separated by a white space.\n";
        addBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";

        return addBookingString;
    }

    /**
     * Method for sorting list of matching dates and times in chronological order.
     *
     * @param matchedDateTimes list of matching dates and times of free assistant on shifts and empty or available bookable rooms.
     * @param temp             temporary date and time needed for the method.
     * @return matched dates and times in chronological order.
     */
    public ArrayList<BookableRoom> chronologicalOrder(ArrayList<BookableRoom> matchedDateTimes, BookableRoom temp) {
        int n = matchedDateTimes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (matchedDateTimes.get(j).getBookableRoomDate().equals(matchedDateTimes.get(j + 1).getBookableRoomDate()) && Integer.parseInt(matchedDateTimes.get(j).getBookableRoomTimeSlot().substring(0, 1)) > Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomTimeSlot().substring(0, 1))) {
                    temp.setBookableRoomTimeSlot(matchedDateTimes.get(j).getBookableRoomTimeSlot());
                    temp.setBookableRoomDate(matchedDateTimes.get(j).getBookableRoomDate());
                    matchedDateTimes.get(j).setBookableRoomDate(matchedDateTimes.get(j + 1).getBookableRoomDate());
                    matchedDateTimes.get(j).setBookableRoomTimeSlot(matchedDateTimes.get(j + 1).getBookableRoomTimeSlot());
                    matchedDateTimes.get(j + 1).setBookableRoomDate(temp.getBookableRoomDate());
                    matchedDateTimes.get(j + 1).setBookableRoomTimeSlot(temp.getBookableRoomTimeSlot());

                } else if (Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(6, 10)) > Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(6, 10))) {
                    temp.setBookableRoomTimeSlot(matchedDateTimes.get(j).getBookableRoomTimeSlot());
                    temp.setBookableRoomDate(matchedDateTimes.get(j).getBookableRoomDate());
                    matchedDateTimes.get(j).setBookableRoomDate(matchedDateTimes.get(j + 1).getBookableRoomDate());
                    matchedDateTimes.get(j).setBookableRoomTimeSlot(matchedDateTimes.get(j + 1).getBookableRoomTimeSlot());
                    matchedDateTimes.get(j + 1).setBookableRoomDate(temp.getBookableRoomDate());
                    matchedDateTimes.get(j + 1).setBookableRoomTimeSlot(temp.getBookableRoomTimeSlot());

                } else if (Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(6, 10)) == Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(6, 10)) &&
                        Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(3, 5)) == Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(3, 5))) {
                    if (Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(0, 2)) > Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(0, 2))) {
                        temp.setBookableRoomTimeSlot(matchedDateTimes.get(j).getBookableRoomTimeSlot());
                        temp.setBookableRoomDate(matchedDateTimes.get(j).getBookableRoomDate());
                        matchedDateTimes.get(j).setBookableRoomDate(matchedDateTimes.get(j + 1).getBookableRoomDate());
                        matchedDateTimes.get(j).setBookableRoomTimeSlot(matchedDateTimes.get(j + 1).getBookableRoomTimeSlot());
                        matchedDateTimes.get(j + 1).setBookableRoomDate(temp.getBookableRoomDate());
                        matchedDateTimes.get(j + 1).setBookableRoomTimeSlot(temp.getBookableRoomTimeSlot());
                    }
                } else if (Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(6, 10)) == Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(6, 10))) {
                    if (Integer.parseInt(matchedDateTimes.get(j).getBookableRoomDate().substring(3, 5)) > Integer.parseInt(matchedDateTimes.get(j + 1).getBookableRoomDate().substring(3, 5))) {
                        temp.setBookableRoomTimeSlot(matchedDateTimes.get(j).getBookableRoomTimeSlot());
                        temp.setBookableRoomDate(matchedDateTimes.get(j).getBookableRoomDate());
                        matchedDateTimes.get(j).setBookableRoomDate(matchedDateTimes.get(j + 1).getBookableRoomDate());
                        matchedDateTimes.get(j).setBookableRoomTimeSlot(matchedDateTimes.get(j + 1).getBookableRoomTimeSlot());
                        matchedDateTimes.get(j + 1).setBookableRoomDate(temp.getBookableRoomDate());
                        matchedDateTimes.get(j + 1).setBookableRoomTimeSlot(temp.getBookableRoomTimeSlot());
                    }
                }
            }
        }
        return matchedDateTimes;


    }

    /**
     * Adding booking after valid inputs.
     *
     * @param booking1     booking that is added to list of bookings.
     * @param studentEmail student email needed for the booking.
     */
    public void addBooking(Booking booking1, String studentEmail){
        booking1.setBookingStatus("SCHEDULED");
        booking1.setStudentEmail(studentEmail);
        bookings.add(booking1);
        String successfulBookingString = "Booking added successfully:\n";
        successfulBookingString += booking1.printBookingTemplate() + "\n\n";
        successfulBookingString += addBookingString2();
        System.out.println(successfulBookingString);

    }


    /**
     * Add booking error string string.
     *
     * @return String for invalid input when adding booking.
     */
    public String addBookingErrorString() {
        String addBookingString = "Error!\n";
        addBookingString += "The sequential ID provided does not match a sequential ID in the list.";
        addBookingString += "\nPlease, enter one of the following:\n";
        addBookingString += "The sequential ID of an available time-slot and the student email, separated by a white space.\n";
        addBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";

        return addBookingString;
    }

    /**
     * Add booking invalid length string string.
     *
     * @return String for invalid input when adding booking.
     */
    public String addBookingInvalidLengthString() {
        String addBookingString = "Error!\n";
        addBookingString += "Invalid amount of inputs.";
        addBookingString += "\nPlease, enter one of the following:\n";
        addBookingString += "The sequential ID of an available time-slot and the student email, separated by a white space.\n";
        addBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";

        return addBookingString;
    }

    /**
     * Add booking invalid email string string.
     *
     * @return String for invalid input when adding booking.
     */
    public String addBookingInvalidEmailString() {
        String addBookingString = "Error!\n";
        addBookingString += "The email provided is not appropriate.";
        addBookingString += "\nPlease, enter one of the following:\n";
        addBookingString += "The sequential ID of an available time-slot and the student email, separated by a white space.\n";
        addBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";

        return addBookingString;
    }

    /**
     * Removing a booking.
     *
     * @param booking booking that is removed from list of bookings after valid input from user.
     */
    public void removeBooking(Booking booking){
        Booking booking1 = booking;
        bookings.remove(booking);
        String latestRemovedBookingString = "Booking removed successfully:\n\n";
        latestRemovedBookingString += booking1.printBookingTemplate();
        latestRemovedBookingString += "\nPlease, enter one of the following:\n\n";
        latestRemovedBookingString += "The sequential ID to select the booking to be removed from the listed bookings above.\n\n";
        latestRemovedBookingString += "0. Back to main menu.\n-1. Quit application.\n";
        clearTerminal();
        System.out.println(removeAssistantsOnShiftString());
        System.out.println(latestRemovedBookingString);
    }

    /**
     * String contains list of scheduled bookings.
     *
     * @return String with information about removal of a booking.
     */
    public String removeBookingString() {
        String removeBookingString = "University of Knowledge - COVID test\n\n" + "List of SCHEDULED Bookings:\n";
        int a = 10;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingStatus().equals("SCHEDULED")) {
                a++;
                removeBookingString += a + "." + this.bookings.get(i).printBookingTemplate() + "\n";
            }
        }
        removeBookingString = removeBookingString + "Removing booking from the system\n\n" + "Please, enter one of the following:\n\n";
        removeBookingString = removeBookingString + "The sequential ID to select the booking to be removed from the listed bookings above.\n";
        removeBookingString = removeBookingString + "0. Back to main menu.\n" + "-1. Quit application.\n";
        return removeBookingString;
    }

    /**
     * Remove booking error string string.
     *
     * @return String for invalid input when removing booking.
     */
    public String removeBookingErrorString() {
        String error = "Error!\nThe sequential ID provided does not match a sequential ID in the list.\nPlease, enter one of the following:\n\n";
        error += "The sequential ID to select the booking to be removed from the listed bookings above\n";
        error += "0. Back to main menu.\n-1. Quit application.\n";
        return error;

    }

    /**
     * Remove booking invalid length string.
     *
     * @return String for invalid input when removing booking.
     */
    public String removeBookingInvalidLength() {
        String error = "Error!\nAmount of inputs is invalid.\nPlease, enter one of the following:\n\n";
        error += "The sequential ID to select the booking to be removed from the listed bookings above\n";
        error += "0. Back to main menu.\n-1. Quit application.\n";
        return error;

    }

    /**
     * Method for concluding a booking.
     *
     * @param booking booking that will be completed.
     */
    public void concludeBooking(Booking booking){
        booking.setBookingStatus("COMPLETED");
        Booking booking1 = booking;
        String latestCompletedBookingString = "Booking completed successfully:\n\n";
        latestCompletedBookingString += booking1.printBookingTemplate();
        latestCompletedBookingString += "\nPlease, enter one of the following:\n\n";
        latestCompletedBookingString += "The sequential ID to select the booking to be completed.\n\n";
        latestCompletedBookingString += "0. Back to main menu.\n-1. Quit application.\n";
        clearTerminal();
        System.out.println(concludeBookingString());
        System.out.println(latestCompletedBookingString);
    }


    /**
     * Conclude booking string string.
     *
     * @return String with information for concluding a booking.
     */
    public String concludeBookingString() {
        String concludeBookingString = "University of Knowledge - COVID test\n\n" + "List of SCHEDULED Bookings:\n";
        int a = 10;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getBookingStatus().equals("SCHEDULED")) {
                a++;
                concludeBookingString += a + "." + this.bookings.get(i).printBookingTemplate() + "\n";
            }
        }
        concludeBookingString += "Conclude booking\n\n" + "Please, enter one of the following:\n\n";
        concludeBookingString += "The sequential ID to select the booking to be completed.\n\n";
        concludeBookingString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return concludeBookingString;
    }

    /**
     * Conclude booking error string string.
     *
     * @return String for invalid input from user when concluding booking.
     */
    public String concludeBookingErrorString() {
        String error = "Error!\nThe sequential ID provided does not match a sequential ID in the list.\nPlease, enter one of the following:\n\n";
        error += "The sequential ID to select the booking to be completed.";
        error += "0. Back to main menu.\\n\" + \"-1. Quit application.\n";
        return error;
    }

    /**
     * Conclude booking invalid length string.
     *
     * @return String for invalid input from user when concluding booking.
     */
    public String concludeBookingInvalidLength() {
        String error = "Error!\nInvalid amount of inputs.\nPlease, enter one of the following:\n\n";
        error += "The sequential ID to select the booking to be completed.";
        error += "0. Back to main menu.\\n\" + \"-1. Quit application.\n";
        return error;
    }

    /**
     * Method for clearing the terminal.
     */
    public final void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException e) {}

    }
}





