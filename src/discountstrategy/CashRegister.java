package discountstrategy;

/**
 * 
 * @author Dan
 */
public class CashRegister {

    
    private Receipt receipt;
    private DataAccessStrategy dataAccessStrategy;

    /**
     * 
     * @param dataAccessStrategy 
     */
    public CashRegister(DataAccessStrategy dataAccessStrategy) {
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
    public final void scanProducts(String productCode, int quantity) {
        receipt.addLineItem(productCode, quantity);
    }

    
    public final void completeSale() {
        receipt.outputReceipt();
    }

}
