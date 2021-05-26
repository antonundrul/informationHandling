package by.undrul.informationHandling.service.impl;

import by.undrul.informationHandling.comparator.ParagraphComparator;
import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.TextComponent;
import by.undrul.informationHandling.entity.impl.TextComposite;
import by.undrul.informationHandling.exception.HandlingException;
import by.undrul.informationHandling.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public List<TextComponent> sortParagraphsByAmountOfSentences(TextComposite textComposite) throws HandlingException {
        if (!textComposite.getType().equals(ComponentType.TEXT)) {
            throw new HandlingException("Expected component of text type: " + textComposite.getType());
        }

        List<TextComponent> a = textComposite.getChildList()
                .stream()
                .filter(textComponent -> matchesType(textComponent, ComponentType.PARAGRAPH))
                .sorted(new ParagraphComparator())
                .collect(Collectors.toList());
        return a;
    }

    @Override
    public String findSentenceWithLongestWord(TextComposite textComposite) throws HandlingException {
        if (textComposite == null) {
            throw new HandlingException("This composite = null");
        }

        int maxLengthWord = 0;
        TextComponent sentenceWithLongestWord = null;
        TextComponent longestWord = null;
        List<TextComponent> paragraphs = textComposite.getChildList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getChildList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> words = lexeme.getChildList();
                    for (TextComponent word : words) {
                        if(maxLengthWord < word.getChildListSize()){
                            maxLengthWord = word.getChildListSize();
                            sentenceWithLongestWord=sentence;
                            longestWord=word;
                        }
                    }
                }
            }
        }
        logger.info("The sentence with longest word is a:  "+sentenceWithLongestWord);
        logger.info("The longest word is a:  "+longestWord);
     return sentenceWithLongestWord.toString();
    }

    @Override
    public TextComposite removeSentencesWithLessNumberOfWords(TextComposite textComposite, int amountOfWords) {

        List<TextComponent> paragraphs = textComposite.getChildList();
        for (int i=0;i<paragraphs.size();i++) {
            List<TextComponent> sentences = paragraphs.get(i).getChildList();
            for (int j=0;j<sentences.size();j++) {
                if(sentences.get(j).getChildListSize() < amountOfWords){
                    logger.info("The sentence * "+sentences.get(j)+" * was deleted");
                    textComposite.getChildList().get(i).getChildList().remove(j);
                }
            }
        }
        return textComposite;
    }

    @Override
    public Map<String, Integer> findIdenticalWords(TextComposite textComposite) {
       Map<String,Integer> wordsMap=new HashMap<>();

        List<TextComponent> paragraphs = textComposite.getChildList();
        for(TextComponent paragraph:paragraphs) {
            List<TextComponent> sentences = paragraph.getChildList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> words = lexeme.getChildList();
                    for (TextComponent word : words) {
                        wordsMap.put(word.toString(), 0);
                    }
                }
            }
        }

        for(TextComponent paragraph:paragraphs) {
            List<TextComponent> sentences = paragraph.getChildList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> words = lexeme.getChildList();
                    for (TextComponent word : words) {
                        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
                            if (entry.getKey().equals(word.toString())) {
                                entry.setValue(entry.getValue() + 1);
                            }
                        }
                    }
                }
            }
        }
        return wordsMap;
    }

    @Override
    public int countVowels(TextComposite textComposite) {
        int vowels = 0;
        List<TextComponent> paragraphs = textComposite.getChildList();
        for(TextComponent paragraph:paragraphs) {
            List<TextComponent> sentences = paragraph.getChildList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> words = lexeme.getChildList();
                    for (TextComponent word : words) {
                        List<TextComponent> letters = word.getChildList();
                        for (TextComponent letter : letters) {
                            if (letter.toString().equals("a")
                                    || letter.toString().equals("e")
                                    || letter.toString().equals("o")
                                    || letter.toString().equals("i")
                                    || letter.toString().equals("u")) {
                                vowels++;
                            }


                        }

                    }
                }
            }
        }
        logger.info("There are "+vowels+" vowels letters");
        return vowels;
    }

    @Override
    public int countСonsonants(TextComposite textComposite) {
        int consonants = 0;
        List<TextComponent> paragraphs = textComposite.getChildList();
        for(TextComponent paragraph:paragraphs) {
            List<TextComponent> sentences = paragraph.getChildList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getChildList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> words = lexeme.getChildList();
                    for (TextComponent word : words) {
                        List<TextComponent> letters = word.getChildList();
                        for (TextComponent letter : letters) {
                            if (!(letter.toString().equals("a")
                                    || letter.toString().equals("e")
                                    || letter.toString().equals("o")
                                    || letter.toString().equals("i")
                                    || letter.toString().equals("u"))) {
                                consonants++;
                            }

                        }

                    }
                }
            }
        }

        logger.info("There are "+consonants+" consonants letters");
        return consonants;
    }

    private boolean matchesType(TextComponent component, ComponentType type) {
        return component.getType().equals(type);
    }
}
