package internet_cafe_refactored;

import java.util.ArrayList;
import java.util.List;

/**
 * InternetCafe.java is where the whole functions located, like food order, payment, or customer session.
 *
 * @author alfhy
 * @version 1.0
 */

public class InternetCafe implements customerAction {

    /**
     * The PPN (Pajak Pertambahan Nilai) tax rate applied to base prices.
     * Currently set at 15% (0.15).
     */
    public static final double PPN = 0.15;

    /** The name of the customer using the internet cafe service */
    private String customerName;

    /** The selected bundle package (e.g., "Paket Hikki (10 jam)") */
    private String bundle;

    /** The assigned seat number for the customer (e.g., "PC-12") */
    private String seatNumber;

    /** The base price of the selected bundle before taxes */
    private double price;

    /** List of food orders made by the customer with their prices */
    private List<String> foodOrders = new ArrayList<>();

    /** The accumulated total of all food order prices */
    private double totalExtra = 0;

    /** Additional billing charges added to the customer's account */
    private double addBilling = 0;

    /**
     * Constructs a new InternetCafe instance with customer and bundle information.
     *
     * @param customerName the name of the customer
     * @param bundle the selected internet bundle package
     * @param seatNumber the assigned seat/PC number
     * @param price the base price of the bundle before tax
     */
    public InternetCafe(String customerName, String bundle, String seatNumber, double price) { // Encapsulate Field
        this.customerName = customerName;
        this.bundle = bundle;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    /**
     * Calculates the total amount to be paid by the customer.
     *
     * The calculation includes:
     *   Base price with 15% PPN tax
     *   Total from food orders
     *   Additional billing charges
     *
     * @return the total amount to be paid
     */
    public double calculateTotal() {
        double baseWithTax = getPrice() + (getPrice() * 0.15);
        return baseWithTax + getTotalExtra() + getAddBilling();
    }

    /**
     * Displays complete billing information for the customer.
     *
     * This method prints out:
     *   Seat number and username
     *   Selected bundle and base price with PPN
     *   All food orders (if any)
     *   Additional billing charges
     *   Total amount to pay
     */
    public void memberInfo() {
        System.out.println("=== Internet Café Billing ===");
        System.out.println("Seat number: " + getSeatNumber());
        System.out.println("Username: " + getCustomerName());
        System.out.println("Selected Bundle: " + getBundle());
        System.out.println("Base Price + PPN 15%: " + priceCalculation()); //add constant + introduce method
        System.out.println("\n--- Food Orders ---");

        if (getFoodOrders().isEmpty()) {
            System.out.println("No food ordered.");
        } else {
            for (String order : getFoodOrders()) {
                System.out.println(order);
            }
        }

        System.out.println("\nAdditional Billing: Rp" + getAddBilling());
        System.out.println("Total to Pay: Rp" + calculateTotal());
    }

    /**
     * Calculates the base price including PPN tax.
     *
     * @return the base price plus 15% PPN tax
     */
    private double priceCalculation() {
        return getPrice() + (getPrice() * PPN);
    }

    /**
     * Adds an additional billing charge to the customer's account.
     *
     * This can be used for penalties, extra services, or other charges
     * not included in the base bundle or food orders.
     *
     * @param bil the additional billing amount to add
     */
    public void adBil(float bil) {
        addBilling = getAddBilling() + bil;
        System.out.println();
        System.out.println("Added extra billing: Rp" + bil);
    }

    /**
     * Records a food order for the customer.
     *
     * This method implements the customerAction interface.
     * It adds the food item to the order list and accumulates the price
     * to the total extra charges.
     *
     * @param item the name of the food item ordered
     * @param price the price of the food item
     */
    @Override
    public void orderFood(String item, float price) { //extract interface
        getFoodOrders().add(item + " (Rp" + price + ")");
        totalExtra = getTotalExtra() + price;
        System.out.println(getCustomerName() + " ordered: " + item + " for Rp" + price);
    }

    /**
     * Gets the customer's name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Gets the selected bundle package.
     *
     * @return the bundle name and description
     */
    public String getBundle() {
        return bundle;
    }

    /**
     * Gets the assigned seat number.
     *
     * @return the seat/PC number
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Gets the base price of the bundle before tax.
     *
     * @return the base bundle price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the list of all food orders made by the customer.
     *
     * @return list of food order strings with prices
     */
    public List<String> getFoodOrders() {
        return foodOrders;
    }

    /**
     * Gets the total amount from all food orders.
     *
     * @return the accumulated food order total
     */
    public double getTotalExtra() {
        return totalExtra;
    }

    /**
     * Gets the additional billing charges.
     *
     * @return the accumulated additional billing amount
     */
    public double getAddBilling() {
        return addBilling;
    }
}
