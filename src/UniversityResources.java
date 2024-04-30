/**
 * The type University resources.
 */
public class UniversityResources {

    private Assistant[] assistants;

    private Room[] rooms;

    /**
     * Constructor to instantiate university resources.
     *
     * @param assistants list of assistants.
     * @param rooms      list of rooms.
     */
    public UniversityResources(Assistant[] assistants, Room[] rooms) {
        this.assistants = assistants;
        this.rooms = rooms;
    }

    /**
     * getter for rooms.
     *
     * @return list of rooms.
     */
    public Room[] getRooms(){
        return rooms;
    }

    /**
     * getter for assistants.
     *
     * @return list of assistants.
     */
    public Assistant[] getAssistants(){
        return assistants;
    }

    /**
     * String containing details of rooms.
     *
     * @return String with information needed for adding bookable room to system.
     */
    public String addBookableRoomsString() {
        String addBookableRoomsString = "University of Knowledge - COVID test";
        addBookableRoomsString += "\n\n" + "Adding bookable room" + "\n\n" + "List of Rooms:\n";
        int a = 10;
        for (int i = 0; i < rooms.length; i++) {
            a++;
            addBookableRoomsString += a + "." + this.rooms[i].printRoomTemplate() + "\n";
        }
        addBookableRoomsString += "Please, enter one of the following:\n\n";
        addBookableRoomsString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\n" + "separated by a white space.\n";
        addBookableRoomsString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookableRoomsString;
    }

    /**
     * Add bookable room invalid length string string.
     *
     * @return String displayed if input for adding bookable room is invalid.
     */
    public String addBookableRoomInvalidLengthString() {
        String addBookableRoomInvalidLengthString = "Error!\nAmount of inputs is invalid.\nPlease, enter one of the following:\n\n";
        addBookableRoomInvalidLengthString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), \nseparated by a white space.\n";
        addBookableRoomInvalidLengthString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookableRoomInvalidLengthString;
    }

    /**
     * Add bookable room invalid id string string.
     *
     * @return String displayed if input for adding bookable room is invalid.
     */
    public String addBookableRoomInvalidIDString() {
        String addBookableRoomInvalidLengthString = "Error!\nInvalid sequential ID.\nPlease, enter one of the following:\n\n";
        addBookableRoomInvalidLengthString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), \nseparated by a white space.\n";
        addBookableRoomInvalidLengthString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookableRoomInvalidLengthString;
    }

    /**
     * Add bookable room invalid date string string.
     *
     * @return String displayed if input for adding bookable room is invalid.
     */
    public String addBookableRoomInvalidDateString(){
        String addBookableRoomInvalidDateString = "Error!\nInvalid Date input.\nPlease, enter one of the following:\n\n";
        addBookableRoomInvalidDateString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), \nseparated by a white space.\n";
        addBookableRoomInvalidDateString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookableRoomInvalidDateString;
    }

    /**
     * Add bookable room invalid time string string.
     *
     * @return String displayed if input for adding bookable room is invalid.
     */
    public String addBookableRoomInvalidTimeString() {
        String addBookableRoomInvalidTimeString = "Error!\nInvalid Time input.\nPlease, enter one of the following:\n\n";
        addBookableRoomInvalidTimeString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), \nseparated by a white space.\n";
        addBookableRoomInvalidTimeString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addBookableRoomInvalidTimeString;
    }

    /**
     * Bookable room already exists string string.
     *
     * @return String displayed if bookable room for the chosen room already exists for the chosen date and time.
     */
    public String bookableRoomAlreadyExistsString() {
        String bookableRoomAlreadyExistsString = "Error!\nBookable room already exists.\nPlease, enter one of the following:\n\n";
        bookableRoomAlreadyExistsString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), \nseparated by a white space.\n";
        bookableRoomAlreadyExistsString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return bookableRoomAlreadyExistsString;
    }

    /**
     * Assistant on shift already exists string string.
     *
     * @return String displayed if assistant on shift for chosen assistant already exists for the chosen date.
     */
    public String assistantOnShiftAlreadyExistsString() {
        String assistantOnShiftAlreadyExistsString = "Error!\nAssistant already has a shift in that day.\nPlease, enter one of the following:\n\n";
        assistantOnShiftAlreadyExistsString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\nseparated by a white space.\n";
        assistantOnShiftAlreadyExistsString += "0. Back to main menu.\n-1. Quit application.\n";
        return assistantOnShiftAlreadyExistsString;
    }

    /**
     * Add assistant on shift invalid id string string.
     *
     * @return String displayed if input for adding assistant on shit is invalid.
     */
    public String addAssistantOnShiftInvalidIDString(){
        String addAssistantOnShiftInvalidIDString = "Error!\nInvalid sequential ID.\nPlease, enter one of the following:\n\n";
        addAssistantOnShiftInvalidIDString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\nseparated by a white space.\n";
        addAssistantOnShiftInvalidIDString += "0. Back to main menu.\n-1. Quit application.\n";
        return addAssistantOnShiftInvalidIDString;
    }

    /**
     * Add assistant on shift invalid length string string.
     *
     * @return String displayed if input for adding assistant on shit is invalid.
     */
    public String addAssistantOnShiftInvalidLengthString(){
        String addAssistantOnShiftInvalidLengthString = "Error!\nAmount of inputs is invalid.\nPlease, enter one of the following:\n\n";
        addAssistantOnShiftInvalidLengthString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\nseparated by a white space.\n";
        addAssistantOnShiftInvalidLengthString += "0. Back to main menu.\n-1. Quit application.\n";
        return addAssistantOnShiftInvalidLengthString;
    }

    /**
     * Add assistant on shift invalid date string string.
     *
     * @return String displayed if input for adding assistant on shit is invalid.
     */
    public String addAssistantOnShiftInvalidDateString(){
        String addAssistantOnShiftInvalidDateString = "Error!\nInvalid Date input.\nPlease, enter one of the following:\n\n";
        addAssistantOnShiftInvalidDateString += "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\nseparated by a white space.\n";
        addAssistantOnShiftInvalidDateString += "0. Back to main menu.\n-1. Quit application.\n";
        return addAssistantOnShiftInvalidDateString;
    }

    /**
     * Add assistants on shift string.
     *
     * @return String with information for adding assistant on shift.
     */
    public String addAssistantsOnShift() {
        String addAssistantsOnShiftString = "University of Knowledge - COVID test";
        addAssistantsOnShiftString += "\n\n" + "List of Assistants:\n";
        int a = 10;
        for (int i = 0; i < assistants.length; i++) {
            a++;
            addAssistantsOnShiftString += a + "." + this.assistants[i].printAssistantTemplate() + "\n";
        }
        addAssistantsOnShiftString += "Please, enter one of the following:\n\n";
        addAssistantsOnShiftString += "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.\n";
        addAssistantsOnShiftString += "0. Back to main menu.\n" + "-1. Quit application.\n";
        return addAssistantsOnShiftString;
    }


}