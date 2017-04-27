package com.example.home.Item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.example.home.ShoppingItem.ShoppingAdapter;
import com.example.home.ShoppingItem.ShoppingItem;
import com.example.home.challenge.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.example.home.challenge.MainActivity.items;

/**
 * Created by Home on 4/23/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>  {


    private final List<Item> list;
    Context c;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
    private ShoppingItem s;

    public  ItemAdapter(List<Item> _list, Context _c, ShoppingItem _s) {
        this.list = _list;
        this.c=_c;
        this.s=_s;


        onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Item item = (Item) buttonView.getTag();

                item.setPurchased(isChecked);
                for (Item i :items  ) {
                    if(item.getId()== i.getId()){
                        i.setPurchased(item.getPurchased());
                        break;
                    }
                }

            }
        };

    }



    public void addItem(Item item){
        list.add(item);

        notifyItemInserted(getItemCount() - 1);
    }

    public void updateItem(Item item){
        int pos = list.indexOf(item);

        notifyItemChanged(pos);
    }

    public void deleteItem(Item item){
        int pos = list.indexOf(item);
        list.remove(pos);

        notifyItemRemoved(pos);
    }

    public List<Item> getItems(){
        if(list == null){
            return new ArrayList<>();
        }
        return list;
    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ItemViewHolder ItemViewHolder, int i) {
        Item ci = list.get(i);
        ItemViewHolder.vName.setText(ci.getName());
        ItemViewHolder.vAmount.setText(String.valueOf(ci.getAmount()));
        //doraditi
        if(ci.getPurchased()) {
            ItemViewHolder.vBuy.setText("Already bought");
        }
        else{
            ItemViewHolder.vBuy.setText("");
        }


       ItemViewHolder.vCheckbox.setTag(ci);
        ItemViewHolder.vCheckbox.setOnCheckedChangeListener(onCheckedChangeListener);


    }

    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.itemview, viewGroup, false);

        return new ItemAdapter.ItemViewHolder(itemView);
    }




    public static class ItemViewHolder extends RecyclerView.ViewHolder   {

        protected TextView vName;
        protected TextView vAmount;
        protected TextView vBuy;
        protected CheckBox vCheckbox;


        public ItemViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.itemname);
            vBuy = (TextView)  v.findViewById(R.id.itembuy);
            vAmount = (TextView)  v.findViewById(R.id.itemamount);
            vCheckbox=(CheckBox)v.findViewById(R.id.itempurchase);

        }



    }
}