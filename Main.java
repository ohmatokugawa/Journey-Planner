import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj kod waluty: EUR lub USD \n");
        String kodWaluty = scanner.nextLine().toUpperCase();

        try {
            double mid = API.waluty(kodWaluty);
            System.out.println("Kurs " + kodWaluty + ": " + mid);

            System.out.print("Podaj kwotę w złotówkach: ");
            double kwotaPLN = scanner.nextDouble();

            double wynik = kwotaPLN / mid;
            System.out.println("Podana kwota w " + kodWaluty + ": " + String.format("%.2f", wynik));
        } catch (IOException | InterruptedException e) {
            System.out.println("Wystąpił błąd podczas pobierania kursu: " + e.getMessage());
        }
    }
}
