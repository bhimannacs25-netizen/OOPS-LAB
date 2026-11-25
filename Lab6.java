
import java.util.InputMismatchException;
import java.util.Scanner;

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

class Reservation {
    boolean[] seats = new boolean[11];

    void reserveSeat(int seatNumber) throws SeatAlreadyBookedException, IllegalArgumentException {
        if (seatNumber < 1 || seatNumber > 10) {
            throw new IllegalArgumentException("Invalid Seat Number!");
        }
        if (seats[seatNumber]) {
            throw new SeatAlreadyBookedException("Seat already booked!");
        }
        seats[seatNumber] = true;
        System.out.println("Seat " + seatNumber + " successfully reserved.");
    }
}

public class Lab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reservation system = new Reservation();

        try {
            System.out.print("Enter seat number (1-10): ");
            int seat = sc.nextInt();
            system.reserveSeat(seat);
        } catch (InputMismatchException e) {
            System.out.println("Error: Enter numerical values only.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction finalized.");
            sc.close();
        }
    }
}
