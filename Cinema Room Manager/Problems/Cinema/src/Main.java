import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        int[][] cinema = new int[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int tickets = scanner.nextInt();
        int output = 0;
        int freeSeats = 0;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (cinema[i][j] == 0) {
                    freeSeats++;
                    if (freeSeats == tickets) {
                        flag = true;
                        output = i + 1;
                        break;
                    }
                } else {
                    freeSeats = 0;
                }
            }
           if (flag) {
               break;
           }
        }
        System.out.println(output);
    }
}