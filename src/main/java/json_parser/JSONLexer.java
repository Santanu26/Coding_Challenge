package json_parser;

import static json_parser.TokenType.*;

public class JSONLexer {

    private String input;

    private int position;

    JSONLexer(String input) {
        this.input = input;
        this.position = 0;
    }

    Token getNextToken() {
        skipWhiteSpace();
        if (position >= input.length()) {
            return new Token(TokenType.NULL, null);
        }
        char currentChar = input.charAt(position);

        switch (currentChar) {

            case '{' -> {
                position++;
                return new Token(TokenType.LEFT_BRACE, "{");
            }
            case '}' -> {
                position++;
                return new Token(RIGHT_BRACE, "}");
            }
            case '"' -> {
                return readString();
            }
            case ',' -> {
                position++;
                return new Token(COMMA, ",");
            }
            case ':' -> {
                position++;
                return new Token(COLON, ":");
            }
            default -> {
                if (Character.isDigit(currentChar) || currentChar == '-') {
                    return readNumber();
                } else {
                    throw new JSONParseException("UnExpected Character: " + currentChar);
                }
            }
        }
    }

    private void skipWhiteSpace() {
        while (position < input.length() && Character.isWhitespace(input.charAt(position))) {
            position++;
        }
    }

    private Token readNumber() {
        var sb = new StringBuilder();
        position++;
        if (position < input.length()
                && Character.isDigit(input.charAt(position))
                || input.charAt(position) == '.' || input.charAt(position) == '-') {
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(NUMBER, sb.toString());
    }

    private Token readString() {
        var sb = new StringBuilder();
        position++;
        if (position < input.length() && input.charAt(position) != '"') {
            sb.append(input.charAt(position));
            position++;
        }
        position++;
        return new Token(STRING, sb.toString());

    }
}
