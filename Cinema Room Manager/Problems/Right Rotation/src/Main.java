import java.util.Arrays;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int n = scanner.nextInt();
        int rotation = n % array.length;
        int iter = 0;
        String[] arrayRotated = new String[array.length];
        for (int i = 0; i < array.length - rotation; i++) {
            arrayRotated[rotation + i] = array[i];
        }
        for (int j = array.length - rotation; j < array.length; j++) {
            arrayRotated[iter] = array[j];
            iter++;
        }
        String returned = Arrays.toString(arrayRotated);
        String withoutCommas = returned.replace(",", "");
        String withoutLeftBrace = withoutCommas.replace("[", "");
        String withoutRightBrace =  withoutLeftBrace.replace("]","");
        System.out.println(withoutRightBrace);
    }

}