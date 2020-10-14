import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sana Eneroth Boukchana
 * Date: 2020-10-13
 * Time: 20:05
 * Project: BestGymEver
 * Copyright: MIT
 */
class RegistryTest {

    private Registry registry;

    @BeforeEach
    void setUp() {
        registry = new Registry();
    }

    @Test
    void testIsPersonCostumer() {
        LocalDate date = LocalDate.now();
        Customer customer = new Customer("", date, "");
        Customer notCustomer = new Customer("", date, "");
        registry.addCustomer(customer);

        assertTrue(registry.isPersonCostumer(customer));
        assertFalse(registry.isPersonCostumer(notCustomer));
    }

    @Test
    void testHasCustomerPayed() {
        LocalDate date = LocalDate.now();
        Customer paidCustomer = new Customer("", date, "");
        Customer notCustomer = new Customer("", date.minusYears(2), "");
        registry.addCustomer(paidCustomer);
        registry.addCustomer(notCustomer);

        assertTrue(registry.hasCustomerPayed(paidCustomer));
        assertFalse(registry.hasCustomerPayed(notCustomer));
    }

    @Test
    void testAddCustomer() {
        LocalDate date = LocalDate.now();
        Customer customer = new Customer("", date, "");

        assertFalse(registry.isPersonCostumer(customer));

        registry.addCustomer(customer);

        assertTrue(registry.isPersonCostumer(customer));
    }

    @Test
    void testPersonWithPersonalNumberIsCustomer() {
        String personalNumber = "9901021234";
        Customer customer = new Customer(personalNumber, LocalDate.now(), "Test Usher");
        registry.addCustomer(customer);

        assertTrue(registry.isPersonalNumberCostumer(personalNumber));
    }

    @Test
    void testFindCustomer() {
        String personalNumber = "5607021234";
        String customerName = "Anna Usher";
        Customer customer = new Customer(personalNumber, LocalDate.now(), customerName);
        registry.addCustomer(customer);

        assertNotNull(registry.findCustomer(personalNumber));
        assertNotNull(registry.findCustomer(customerName));
    }
}