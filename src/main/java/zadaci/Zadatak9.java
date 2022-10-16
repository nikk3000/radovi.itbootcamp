package zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class Zadatak9 {
    public static void main(String[] args) {
        // Obrisite dva elementa iz niza

        Scanner s = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");
        int n = s.nextInt();
        int[] array = new int[n];


        for (int i = 0; i < n; i++) {
            System.out.print("Unesite " + (i + 1) + " broj niza: ");
            array[i] = s.nextInt();
        }

        System.out.println("Vas niz je: " + Arrays.toString(array));

        System.out.println("Unesite prvi index: ");
        int a = s.nextInt();
        System.out.println("Unesite drugi index: ");
        int b = s.nextInt();

        int[] arrayCut = new int[array.length];
        int cutVar = 0;
        for (int i = 0; i < array.length; i++){
            if (i != a && i != b){
                arrayCut[cutVar] = array [i];
                cutVar++;
            }
        }

        int [] arrayCutTrim = new int[cutVar];
                for(int i = 0; i < cutVar; i++){
                    arrayCutTrim [i] = arrayCut[i];
                }
        System.out.println(Arrays.toString(arrayCutTrim));
        }
    }



