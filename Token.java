public class Token {

    public enum Type {
        NUMBER,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
        LPAREN,
        RPAREN
    }

    Type type;
    String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        return type + " : " + value;
    }
}