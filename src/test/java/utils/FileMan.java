package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.testng.Assert.assertTrue;

/**
 * Created by Pyrozhok on 13.01.2016.
 */
public class FileMan {

    public static boolean fileExists(String filePath) {
        Logger.info("Check does file exist [" + filePath + "]");
        File file = new File(filePath);
        return file.exists() && !file.isDirectory();
    }

    public static File writeToFile(String filePath, String data) {
        File file = new File(filePath);
        try {
            if (!fileExists(filePath)) {
                file.createNewFile();
            }
            Logger.info("Writing data [" + data + "] to file [" + filePath + "]");
            FileUtils.writeStringToFile(file, data);
        } catch (IOException e) {
            Logger.error("Failed to write to file [" + filePath + "]");
        }
        return file;
    }

    public static File writeToFile(String filePath, String[] words) {
        File file = new File(filePath);
        try {
            if (!fileExists(filePath)) {
                file.createNewFile();
            }
            FileUtils.writeLines(file, Arrays.asList(words));
        } catch (IOException e) {
            Logger.error("Failed to write to file [" + filePath + "]");
        }
        return file;
    }

    public static String readTextFromFile(String filePath) {
        assertTrue(fileExists(filePath));
        try {
            return FileUtils.readFileToString(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
