package com.example.home.ShoppingItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.example.home.Item.Item;
import com.example.home.challenge.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Home on 4/16/2017.
 */

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>  {

    private List<ShoppingItem> list;
    private List<Item> items;
    Context c;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public ShoppingAdapter(List<ShoppingItem> _list, Context _c, List<Item> _items) {
        this.list = _list;
        Collections.sort(this.list, new Comparator<ShoppingItem>() {
            @Override
            public int compare(ShoppingItem abc1, ShoppingItem abc2) {
                return Boolean.compare(abc1.isChecked(),abc2.isChecked());
            }
        });
        this.c=_c;
        this.items=_items;
        onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ShoppingItem item = (ShoppingItem) buttonView.getTag();

                item.setChecked(isChecked);

            }
        };

    }






    public void addItem(ShoppingItem item){
        list.add(item);
        Collections.sort(list, new Comparator<ShoppingItem>() {
            @Override
            public int compare(ShoppingItem abc1, ShoppingItem abc2) {
                return Boolean.compare(abc2.isChecked(),abc1.isChecked());
            }
        });
        notifyItemInserted(getItemCount() - 1);
    }

    public void updateItem(ShoppingItem item){
        int pos = list.indexOf(item);
        Collections.sort(list, new Comparator<ShoppingItem>() {
            @Override
            public int compare(ShoppingItem abc1, ShoppingItem abc2) {
                return Boolean.compare(abc2.isChecked(),abc1.isChecked());
            }
        });
        notifyItemChanged(pos);
    }

    public void deleteItem(ShoppingItem item){
        int pos = list.indexOf(item);
        list.remove(pos);
        Collections.sort(list, new Comparator<ShoppingItem>() {
            @Override
            public int compare(ShoppingItem abc1, ShoppingItem abc2) {
                return Boolean.compare(abc2.isChecked(),abc1.isChecked());
            }
        });
        notifyItemRemoved(pos);
    }

    public List<ShoppingItem> getItems(){
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
    public void onBindViewHolder(ShoppingViewHolder ShoppingViewHolder, int i) {
        ShoppingItem ci = list.get(i);
        ShoppingViewHolder.vName.setText(ci.getName());

        /*for (Item it:ci.getList()) {
            if(it.getPurchased())

        }*/

        ShoppingViewHolder.vCheckbox.setChecked(ci.isChecked());
        ShoppingViewHolder.vCheckbox.setTag(ci);
        ShoppingViewHolder.vCheckbox.setOnCheckedChangeListener(onCheckedChangeListener);
        ShoppingViewHolder.itemView.setTag(ci);
        ShoppingViewHolder.itemView.setOnClickListener(new ShoppingItemClickedListener(c));


    }

    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview, viewGroup, false);

        return new ShoppingViewHolder(itemView);
    }




    public static class ShoppingViewHolder extends RecyclerView.ViewHolder   {
        protected TextView vName;
        protected CheckBox vCheckbox;



        public ShoppingViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vCheckbox = (CheckBox)  v.findViewById(R.id.checkbox);

        }



    }
}