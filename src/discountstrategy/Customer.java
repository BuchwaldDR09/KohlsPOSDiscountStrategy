package discountstrategy;

/**
 * 
 * @author Dan
 */
public class Customer {

    private String customerNumber;
    private String customerName;

    /**
     * 
     * @param customerNumber
     * @param customerName 
     */
    public Customer(String customerNumber, String customerName) {
        setCustomerNumber(customerNumber);
        setCustomerName(customerName);
    }

    /**
     * 
     * @return 
     */
    public final String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * 
     * @return 
     */
    public final String getCustomerName() {
        return customerName;
    }

    /**
     * 
     * @param customerNumber 
     */
    public final void setCustomerNumber(String customerNumber) {
        if (customerNumber == null || customerNumber.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.CUSTOMER_NUMBER_ERROR);
        }
        this.customerNumber = customerNumber;
    }

    /**
     * 
     * @param customerName 
     */
    public final void setCustomerName(String customerName) {
        if (customerName == null || customerName.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.CUSTOMER_NAME_ERROR);
        }
        this.customerName = customerName;
    }

}
