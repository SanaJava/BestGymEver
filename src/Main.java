import java.io.*;
import java.time.LocalDate;
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
        String listMembers;

        Registry registry = new Registry();

        try {
            BufferedReader fileIn = new BufferedReader(new FileReader("customers.txt"));
            while ((listMembers = fileIn.readLine()) != null) {
                int indexOf = listMembers.indexOf(",");
                if (indexOf < 0) {
                    break;
                }

                String personalNumber = listMembers.substring(0, indexOf);//System.out.println(personalNumber);
                String customerName = listMembers.substring(indexOf + 1).trim();//System.out.println(customerName);
                String dateFee = fileIn.readLine();//System.out.println(dateFee);
                LocalDate localDate = LocalDate.parse(dateFee);

                Customer customer = new Customer(personalNumber, localDate, customerName);
                registry.addCustomer(customer);

            }

            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter the full name or personal number of the person: ");
        String input = sc.nextLine();
        Customer customer = registry.findCustomer(input);

        if (customer != null) {
            if (registry.hasCustomerPayed(customer)) {
                System.out.println("Membership for " + customer.getCustomerName() + " is active!\n");

            } else {
                System.out.println("Access denied for "
                        + customer.getCustomerName() + ", the membership expired at "
                        + customer.getAnnualFeeDate().plusYears(1));
            }
        } else {
            System.out.println("Membership is not active");
        }

    }
}
