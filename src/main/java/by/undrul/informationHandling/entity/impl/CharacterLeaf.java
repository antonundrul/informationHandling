package by.undrul.informationHandling.entity.impl;

import by.undrul.informationHandling.entity.ComponentType;
import by.undrul.informationHandling.entity.TextComponent;

import java.util.List;

public class CharacterLeaf implements TextComponent {
    private char symbol;
    private ComponentType componentType;

    public CharacterLeaf(char symbol, ComponentType componentType) {
        this.symbol = symbol;
        this.componentType = componentType;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getChildList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getChildListSize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
