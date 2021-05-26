package by.undrul.informationHandling.comparator;

import by.undrul.informationHandling.entity.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int first = o1.getChildListSize();
        int second = o2.getChildListSize();

        return Integer.compare(first, second);
    }
}