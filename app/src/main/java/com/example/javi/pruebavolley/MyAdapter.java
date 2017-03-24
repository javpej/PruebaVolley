package com.example.javi.pruebavolley;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Javi on 24/3/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Item> aItemSelected;

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){



        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return aItemSelected.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);



        }
    }
}
