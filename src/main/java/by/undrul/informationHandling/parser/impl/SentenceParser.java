package by.undrul.informationHandling.parser.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements TextParser {
    private static Logger logger = LogManager.getLogger();
    private static final String SENTENCE_REGEX="(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?)\\s";
    private TextParser nextParser;

    public SentenceParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public void parseText(TextComposite textComposite, String data) {
        String[] sentences = data.split(SENTENCE_REGEX);
        for(String sentence: sentences){
            TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);
            textComposite.add(sentenceComposite);

            if(nextParser!=null){
                nextParser.parseText(sentenceComposite,sentence);
            }
        }
    }
}
