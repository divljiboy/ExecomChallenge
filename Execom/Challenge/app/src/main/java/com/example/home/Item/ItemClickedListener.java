package com.example.home.Item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.challenge.SelectedItemActivity;

import static com.example.home.challenge.PasswordActivity.password;


/**
 * Created by Home on 4/27/2017.
 */

public class ItemClickedListener implements View.OnClickListener {
    Bundle bundle;

    Context c;
    Intent i;
    public ItemClickedListener(Context context) {


        this.c=context;
    }

    @Override
    public void onClick(View v) {
        Item s=(Item) v.getTag();
        i= new Intent(c,SelectedItemActivity.class);
        bundle= new Bundle();
        bundle.putSerializable("selecteditem", s);
        bundle.putBoolean("Action",true);
        i.putExtras(bundle);




        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Alert");
        builder.setMessage("Please enter your password");
        final EditText input = new EditText(c);

        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(password.equals(input.getText().toString())){
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
