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
    }
}
