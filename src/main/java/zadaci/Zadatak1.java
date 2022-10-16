package zadaci;

import java.util.Calendar;
import java.util.Scanner;

//Write a program tha determines your position in the company based on the length of your career in years


public class Zadatak1 {
    public static void main(String[] args) {
int year = Calendar.getInstance().get(Calendar.YEAR);
        Scanner starterYear = new Scanner(System.in);
        System.out.println("Enter the year when you started working");
        int yrsOfExperience = year - starterYear.nextInt();
        if(yrsOfExperience <= 0){
            System.out.println("You do not have any work experience yet");
        }else if (yrsOfExperience<=4) {
        System.out.println("You are a Junior programmer");
        }else if (yrsOfExperience<=8) {
            System.out.println("You are a Senior programmer");
        } else{
            System.out.println("You are the company Director");
        }

    }
}