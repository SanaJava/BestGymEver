import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Sana Eneroth Boukchana
 * Date: 2020-10-12
 * Time: 13:36
 * Project: BestGymEver
 * Copyright: MIT
 */

public class Registry {

    private ArrayList<Customer> customers = new ArrayList<>();


    public Registry() {

    }

    public boolean isPersonCostumer(Customer customer) {

        return customers.contains(customer);
    }

    public boolean hasCustomerPayed(Customer customer) {

        Period period = Period.between(customer.getAnnualFeeDate(), LocalDate.now());
        return period.getYears() <= 1;
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

        PrintWriter printWriter = new PrintWriter(
                new BufferedWriter(new FileWriter("personaltrainer.txt",true)));
        try {
            String toList = customer.getPersonalNumber() + " "
                    + customer.getCustomerName() + " "
                    + LocalDate.now() + " "
                    + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

            printWriter.printf("%s\r\n", toList);

        } finally {
            printWriter.flush();
            printWriter.close();
        }

    }


}




/*
    public Customer findCustomerByName(String costumerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(costumerName)) {
                return customer;
            }
        }
        return null;
    }

 */

