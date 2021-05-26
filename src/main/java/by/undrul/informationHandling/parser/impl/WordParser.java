package by.undrul.informationHandling.parser.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements TextParser {
    private static Logger logger = LogManager.getLogger();
    public static final String WORD_REGEX="[- ,.:;()\\s\\t\\n]";
    public TextParser nextParser;

    public WordParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public void parseText(TextComposite textComposite, String data) {
        String[] words = data.split(WORD_REGEX);
        for(String word:words){
            TextComposite wordComposite = new TextComposite(ComponentType.WORD);
            textComposite.add(wordComposite);

            if(nextParser!=null){
                nextParser.parseText(wordComposite,word);
            }
        }
    }
}
