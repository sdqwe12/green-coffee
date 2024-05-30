package com.mh.green2nd.store.superAdminStore;

import lombok.Data;

import java.util.Map;

@Data
public class OrderInfo {
    private String customerName;
    private Map<String, Integer> orderedItems; // Key: Menu name, Value: Quantity
    private double totalOrderPrice;
}