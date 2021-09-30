import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int iter = 0;
        for (int var : array) {
            if (var == n) {
                iter++;
            }
        }
        System.out.println(iter);
    }
}