/**
 * The type Assistant on shift.
 */
public class AssistantOnShift {

    private Assistant assistant;

    private String assistantOnShiftDate;

    private String assistantOnShiftStatus;

    private String assistantTimeSlot;

    /**
     * Print assistant on shift template string.
     *
     * @return template for assistant on shift.
     */
    public String printAssistantOnShiftTemplate() {
        String AssistantOnShiftTemplate = " | " + assistantOnShiftDate + " " + assistantTimeSlot + " | " + assistantOnShiftStatus + " | " +
                this.assistant.getEmail() + " |";
        return AssistantOnShiftTemplate;
    }


    /**
     * Constructor for instantiating a assistant on shift.
     *
     * @param assistant              assistant of assistant on shift.
     * @param assistantOnShiftDate   date of assistant on shift.
     * @param assistantOnShiftStatus status of assistant on shift.
     * @param assistantTimeSlot      timeslot of assistant on shift.
     */
    public AssistantOnShift(Assistant assistant, String assistantOnShiftDate, String assistantOnShiftStatus, String assistantTimeSlot) {
        this.assistant = assistant;
        this.assistantOnShiftDate = assistantOnShiftDate;
        this.assistantOnShiftStatus = assistantOnShiftStatus;
        this.assistantTimeSlot = assistantTimeSlot;

    }

    /**
     * getter.
     *
     * @return assistant of assistant on shift.
     */
    public Assistant getAssistant() {
        return assistant;
    }

    /**
     * getter for date of assistant on shift.
     *
     * @return date of assistant on shift.
     */
    public String getAssistantOnShiftDate() {
        return assistantOnShiftDate;
    }

    /**
     * getter for status of assistant.
     *
     * @return status of assistant on shift.
     */
    public String getAssistantOnShiftStatus() {
        return assistantOnShiftStatus;
    }

    /**
     * getter for timeslot of assistant on shift.
     *
     * @return timeslot of assistant on shift.
     */
    public String getAssistantOnShiftTimeSlot() {
        return assistantTimeSlot;
    }

    /**
     * setter for status of assistant on shift.
     *
     * @param assistantOnShiftStatus status of assistant on shift.
     */
    public void setAssistantOnShiftStatus(String assistantOnShiftStatus) {
        this.assistantOnShiftStatus = assistantOnShiftStatus;
    }






}
