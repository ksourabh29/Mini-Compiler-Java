import java.util.List;
import java.util.Stack;

public class Evaluator {

    public int evaluate(List<Token> tokens) {

        Stack<Integer> values = new Stack<>();
        Stack<Token.Type> ops = new Stack<>();

        for (int i = 0; i < tokens.size(); i++) {

            Token t = tokens.get(i);

            // NUMBER
            if (t.type == Token.Type.NUMBER) {

                values.push(Integer.parseInt(t.value));
            }

            // (
            else if (t.type == Token.Type.LPAREN) {

                ops.push(t.type);
            }

            // )
            else if (t.type == Token.Type.RPAREN) {

                while (ops.peek() != Token.Type.LPAREN) {

                    int b = values.pop();
                    int a = values.pop();
                    Token.Type op = ops.pop();

                    values.push(apply(a, b, op));
                }

                ops.pop(); // remove '('
            }

            // Operator
            else {

                while (!ops.isEmpty() &&
                        ops.peek() != Token.Type.LPAREN &&
                        priority(ops.peek()) >= priority(t.type)) {

                    int b = values.pop();
                    int a = values.pop();
                    Token.Type op = ops.pop();

                    values.push(apply(a, b, op));
                }

                ops.push(t.type);
            }
        }

        // Remaining operations
        while (!ops.isEmpty()) {

            int b = values.pop();
            int a = values.pop();
            Token.Type op = ops.pop();

            values.push(apply(a, b, op));
        }

        return values.pop();
    }


    // Priority check
    private int priority(Token.Type op) {

        if (op == Token.Type.PLUS || op == Token.Type.MINUS)
            return 1;

        if (op == Token.Type.MULTIPLY || op == Token.Type.DIVIDE)
            return 2;

        return 0;
    }


    // Apply operation with divide by zero check
    private int apply(int a, int b, Token.Type op) {

        if (op == Token.Type.PLUS)
            return a + b;

        if (op == Token.Type.MINUS)
            return a - b;

        if (op == Token.Type.MULTIPLY)
            return a * b;

        if (op == Token.Type.DIVIDE) {

            if (b == 0) {
                throw new ArithmeticException("Divide by zero");
            }

            return a / b;
        }

        return 0;
    }
}