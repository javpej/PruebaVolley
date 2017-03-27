package com.example.javi.pruebavolley;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Javi on 24/3/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Item> aItemSelected;

    Context context;

    LayoutInflater inflater;

    public MyAdapter(ArrayList<Item> aItemSelected, Context context) {
        this.aItemSelected = aItemSelected;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){

       View v = inflater.inflate(R.layout.cardview, null);

        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Item itemselected = aItemSelected.get(position);

        holder.tvCiudad.setText(itemselected.getsCiudad());
        holder.tvTemp.setText(itemselected.getsTemperatura() + "ºC");
        holder.tvPred.setText(itemselected.getsPred());

    }

    @Override
    public int getItemCount() {
        return aItemSelected.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCiudad;
        TextView tvTemp;
        TextView tvPred;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvCiudad = (TextView) itemView.findViewById(R.id.TVCiudad);
            tvTemp = (TextView) itemView.findViewById(R.id.TVTemp);
            tvPred = (TextView) itemView.findViewById(R.id.TVPred);
            
        }
    }
}
