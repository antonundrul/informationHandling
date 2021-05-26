package by.undrul.informationHandling.parser.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.impl.CharacterLeaf;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LetterParser implements TextParser {

    public static Logger logger = LogManager.getLogger();

    @Override
    public void parseText(TextComposite textComposite, String data) {
        char[] letters = data.toCharArray();
        for(char letter: letters){
            CharacterLeaf characterLeaf = new CharacterLeaf(letter, ComponentType.LETTER);
            textComposite.add(characterLeaf);
        }
    }
}
