import java.util.List;

public class Student {

    // Attributes
    private String uniqueID;
    private List<String> answers;

    // Constructor
    public Student(String uniqueID, List<String> answers) {
        this.uniqueID = uniqueID;
        this.answers = answers;
    }
    
    // Methods
    public String getUniqueID() {
        return uniqueID;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}