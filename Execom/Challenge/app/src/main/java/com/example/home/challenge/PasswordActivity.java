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
        Item i1= new Item("Televizor",1);
        Item i5= new Item("Frizider",1);
        Item i2= new Item("Laptop",5);
        Item i3= new Item("Monitor",7);
        Item i4= new Item("Mis",2);

        result.add(i1);
        result.add(i2);
        result.add(i3);
        result.add(i4);
        result.add(i5);

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
