import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class VotingService {

    // Attributes
    private Question questionType;
    private List<Student> submissions;

    // Constructor
    public VotingService(Question questionType) {
        this.questionType = questionType;
        this.submissions = new ArrayList<>();
    }

    // Methods
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
        int[] answerCounts = new int[questionType.getOptions().length];

        for (int i = 0; i < answerCounts.length; i++) {
            answerCounts[i] = 0;
        }

        for (Student student : submissions) {
                String answer = student.getAnswer();
                int index = Arrays.asList(questionType.getOptions()).indexOf(answer);
            if (index >= 0 && index < answerCounts.length) {
                    answerCounts[index]++;
            }
        }

        System.out.println("--Multiple-Choice Questions--");
        System.out.println("Submission Results:");
        for (int i = 0; i < answerCounts.length; i++) {
            System.out.println(questionType.getOptions()[i] + " = " + answerCounts[i]);
        }
    }

    public void displaySingleChoiceResults() {

        int[] answerCounts = new int[questionType.getOptions().length];

        for (int i = 0; i < answerCounts.length; i++) {
            answerCounts[i] = 0;
        }

        for (Student student : submissions) {
                String answer = student.getAnswer();
                int index = Arrays.asList(questionType.getOptions()).indexOf(answer);
            if (index >= 0 && index < answerCounts.length) {
                    answerCounts[index]++;
            }
        }

        System.out.println("--Single-Choice Questions--");
        System.out.println("Submission Results:");
        for (int i = 0; i < answerCounts.length; i++) {
            System.out.println(questionType.getOptions()[i] + " = " + answerCounts[i]);
        }
    }
}
