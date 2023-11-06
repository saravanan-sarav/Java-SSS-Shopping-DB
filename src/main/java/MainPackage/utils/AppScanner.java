package MainPackage.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppScanner {
    private static Scanner scanner;
    private static Scanner fileScanner;

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static Scanner getFileScanner(File file) {
        File csvFile = file;
        try {
            fileScanner = new Scanner(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fileScanner;
    }
}
