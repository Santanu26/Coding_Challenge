package json_parser;

public class Client {
    public static void main(String[] args) {
        String input = "{}";
        int result = parseJSON(input);
        System.out.println(result);
        System.out.println("-------------------");
        String ss = """
                {
                  "name": "John Doe",
                  "age": 30,
                  "city": "New York"
                }
                """;
        int resul1 = parseJSON(ss);
        System.out.println(resul1);
    }

    private static int parseJSON(String input) {
        JSONLexer lexer = new JSONLexer(input);
        Token token = lexer.getNextToken();

        if (token.type == TokenType.LEFT_BRACE) {

            System.out.println("Valid JSON: " + input);
            return 0;
        } else {

            System.out.println("Invalid JSON: " + input);
            return 1;
        }
    }
}
