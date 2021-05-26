package by.undrul.informationHandling._main;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.exception.HandlingException;
import by.undrul.informationHandling.parser.impl.*;
import by.undrul.informationHandling.reader.impl.DataReaderImpl;
import by.undrul.informationHandling.service.TextService;
import by.undrul.informationHandling.service.impl.TextServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Hello world!
 *
 */
public class InformationHandlingMain
{
    private static Logger logger= LogManager.getLogger();
    public static void main( String[] args )
    {
        String filepath = "./src/main/resources/data/data.txt";
        DataReaderImpl dataReader = new DataReaderImpl();
        try {
            String datafromFile = dataReader.readDataFromFile(filepath);

            LetterParser letterParser = new LetterParser();
            WordParser wordParser = new WordParser(letterParser);
            LexemeParser lexemeParser = new LexemeParser(wordParser);
            SentenceParser sentenceParser = new SentenceParser(lexemeParser);
            ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

            TextComposite component = new TextComposite(ComponentType.TEXT);
            paragraphParser.parseText(component, datafromFile);
            logger.info(paragraphParser);

            TextService service= new TextServiceImpl();

            service.sortParagraphsByAmountOfSentences(component);
            logger.info(component);

            service.findSentenceWithLongestWord(component);

            logger.info(service.findIdenticalWords(component));

            service.countVowels(component);
            service.countСonsonants(component);

            service.removeSentencesWithLessNumberOfWords(component,20);
            logger.info(component);



        } catch (HandlingException e) {
            e.printStackTrace();
        }
    }
}
