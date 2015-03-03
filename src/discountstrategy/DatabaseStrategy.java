package discountstrategy;

/**
 * 
 * @author Dan
 */
public interface DatabaseStrategy {

    public abstract Customer customerSearch(String customerNumber);

    public abstract Product productSearch(String productCode);
    
}
