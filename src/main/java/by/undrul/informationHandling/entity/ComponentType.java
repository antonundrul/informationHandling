package by.undrul.informationHandling.entity;

public enum ComponentType {
    TEXT("\n"),
    PARAGRAPH(" "),
    SENTENCE(" "),
    LEXEME(""),
    WORD("  "),
    LETTER(""),
    PUNCTUATION("");

    private final String delimiter;

    ComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
