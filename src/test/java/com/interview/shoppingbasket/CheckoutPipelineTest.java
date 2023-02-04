package com.interview.shoppingbasket;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CheckoutPipelineTest {

    CheckoutPipeline checkoutPipeline;

    @Mock
    Basket basket;

    @Mock
    CheckoutStep checkoutStep1;

    PricingService pricingService;
    
    @Mock
    CheckoutStep checkoutStep2;
    
    PromotionsService promotionsService;

    @BeforeEach
    void setup() {
        checkoutPipeline = new CheckoutPipeline();
        promotionsService = Mockito.mock(PromotionsService.class);
        pricingService = Mockito.mock(PricingService.class);
    }

    @Test
    void returnZeroPaymentForEmptyPipeline() {
        PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);

        assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }

    @Test
    void executeAllPassedCheckoutSteps() {
    	PaymentSummary paymentSummary = checkoutPipeline.checkout(basket);
    	
    	checkoutPipeline.addStep(new BasketConsolidationCheckoutStep());
    	checkoutPipeline.addStep(new PromotionsCheckoutStep(promotionsService));
    	checkoutPipeline.addStep(new RetailPriceCheckoutStep(pricingService));
    	
    	assertEquals(paymentSummary.getRetailTotal(), 0.0);
    }
}
