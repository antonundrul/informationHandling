package by.undrul.informationHandling.parser.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements TextParser {
    private static Logger logger = LogManager.getLogger();
    private static final String LEXEME_REGEX="[\\s]+";
    private TextParser nextParser;

    public LexemeParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public void parseText(TextComposite textComposite, String data) {
        String[] lexemes = data.split(LEXEME_REGEX);

        for(String lexeme:lexemes){
            TextComposite lexemeData = new TextComposite(ComponentType.LEXEME);
            textComposite.add(lexemeData);

            if(nextParser!=null){
                nextParser.parseText(lexemeData,lexeme);
            }
        }
    }
}
