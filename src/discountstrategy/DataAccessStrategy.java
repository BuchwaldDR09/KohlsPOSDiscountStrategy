package discountstrategy;

/**
 * 
 * @author Dan
 */
public interface DataAccessStrategy {

    public abstract Customer customerSearch(String customerNumber);

    public abstract Product productSearch(String productCode);
    
}
