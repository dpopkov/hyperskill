package learn.hyperskill.practice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfNeighbours {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if ("end".equals(line)) {
                break;
            } else {
                lines.add(line);
            }
        }
        String[] tokens = lines.get(0).split(" ");
        int width = tokens.length;
        int height = lines.size();
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = lines.get(i);
            tokens = line.split(" ");
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            int iUp = i - 1;
            iUp = iUp >= 0 ? iUp : height - 1;
            int iDown = i + 1;
            iDown = iDown < height ? iDown : 0;
            for (int j = 0; j < width; j++) {
                int jLeft = j - 1;
                jLeft = jLeft >= 0 ? jLeft : width - 1;
                int jRight = j + 1;
                jRight = jRight < width ? jRight : 0;
                result[i][j] = matrix[iUp][j] + matrix[iDown][j] + matrix[i][jLeft] + matrix[i][jRight];
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
