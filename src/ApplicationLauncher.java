import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by eniakel on 06/08/2015.
 */
public class ApplicationLauncher {
    public static void main (String []args) {

        Item item1 = new Item("Mars", 1.00);
        Item item2 = new Item("Bounty", 1.50);
        Item item3 = new Item("Kitkat", 0.75);

        MachineContents contents = new MachineContents();
        contents.addItem(item1, 10);
        contents.addItem(item2, 5);
        contents.addItem(item3, 1);

        Scanner sc = new Scanner(System.in);
        boolean newItemRequired = true;
        System.out.println("Enter Amount of Money: €");
        double amount = sc.nextDouble();

        while (newItemRequired) {
            System.out.println("Select Product (Mars, Bounty, Kitkat): ");
            String choice = sc.next();

            Iterator it = contents.getItems().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry currentEntry = (Map.Entry) it.next();
                Item item = (Item) currentEntry.getKey();

                if (item.getName().equals(choice) && item.getPrice() <= amount) {
                    Integer quantity = (Integer) currentEntry.getValue();

                    if (quantity >0) {
                        contents.getItems().put(item, Integer.valueOf(quantity - 1));
                        int left = contents.getItems().get(item);
                        System.out.println("Number of " + item.getName() + " left: " + left);
                        amount -= item.getPrice();
                        System.out.printf("The change due is €%.2f.%n", amount);
                    } else {
                        System.out.println("Sorry, there are no " + item.getName() + "'s left.");
                    }

                    System.out.println("Would you like to do another transaction? (yes or no): ");
                    String response = sc.next();

                    if (response.equalsIgnoreCase("no")) {
                        newItemRequired = false;
                        System.out.printf("Change returned is €%.2f%n", amount);
                    };
                }
            }
        }

    }
}
