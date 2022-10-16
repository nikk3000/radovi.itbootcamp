package projekat;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ITBootcampProjekat {



    //region task0

    public static int[] arrInt() {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number of integer elements that you want to have in the array: ");
        int n = s.nextInt();

        int [] arrI = new int[n];
        for (int i = 0; i < n; i++){
            System.out.println("Enter the " + (i + 1) + ". element of the array: ");
            arrI[i] = s.nextInt();
        }

        return arrI;
    }

    public static String [] arrStr() {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number of String elements that you want to have in the array: ");
        int n = s.nextInt();

        String [] arrS = new String[n];
        for (int i = 0; i < n; i++){
            System.out.println("Enter the " + (i + 1) + ". element of the array: ");
            arrS[i] = s.next();
        }

        return arrS;
    }

    public static char[] arrChr() {


        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number of character elements that you want to have in the array: ");
        int n = s.nextInt();

        char [] arrC = new char[n];
        for (int i = 0; i < n; i++){
            System.out.println("Enter the " + (i + 1) + ". element of the array: ");
            arrC[i] = s.next().charAt(0);
        }

        return arrC;
    }

    // endregion

    // region task1
    public static int sumOfIndividualNumbers(int n){

        int sum, sum2;

        for (sum = 0; n != 0; n = n / 10){
            sum += n % 10;
        }

        for (sum2 = 0; sum != 0; sum = sum /10){
            sum2 += sum % 10;
        }

        return sum2;
    }
    //endregion

    //region task2
    public static boolean powerOfTheNumber(int n, int m) {

        boolean pow = false;
        int control = 1;

        for (; control < n;) {
            control *= m;
            if(control == n){
                pow = true;
            }
        }
        return pow;
    }
    // endregion

    //region task3

    public static int [] sumOfIndexesInArrayMeta(int [] niz, int meta){

        int [] index = new int[niz.length];
        int k = 0;

        for (int i = 0; i < niz.length ; i++){
            for(int j = i +1 ; j < niz.length; j++){
                if(niz[i] + niz[j] == meta){
                    index[k] = i;
                    index[k+1] = j;
                    k++;
                }
            }
        }
        int[] indexCut = Arrays.copyOf(index, 2);

        return indexCut;
    }


    //endregion

    // region task4

    public static String toBinary(int n){

        String binary = Integer.toBinaryString(Math.abs(n));


        return binary;
    }

    //endregion

    // region task5

    public static int numberOfRepetitions(String s, String recenica){

        String[] split = recenica.split(" ");
        int no = 0;

        for(int  i = 0;  i < split.length; i++){
            if (s.equals(split[i])){
                no++;
            }
        }

        return no;
    }

    //endregion

    //region task6

    public static int[] moveTheZeroes(int[] niz){

        int [] copy = new int[niz.length];

        for(int i = 0, k = 0;  i < niz.length; i++){
            if (niz[i] !=0){
                copy[k] = niz[i];
                k++;
            }

        }
        return copy;

    }

    //endregion

    // region task7

    public static int[] removeTheDuplicates(int[] niz){

        int [] arr = new int[niz.length];
        int k = 0;

        for(int  i = 0; i < niz.length; i++){
            boolean duplicate = false;
            for( int j = i +1 ; j< niz.length; j++){
                if (niz[i] == niz[j]){
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate){
                arr[k] = niz[i];
                k++;
            }
        }
        int [] arrCut = Arrays.copyOf(arr, k);

        return arrCut;
    }

    //endregion

    // region task9

    public static  boolean validatePhone(String num){

        Pattern patternA = Pattern.compile("^(\\d{3})-(\\d{3})-\\d{4}$");
        Matcher matcherA = patternA.matcher(num);

        Pattern patternB = Pattern.compile("^\\(\\d{3}\\)\\s?(\\d{3})-\\d{4}");
        Matcher matcherB = patternB.matcher(num);


        return matcherA.matches() || matcherB.matches();

    }

    //endregion

    // region main
    public static void main(String[] args) {

        System.out.println("Your array of integers is: " + Arrays.toString(arrInt()));
        System.out.println("Your array of Strings is: " + Arrays.toString(arrStr()));
        System.out.println("Your array of characters is: " + Arrays.toString(arrChr()));
        System.out.println(sumOfIndividualNumbers(556));
        System.out.println(powerOfTheNumber(13, 4));
        System.out.println(Arrays.toString(sumOfIndexesInArrayMeta(new int[]{2, 3, 10, -2}, (13))));
        System.out.println(toBinary(14));
        System.out.println(numberOfRepetitions("cao", "cao kako si cao"));
        System.out.println(Arrays.toString(moveTheZeroes(new int [] {1, 0, 0, 2, 3})));
        System.out.println(Arrays.toString(removeTheDuplicates(new int []  {3, 4, 3, 4, 3, 4, 5} )));
        System.out.println(validatePhone("(012) 345-6789"));

    }
    //endregion

}