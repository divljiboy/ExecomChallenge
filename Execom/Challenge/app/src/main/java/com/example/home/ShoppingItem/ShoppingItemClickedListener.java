package com.example.home.ShoppingItem;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.home.Item.Item;
import com.example.home.challenge.SelectedShoppingActivity;

import static com.example.home.challenge.PasswordActivity.items;
import static com.example.home.challenge.PasswordActivity.password;


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
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Alert");
        builder.setMessage("Please enter your password");

        ShoppingItem s=(ShoppingItem) v.getTag();

        i= new Intent(c,SelectedShoppingActivity.class);
        bundle= new Bundle();
        bundle.putSerializable("selected", s);
        for(Item i:items){
            i.setPurchased(false);
        }
        for (int i=0;i<items.size();i++) {
            for (Item i2:s.getList()) {
                if(items.get(i).getId()==i2.getId())
                {
                    items.get(i).setPurchased(true);
                }
            }

        }




        final EditText input = new EditText(c);

        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if(password.equals(input.getText().toString())){


                   bundle.putBoolean("Action",true);
                   i.putExtras(bundle);

                   c.startActivity(i);


               }
               else{
                   Toast.makeText(c,"Wrong password",Toast.LENGTH_LONG);

               }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();





    }
}
