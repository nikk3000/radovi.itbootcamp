package zadaci;

import java.util.Scanner;

public class Zadatak4 {

    public static void main(String[] args) {
        //Istampati sve samoglasnike iz proizvoljnog stringa.
        Scanner scanner = new Scanner(System.in);
        int vowels = 0;
        System.out.println("Unesite string: ");
        String string = scanner.nextLine().toLowerCase();


        for(int i = 0; i < string.length(); i++ ){
            char vowelsChar = string.charAt(i);
            if(vowelsChar == 'a' || vowelsChar == 'e' || vowelsChar == 'i' || vowelsChar == 'o' || vowelsChar == 'u'){
                System.out.println(vowelsChar + " , " + i);
                vowels++;
            }
        }



    }
}
