import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(String input) {

        List<Token> tokens = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {

                String num = "";

                while (i < input.length() &&
                       Character.isDigit(input.charAt(i))) {

                    num += input.charAt(i);
                    i++;
                }

                i--; // step back

                tokens.add(new Token(Token.Type.NUMBER, num));
            }

            else if (ch == '+')
                tokens.add(new Token(Token.Type.PLUS, "+"));

            else if (ch == '-')
                tokens.add(new Token(Token.Type.MINUS, "-"));

            else if (ch == '*')
                tokens.add(new Token(Token.Type.MULTIPLY, "*"));

            else if (ch == '/')
                tokens.add(new Token(Token.Type.DIVIDE, "/"));

            else if (ch == '(')
                tokens.add(new Token(Token.Type.LPAREN, "("));

            else if (ch == ')')
                tokens.add(new Token(Token.Type.RPAREN, ")"));
        }

        return tokens;
    }
}