package zadaci;

import java.util.Scanner;

public class Zadatak5 {

    public static void main(String[] args) {
        //Uneti string "ITBootCamp" i stampati sve karaktere osim slova C. (Obratiti paznju na velicinu fonta)

        //resenje 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite adekvatni string: ");
        String input = scanner.nextLine();
        int charCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char charC = input.charAt(charCount);

            if (charC == 'C' && charCount == 6) {
                charCount++;
                continue;
            }

            if (charC != 'C' && charCount != 6) {
                System.out.println(charC);
                charCount++;
            }

            //resenje 2 - samo sa while, iste definicije vrednosti

            /*while(charCount < input.length()){
                char charC = input.charAt(charCount);

                if (charC == 'C' && charCount == 6) {
                    charCount++;
                    continue;
                }

                if(charC != 'C'&& charCount != 6){
                    System.out.println(charC);
                    charCount++;
                }
            }

        }*/

        }
    }
}