package by.undrul.informationHandling.parser.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements TextParser {
    private static Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_REGEX ="[\\n\\t]+";
    private TextParser nextParser;

    public ParagraphParser(TextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public void parseText(TextComposite textComposite, String data) {
        String[] paragraphs = data.split(PARAGRAPH_REGEX);
        for(String paragraph : paragraphs){
            TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
            textComposite.add(paragraphComposite);

            if(nextParser!=null){
                nextParser.parseText(paragraphComposite,paragraph);
            }
        }
    }
}
