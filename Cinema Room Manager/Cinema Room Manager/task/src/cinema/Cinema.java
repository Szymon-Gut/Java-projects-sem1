package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int row = scanner.nextInt();
        System.out.println("Enter the number of seats in each row");
        int seat = scanner.nextInt();
        sala(row,seat,0, 1);
        int price = 0;
        System.out.println("Enter a row number:");
        int seatRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        if (seat * row <= 60) {
            price = 10;
        } else {
            if (seatRow <= (row / 2)) {
                price = 10;
            } else {
                price = 8;
            }
        }

        System.out.println("Ticket price: " + "$" + price);
        sala(row, seat, seatRow, seatNumber);
    }
    public static void sala(int row, int seat, int seatRow, int seatNumber){
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i < seat + 1; i++) {
            System.out.print(i + " ");
        }
        for (int k = 1; k < row + 1; k++) {
            System.out.print("\n");
            System.out.print(k + " ");
            for (int j = 0; j < seat; j++) {
                if (k == seatRow && j == (seatNumber - 1)) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
        }
        System.out.println("");
    }
}