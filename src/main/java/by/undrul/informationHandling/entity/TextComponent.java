package by.undrul.informationHandling.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent component);

    void delete(TextComponent component);

    TextComponent getChild(int index);

    ComponentType getType();

    List<TextComponent> getChildList();
}
