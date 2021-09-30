import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean value = true;
        String word1 = scanner.next();
        while (scanner.hasNext()) {
            String word2 = scanner.next();
            int comparison = word1.compareTo(word2);
            word1 = word2;
            if (comparison > 0) {
                value = false;
                break;
            }
        }

        System.out.println(value);
    }
}
