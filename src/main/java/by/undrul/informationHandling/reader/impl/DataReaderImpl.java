package by.undrul.informationHandling.reader.impl;

import by.undrul.informationHandling.exception.HandlingException;
import by.undrul.informationHandling.reader.DataReader;
import by.undrul.informationHandling.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String readDataFromFile(String path) throws HandlingException {
        logger.info("Method to read data from file started");

        if (!FileValidator.isFileValid(path)) {
            throw new HandlingException("File " + path + " is empty or don't exist or has incorrect filepath");
        }

        String dataFromFile;
        File file = new File(path);

        try  {
            dataFromFile = Files.readString(Paths.get(path));

        } catch (Exception e) {
            throw new HandlingException("File is not found", e);
        }

        logger.info("Data from file read");
        return dataFromFile;

    }
}
