import java.util.Scanner;
import java.util.ArrayList;

/**
 * BookingApp
 *
 * @author Jason Gurung 25/02/2021
 */
public class BookingApp {

    /**
     * The Booking system.
     */
    public BookingSystem bookingSystem;
    /**
     * The University resources.
     */
    public UniversityResources universityResources;

    /**
     * Checks input from user to display the screen they want to see.
     */
    public void mainMenuInput() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        switch (input) {
            case "-1":
                System.exit(0);
                break;
            case "0":
                bookingSystem.clearTerminal(); // clear terminal
                bookingSystem.loadMainMenu();
                mainMenuInput(); // calls input checker.
                break;
            case "1":
                bookingSystem.clearTerminal();
                bookingSystem.listBookableRooms();
                listBookableRoomsInput();
                break;
            case "2":
                bookingSystem.clearTerminal();
                System.out.println(universityResources.addBookableRoomsString());
                addBookableRoomsInput();
                break;
            case "3":
                bookingSystem.clearTerminal();
                bookingSystem.removeBookableRoomsString();
                removeBookableRoomsInput();
                break;
            case "4":
                bookingSystem.clearTerminal();
                bookingSystem.listAssistantsOnShift();
                listAssistantsOnShiftInput();
                break;
            case "5":
                bookingSystem.clearTerminal();
                System.out.println(universityResources.addAssistantsOnShift());
                addAssistantsOnShiftInput();
                break;
            case "6":
                bookingSystem.clearTerminal();
                System.out.println(bookingSystem.removeAssistantsOnShiftString());
                removeAssistantsOnShiftInput();
                break;
            case "7":
                bookingSystem.clearTerminal();
                bookingSystem.listBookings();
                listBookingsInput();
                break;
            case "8":
                bookingSystem.clearTerminal();
                System.out.println(bookingSystem.addBookingString());
                addBookingInput();
                break;
            case "9":
                bookingSystem.clearTerminal();
                System.out.println(bookingSystem.removeBookingString());
                removeBookingInput();
                break;
            case "10":
                bookingSystem.clearTerminal();
                System.out.println(bookingSystem.concludeBookingString());
                concludeBookingInput();
            default:
                System.out.println("Invalid input.");
                mainMenuInput();
        }
        // Above, these are different cases depending on the number user inputs.
        in.close();
    }

    /**
     * Checks input for list bookable rooms to output the option they choose.
     */
    public void listBookableRoomsInput() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        switch (input) {
            case "0":
                bookingSystem.clearTerminal();
                bookingSystem.loadMainMenu();
                mainMenuInput();
                break;
            case "-1":
                System.exit(0);
                break;
            default:
                System.out.println(" Invalid input.");
                listBookableRoomsInput();
        }
        in.close();
    }

    /**
     * Checks input for adding bookable room.
     */
    public void addBookableRoomsInput() {
        Scanner scan = new Scanner(System.in);
        String addBookableRoomInput = scan.nextLine();
        String[] inputs = addBookableRoomInput.split(" "); // stores inputs separated by white space in an array.
        if (addBookableRoomInput.equals("0")) {
            bookingSystem.clearTerminal();
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (addBookableRoomInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 3) {
            String iD = inputs[0];
            String date = inputs[1]; // inputs assigned to variables.
            String time = inputs[2];
            try {
                if (Integer.parseInt(iD) > 10 && Integer.parseInt(iD) <= (universityResources.getRooms().length + 10)) { // Checks
                                                                                                                         // if
                                                                                                                         // the
                                                                                                                         // ID
                                                                                                                         // entered
                                                                                                                         // by
                                                                                                                         // user
                                                                                                                         // is
                                                                                                                         // valid.
                    if (bookingSystem.checkDateValidity(date)) {
                        if (bookingSystem.checkTimeValidity(time)) {
                            boolean bookableRoomAlreadyExists = false;
                            Room room1 = universityResources.getRooms()[Integer.parseInt(iD) - 11];
                            for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
                                if (bookingSystem.getBookableRooms().get(i).getRoom().equals(room1)) {
                                    if (bookingSystem.getBookableRooms().get(i).getBookableRoomDate().equals(date)) {
                                        if (bookingSystem.getBookableRooms().get(i).getBookableRoomTimeSlot()
                                                .equals(time)) { // if date and time matches a bookable room with same
                                                                 // room then bookable room already exists for that date
                                                                 // and time.
                                            bookableRoomAlreadyExists = true;
                                            System.out.println(universityResources.bookableRoomAlreadyExistsString());
                                            addBookableRoomsInput();
                                        }
                                    }
                                }
                            }
                            if (!bookableRoomAlreadyExists) {
                                bookingSystem.addBookableRoom(date, time, room1); // Adds bookable room if bookable room
                                                                                  // doesn't already exist.
                                addBookableRoomsInput();
                            }

                        } else {
                            System.out.println(universityResources.addBookableRoomInvalidTimeString());
                            addBookableRoomsInput();
                        }

                    } else {
                        System.out.println(universityResources.addBookableRoomInvalidDateString());
                        addBookableRoomsInput();
                    }
                } else {
                    System.out.println(universityResources.addBookableRoomInvalidIDString()); // Strings for invalid
                                                                                              // inputs.
                    addBookableRoomsInput();
                }
            } catch (NumberFormatException e) {
                System.out.println(universityResources.addBookableRoomInvalidIDString());
                addBookableRoomsInput();
            }
        } else {
            System.out.println(universityResources.addBookableRoomInvalidLengthString());
            addBookableRoomsInput();
        }
        scan.close();

    }

    /**
     * Checks input for removing bookable room.
     */
    public void removeBookableRoomsInput() {
        Scanner scan = new Scanner(System.in);
        String removeBookableRoomInput = scan.nextLine();
        String[] inputs = removeBookableRoomInput.split(" ");
        if (removeBookableRoomInput.equals("0")) {
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (removeBookableRoomInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 1) { // Checks amount of inputs from user separated by white space.
            String iD = inputs[0];
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
                if (bookingSystem.getBookableRooms().get(i).getBookableRoomStatus().equals("EMPTY")) {
                    System.out.println("number = " + i);
                    numbers.add(i);
                }
            }
            try {
                if (Integer.parseInt(iD) > 10 && Integer.parseInt(iD) <= (numbers.size() + 10)) { // Checks ID entered
                                                                                                  // by user.
                    bookingSystem.removeBookableRoom(
                            bookingSystem.getBookableRooms().get(numbers.get(Integer.parseInt(iD) - 11)));
                } else {
                    System.out.println(bookingSystem.removeBookableRoomErrorString());
                }
                removeBookableRoomsInput();
            } catch (NumberFormatException e) { // Catch exception when ID is not entered in number format and therefore
                System.out.println(bookingSystem.removeBookableRoomErrorString());
                removeBookableRoomsInput();
            }
        } else {
            System.out.println(bookingSystem.removeBookableRoomErrorString());
            removeBookableRoomsInput();
        }
        scan.close();

    }

    /**
     * Checks input for list of assistants on shift.
     */
    public void listAssistantsOnShiftInput() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        switch (input) {
            case "0":
                bookingSystem.clearTerminal();
                bookingSystem.loadMainMenu();
                mainMenuInput();
                break;
            case "-1":
                System.exit(0);
                break;
            default:
                System.out.println(" Invalid input.");
                listAssistantsOnShiftInput();
        }
        in.close();
    }

    /**
     * Checks input for adding assistants on shift.
     */
    public void addAssistantsOnShiftInput() {
        Scanner scan = new Scanner(System.in);
        String addAssistantsOnShiftInput = scan.nextLine();
        String[] inputs = addAssistantsOnShiftInput.split(" ");
        if (addAssistantsOnShiftInput.equals("0")) {
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (addAssistantsOnShiftInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 2) {
            String iD = inputs[0];
            String date = inputs[1];
            try {
                if (Integer.parseInt(iD) > 10
                        && Integer.parseInt(iD) <= (universityResources.getAssistants().length + 10)) {
                    if (bookingSystem.checkDateValidity(date)) {
                        boolean assistantOnShiftAlreadyExists = false;
                        Assistant assistant1 = universityResources.getAssistants()[Integer.parseInt(iD) - 11];
                        for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
                            if (bookingSystem.getAssistantsOnShift().get(i).getAssistant().equals(assistant1)) {
                                if (bookingSystem.getAssistantsOnShift().get(i).getAssistantOnShiftDate()
                                        .equals(date)) { // Checks if assistant on shift with same date already exists.
                                    assistantOnShiftAlreadyExists = true;
                                    System.out.println(universityResources.assistantOnShiftAlreadyExistsString());
                                    addAssistantsOnShiftInput();
                                }
                            }
                        }
                        if (!assistantOnShiftAlreadyExists) {
                            bookingSystem.addAssistantOnShift(assistant1, date); // If assistant on shift already exists
                                                                                 // with same date then assistant on
                                                                                 // shift is not added to system.
                            addAssistantsOnShiftInput();
                        }
                    } else {
                        System.out.println(universityResources.addAssistantOnShiftInvalidDateString());
                        addAssistantsOnShiftInput();
                    }
                } else {
                    System.out.println(universityResources.addAssistantOnShiftInvalidIDString());
                    addAssistantsOnShiftInput();
                }

            } catch (NumberFormatException e) {
                System.out.println(universityResources.addAssistantOnShiftInvalidIDString());
                addAssistantsOnShiftInput();
            }

        } else {
            System.out.println(universityResources.addAssistantOnShiftInvalidLengthString());
            addAssistantsOnShiftInput();
        }
        scan.close();

    }

    /**
     * checks input for removing assistant on shift.
     */
    public void removeAssistantsOnShiftInput() {
        Scanner scan = new Scanner(System.in);
        String removeAssistantOnShiftInput = scan.nextLine();
        String[] inputs = removeAssistantOnShiftInput.split(" ");
        if (removeAssistantOnShiftInput.equals("0")) {
            bookingSystem.clearTerminal();
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (removeAssistantOnShiftInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 1) {
            String iD = inputs[0];
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
                if (bookingSystem.getAssistantsOnShift().get(i).getAssistantOnShiftStatus().equals("FREE")) {
                    numbers.add(i); // using array to get the assistant on shift chosen by user for it to be
                                    // removed.
                }
            }
            try {
                if (Integer.parseInt(iD) > 10 && Integer.parseInt(iD) <= (numbers.size() + 10)) {
                    bookingSystem.removeAssistantOnShift(
                            bookingSystem.getAssistantsOnShift().get(numbers.get(Integer.parseInt(iD) - 11)));

                } else {
                    System.out.println(bookingSystem.removeAssistantOnShiftErrorString());
                }
                removeAssistantsOnShiftInput();
            } catch (NumberFormatException e) {
                System.out.println(bookingSystem.removeAssistantOnShiftErrorString());
                removeAssistantsOnShiftInput();
            }
        } else {
            System.out.println(bookingSystem.removeAssistantOnShiftErrorString());
            removeAssistantsOnShiftInput();
        }
        scan.close();

    }

    /**
     * Checks input for list of bookings.
     */
    public void listBookingsScanner() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        switch (input) {
            case "0":
                bookingSystem.clearTerminal();
                bookingSystem.loadMainMenu();
                mainMenuInput();
                break;
            case "-1":
                System.exit(0);
                break;
            default:
                System.out.println(" Invalid input.");
                listBookingsScanner();
        }
        in.close();
    }

    /**
     * Checks input for list of bookings.
     */
    public void listBookingsInput() {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        switch (input) {
            case "0":
                bookingSystem.clearTerminal();
                bookingSystem.loadMainMenu();
                mainMenuInput();
                break;
            case "-1":
                System.exit(0);
                break;
            case "1":
                bookingSystem.listAllBookings();
                listBookingsScanner();
                break;
            case "2":
                bookingSystem.listScheduledBookings(); // Loading different cases for viewing bookings.
                listBookingsScanner();
                break;
            case "3":
                bookingSystem.listCompletedBookings();
                listBookingsScanner();
                break;
            default:
                System.out.println(" Invalid input.");
                bookingSystem.listAllBookings();
                listBookingsScanner();

        }
        in.close();

    }

    /**
     * Checks input for adding bookings.
     */
    public void addBookingInput() {
        Scanner scan = new Scanner(System.in);
        String addBookingInput = scan.nextLine();
        String[] inputs = addBookingInput.split(" ");
        if (addBookingInput.equals("0")) {
            bookingSystem.clearTerminal();
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (addBookingInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 2) {
            String iD = inputs[0];
            String studentEmail = inputs[1];

            ArrayList<BookableRoom> matchedDateTimes = new ArrayList<>();
            for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
                if (!bookingSystem.getBookableRooms().get(i).getBookableRoomStatus().equals("FULL")) {
                    for (int j = 0; j < bookingSystem.getAssistantsOnShift().size(); j++) {
                        if (bookingSystem.getAssistantsOnShift().get(j).getAssistantOnShiftStatus().equals("FREE")) {
                            if (bookingSystem.getBookableRooms().get(i).getBookableRoomTimeSlot()
                                    .equals(bookingSystem.getAssistantsOnShift().get(j).getAssistantOnShiftTimeSlot())
                                    && bookingSystem.getBookableRooms().get(i).getBookableRoomDate().equals(
                                            bookingSystem.getAssistantsOnShift().get(j).getAssistantOnShiftDate())) {
                                BookableRoom bookableRoom1 = new BookableRoom(
                                        bookingSystem.getBookableRooms().get(i).getBookableRoomDate(),
                                        bookingSystem.getBookableRooms().get(i).getBookableRoomTimeSlot());
                                matchedDateTimes.add(bookableRoom1);
                            }
                        }
                    }
                }
            }
            BookableRoom temp = new BookableRoom(null, null);
            try {
                if (Integer.parseInt(iD) > 10 && Integer
                        .parseInt(iD) <= (bookingSystem.chronologicalOrder(matchedDateTimes, temp).size() + 10)) {
                    if (studentEmail.endsWith("@uok.ac.uk")) { // Student email checker.
                        Booking booking1 = new Booking(null, null, null, null, null, null, null);
                        for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
                            AssistantOnShift assistantOnShift1 = bookingSystem.getAssistantsOnShift().get(i);
                            if (assistantOnShift1.getAssistantOnShiftDate()
                                    .equals(matchedDateTimes.get(Integer.parseInt(iD) - 11).getBookableRoomDate()) &&
                                    assistantOnShift1.getAssistantOnShiftTimeSlot().equals(matchedDateTimes
                                            .get(Integer.parseInt(iD) - 11).getBookableRoomTimeSlot())) {
                                bookingSystem.getAssistantsOnShift().get(i).setAssistantOnShiftStatus("BUSY");
                                booking1.setAssistantOnShift(bookingSystem.getAssistantsOnShift().get(i));
                                booking1.setBookingDate(
                                        bookingSystem.getAssistantsOnShift().get(i).getAssistantOnShiftDate());
                                booking1.setBookingTimeSlot(
                                        bookingSystem.getAssistantsOnShift().get(i).getAssistantOnShiftTimeSlot());
                            }
                        }
                        for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
                            BookableRoom bookableRoom1 = bookingSystem.getBookableRooms().get(i);
                            if (bookableRoom1.getBookableRoomDate()
                                    .equals(matchedDateTimes.get(Integer.parseInt(iD) - 11).getBookableRoomDate()) &&
                                    bookableRoom1.getBookableRoomTimeSlot().equals(matchedDateTimes
                                            .get(Integer.parseInt(iD) - 11).getBookableRoomTimeSlot())) {
                                bookingSystem.getBookableRooms().get(i)
                                        .setOccupancy(bookingSystem.getBookableRooms().get(i).getOccupancy() + 1);
                                if (bookingSystem.getBookableRooms().get(i).getOccupancy() == bookingSystem
                                        .getBookableRooms().get(i).getRoom().getCapacity()) {
                                    bookingSystem.getBookableRooms().get(i).setBookableRoomStatus("FULL");
                                    booking1.setBookableRoom(bookingSystem.getBookableRooms().get(i));
                                    booking1.setRoomCode(bookingSystem.getBookableRooms().get(i).getRoom().getCode());
                                } else if (bookingSystem.getBookableRooms().get(i).getOccupancy() < bookingSystem
                                        .getBookableRooms().get(i).getRoom().getCapacity()) {
                                    bookingSystem.getBookableRooms().get(i).setBookableRoomStatus("AVAILABLE");
                                    booking1.setBookableRoom(bookingSystem.getBookableRooms().get(i));
                                    booking1.setRoomCode(bookingSystem.getBookableRooms().get(i).getRoom().getCode()); // Using
                                                                                                                       // setters
                                                                                                                       // to
                                                                                                                       // set
                                                                                                                       // the
                                                                                                                       // details
                                                                                                                       // for
                                                                                                                       // booking
                                                                                                                       // before
                                                                                                                       // it
                                                                                                                       // is
                                                                                                                       // added
                                                                                                                       // using
                                                                                                                       // the
                                                                                                                       // method
                                                                                                                       // to
                                                                                                                       // add
                                                                                                                       // booking.
                                }
                            }
                        }
                        bookingSystem.addBooking(booking1, studentEmail); // The booking is used as parameter.
                    } else {
                        System.out.println(bookingSystem.addBookingInvalidEmailString());
                        addBookingInput();

                    }

                } else {
                    System.out.println(bookingSystem.addBookingErrorString());
                }
                addBookingInput();

            } catch (NumberFormatException e) {
                System.out.println(bookingSystem.addBookingErrorString());
                addBookingInput();
            }
        } else {
            System.out.println(bookingSystem.addBookingInvalidLengthString());
            addBookingInput();
        }
        scan.close();

    }

    /**
     * checks input for removing bookings.
     */
    public void removeBookingInput() {
        Scanner scan = new Scanner(System.in);
        String removeBookingInput = scan.nextLine();
        String[] inputs = removeBookingInput.split(" ");
        if (removeBookingInput.equals("0")) {
            bookingSystem.clearTerminal();
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (removeBookingInput.equals("-1")) {
            System.exit(0);
        } else if (inputs.length == 1) {
            String iD = inputs[0];
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < bookingSystem.getBookings().size(); i++) {
                if (bookingSystem.getBookings().get(i).getBookingStatus().equals("SCHEDULED")) {
                    numbers.add(i);
                }
            }
            try {
                if (Integer.parseInt(iD) > 10 && Integer.parseInt(iD) <= (numbers.size() + 10)) { // Checking if ID
                                                                                                  // entered by user is
                                                                                                  // valid.
                    System.out.println(numbers.size());

                    bookingSystem
                            .removeBooking(bookingSystem.getBookings().get(numbers.get(Integer.parseInt(iD) - 11)));
                    System.out.println("hello");

                } else {
                    System.out.println(bookingSystem.removeBookingErrorString());
                }
                removeBookingInput();
            } catch (NumberFormatException e) {
                System.out.println(bookingSystem.removeBookingErrorString());
                removeBookingInput();
            }
        } else {
            System.out.println(bookingSystem.removeBookingInvalidLength());
            removeBookingInput();
        }
        scan.close();

    }

    /**
     * checks input for concluding booking.
     */
    public void concludeBookingInput() {
        Scanner scan = new Scanner(System.in);
        String concludeBookingInput = scan.nextLine();
        String[] inputs = concludeBookingInput.split(" ");
        if (concludeBookingInput.equals("0")) {
            bookingSystem.clearTerminal();
            bookingSystem.loadMainMenu();
            mainMenuInput();
        } else if (concludeBookingInput.equals("-1")) {
            System.exit(0); // Exits Booking app when "-1" entered.
        } else if (inputs.length == 1) {
            String iD = inputs[0];
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < bookingSystem.getBookings().size(); i++) {
                if (bookingSystem.getBookings().get(i).getBookingStatus().equals("SCHEDULED")) {
                    numbers.add(i);
                }
            }
            try {
                if (Integer.parseInt(iD) > 10 && Integer.parseInt(iD) <= (numbers.size() + 10)) {
                    bookingSystem
                            .concludeBooking(bookingSystem.getBookings().get(numbers.get(Integer.parseInt(iD) - 11)));
                } else {
                    System.out.println(bookingSystem.concludeBookingErrorString());
                }
                concludeBookingInput();
            } catch (NumberFormatException e) {
                System.out.println(bookingSystem.concludeBookingErrorString());
                concludeBookingInput();
            }
        } else {
            System.out.println(bookingSystem.concludeBookingInvalidLength());
            concludeBookingInput();
        }
        scan.close();

    }

    /**
     * Booking App is started here.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Room room1 = new Room("201", 1);
        Room room2 = new Room("202", 2);
        Room room3 = new Room("203", 3);
        // Creation of rooms.

        Room[] rooms = { room1, room2, room3 };
        // List of rooms.

        Assistant assistant1 = new Assistant("Bob", "bob@uok.ac.uk");
        Assistant assistant2 = new Assistant("Rob", "rob@uok.ac.uk");
        Assistant assistant3 = new Assistant("Tom", "tom@uok.ac.uk");
        // Creation of assistants.

        Assistant[] assistants = { assistant1, assistant2, assistant3 };
        // List of assistants.

        BookableRoom bookableRoom1 = new BookableRoom(room1, 0, "EMPTY", "21/03/2021", "07:00");
        BookableRoom bookableRoom2 = new BookableRoom(room1, 1, "FULL", "21/03/2021", "08:00");
        BookableRoom bookableRoom3 = new BookableRoom(room1, 1, "FULL", "21/03/2021", "09:00");
        BookableRoom bookableRoom4 = new BookableRoom(room2, 0, "EMPTY", "22/03/2021", "07:00");
        BookableRoom bookableRoom5 = new BookableRoom(room2, 1, "AVAILABLE", "21/03/2021", "08:00");
        BookableRoom bookableRoom6 = new BookableRoom(room2, 2, "FULL", "21/03/2021", "09:00");
        BookableRoom bookableRoom7 = new BookableRoom(room3, 0, "EMPTY", "22/03/2021", "07:00");
        BookableRoom bookableRoom8 = new BookableRoom(room3, 1, "AVAILABLE", "21/03/2021", "08:00");
        BookableRoom bookableRoom9 = new BookableRoom(room3, 2, "AVAILABLE", "23/03/2021", "09:00");
        // Creation of bookable rooms.

        ArrayList<BookableRoom> bookableRooms = new ArrayList<>();
        bookableRooms.add(bookableRoom1);
        bookableRooms.add(bookableRoom2);
        bookableRooms.add(bookableRoom3);
        bookableRooms.add(bookableRoom4);
        bookableRooms.add(bookableRoom5);
        bookableRooms.add(bookableRoom6);
        bookableRooms.add(bookableRoom7);
        bookableRooms.add(bookableRoom8);
        bookableRooms.add(bookableRoom9);
        // Adding bookable rooms to an array list.

        AssistantOnShift assistantOnShift1 = new AssistantOnShift(assistant1, "21/03/2021", "FREE", "07:00");
        AssistantOnShift assistantOnShift2 = new AssistantOnShift(assistant1, "22/03/2021", "FREE", "08:00");
        AssistantOnShift assistantOnShift3 = new AssistantOnShift(assistant1, "21/03/2021", "BUSY", "09:00");
        AssistantOnShift assistantOnShift4 = new AssistantOnShift(assistant2, "22/03/2021", "FREE", "07:00");
        AssistantOnShift assistantOnShift5 = new AssistantOnShift(assistant2, "21/03/2021", "FREE", "08:00");
        AssistantOnShift assistantOnShift6 = new AssistantOnShift(assistant3, "23/03/2021", "FREE", "09:00");
        // Creation of assistants on shift.

        ArrayList<AssistantOnShift> assistantsOnShift = new ArrayList<>();
        assistantsOnShift.add(assistantOnShift1);
        assistantsOnShift.add(assistantOnShift2);
        assistantsOnShift.add(assistantOnShift3);
        assistantsOnShift.add(assistantOnShift4);
        assistantsOnShift.add(assistantOnShift5);
        assistantsOnShift.add(assistantOnShift6);
        // Adding assistants on shift to an array list.

        Booking booking1 = new Booking(bookableRoom3, assistantOnShift3, "21/03/2021", "09:00", "SCHEDULED", "201",
                "jason@uok.ac.uk");
        Booking booking2 = new Booking(bookableRoom9, assistantOnShift1, "21/02/2021", "07:00", "COMPLETED", "203",
                "kenny@uok.ac.uk");
        // Creation of bookings.

        ArrayList<Booking> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        // Adding bookings to an array list.

        BookingApp app = new BookingApp();
        app.bookingSystem = new BookingSystem(bookableRooms, assistantsOnShift, bookings);
        app.universityResources = new UniversityResources(assistants, rooms);

        app.bookingSystem.loadMainMenu();
        app.mainMenuInput();
        // Calling load main menu and main menu input checker methods.

    }
}
