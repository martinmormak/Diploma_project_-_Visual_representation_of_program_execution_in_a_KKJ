import java.util.Random;

public class KKJGenerator {
    private final Random random = new Random();
    private int maxLength;
    private int generatedLength;

    public String generateProgram(int maxLength) {
        if(maxLength <= 0) throw new KKJException("Max length cannot be negative or equal to zero.");
        this.maxLength = maxLength;
        return generateSequence();
    }

    private String generateSequence() {
        int choice = random.nextInt(3); // Sequence → Command | Command Sequence | SpecialExpression Command

        if (choice == 0) {
            return generateCommand();
        } else if (choice == 1) {
            return generateCommand() + " " + generateSequence();
        } else {
            return generateSpecialExpression() + " " + generateCommand();
        }
    }

    private String generateCommand() {
        return random.nextBoolean() ? generateNumberExpression() : generateBoolExpression();
    }

    private String generateBoolExpression() {
        int choice = random.nextInt(7);
        if (choice == 0 && generatedLength < maxLength) {
            generatedLength++;
            return "true";
        } else if (choice == 1 && generatedLength < maxLength) {
            generatedLength++;
            return "false";
        } else if (choice == 2 && generatedLength < maxLength) {
            generatedLength++;
            return generateBoolExpression() + " NOT";
        } else if (choice == 3 && generatedLength < maxLength) {
            generatedLength++;
            return generateBoolExpression() + " " + generateBoolExpression() + " AND";
        } else if (choice == 4 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " ISNEG";
        } else if (choice == 5 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " ISPOS";
        } else if (choice == 6 && generatedLength < maxLength) {
            generatedLength++;
            return generateBoolExpression() + " " + generateSpecialExpression();
        }
        choice = random.nextInt(2);
        if (choice == 0 ) {
            generatedLength++;
            return "true";
        } else {
            generatedLength++;
            return "false";
        }
    }

    private String generateNumberExpression() {
        int choice = random.nextInt(6);
        if (choice == 0 && generatedLength < maxLength) {
            generatedLength++;
            return String.valueOf(random.nextInt(100));
        } else if (choice == 1 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " " + generateNumberExpression() + " ADD";
        } else if (choice == 2 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " " + generateNumberExpression() + " SUB";
        } else if (choice == 3 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " " + generateNumberExpression() + " MUL";
        } else if (choice == 4 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " " + generateNumberExpression() + " CMP";
        } else if (choice == 5 && generatedLength < maxLength) {
            generatedLength++;
            return generateNumberExpression() + " " + generateSpecialExpression();
        }
        generatedLength++;
        return String.valueOf(random.nextInt(10));
    }

    private String generateSpecialExpression() {
        if(generatedLength >= maxLength) { return ""; }
        return generateCommand() + " POP";
    }
}
