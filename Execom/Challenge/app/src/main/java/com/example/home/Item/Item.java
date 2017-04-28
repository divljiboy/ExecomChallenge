package com.example.home.Item;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Home on 4/23/2017.
 */

public class Item implements Serializable {

    private int id;
    private String name;


    private int amount;
    public boolean purchased;
    private static final AtomicInteger count = new AtomicInteger(0);


    public Item() {
        this.id= count.incrementAndGet();
    }

    public int getId() {

        return id;
    }

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.id= count.incrementAndGet();
    }

    public Item(String name, int amount, boolean purchased) {
        this.name = name;
        this.amount = amount;
        this.purchased = purchased;
        this.id= count.incrementAndGet();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item(int id, String name, int amount, boolean purchased) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.purchased = purchased;

        this.id= count.incrementAndGet();
    }

    public boolean getPurchased() {

        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
