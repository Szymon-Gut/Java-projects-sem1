import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] transMatrix = new int[columns][rows];
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++) {
                transMatrix[i][j] = matrix[rows - 1 - j][i];
            }
        }
        String output = Arrays.deepToString(transMatrix)
                .replace("[", "")
                .replace("]","\n")
                .replace(",","");
        System.out.println(output);
    }
}