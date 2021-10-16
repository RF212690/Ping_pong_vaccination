package com.company;

import java.util.Scanner;
import java.util.Random;

//infected people=2; vaccinated people=1;normal people=0; dead people=3;almost infected people=4;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("How many people?");
        int Maxpeople = input.nextInt();
        int[] people = new int[Maxpeople];
        System.out.println("How many are vaccinated?");
        int vaccinated = input.nextInt();
        while (vaccinated >= Maxpeople) {
            System.out.println("Insert a value less than the amount of people");
            vaccinated = input.nextInt();
        }
        System.out.println("How many start infected?");
        int infected = input.nextInt();
        while (vaccinated + infected >= Maxpeople) {
            System.out.println("The amount of vaccinated and infected people is bigger than the amount of people in the" +
                    " simulation," +
                    " insert a lower value for the infected people");
            infected = input.nextInt();
        }
        int infect_result = infected;
        System.out.println("How many rounds?");
        int rounds = input.nextInt();
        for (int i = 0; i < infected + vaccinated; i++) {
            people[i]++;
        }
        for (int i = 0; i < infected; i++) {
            people[i]++;
        }
        for (int i = 0; i < rounds; i++) {

            for (int n = 0; n < Maxpeople; n++) {
                if (people[n] == 2) {
                    int first = random.nextInt(Maxpeople);
                    if (people[first] == 0) {
                        people[first] = 4;
                        infect_result++;
                    }
                    int second = random.nextInt(Maxpeople);
                    if (people[second] == 0) {
                        people[second] = 4;
                        infect_result++;
                    }
                }
                if (people[n] == 4) {
                    people[n] = 2;
                }
                else if(people[n]==2){
                    people[n]++;
                }
            }
        }
        System.out.println(infect_result +" people were infected");


    }
}