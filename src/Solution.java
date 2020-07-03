import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][] newForms = new int[3][3];

        for (int i = 0; i < s.length; i++) {
            newForms[i] = Arrays.copyOf(s[i], s[i].length);
        }

        int maxValue = newForms[1][1] * 3;

        int crossOneTotal = newForms[0][0] + newForms[1][1] + newForms[2][2];
        int crossTwoTotal = newForms[0][2] + newForms[1][1] + newForms[2][0];
        int verticalTotal = newForms[0][1] + newForms[1][1] + newForms[2][1];
        int horizontalTotal = newForms[1][0] + newForms[1][1] + newForms[1][2];

        // Cross One
        int crossOneLeftover = maxValue - crossOneTotal;
        if ((newForms[0][0] + crossOneLeftover) + newForms[0][1] + newForms[0][2] == maxValue && (newForms[0][0] + crossOneLeftover) + newForms[1][0] + newForms[2][0] == maxValue) {
            newForms[0][0] += crossOneLeftover;
        } else {
            newForms[2][2] += crossOneLeftover;
        }

        // Cross Two
        int crossTwoLeftover = maxValue - crossTwoTotal;
        if (newForms[0][0] + newForms[0][1] + (newForms[0][2] + crossTwoLeftover) == maxValue && (newForms[0][2] + crossOneLeftover) + newForms[1][2] + newForms[2][2] == maxValue) {
            newForms[0][2] += crossTwoLeftover;
        } else {
            newForms[2][0] += crossTwoLeftover;
        }

        // Vertical
        int verticalLeftOver = maxValue - verticalTotal;
        if (newForms[0][0] + (newForms[0][1] + verticalLeftOver) + newForms[0][2] == maxValue) {
            newForms[0][1] += verticalLeftOver;
        } else {
            newForms[2][1] += verticalLeftOver;
        }

        // Horizontal
        int horizontalLeftOver = maxValue - horizontalTotal;
        if (newForms[0][0] + (newForms[1][0] + horizontalLeftOver) + newForms[2][0] == maxValue) {
            newForms[1][0] += horizontalLeftOver;
        } else {
            newForms[1][2] += horizontalLeftOver;
        }

        int minimumCost = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[i][j] != newForms[i][j]) {
                    minimumCost += Math.abs(s[i][j] - newForms[i][j]);
                }
            }
        }

        return minimumCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
