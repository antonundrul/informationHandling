package by.undrul.informationHandling._main;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.exception.HandlingException;
import by.undrul.informationHandling.parser.impl.*;
import by.undrul.informationHandling.reader.impl.DataReaderImpl;

/**
 * Hello world!
 *
 */
public class InformationHandlingMain
{
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
            System.out.println(paragraphParser);

        } catch (HandlingException e) {
            e.printStackTrace();
        }
    }
}
