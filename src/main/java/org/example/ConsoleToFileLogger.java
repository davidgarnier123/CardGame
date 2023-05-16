package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ConsoleToFileLogger {
    private static final String FILE_NAME = "output.txt";
    private static PrintStream filePrintStream;

    public static void initialize() {
        try {
            String filePath = System.getProperty("user.dir") + File.separator + FILE_NAME;
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            filePrintStream = new PrintStream(fos);
            System.setOut(filePrintStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        if (filePrintStream != null) {
            filePrintStream.close();
        }
    }
}