/**
 * The type Assistant.
 */
public class Assistant {

    private String name;

    private String email;

    /**
     * Print assistant template string.
     *
     * @return Template for assistant details.
     */
    public String printAssistantTemplate() {
        String assistantTemplate = " | " + name + " | " + email + " |";

        return assistantTemplate;
    }

    /**
     * Constructor to instantiate an assistant.
     *
     * @param name  name of assistant.
     * @param email email of assistant.
     */
    public Assistant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Gets email.
     *
     * @return email of assistant object.
     */
    public String getEmail() {
        return email;
    }
}