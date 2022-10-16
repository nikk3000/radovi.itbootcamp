package zadaci;
//1. Napisati program sa metodama za:
//1.1 Metoda za unos imena(String element) i ispis niz-a svih elemenata nakon sto se unesu
//Unos: Marko
//Unos: Jelena
//Unos: Dejan
//Ispis: Marko, Jelena, Dejan
//1.2 Metoda koja pronalazi uniju elemenata neka dva niza i ispisuje tu uniju kao treci niz
//Unos: Marko, Jelena, Nikola
//Unos: Milan, Jelena, Nikola
//Ispis: Marko, Jelena, Nikola, Milan

import java.util.Arrays;
import java.util.Scanner;

public class Zadatak12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] names1 = new String[3];

        System.out.println("Unesite imena: ");

        for (int i = 0; i < names1.length; i++) {
            names1[i] = s.next();
            System.out.println("Unesite sledece ime: ");
        }
        System.out.println("Uneta imena su: " + Arrays.toString(names1));

        String[] names2 = new String[3];

        System.out.println("Unesite imena: ");

        for (int i = 0; i < names2.length; i++) {
            names2[i] = s.next();
            System.out.println("Unesite sledece ime: ");
        }
        System.out.println("Uneta imena su: " + Arrays.toString(names2));


        String[] allNames = namesCombined(names1, names2);
        String[] disNames = distinct(allNames);

        System.out.println(Arrays.toString(disNames));


    }
    // region Spajanje stringova
    public static String[] namesCombined(String[] names1, String[] names2) {

        int n = names1.length + names2.length;
        String[] allNames = new String[n];
        int k = 0;

        for (int i = 0; i < names1.length ; i++) {
            allNames[k] = names1[i];
            k++;
        }

        for (int j = 0; j < names2.length; j++){
            allNames[k] = names2[j];
            k++;
        }

        return allNames;
        }
    // endregion

    // region Provera duplikata
    public static String [] distinct(String [] allNames){

        int l = allNames.length;
        String [] disNames = new String[l];
        int k = 0;

        for (int i =0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (allNames[i] == allNames[j]) {
                    l -=1;
                    k++;
                    }
                disNames[i] = allNames[i];
            }
            }



        return disNames;
    }
    //endregion

// ne radi kako treba, znam da sam blizu po logici, ali ne znam kako da ga zavrsim
// ostavio sam ovako da bi mogla da se vidi logika, cenio bih jako neki direktan feedback kako ovo moze da proradi
// znam da je sve ovo moglo da se odradi mnogo lakse us hash, ali nisam hteo da koristim jer ga nismo radili

}










