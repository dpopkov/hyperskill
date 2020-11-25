package learn.hyperskill.util;

import java.io.*;

/**
 * This utility class helps to merge all java source code files into one class.
 * It is used for producing automatically tested solution for current hyperskill project.
 */
public class MergeClasses {
    private static final String NL = System.lineSeparator();

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: " + MergeClasses.class.getSimpleName() + " "
                + "sourceDirectoryPath targetFilePath");
            System.exit(0);
        }
        try {
            String sourceDir = args[0];
            String targetFile = args[1];
            System.out.printf("Merging files from %s to %s%n", sourceDir, targetFile);
            merge(new File(sourceDir), new File(targetFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void merge(File sourceDir, File targetFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            File[] files = sourceDir.listFiles();
            if (files == null) {
                System.err.println("This abstract path does not denote a directory " + sourceDir);
                return;
            }
            for (File file : files) {
                if (file.getName().endsWith(".java")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        // todo: find and store 'import' statements for moving them to the start
                        reader.lines()
                                .filter(line -> !line.startsWith("package "))
                                .map(line -> line.startsWith("public ") ? line.substring(7) : line)
                                .forEach(line -> {
                                    try {
                                        writer.write(line);
                                        writer.write(NL);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                    }
                    writer.write(NL);
                }
            }
        }
    }
}
