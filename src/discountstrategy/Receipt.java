package discountstrategy;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class looks up the customer info by using the customer number.
 * Works with the lineItem array to store items and retrieve totals.
 *
 */
public class Receipt {

    private ReceiptLineItem[] receiptLineItem = new ReceiptLineItem[0];
    private Customer customer;
    private DataAccessStrategy dataAccessStrategy;
    
    
    private NumberFormat numberFormatter = NumberFormat.getCurrencyInstance();

    /**
     *
     * @param customerNumber
     * @param dataAccessStrategy
     */
    public Receipt(String customerNumber, DataAccessStrategy dataAccessStrategy) throws IllegalArgumentException {

        if (customerNumber == null || customerNumber.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.CUSTOMER_NUMBER_ERROR);
        }
        this.customer = dataAccessStrategy.customerSearch(customerNumber);
        if (dataAccessStrategy == null) {
            throw new IllegalArgumentException(ApplicationConstants.INVALLID_DATA_ACCESS_STRATEGY);
        }
        this.dataAccessStrategy = dataAccessStrategy;

    }

    /**
     *
     * @return
     */
    public final ReceiptLineItem[] getReceiptLineItems() {
        return receiptLineItem;
    }

    /**
     *
     * @return
     */
    public final Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param productCode
     * @param quantityPurchased
     */
    public final void addLineItem(String productCode, int quantityPurchased) {
        if (productCode == null || productCode.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.PRODUCT_CODE_ERROR);
        }
        if (quantityPurchased <= ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_QTY_ERROR);
        }
        ReceiptLineItem lineItem = new ReceiptLineItem(dataAccessStrategy.productSearch(productCode), quantityPurchased);
        addToArray(lineItem);
    }

    /**
     *
     * @param lineItem
     */
    public final void addToArray(ReceiptLineItem lineItem) {
        if (lineItem == null) {
            throw new IllegalArgumentException(ApplicationConstants.INVALLID_LINE_ITEM);
        }
        ReceiptLineItem[] tempItems = new ReceiptLineItem[receiptLineItem.length + 1];
        System.arraycopy(receiptLineItem, 0, tempItems, 0, receiptLineItem.length);
        tempItems[receiptLineItem.length] = lineItem;
        receiptLineItem = tempItems;
    }

    
    public final void outputReceipt() {
        double subtotal = 0;
        double discountTotal = 0;
        double taxTotal = 0;
        double grandTtotal = 0;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        System.out.println("|*******************************************************************************************************|");
        System.out.println("|  \t\t\t\t\t" + ApplicationConstants.RECEIPT_MESSAGE + "\t\t\t\t|");
        System.out.println("|  \t\t\t\t\t\t" + dateFormat.format(date)+ "\t\t\t\t\t|"); 
        System.out.println("|  Customer Name:  " + customer.getCustomerName() + "\t\t\t\t\t\t\t\t|");
        System.out.println("|  Customer Number: " + customer.getCustomerNumber() + "\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("|-------------------------------------------------------------------------------------------------------|");
        System.out.println("|  Item UPC \tDESCRIPTION \t\t  QUANTITY\tPRICE \t\tDISCOUNT \tTotal\t\t|");
        System.out.println("|-------------------------------------------------------------------------------------------------------|");

        for (ReceiptLineItem lineItems : receiptLineItem) {
            subtotal = subtotal + lineItems.getLineItemTotal();
            discountTotal = discountTotal + lineItems.getDiscountAmount();
            System.out.println("|  " + lineItems.getProductCode() + "\t" + lineItems.getProductDescription() + "\t\t" + lineItems.getQuantityPurchased() + "\t" + numberFormatter.format(lineItems.getUnitPrice()) + "\t\t" + numberFormatter.format(lineItems.getDiscountAmount()) + "\t\t" + numberFormatter.format(lineItems.getLineItemTotal()) + "\t\t|");
        }
        taxTotal = subtotal * ApplicationConstants.SALES_TAX;
        grandTtotal = subtotal + taxTotal;
        System.out.println("|-------------------------------------------------------------------------------------------------------|");

        System.out.println("|  Sub Totals\t\t\t\t\t\t\t\t" +  "\t\t" + numberFormatter.format(subtotal) + "\t\t|");
        System.out.println("|  Total Discount Given\t\t\t\t\t\t\t\t\t"+ numberFormatter.format(discountTotal) + "\t\t|");
        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t|");
        System.out.println("|  Sales Tax \t\t\t\t\t\t\t\t\t\t" + numberFormatter.format(taxTotal) + "\t\t|");
        System.out.println("|*******************************************************************************************************|");
        System.out.println("|  Sale Total \t\t\t\t\t\t\t\t\t\t" + numberFormatter.format(grandTtotal) + "\t\t|");
        System.out.println("|*******************************************************************************************************|\n\n");

    }
}
