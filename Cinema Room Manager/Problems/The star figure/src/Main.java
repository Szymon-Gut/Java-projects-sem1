import java.util.Scanner;
class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[][] array = new int[n][n];
       for (int i = 0; i < n; i++) {

           for (int j = 0; j < n; j++) {
               if (j == (n / 2)) {
                   System.out.print("* ");
               }
               else if (i == n / 2) {
                   System.out.print("* ");
               }
               else if (i == j) {
                   System.out.print("* ");
               }
               else if (n - i - 1== j) {
                   System.out.print("* ");
               }
               else {
                   System.out.print(". ");
               }
           }
           System.out.println(" ");
       }
    }
}