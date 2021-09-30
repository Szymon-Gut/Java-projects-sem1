import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int firstColumn = scanner.nextInt();
        int secondCOlumn = scanner.nextInt();
        int tmp = 0;
        for (int i = 0; i < rows; i++) {
            tmp = array[i][secondCOlumn];
            array[i][secondCOlumn] = array[i][firstColumn];
            array[i][firstColumn] = tmp;
        }
        String b = Arrays.deepToString(array)
                .replace("[", "")
                .replace("]","\n")
                .replace(",","");

        System.out.println(b);
    }
}