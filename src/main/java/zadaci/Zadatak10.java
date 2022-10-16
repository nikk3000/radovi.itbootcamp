package zadaci;

import java.util.Scanner;

public class Zadatak10 {
    //1.Uneti broj ciji faktorijal zelite da izracunate (5! = 5 * 4 * 3 * 2 * 1).
    //Unos: 5
    //Ispis: 120
    //Ps: napravio sam prvobitnu gresku i stavio umesto *, +; Prihvaticu i odgovore zadataka sa +.

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Unesite broj ciji faktorijal zelite da izracunate: ");
        int num = s.nextInt();

        System.out.println("Faktorijal vaseg broja je: " + factorial(num));


    }

    public static int factorial(int num){

        int numFact = 1; // za sabiranje bi numFact = 0
        for(int  i = 1; i <= num; i++){ // za sabiranje i moze da ostane 1, a moze i da bude 0
            numFact *= i; // formula za sabiranje bi bila numFact += 1
        }
        return numFact;


    }
}
