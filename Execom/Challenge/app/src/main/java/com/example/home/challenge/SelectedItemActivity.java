package com.example.home.challenge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.Item.Item;
import com.example.home.Item.ItemAdapter;
import com.example.home.ShoppingItem.ShoppingItem;


import static com.example.home.challenge.PasswordActivity.items;


/**
 * Created by Home on 4/27/2017.
 */

public class SelectedItemActivity extends AppCompatActivity {
    Item s;
    EditText name;
    EditText amount;

    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item_view);
        s=null;

        name = (EditText)findViewById(R.id.editItemName);
        amount=(EditText)findViewById(R.id.editItemAmount);
        Intent intent = this.getIntent();
        bundle = intent.getExtras();



        if(bundle.getBoolean("Action")) {
            s=(Item) bundle.getSerializable("selecteditem");
            name.setText(s.getName());
            amount.setText(String.valueOf(s.getAmount()));
        }
        else
        {
            name.setText("");
            amount.setText("");

        }



    }

    public void acceptClicked(View v){


        if(s!=null){

            s.setName(name.getText().toString());
            s.setAmount(Integer.valueOf(amount.getText().toString()));
            for (int i=0;i<items.size();i++) {
                if(items.get(i).getId()==s.getId())
                {
                    items.set(i,s);
                    break;
                }

            }

        }else{
            s=new Item();
            s.setAmount(Integer.valueOf(amount.getText().toString()));
            s.setName(name.getText().toString());
            items.add(s);
        }
        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("Fragment","ItemFragment");
        startActivity(intent);

    }
}
