package discountstrategy;

/**
 * 
 * @author Dan
 */
public class Product {

    private String productCode;
    private String productDescription;
    private double unitPrice;
    private DiscountStrategy discountStrategy;

    /**
     *
     * @param productCode
     * @param productDescription
     * @param unitPrice
     * @param discountStrategy
     */
    public Product(String productCode, String productDescription, double unitPrice, DiscountStrategy discountStrategy) throws IllegalArgumentException {
        setProductCode(productCode);
        setProductDescription(productDescription);
        setUnitPrice(unitPrice);
        if (discountStrategy == null) {
            throw new IllegalArgumentException(ApplicationConstants.INVALLID_DISCOUNT_STRATEGY);
        }
        this.discountStrategy = discountStrategy;
    }

    /**
     *
     * @return
     */
    public final String getProductCode() {
        return productCode;
    }

    /**
     *
     * @return
     */
    public final String getProductDescription() {
        return productDescription;
    }

    /**
     *
     * @return
     */
    public final double getUnitPrice() {
        return unitPrice;
    }

    /**
     *
     * @param quantityPurchased
     * @param unitPrice
     * @return
     */
    public final double getDiscountAmount(int quantityPurchased, double unitPrice) throws IllegalArgumentException {
        if (quantityPurchased <= ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_QTY_ERROR);
        }
        if (unitPrice < ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_PRICE_ERROR);
        }
        return discountStrategy.getDiscountAmount(quantityPurchased, unitPrice);
    }

    /**
     *
     * @return
     */
    public final DiscountStrategy getDiscountStategy() {
        return discountStrategy;
    }

    public final void setProductCode(String productCode) {
        if (productCode == null || productCode.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.PRODUCT_CODE_ERROR);
        }
        this.productCode = productCode;
    }

    public final void setProductDescription(String productDescription) {
        if (productDescription == null || productDescription.length() == ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.PRODUCT_DESCRIPTION_ERROR);
        }
        this.productDescription = productDescription;
    }

    public final void setUnitPrice(double unitPrice) {
        if (unitPrice < ApplicationConstants.ZERO) {
            throw new IllegalArgumentException(ApplicationConstants.UNIT_PRICE_ERROR);
        }
        this.unitPrice = unitPrice;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

}
