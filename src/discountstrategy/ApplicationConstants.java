package discountstrategy;

/**
 * 
 * Used to hold error messages outside of any individual class so they can be called 
 * where ever they are needed.
 * 
 * @author Dan
 */
public class ApplicationConstants {

    public static final int ZERO = 0;
    public static final String CUSTOMER_NUMBER_ERROR = "A customer number is requried.";
    public static final String CUSTOMER_NAME_ERROR = "The customer's name is requried.";
    public static final String PRODUCT_CODE_ERROR = "The product code is requried.";
    public static final String PRODUCT_DESCRIPTION_ERROR = "A product description is requried.";
    public static final String UNIT_PRICE_ERROR = "Unit price cannot be lass than 0.";
    public static final String UNIT_QTY_ERROR = "Purchased quantity must be greater than 0.";
    public static final String INVALLID_DISCOUNT_STRATEGY = "A valid Discount Strategy is requried.";
    public static final String INVALLID_DATABASE = "A valid Product Database is requried.";
    public static final String INVALLID_DATA_ACCESS_STRATEGY = "A valid Data Access Strategy is requried.";
    public static final String INVALLID_LINE_ITEM = "A valid line item is requried.";
    public static final String NULL_SEARCH = "Your search returned no results.";
    
    public static final String RECEIPT_MESSAGE = "Thank you for shopping at Kohls!";
   
    
}
