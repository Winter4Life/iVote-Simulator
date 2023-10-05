import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {

        String[] options = {"A", "B", "C", "D"};
        Random random = new Random();

        // Randomized number of students and prints 
        int numStudents = random.nextInt(50)+1;
        System.out.println("Number of randomly generated students: " + numStudents);

        // true: is single-choice question, false: multiple-choice question
        // If wanted to test both, run twice with different input
        boolean isSingleChoice = false;

        if (isSingleChoice) {
            Question singleChoiceQuestion = new Question(options, true);
            VotingService singleChoiceService = new VotingService(singleChoiceQuestion);
            simulateForQuestion(singleChoiceService, singleChoiceQuestion, numStudents);
            singleChoiceService.displaySingleChoiceResults();
        } else {
            Question multipleChoiceQuestion = new Question(options, false);
            VotingService multipleChoiceService = new VotingService(multipleChoiceQuestion);
            simulateForQuestion(multipleChoiceService, multipleChoiceQuestion, numStudents);
            multipleChoiceService.displayMultipleChoiceResults();
        }
    }

    public static void simulateForQuestion(VotingService votingService, Question question, int numStudents) {
        Random random = new Random();
        String[] options = question.getOptions();

        // Goes through each student
        for (int i = 1; i <= numStudents; i++) {
            String uniqueID = "Student" + i;
            List<String> answers = new ArrayList<>();

            // If single choice chooses one answer, else chooses multiple answers
            if (question.isSingleChoice()) {
                answers.add(options[random.nextInt(options.length)]);
            } else {
                int choices = random.nextInt(options.length) + 1;
                for (int j = 0; j < choices; j++) {
                    answers.add(options[random.nextInt(options.length)]);
                }
            }

            Student student = new Student(uniqueID, answers);
            votingService.submitAnswer(student);
        }
    }
}