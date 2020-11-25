package learn.hyperskill.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
            System.out.printf("Merging files from folder %s to %s%n", sourceDir, targetFile);
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
            List<String> importLines = new ArrayList<>();
            List<JavaFile> allJavaFiles = new ArrayList<>();
            for (File file : files) {
                if (file.getName().endsWith(".java")) {
                    List<String> oneFileLines = readOneFileLines(file, importLines);
                    JavaFile javaFile = new JavaFile(file.getName(), oneFileLines);
                    allJavaFiles.add(javaFile);
                }
            }
            importLines.sort(Comparator.naturalOrder());
            allJavaFiles.sort(Comparator.comparing(JavaFile::getName));
            makeMainFirst(allJavaFiles);
            checkAndEnsurePackage(targetFile, importLines);

            writeLines(writer, importLines);
            for (JavaFile jf : allJavaFiles) {
                writeLines(writer, jf.getLines());
            }
        }
    }

    private static void checkAndEnsurePackage(File targetFile, List<String> importLines) throws IOException {
        String path = targetFile.getCanonicalPath();
        final String pathInProject = "/src/main/java/";
        int idx = path.indexOf(pathInProject);
        if (idx != -1) {
            int packageStart = idx + pathInProject.length();
            int packageEnd = path.lastIndexOf(File.separator);
            String packageStr = path.substring(packageStart, packageEnd);
            String packageName = packageStr.replaceAll("/", ".");
            importLines.add(0, "package " + packageName + ";" + NL);
            importLines.add(1, NL);
        }
    }

    private static void makeMainFirst(List<JavaFile> javaFiles) {
        int mainIdx = -1;
        for (int i = 0; i < javaFiles.size(); i++) {
            JavaFile jf = javaFiles.get(i);
            if ("Main.java".equals(jf.getName())) {
                mainIdx = i;
                break;
            }
        }
        if (mainIdx != -1) {
            JavaFile main = javaFiles.remove(mainIdx);
            javaFiles.add(0, main);
        }
    }

    private static void writeLines(BufferedWriter writer, List<String> lines) throws IOException {
        for (String line : lines) {
            writer.write(line);
        }
        writer.write(NL);
    }

    private static List<String> readOneFileLines(File file, List<String> importLines) throws IOException {
        List<String> oneFileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines()
                    .filter(line -> !line.startsWith("package "))
                    .map(line -> line.startsWith("public ") ? line.substring(7) : line)
                    .forEach(line -> {
                        if (line.startsWith("import ")) {
                            importLines.add(line + NL);
                        } else {
                            oneFileLines.add(line + NL);
                        }
                    });
        }
        return oneFileLines;
    }

    private static class JavaFile {
        private final String name;
        private final List<String> lines;

        public JavaFile(String name, List<String> lines) {
            this.name = name;
            this.lines = lines;
        }

        public String getName() {
            return name;
        }

        public List<String> getLines() {
            return lines;
        }
    }
}
