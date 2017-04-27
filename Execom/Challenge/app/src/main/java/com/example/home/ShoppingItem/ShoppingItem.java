package com.example.home.ShoppingItem;


import com.example.home.Item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Home on 4/23/2017.
 */

public class ShoppingItem  implements Serializable {
    public int id;
    public List<Item> list;
    public String name;
    public boolean checked;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public ShoppingItem() {
        this.id= counter.incrementAndGet();
        this.list=new ArrayList<>();
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }



    public ShoppingItem(List<Item> list, String name, boolean checked) {
        this.list = list;
        this.name = name;
        this.checked = checked;

    }








}
