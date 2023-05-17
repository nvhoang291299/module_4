package com.example.cartapplication.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int quantity;
    private Map<Food,Integer> foods = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Food,Integer> foods) {
        this.foods = foods;
    }

    public Map<Food,Integer> getFoods() {
        return foods;
    }

    private boolean checkItemInCart(Food food){
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            if(entry.getKey().getIdFood() == food.getIdFood()){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Food, Integer> selectItemInCart(Food food){
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            if(entry.getKey().getIdFood() == food.getIdFood()){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Food food){
        if (!checkItemInCart(food)){
            foods.put(food,1);
        } else {
            Map.Entry<Food, Integer> itemEntry = selectItemInCart(food);
            Integer newQuantity = itemEntry.getValue() + 1;
            foods.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public void downProduct(Food food){
        if (!checkItemInCart(food)){
            foods.put(food,1);
        } else {
            Map.Entry<Food, Integer> itemEntry = selectItemInCart(food);
            Integer newQuantity = itemEntry.getValue() - 1;
            foods.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return foods.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Food, Integer> entry : foods.entrySet()) {
            payment += entry.getKey().getNewPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void removeFood(Food food) {
        Map.Entry<Food, Integer> itemEntry = selectItemInCart(food);
        assert itemEntry != null;
        this.foods.remove(itemEntry.getKey());
    }
}
