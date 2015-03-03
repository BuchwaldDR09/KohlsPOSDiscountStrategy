package discountstrategy;

/**
 * 
 * @author Dan
 */
public interface DiscountStrategy {

    public abstract double getDiscountAmount(int quantityPurchased, double unitPrice);
    public abstract double getPriceAfterDiscount(int quantityPurchased, double unitPrice);

}
