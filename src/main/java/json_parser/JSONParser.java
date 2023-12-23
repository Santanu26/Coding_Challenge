package json_parser;

public class JSONParser {

    TokenType tokenType;
    String value;

   public JSONParser(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }
}
