package zadaci;

import java.util.Arrays;
import java.util.Scanner;

public class Zadatak7 {
    public static void main(String[] args) {
        //Napraviti  program gde cete da unosite imena u neki niz.
        //U istom tom programu dodati ispis za sva slova koja pocinju na 'M'.

        Scanner s = new Scanner(System.in);
        System.out.println("Unesite broj imena koje zelite da unesete u niz: ");
        int n = s.nextInt();
        String [] names = new String[n];

        for (int i = 0 ; i < n ; i++){
            System.out.println("Unesite ime broj " + (i + 1) + " :" );
            names[i] = s.next();

        }
        System.out.println(Arrays.toString(names));

        char searchLetter = 'M';

        String [] searchedNames = new String[names.length];
        int j = 0;
        for (int i = 0; i < names.length; i++){
            if(names[i].toUpperCase().charAt(0) == searchLetter){
                searchedNames[j] = names[i];
                j++;
            }
        }

        String [] searchedNamesTrim = new String[j];
        for (int i = 0; i < j; i++){
            searchedNamesTrim[i] = searchedNames[i];
        }
        System.out.println("Imena koja pocinju na slovo M su: " + Arrays.toString(searchedNamesTrim));





    }
}
