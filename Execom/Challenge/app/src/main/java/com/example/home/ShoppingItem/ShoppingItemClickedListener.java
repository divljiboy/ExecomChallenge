package com.example.home.ShoppingItem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;


import com.example.home.Item.Item;
import com.example.home.challenge.SelectedActivity;

import static com.example.home.challenge.MainActivity.items;


/**
 * Created by Home on 4/23/2017.
 */

class ShoppingItemClickedListener implements View.OnClickListener {
    Bundle bundle;

    Context c;
    Intent i;
    public ShoppingItemClickedListener(Context context) {


        this.c=context;
    }

    @Override
    public void onClick(View v) {
        ShoppingItem s=(ShoppingItem) v.getTag();

        Toast.makeText(c,"Size of "+s.getList().size(), Toast.LENGTH_LONG).show();

        i= new Intent(c,SelectedActivity.class);
        bundle= new Bundle();
        bundle.putSerializable("selected", s);
        for (Item i: items) {
            i.setPurchased(false);
        }


        bundle.putBoolean("Action",true);
        i.putExtras(bundle);

        c.startActivity(i);



    }
}
