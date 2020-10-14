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
            if (customer.getPersonalNumber().equals(identifier)){
                return customer;
            } else if (customer.getCustomerName().equals(identifier)){
                return customer;
            }
        }

        return null;

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
}
