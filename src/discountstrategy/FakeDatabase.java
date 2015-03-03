package discountstrategy;

/**
 * This class represents a database that stores information about customers and products in two arrays.
 * It provides a way to search the arrays for matching items.
 * 
 *
 */

/**
 * 
 * @author Dan
 */


public class FakeDatabase implements DataAccessStrategy {

    private DiscountStrategy percentOffDiscount = new PercentOffDiscount();
    private DiscountStrategy quantityDiscount = new ProductQuantityDiscount();

    private Product[] products = {
        new Product("878841132", "LEVI JEANS      ", 45.99, percentOffDiscount),
        new Product("133562060", "BROWN UGG FUR BOOTS", 69.99, percentOffDiscount),
        new Product("009270653", "1 PAIR OF SOCKS   ", 1.99, percentOffDiscount),
        new Product("008498255", "COLEMAN HIKING BOOTS", 41.99, percentOffDiscount),
        new Product("001357375", "4 PACK OF SOCKS  ", 2.99, quantityDiscount)
    };

    private  Customer[] customers = {
        new Customer("00000001", "Daniel Buchwald         "),
        new Customer("00000002", "Morgan Buchwald          "),};

    /**
     * 
     * @param productCode
     * @return 
     */
    @Override
    public final Product productSearch(String productCode) {
        if (productCode == null || productCode.isEmpty()) {
            throw new IllegalArgumentException(ApplicationConstants.PRODUCT_CODE_ERROR);
        }
        Product searchResult = null;
        for (Product product : products) {
            if (productCode.equals(product.getProductCode())) {
                searchResult = product;
                break;
            }
        }
        if (searchResult == null) {
            throw new IllegalArgumentException(ApplicationConstants.NULL_SEARCH);
        }
        return searchResult;
    }

   /**
    * 
    * @param customerNumber
    * @return 
    */
    @Override
    public final Customer customerSearch(String customerNumber) {
        if (customerNumber == null || customerNumber.isEmpty()) {
            throw new IllegalArgumentException(ApplicationConstants.CUSTOMER_NUMBER_ERROR);
        }
        Customer searchResult = null;
        for (Customer customer : customers) {
            if (customerNumber.equals(customer.getCustomerNumber())) {
                searchResult = customer;
                break;
            }
        }
        if (searchResult == null) {
            throw new IllegalArgumentException(ApplicationConstants.NULL_SEARCH);
        }
        return searchResult;
    }
}
