package com.example.home.ShoppingItem;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.home.Item.Item;
import com.example.home.ShoppingItem.ShoppingAdapter;
import com.example.home.ShoppingItem.ShoppingItem;
import com.example.home.challenge.R;
import com.example.home.challenge.SelectedShoppingActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.example.home.challenge.PasswordActivity.data;
import static com.example.home.challenge.PasswordActivity.items;


/**
 * Created by Home on 4/27/2017.
 */

public class ShoppingItemFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    private static final int DATASET_COUNT = 60;


    RecyclerView recList;
    Bundle bundle;


    ItemTouchHelper swipeToDismissTouchHelper;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Nullable
    @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_items, container, false);
        rootView.setTag(TAG);

        recList = (RecyclerView) rootView.findViewById(R.id.cardList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);



        recList.setHasFixedSize(true);



        final ShoppingAdapter ca = new ShoppingAdapter(data,rootView.getContext(),items);

        recList.setAdapter(ca);



        swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {


                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
            {


                if(direction==4) {
                    data.remove(viewHolder.getAdapterPosition());
                    ca.notifyItemRemoved(viewHolder.getAdapterPosition());
                    Snackbar.make(recList, "Delete successful" + viewHolder.getAdapterPosition(), Snackbar.LENGTH_LONG).show();

                }


            }

        });
        swipeToDismissTouchHelper.attachToRecyclerView(recList);


        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(Item i:items){
                    i.setPurchased(false);
                }
                Intent i= new Intent(rootView.getContext(),SelectedShoppingActivity.class);
                bundle= new Bundle();
                bundle.putBoolean("Action",false);
                i.putExtras(bundle);
                startActivity(i);
            }
        });



        return rootView;



    }

}
