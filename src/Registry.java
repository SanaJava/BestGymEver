import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * Created by Sana Eneroth Boukchana
 * Date: 2020-10-12
 * Time: 13:36
 * Project: BestGymEver
 * Copyright: MIT
 */
public class Registry {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public boolean isPersonCostumer(Customer customer) {
        return customers.contains(customer);
    }

    public boolean hasCustomerPayed(Customer customer) {
        Period period = Period.between(customer.getAnnualFeeDate(), LocalDate.now());
        return period.getYears() < 1;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public boolean isPersonalNumberCostumer(String personalNumber) {
        for (Customer customer : customers) {
            if (customer.getPersonalNumber().equals(personalNumber)) {
                return true;
            }
        }
        return false;
    }

    public Customer findCustomer(String identifier) {
        for (Customer customer : customers) {
            if (customer.getPersonalNumber().equals(identifier)) {
                return customer;
            } else if (customer.getCustomerName().equals(identifier)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomerToPTList(Customer customer) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter("personaltrainer.txt", true)))) {

            String output = customer.getPersonalNumber() + " "
                    + customer.getCustomerName() + " "
                    + LocalDate.now();

            printWriter.printf("%s\r\n", output);
        }
    }

    public void addProgressBar() {
        for (int i = 0; i <= 100; i++) {
            System.out.print("Loading file: " + i + "% " + "\r");

            try {
                Thread.sleep(13);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Loading file: Loading completed");
    }
}