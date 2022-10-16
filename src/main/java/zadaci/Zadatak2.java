package zadaci;

import java.util.Scanner;

//Write a program that returns your T-shirt size in letters based off of your size in centimeters

public class Zadatak2 {
    public static void main(String[] args) {
        Scanner size = new Scanner(System.in);
        System.out.println("Enter the T-shirt size in cm:");
        switch(size.nextInt()){
            case 24:
                System.out.println("You are size S");
                break;
            case 30:
                System.out.println("You are size M");
                break;
            case 36:
                System.out.println("You are size L");
                break;
            case 42:
                System.out.println("You are size XL");
                break;
            default:
                System.out.println("Invalid size");

        }
    }
}
