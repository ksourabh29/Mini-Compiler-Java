import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter expression:");
        String input = sc.nextLine();

        try {

            // Lexer
            Lexer lexer = new Lexer();
            List<Token> tokens = lexer.tokenize(input);

            // Parser
            Parser parser = new Parser();

            if (!parser.isValid(tokens)) {
                System.out.println("Invalid Expression");
                return;
            }

            // Evaluator
            Evaluator eval = new Evaluator();
            int result = eval.evaluate(tokens);

            System.out.println("Result = " + result);

        } catch (ArithmeticException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid Expression");

        }
    }
}