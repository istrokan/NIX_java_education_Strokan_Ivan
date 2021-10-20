package nix.education.java.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    //Constants and Scanner for 2 and 3 stages
    final Scanner scan = new Scanner(System.in);
    static final int WATER_ML = 200;
    static final int MILK_ML = 50;
    static final int COFFEE_BEANS_G = 15;
    //stage 1 start of methods description
    protected void starting(){
        System.out.println("Starting to make a coffee");
    }

    protected void grinding(){
        System.out.println("Grinding coffee beans");
    }

    protected void boiling(){
        System.out.println("Boiling water");
    }

    protected void mixing(){
        System.out.println("Mixing boiled water with crushed coffee beans");
    }

    protected void pouringCoffee(){
        System.out.println("Pouring coffee into the cup");
    }

    protected void pouringMilk(){
        System.out.println("Pouring some milk into the cup");
    }

    protected void coffeeFinishing(){
        System.out.println("Coffee is ready!");
    }
    //stage 1 end of methods description

    //Stage 2 start of method description
    protected void countCupsOfCoffee(){
        System.out.println("\nWrite how many cups of coffee you will need:");
        int cups = scan.nextInt();
        System.out.println("For " + cups + " cups of coffee you will need:" );
        System.out.println(cups * WATER_ML + " ml of water");
        System.out.println(cups * MILK_ML + " ml of milk");
        System.out.println(cups * COFFEE_BEANS_G + " g of coffee beans");
    }
    //Stage 2 end of method description
    //Stage 3 start of method description
    protected void check(){
        System.out.println("\nWrite how many ml of water the coffee machine has:");
        int mlOfWater = scan.nextInt() / WATER_ML;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int mlOfMilk = scan.nextInt() / MILK_ML;
        System.out.println("Write how many grams of coffee the coffee machine has:");
        int gramsOfBeans = scan.nextInt() / COFFEE_BEANS_G;
        System.out.println("Write how many cups of coffee you will need:");
        int needCupsOfCoffee = scan.nextInt();

        int minCupsOfCoffee = Math.min(mlOfWater, Math.min(mlOfMilk,gramsOfBeans));

        if (minCupsOfCoffee == needCupsOfCoffee )
        {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (minCupsOfCoffee > needCupsOfCoffee ){
            int n = minCupsOfCoffee - needCupsOfCoffee;
            System.out.println("Yes, I can make that amount of coffee (and even " + n + " more than that)");
        } else/* if (minCupsOfCoffee < needCupsOfCoffee) */{
            System.out.println("No, I can make only " + minCupsOfCoffee + " cups of coffee");
        }

    } // Stage 3 end of method description

    public static void main(String[] args){
        CoffeeMachine argo = new CoffeeMachine();
        //stage 1 methods call
        argo.starting();
        argo.grinding();
        argo.boiling();
        argo.mixing();
        argo.pouringCoffee();
        argo.pouringMilk();
        argo.coffeeFinishing();
        //stage 2 method call
        argo.countCupsOfCoffee();
        //stage 3 method call
        argo.check();
    }
}
