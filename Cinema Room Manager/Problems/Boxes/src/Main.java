import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        for (int i = 0; i < 6; i++) {
            if (i > 2) {
                box2[i-3] = scanner.nextInt();
            } else {
                box1[i] = scanner.nextInt();
            }
        }
        Arrays.sort(box1);
        Arrays.sort(box2);
        int dimensions1 = 0;
        int dimensions2 = 0;
        for (int i = 0; i < 3; i++) {
            if (box1[i] < box2[i]) {
                dimensions1++;
            } else if ((box1[i] > box2[i])) {
                dimensions2++;
            } else {

                break;
            }
        }
        if (dimensions1 == 3) {
            System.out.println("Box 1 < Box 2");
        } else if (dimensions2 == 3){
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}