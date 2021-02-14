import java.util.*;

/**
 * @author Tyler Holley
 * @version October 25, 2020
 */
public class Driver {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();

        Item a = new Item("Lucky Charms", 4.98);
        Item b = new Item("Milk 2%", 2.94);
        Item c = new Item("Goldfish", 6.28);
        cart.add(a);
        cart.add(b);
        cart.add(c);

        Transaction purchase = new Transaction(cart);
        purchase.printReceipt();
    }
}
