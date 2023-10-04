public class Student {

    // Attributes
    private String uniqueID;
    private String answer;

    // Constructor
    public Student(String uniqueID, String answer) {
        this.uniqueID = uniqueID;
        this.answer = answer;
    }

    // Methods
    public String getUniqueID() {
        return uniqueID;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}