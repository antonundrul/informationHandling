package by.undrul.informationHandling.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileValidator {
    private static Logger logger = LogManager.getLogger();

    public static boolean isFileValid(String path) {

        logger.info("Method to validate file start");

        if (path == null || path.isEmpty()) {
            logger.info("Filepath " + path + " is null or empty");
            return false;
        }

        boolean flag = false;
        File file = new File(path);

        if (file.exists() & file.length() > 0) {
            flag = true;
        } else {
            logger.info("File " + path + " doesn't exist or empty");
        }

        return flag;
    }
}