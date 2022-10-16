package zadaci;


import java.util.Arrays;
import java.util.Scanner;

public class Zadatak8 {
    public static void main(String[] args) {
        /*1.Napisati program gde unosite velicinu niza, zatim elemente niza, zatim istampati niz u suprotnom redosledu.
        Primer:
        Unos: 1, 2, 3, 4, 5
        Ispis: 5, 4, 3, 2, 1
        2.U prvom programu, nakon sto se obrne redosled, dodati funkcionalnost izbacivanja svih parnih brojeva.
        Unos: 5, 4, 3, 2, 1
        Ispis: 5, 3, 1 */


        // region Unosenje niza

        Scanner s = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int n = s.nextInt();
        int[] array = new int[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Unesite " + (i + 1) + " broj niza: ");
            array[i] = s.nextInt();
        }

        System.out.println("Vas niz je: " + Arrays.toString(array));

        // endregion

        // region Obrtanje niza
        int[] arrayReverse = new int[array.length];
        for (int i = 1, j = 0; i <= array.length; i++) {
            arrayReverse[j++] = array[array.length - i];
        }
        System.out.println("Obrnuti redosled vaseg niza je: " + Arrays.toString(arrayReverse));
        // endregion

        // region Izbacivanje parnih brojeva

        int [] arrayUneven = new int[arrayReverse.length];
        int k = 0;

        for (int i = 0; i < arrayReverse.length; i++) {
            if (arrayReverse[i] % 2 != 0) {
                arrayUneven[k] = arrayReverse[i];
                k++;
            }
        }


        int[] arraysUnevenTrim = new int[k];
        for (int i = 0; i < k ; i++){
            arraysUnevenTrim[i] = arrayUneven[i];

        }
        System.out.println("Neparni brojevi u vasem nizu su: " + Arrays.toString(arraysUnevenTrim));
        }
        //endregion

        }


