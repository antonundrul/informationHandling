package by.undrul.informationHandling.reader;

import by.undrul.informationHandling.exception.HandlingException;

import java.util.ArrayList;

public interface DataReader {
    String readDataFromFile(String path) throws HandlingException;
}
