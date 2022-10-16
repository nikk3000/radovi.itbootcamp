package zadaci;

import java.util.Scanner;

public class Zadatak11 {
    //2. Napraviti metod koji ce za dva uneta Stringa proveriti da li su iste velicine, ako su iste velicine,
    //ispisati sve samoglasnike iz oba Stringa.
    //Prvi unos: mama
    //Drugi unos: teta
    //Prvi ispis: Ova dva Stringa su jednaka!
    //Drugi ispis: Samoglasnici su a,a,e,a.

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Unesite prvi string: ");
        String a = s.next();
        System.out.println("Unesite drugi string: ");
        String b = s.next();
        String c = new String();

            if (a.length() == b.length()) {
                c = a.concat(b);

            } else System.out.println("Stringovi nisu iste duzine.");


            System.out.println(vowelsCut(c));

    }

    public static String vowelsCut (String c) {

        StringBuilder vowels = new StringBuilder();
        for(int i = 0; i < c.length(); i++){
            if (c.charAt(i) == 'a' || c.charAt(i) == 'e' || c.charAt(i) == 'i' ||  c.charAt(i) == 'o' ||c.charAt(i) == 'u') {
                vowels.append(c.charAt(i) + " ");
            }
        }
        return String.valueOf(vowels);
    }
}




