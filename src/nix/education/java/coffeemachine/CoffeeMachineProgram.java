package nix.education.java.coffeemachine;

import java.util.Scanner;

enum CoffeeSorts {
    ESPRESSO("1"), LATTE("2"), CAPPUCCINO("3");

    private final String value;

    CoffeeSorts(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

class CoffeeMachineTwo {
    private int moneyHas = 550;
    private int waterHas = 400;
    private int milkHas = 540;
    private int beansHas = 120;
    private int cupsHas = 9;
    final Scanner scan = new Scanner(System.in);

    private void makeEspresso(){
        if (waterHas < 250){
            System.out.println("Sorry, not enough water!\n");
        } else if(beansHas <16) {
            System.out.println("Sorry, not enough beans!\n");
        } else if (cupsHas <1){
            System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making your coffee! (espresso)\n");
            moneyHas += 4;
            waterHas -= 250;
            beansHas -= 16;
            cupsHas -= 1;
        }
    }

    private void makeLatte(){
        if (waterHas < 350){
            System.out.println("Sorry, not enough water!\n");
        } else if(milkHas <75){
            System.out.println("Sorry, not enough milk!\n");
        }else if(beansHas <20) {
            System.out.println("Sorry, not enough beans!\n");
        } else if (cupsHas <1){
            System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making your coffee! (latte)\n");
            moneyHas += 7;
            waterHas -= 350;
            milkHas -= 75;
            beansHas -= 20;
            cupsHas -= 1;
        }
    }

    private void makeCappuccino(){
        if (waterHas < 200){
            System.out.println("Sorry, not enough water!\n");
        } else if (milkHas <100){
            System.out.println("Sorry, not enough milk!\n");
        }else if(beansHas <12) {
            System.out.println("Sorry, not enough beans!\n");
        } else if (cupsHas <1){
            System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making your coffee! (cappuccino)\n");
            moneyHas += 6;
            waterHas -= 200;
            milkHas -= 100;
            beansHas -= 12;
            cupsHas -= 1;
        }
    }

    private void fill(){
        System.out.println("Write how many ml of water you want to add:");
        int plusWater = scan.nextInt();
        waterHas += plusWater;
        System.out.println("Write how many ml of milk you want to add:");
        int plusMilk = scan.nextInt();
        milkHas += plusMilk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int plusBeans = scan.nextInt();
        beansHas += plusBeans;
        System.out.println("Write how many disposable coffee cups you want to add:");
        int plusCups = scan.nextInt();
        cupsHas += plusCups;
    }

    private void take(){
        System.out.println("\nI gave you " + moneyHas + "\n");
        moneyHas -= moneyHas;
    }

    private void remaining(){
        System.out.println("\nThe coffee machine has: \n" +
                waterHas +  " of water\n" +
                milkHas + " of milk\n" +
                beansHas + " of coffee beans\n" +
                cupsHas + " of disposable cups\n" +
                moneyHas + " of money\n");
    }

    public final void coffeeMachineOn(){
        CoffeeMachineTwo argo = new CoffeeMachineTwo();
        boolean a = true;
        String espresso, latte, cappuccino;

        espresso = CoffeeSorts.ESPRESSO.getValue();
        latte = CoffeeSorts.LATTE.getValue();
        cappuccino = CoffeeSorts.CAPPUCCINO.getValue();

        while(a) {
            System.out.println("\nWrite action(buy,fill,take,remaining,exit):");
            String checkChoice = scan.next();

            switch (checkChoice) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String checkChoiceDrinks = scan.next();
                    if (checkChoiceDrinks.equals(espresso)){
                        argo.makeEspresso();
                        break;
                    } else if (checkChoiceDrinks.equals(latte)){
                        argo.makeLatte();
                        break;
                    } else if (checkChoiceDrinks.equals(cappuccino)){
                        argo.makeCappuccino();
                        break ;
                    } else if (checkChoiceDrinks.equals("back")){
                        break;
                    } else {continue;}
                case "fill":
                    argo.fill();
                    break;
                case "take":
                    argo.take();
                    break;
                case "remaining":
                    argo.remaining();
                    break;
                case "exit":
                    a = false;
                default:
                    continue;
            }
        }
    }

}

public class CoffeeMachineProgram {
    public static void main(String[] args) {
        CoffeeMachineTwo coffeeMachine = new CoffeeMachineTwo();
        coffeeMachine.coffeeMachineOn();
    }
}