package discountstrategy;

/**
 * 
 * @author Dan
 */
public class ProductQuantityDiscount implements DiscountStrategy {

    //public static final int ZERO = 0;

    /**
     * 
     * @param quantityPurchased
     * @param unitPrice
     * @return
     * @throws IllegalArgumentException 
     */
    @Override
    public double getDiscountAmount(int quantityPurchased, double unitPrice) throws IllegalArgumentException {
        if (quantityPurchased <= ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_QTY_ERROR);
        }
        if (unitPrice < ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_PRICE_ERROR);
        }
        double amount = 0;
        if (quantityPurchased >= ApplicationConstants.MIN_QTY_FOR_DISCOUNT) {
            amount = unitPrice * quantityPurchased * ApplicationConstants.QTY_DISCOUNT_PERCENT_OFF;
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
        if (quantityPurchased <= ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_QTY_ERROR);
        }
        if (unitPrice < ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_PRICE_ERROR);
        }

        double price = 0;

        if (quantityPurchased >= ApplicationConstants.MIN_QTY_FOR_DISCOUNT) {
            price -= getDiscountAmount(quantityPurchased, unitPrice);
        }

        return price;
    }

}
