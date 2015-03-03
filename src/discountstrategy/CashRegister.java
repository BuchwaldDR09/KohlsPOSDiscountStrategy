package discountstrategy;

/**
 * 
 * @author Dan
 */
public class CashRegister {

    
    private Receipt receipt;
    private DatabaseStrategy dataAccessStrategy;

    /**
     * 
     * @param dataAccessStrategy 
     */
    public CashRegister(DatabaseStrategy dataAccessStrategy) {
        this.dataAccessStrategy = dataAccessStrategy;

    }

    /**
     * 
     * @param customerNumber 
     */
    public final void startNewSale(String customerNumber) {
        receipt = new Receipt(customerNumber, dataAccessStrategy);
    }

    /**
     * 
     * @param productCode
     * @param quantity 
     */
    public final void addLineItem(String productCode, int quantity) {
        receipt.addLineItem(productCode, quantity);
    }

    
    public final void completeSale() {
        receipt.outputReceipt();
    }

}
