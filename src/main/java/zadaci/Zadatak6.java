package zadaci;

import java.util.Scanner;

public class Zadatak6 {
    public static void main(String[] args) {
        /*Napisati pomocu petlje program koji racuna sumu kvadratnih vrednost od 1 2 3 i 5, ako korisnik unese
        0, izlazi iz programa. (Obratiti paznju na negativne brojeve).*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesi neki broj: ");
        int input = Math.abs(scanner.nextInt());
        int sqrSum = 0;

        for(int i = 0 ;i <= input;i++){

            if(true){

                //sqrSum += i * i;
                sqrSum += Math.pow(i, 2);
            }

            if(input == 0){
                break;
            }
        }
        System.out.println("Zbir vasih kvadrata je: " + sqrSum + ".");


    }





}







