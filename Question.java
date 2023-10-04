public class Question {

    // Attributes
    private String[] options;
    private boolean isSingleChoice;

    // Constructor
    public Question(String[] options, boolean isSingleChoice) {
        this.options = options;
        this.isSingleChoice = isSingleChoice;
    }

    // Methods
    public String[] getOptions() {
        return options;
    }

    public boolean isSingleChoice() {
        return isSingleChoice;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setIsSingleChoice(boolean isSingleChoice) {
        this.isSingleChoice = isSingleChoice;
    }
}
