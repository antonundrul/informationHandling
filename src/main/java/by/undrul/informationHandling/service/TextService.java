package by.undrul.informationHandling.service;

import by.undrul.informationHandling.entity.TextComponent;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.exception.HandlingException;

import java.util.List;
import java.util.Map;

public interface TextService {
    List<TextComponent> sortParagraphsByAmountOfSentences(TextComposite textComposite) throws HandlingException;

    String findSentenceWithLongestWord(TextComposite textComposite) throws HandlingException;

    TextComposite removeSentencesWithLessNumberOfWords(TextComposite textComposite, int amountOfWords);

    Map<String, Integer> findIdenticalWords(TextComposite textComposite);

    int countVowels(TextComposite textComposite);

    int countСonsonants(TextComposite textComposite);

}
