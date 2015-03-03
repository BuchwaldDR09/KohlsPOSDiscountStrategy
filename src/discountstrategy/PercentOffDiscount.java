package discountstrategy;

/**
 * 
 * @author Dan
 */
public class PercentOffDiscount implements DiscountStrategy {

    private double percentOffDiscount;

        
    /**
     * 
     * @param quantityPurchased
     * @param unitPrice
     * @return 
     */
    @Override
    public double getDiscountAmount(int quantityPurchased, double unitPrice) {
        double amount = unitPrice * quantityPurchased * ApplicationConstants.PERCENT_OFF_DISCOUNT;
        return amount;
    }

    /**
     * 
     * @param quantityPurchased
     * @param unitPrice
     * @return 
     */
    @Override
    public double getPriceAfterDiscount(int quantityPurchased, double unitPrice) {
        double price = unitPrice - getDiscountAmount(quantityPurchased, unitPrice);

        return price;
    }

    public double getPercentOffDiscount() {
        return percentOffDiscount;
    }

    public void setPercentOffDiscount(double percentOffDiscount) {
        this.percentOffDiscount = percentOffDiscount;
    }

}
