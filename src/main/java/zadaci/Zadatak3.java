package zadaci;

import java.util.Scanner;

public class Zadatak3 {
    public static void main(String[] args) {
        //Pomnoziti dva broja putem while petlje  tako da se obrati paznja na mnozenje negativnih brojeva.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite prvi broj: ");
        int a = scanner.nextInt();

        System.out.println("Unesite drugi broj: ");
        int b = scanner.nextInt();

        int proizvod = 0;

        String kraj = scanner.nextLine();

        while (a != 0) {
            proizvod = proizvod + b;
            a--;
        }
        System.out.println("Vas proizvod je " + proizvod + ".");
}
}
