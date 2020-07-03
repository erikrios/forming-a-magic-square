import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int[][][] magicSquares = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        List<Integer> totals = new ArrayList<>();

        for (int[][] magicSquare : magicSquares) {
            int total = 0;

            for (int i = 0; i < magicSquare.length; i++) {
                int[] magicSquareRow = magicSquare[i];
                int[] sRow = s[i];

                for (int j = 0; j < magicSquareRow.length; j++) {
                    int magicSquareRowItem = magicSquareRow[j];
                    int sRowItem = sRow[j];
                    if (magicSquareRowItem != sRowItem) {
                        total += Math.abs(sRowItem - magicSquareRowItem);
                    }
                }
            }

            totals.add(total);
        }

        int minimumValue = Integer.MAX_VALUE;

        for (int total : totals) {
            if (total < minimumValue) {
                minimumValue = total;
            }
        }

        return minimumValue;
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
