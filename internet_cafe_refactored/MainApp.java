package internet_cafe_refactored;

import javax.xml.namespace.QName;
import java.util.Scanner;

/**
 * Main class to launch the Internet Cafe program
 *
 * @author alfhy
 * @version 1.0
 */

public class MainApp {

    /**
     * Creates a sample customer with this information:
     * customer name = Hapis
     * bundle = Paket Hikki (10 jam)
     * seat number = PC-12
     * price = 15000
     *
     * @param args for arguments (only for main class)
     */
    public static void main(String[] args) { //move members
        Scanner sc = new Scanner(System.in);

        System.out.println("input name: ");
        String name = sc.nextLine();

        InternetCafe customer = new InternetCafe(name, "Paket Hikki (10 jam)", "PC-12", 15000);

        customer.adBil(5000);
        customer.orderFood("Instant Noodles", 10000);
        customer.orderFood("Caffe Latte", 8000);
        customer.memberInfo();
    }
}
