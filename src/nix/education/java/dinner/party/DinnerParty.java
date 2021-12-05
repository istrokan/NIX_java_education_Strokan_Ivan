package nix.education.java.dinner.party;

import java.util.*;

public class DinnerParty {
    private final Scanner scanner = new Scanner(System.in);
    private Map<String, String> people = new LinkedHashMap<>();

    private void addPeople(int counter) {
        while (counter != 0) {
            String human = scanner.next();
            people.put(human, "0");
            counter--;
        }
    }

    private void countTotalAmount(int howPeople, float receipt) {
        receipt = receipt / howPeople;
        for (var entry : people.entrySet()) {
            people.put(entry.getKey(), String.format("%.2f", receipt));
        }
    }

    private void getLucky(int p, float r) {
        System.out.println("Do you want to use the \"Who is lucky?\" feature? Write Yes/No:");
        String needLucky = scanner.next();
        if (needLucky.equals("Yes")) {
            Set<String> keys = people.keySet();
            List<String> keysList = new ArrayList<>(keys);
            int randIdx = new Random().nextInt(keysList.size());
            String lucky = keysList.get(randIdx);
            System.out.println(lucky + " is lucky!");
            deleteLucky(lucky, p, r);
        } else if (needLucky.equals("No")) {
            System.out.println("No one is going to be lucky");
        } else {
            getLucky(p, r);
        }
    }

    private void deleteLucky(String l, int p, float r) {
        countTotalAmount(p - 1, r);
        people.replace(l, "0");
    }

    private void createList() {
        System.out.println("Enter the number of friends joining (including you):");
        int howPeople = scanner.nextInt();
        if (howPeople <= 0) {
            System.out.println("No one is joining for the party");
        } else {
            System.out.println("Enter the name of every friend (including you), each on a new line:");
            addPeople(howPeople);
            System.out.println("Enter the total amount:");
            float receipt = scanner.nextInt();
            countTotalAmount(howPeople, receipt);
            getLucky(howPeople, receipt);
            System.out.println(people);
        }
    }

    public static void main(String[] args) {
        DinnerParty party = new DinnerParty();
        party.createList();
    }
}
