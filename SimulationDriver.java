import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {

        //String[] options = {"1. Right", "2. Wrong"};
        String[] options = {"A", "B", "C", "D"};

        // true: is single-choice question, false: multiple-choice question
        // If wanted to test both, run twice with different input
        Question questionType = new Question(options, false); 
        VotingService votingService = new VotingService(questionType);

        Random random = new Random();
        // Randomized number of students and prints
        int numStudents = random.nextInt(50) + 1; 
        System.out.println("Number of randomly generated students: " + numStudents);

        for (int i = 1; i <= numStudents; i++) {
            String uniqueID = "Student" + i;
            String answer = options[random.nextInt(options.length)];
            Student student = new Student(uniqueID, answer);
            votingService.submitAnswer(student);
        }

        if (questionType.isSingleChoice()) {
            votingService.displaySingleChoiceResults();
        } else {
            votingService.displayMultipleChoiceResults();
        }
    }
}
