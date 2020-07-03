import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int[][] newForms = Arrays.copyOf(s, s.length);

        int crossOneTotal = newForms[0][0] + newForms[1][1] + newForms[2][2];
        int crossTwoTotal = newForms[0][2] + newForms[1][1] + newForms[2][0];
        int verticalTotal = newForms[0][1] + newForms[1][1] + newForms[2][1];
        int horizontalTotal = newForms[1][0] + newForms[1][1] + newForms[1][2];

        // Cross One
        return -1;
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
