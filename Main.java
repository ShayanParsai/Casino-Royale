package com.company;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    static double D6(double min, double max){
        double x = (int)(Math.random()*((6-1))+min);
        return x;
    }
    static double D12(double min, double max){
        double x = (int)(Math.random()*((12-1))+min);
        return x;
    }

    public static void main(String[] args) {

        System.out.println("-----------------------------");

        Scanner Namn = new Scanner(System.in);
        System.out.print("Your name: ");
        String NamN = Namn.next();

        Scanner Ålder = new Scanner(System.in);
        System.out.print("Your age: ");
        int ÅldeR = Namn.nextInt();

        int loop = 1;
        System.out.println("-----------------------------");
        System.out.println("Welcome "+NamN+" to Shayans program!");

        while (loop == 1) {

            System.out.println("-----------------------------");
            System.out.println("[1] Roll dice with 6 figures");
            System.out.println("[2] Roll dice with 12 figures");
            System.out.println("[3] Your current date and time");
            System.out.println("[4] How old am i in 20 years?");
            System.out.println("[5] Exit");

            Scanner Menyval = new Scanner(System.in);
            System.out.print("Menyval: ");
            int i = Menyval.nextInt();

            switch (i){
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("You rolled "+D6(1,6));
                    break;


                case 2:
                    System.out.println("-----------------------------");
                    System.out.println("You rolled "+D12(6,6));
                    break;


                case 3:
                    System.out.println("-----------------------------");
                    DateTimeFormatter Datum = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    System.out.println(Datum.format(now));
                    break;


                case 4:
                    System.out.println("-----------------------------");
                    System.out.println("You will be "+(ÅldeR + 20)+" in 20 years");
                    break;


                case 5:
                    System.out.println("-----------------------------");
                    System.out.println("Thank you "+NamN+" for using my program");
                    loop++;
                    break;


                default:
                    System.out.println("-----------------------------");
                    System.out.println("You can only choose between 1-5");
                    break;
            }
        }
    }
}
