import java.io.*;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Sana Eneroth Boukchana
 * Date: 2020-10-12
 * Time: 12:41
 * Project: BestGymEver
 * Copyright: MIT
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Registry registry = new Registry();

        try (Scanner fileScanner = new Scanner(new File("customers.txt")).useDelimiter("[,\n]")) {
            while (fileScanner.hasNext()) {
                String personalNumber = fileScanner.next();
                String name = fileScanner.next().trim();
                String date = fileScanner.next().trim();

                Customer customer = new Customer(personalNumber, LocalDate.parse(date), name);

                registry.addCustomer(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (NoSuchElementException e) {
            registry.addProgressBar();
        }

        while (true) {
            System.out.println("Enter the full name or personal number of the person (or exit to quit): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Stay safe and wash your hands \u2661");
                break;
            }
            Customer customer = registry.findCustomer(input);

            if (customer != null) {
                if (registry.hasCustomerPayed(customer)) {
                    System.out.println("Membership for " + customer.getCustomerName() + " is active!\n");
                    try {
                        registry.addCustomerToPTList(customer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Access denied for "
                            + customer.getCustomerName() + ", the membership expired at "
                            + customer.getAnnualFeeDate().plusYears(1)+"\n");
                }
            } else {
                System.out.println("WARNING! Membership has never existed.\n");
            }
        }
    }
}
