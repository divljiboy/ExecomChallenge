package com.example.home.challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.home.Item.Item;
import com.example.home.ShoppingItem.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class PasswordActivity extends AppCompatActivity {

    EditText editText;
    public static String password;
    public static List<ShoppingItem> data=null;
    public static List<Item> items=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        editText= (EditText) findViewById(R.id.editText);

        if(data==null && items==null) {
            data = createList(8);
            items = createItems(4);
        }
    }

    protected void passwordClicked(View v){
        password=editText.getText().toString();
        Intent i= new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private List createItems(int size){
        List result = new ArrayList();
        for (int i = 1; i <= size; i++) {
            Item ci = new Item();
            ci.setName("Item name"+i);
            if(i%2==0)
                ci.setPurchased(false);
            else
                ci.setPurchased(true);
            ci.setAmount(i%5);

            result.add(ci);
        }
        return result;
    }



    private List createList(int size) {

        List result = new ArrayList();
        for (int i = 1; i <= size; i++) {
            ShoppingItem ci = new ShoppingItem();
            ci.setName("Shopping list "+i);
            if(i%2==0)
                ci.setChecked(true);
            else
                ci.setChecked(false);


            result.add(ci);
        }
        return result;

    }
}
