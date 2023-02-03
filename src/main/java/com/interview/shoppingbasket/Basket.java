package com.interview.shoppingbasket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
	
    private List<BasketItem> items = new ArrayList<>();

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
}
