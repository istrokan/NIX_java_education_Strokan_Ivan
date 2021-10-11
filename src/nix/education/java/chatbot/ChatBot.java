package nix.education.java.chatbot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String args[]){
        System.out.println("Hello! My name is STR");
        System.out.println("I was created in 2021");
        Scanner s = new Scanner(System.in);
        System.out.println("Please, remind me your name.");
        String yourName = s.nextLine();
        System.out.println("What a great name you have, " + yourName + "!");
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age" +
                "by 3, 5 and 7.");
        int remainder3 = s.nextInt();
        int remainder5 = s.nextInt();
        int remainder7 = s.nextInt();
        int age = (remainder3*70 + remainder5*21 + remainder7*15)%105;
        System.out.println("Your age is " + age + "; that's a good time" +
                "to start programming");
        System.out.println("Now I will prove to you that I can count " +
                "to any number you want.");
        int count = s.nextInt();
        for (int i = 0; i <= count; i++){
            System.out.println(i + " !");
        }
    }
}
