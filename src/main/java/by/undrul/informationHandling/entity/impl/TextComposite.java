package by.undrul.informationHandling.entity.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static Logger logger = LogManager.getLogger();
    private ComponentType componentType;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void delete(TextComponent component) {
        components.remove(component);
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildList() {
        return components;
    }

    @Override
    public int getChildListSize() {
        List<TextComponent> textComponents = getChildList();
        return textComponents.size();
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        for (TextComponent textComponent : components){
            stringBuilder.append(textComponent);
            stringBuilder.append(componentType.getDelimiter());
        }
        return stringBuilder.toString();
    }
}
