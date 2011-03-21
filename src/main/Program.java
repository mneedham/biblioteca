package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;// package com.thoughtworks.biblioteca;

public class Program {
    public static void main(String[] args) {
        while (true) {
            System.out.println("**********************************************************");
            System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
            System.out.println("**********************************************************");
            System.out.println("*                Menu                                    *");
            System.out.println("*         =====================                          *");
            System.out.println("*         1. List Book Catalog                           *");
            System.out.println("*         2. Check out Book                              *");
            System.out.println("*         3. Check Library Number                        *");
            System.out.println("*         9. Exit                                        *");
            System.out.println("**********************************************************");
            System.out.println("Your Selection: ");

            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStream);
            int i1 = 0;
            try {
                String value = reader.readLine();
                i1 = Integer.parseInt(value);
            } catch (Exception e) {
                // Do you know what numbers are!!!
                System.out.println("Enter a valid integer!!");
            }

            if (i1 == 1) {
                System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
                System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
                System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
                System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
            } else if (i1 == 2) {
                System.out.println(" Please enter the number of the book you wish to checkout: ");
                int i2 = 0;
                try {
                    i2 = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    // Do you know what numbers are!!!
                    System.out.println("Enter a valid integer!!");

                }
                switch (i2) {
                    case 1:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 3:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 4:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Sorry we don't have that book yet.");
                        break;
                }
            } else if (i1 == 3) {
                System.out.println("\n");
                System.out.println("Please talk to Librarian. Thank you.");
            } else if (i1 == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }

        }
    }
}

