import java.util.List;

public class Parser {

    public boolean isValid(List<Token> tokens) {

        if (tokens.size() == 0)
            return false;

        int balance = 0;

        for (int i = 0; i < tokens.size(); i++) {

            Token t = tokens.get(i);

            // check parentheses balance
            if (t.type == Token.Type.LPAREN)
                balance++;

            if (t.type == Token.Type.RPAREN)
                balance--;

            if (balance < 0)
                return false;

            // check operator rules
            if (i < tokens.size() - 1) {

                Token next = tokens.get(i + 1);

                // number followed by number → wrong
                if (t.type == Token.Type.NUMBER &&
                    next.type == Token.Type.NUMBER)
                    return false;

                // operator followed by operator → wrong
                if (isOp(t) && isOp(next))
                    return false;
            }
        }

        return balance == 0;
    }

    private boolean isOp(Token t) {

        return t.type == Token.Type.PLUS ||
               t.type == Token.Type.MINUS ||
               t.type == Token.Type.MULTIPLY ||
               t.type == Token.Type.DIVIDE;
    }
}