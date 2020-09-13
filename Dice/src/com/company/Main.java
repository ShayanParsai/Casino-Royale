package com.company;
import java.util.ArrayList;
import java.util.Collections;
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

        ArrayList<Double> SaveD6 = new ArrayList<Double>();
        ArrayList<Double> SaveD12 = new ArrayList<Double>();

        DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("========================");
        LocalDateTime NOW = LocalDateTime.now();
        System.out.println(DATE.format(NOW));
        System.out.println("========================");

        Scanner Namn = new Scanner(System.in);
        System.out.print("Your name: ");
        String NamN = Namn.next();

        int loop = 1;
        Double sum = 0.0;
        System.out.println("========================");
        System.out.println("Welcome "+NamN+" to Shayans program!");

        while (loop == 1) {

            System.out.println("========================");
            System.out.println("[1] Roll dice with 6 figures");
            System.out.println("[2] Roll dice with 12 figures");
            System.out.println("[3] Print out all saved rolls");
            System.out.println("[4] Exit");

            Scanner Menyval = new Scanner(System.in);
            System.out.print("Menyval: ");
            int i = Menyval.nextInt();

            switch (i){

                case 1:  // Rullar tärning med 6 sidor, sparar tärnings rull till ArrayList

                    System.out.println("========================");
                    Double Roll1 = D6(1,6);
                    SaveD6.add(Roll1);
                    System.out.println("You rolled "+ Roll1);
                    break;

                case 2: // Rullar tärning med 12 sidor, sparar tärnings rull till ArrayList

                    System.out.println("========================");
                    Double Roll2 = D12(1,12);
                    SaveD12.add(Roll2);
                    System.out.println("You rolled "+ Roll2);
                    break;

                case 3: // Sorterar båda ArrayList, skriver ut alla sparade tärnings rull i ordning

                    System.out.println("========================");
                    Collections.sort(SaveD6);
                    Collections.sort(SaveD12);
                    System.out.println("All your previous D6 rolls: " + SaveD6);
                    System.out.println("All your previous D12 rolls: " + SaveD12);
                    break;

                case 4: // Exit

                    System.out.println("========================");
                    LocalDateTime NOW1 = LocalDateTime.now();
                    System.out.println(DATE.format(NOW1));
                    System.out.println("========================");
                    System.out.println("Thank you "+NamN+" for using my program");
                    loop++;
                    break;

                default: // Om användaren skriver in ett menyval som inte finns

                    System.out.println("========================");
                    System.out.println("You can only choose between 1-4");
                    break;
            }
        }
    }
}
