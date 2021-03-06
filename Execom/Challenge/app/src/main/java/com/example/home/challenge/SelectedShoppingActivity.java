package com.example.home.challenge;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.Item.Item;
import com.example.home.Item.ItemAdapter;
import com.example.home.ShoppingItem.ShoppingItem;


import java.util.ArrayList;
import java.util.List;

import static com.example.home.challenge.PasswordActivity.data;
import static com.example.home.challenge.PasswordActivity.items;


public class SelectedShoppingActivity extends AppCompatActivity {
    ShoppingItem s;
    EditText name;
    CheckBox checkBox;
    RecyclerView v;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_shopping_view);
        s=null;

        name = (EditText)findViewById(R.id.name);
        checkBox=(CheckBox)findViewById(R.id.check);
        v=(RecyclerView)findViewById(R.id.itemrecycle);



        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();



        if(bundle.getBoolean("Action")) {
            s=(ShoppingItem) bundle.getSerializable("selected");
            name.setText(s.getName());
            checkBox.setChecked(s.isChecked());
            checkBox.setEnabled(false);
        }
        else
        {
            name.setText("");
            checkBox.setChecked(false);
        }

        v.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        v.setLayoutManager(llm);

        //data=createList(5);

        ItemAdapter ca = new ItemAdapter(items,this,s,true);
        v.setAdapter(ca);

 }
public ShoppingItem contains(ShoppingItem _s){

    List<Item> temp=new ArrayList<>();

    for (Item item :_s.getList()){
        for (Item it:items) {
            if(it.getId()==item.getId())
            {
                temp.add(it);
                break;
            }
        }
    }
    if(temp.containsAll(items))
    {
        _s.setChecked(true);
    }else
    {
        _s.setChecked(false);
    }
    temp.clear();

    return _s;
}

 public void acceptClicked(View v){


     if(s!=null){

         s.setChecked(checkBox.isChecked());
         s.setName(name.getText().toString());




         s.getList().clear();
         for(int i=0;i<items.size();i++){
             if(items.get(i).getPurchased()){
                 s.getList().add(items.get(i));
             }
         }

         s=contains(s);
         for (int i=0;i<data.size();i++) {
            if(data.get(i).getId()==s.getId())
            {
                data.set(i,s);
                break;
            }

         }

     }else{
         s=new ShoppingItem();
         s.setChecked(checkBox.isChecked());
         s.setName(name.getText().toString());

         for(int i=0;i<items.size();i++){
             if(items.get(i).getPurchased()){
                 s.getList().add(items.get(i));
             }
         }
         s=contains(s);
         data.add(s);
     }






     Intent intent= new Intent(this,MainActivity.class);
     intent.putExtra("Fragment","ShoppingFragment");
         startActivity(intent);

 }
}
