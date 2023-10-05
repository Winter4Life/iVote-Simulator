import java.util.List;
import java.util.ArrayList;

public class VotingService {

    // Attributes
    private Question questionType;
    private List<Student> submissions;

    // Constructor
    public VotingService(Question questionType) {
        this.questionType = questionType;
        this.submissions = new ArrayList<>();
    }

    // Method to remove submission and add new submission for single choice 
    public void submitAnswer(Student student) {
        boolean studentAlreadySubmitted = submissions.stream()
                .anyMatch(s -> s.getUniqueID().equals(student.getUniqueID()));

        if (!studentAlreadySubmitted) {
            submissions.add(student);
        } else {
            submissions.removeIf(s -> s.getUniqueID().equals(student.getUniqueID()));
            submissions.add(student);
        }
    }

    public void displayMultipleChoiceResults() {
        displayResults("--Multiple-Choice Questions--");
    }

    public void displaySingleChoiceResults() {
        displayResults("--Single-Choice Questions--");
    }
    
    // Method to display results for multiple and single choice
    private void displayResults(String header) {
        int[] answerCounts = new int[questionType.getOptions().length];

        for (Student student : submissions) {
            for (String answer : student.getAnswers()) {
                int index = findAnswerIndex(answer);
                if (index != -1) {
                    answerCounts[index]++;
                }
            }
        }

        System.out.println(header);
        System.out.println("Submission Results:");
        for (int i = 0; i < questionType.getOptions().length; i++) {
            System.out.println(questionType.getOptions()[i] + " = " + answerCounts[i]);
        }
    }

    // Method to find student answers in the answerCounts array
    private int findAnswerIndex(String answer) {
        String[] options = questionType.getOptions();
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(answer)) {
                return i;
            }
        }
        return -1;
    }
}