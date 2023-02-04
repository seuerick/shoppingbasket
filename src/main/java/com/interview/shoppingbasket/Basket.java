package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
	
    private List<BasketItem> items = new ArrayList<>();
    
    private List<Promotion> promotions = new ArrayList<Promotion>();
    
    public Basket() {
    	promotions.add(new Promotion("product1", "2 items for the price of 1", 0.5));
    	promotions.add(new Promotion("product2", "50% off retail price", 0.5));
    	promotions.add(new Promotion("product3", "10% off retail price", 0.1));
	}

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
    	this.items = items.stream()
    		     .distinct()
    		     .collect(Collectors.toList());
    }

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public Promotion getPromotion(String productCode) {
		return promotions.stream().filter(promotion -> promotion.getProductCode().equals(productCode)).findAny().orElseThrow();
	}
}
