package discountstrategy;

/**
 * 
 * @author Dan
 */
public class ProductQuantityDiscount implements DiscountStrategy {

    private int minQuantity = 5;
    private double percentOff = .1;
    public static final int ZERO = 0;

    /**
     * 
     * @param quantityPurchased
     * @param unitPrice
     * @return
     * @throws IllegalArgumentException 
     */
    @Override
    public double getDiscountAmount(int quantityPurchased, double unitPrice) throws IllegalArgumentException {
        if (quantityPurchased <= ZERO) {
            throw new IllegalArgumentException("Purchased quantity must be greater than 0.");
        }
        if (unitPrice < ZERO) {
            throw new IllegalArgumentException("Unit price cannot be less than 0.");
        }
        double amount = 0;
        if (quantityPurchased >= minQuantity) {
            amount = unitPrice * quantityPurchased * percentOff;
        }
        return amount;
    }

    /**
     * 
     * @param quantityPurchased
     * @param unitPrice
     * @return
     * @throws IllegalArgumentException 
     */
    @Override
    public double getPriceAfterDiscount(int quantityPurchased, double unitPrice) throws IllegalArgumentException {
        if (quantityPurchased <= ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_QTY_ERROR);
        }
        if (unitPrice < ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_PRICE_ERROR);
        }

        double price = 0;

        if (quantityPurchased >= minQuantity) {
            price -= getDiscountAmount(quantityPurchased, unitPrice);
        }

        return price;
    }

}
