package com.interview.shoppingbasket;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PromotionsCheckoutStepTest {
	
	CheckoutContext checkoutContext;
	
	PromotionsService promotionsService;
	
	Basket basket;
	
	@BeforeEach
    void setup() {
		promotionsService = Mockito.mock(PromotionsService.class);
        checkoutContext = Mockito.mock(CheckoutContext.class);
        basket = new Basket();

        when(checkoutContext.getBasket()).thenReturn(basket);
    }

	@Test
	void promotionsCheckoutStepTest() {
		PromotionsCheckoutStep promotionsCheckoutStep = new PromotionsCheckoutStep(promotionsService);
		promotionsCheckoutStep.execute(checkoutContext);
		
		
	}
}
