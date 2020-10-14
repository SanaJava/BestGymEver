import java.time.LocalDate;

/**
 * Created by Sana Eneroth Boukchana
 * Date: 2020-10-12
 * Time: 13:23
 * Project: BestGymEver
 * Copyright: MIT
 */
public class Customer {

    private String personalNumber;
    private LocalDate annualFeeDate;
    private String customerName;

    public Customer(String personalNumber, LocalDate annualFeeDate, String customerName) {
        this.personalNumber = personalNumber;
        this.annualFeeDate = annualFeeDate;
        this.customerName = customerName;

    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public LocalDate getAnnualFeeDate() {
        return annualFeeDate;
    }

    public void setAnnualFeeDate(LocalDate annualFeeDate) {
        this.annualFeeDate = annualFeeDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
