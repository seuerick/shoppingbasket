package com.interview.shoppingbasket;

public class RetailPriceCheckoutStep implements CheckoutStep {
	
    private PricingService pricingService;
    
    private PromotionsService promotionsService;
    
    private double retailTotal;

    public RetailPriceCheckoutStep(PricingService pricingService) {
        this.pricingService = pricingService;
    }
    
    public RetailPriceCheckoutStep(PricingService pricingService, PromotionsService promotionsService) {
        this.pricingService = pricingService;
        this.promotionsService = promotionsService;
    }

    @Override
    public void execute(CheckoutContext checkoutContext) {
        Basket basket = checkoutContext.getBasket();
        retailTotal = 0.0;

        for (BasketItem basketItem: basket.getItems()) {
            int quantity = basketItem.getQuantity();
            double price = pricingService.getPrice(basketItem.getProductCode());
            Promotion promotion = promotionsService.getPromotion(basketItem.getProductCode());
            basketItem.setProductRetailPrice(price);
            retailTotal += quantity*price;
            applyPromotion(promotion, basketItem, price);
        }

        checkoutContext.setRetailPriceTotal(retailTotal);
    }

    public double applyPromotion(Promotion promotion, BasketItem item, double price) {
    	int quantity = item.getQuantity();
    	double discountValue = promotion.getDiscountValue();
    	price = price - (price * discountValue);
    	return quantity * price;
    }
}
