import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String arraystr = scanner.nextLine();
        int[] array = new int[length];

        int sequenceLength = 1;
        int highest = 1;
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int j = 0; j < length - 1; j++){
            if (array[j] <= array[j+1]) {
                sequenceLength++;
            } else {
                if (highest < sequenceLength) {
                    highest = sequenceLength;
                }
                sequenceLength = 1;

            }
        }
        if (sequenceLength > highest) {
            highest = sequenceLength;
        }
        System.out.println(highest);
    }
}