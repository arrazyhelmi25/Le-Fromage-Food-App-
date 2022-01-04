package com.hci.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hci.foodapp.FoodDetails;
import com.hci.foodapp.R;
import com.hci.foodapp.model.Allmenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> implements Filterable {

    Context context;
    List<Allmenu> allmenuList;
    List<Allmenu> allmenuListAll;

    public AllMenuAdapter(Context context, List<Allmenu> allmenuList) {
        this.context = context;
        this.allmenuList = allmenuList;
        this.allmenuListAll = new ArrayList<>(allmenuList);
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);
        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, int position) {

        holder.allmenuName.setText(allmenuList.get(position).getName());
        holder.allmenuPrice.setText("Rp. "+allmenuList.get(position).getPrice()+"K");
        holder.allmenuTime.setText(allmenuList.get(position).getDeliveryTime());
        holder.allmenuRating.setText(allmenuList.get(position).getRating());
        holder.allmenuCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.allmenuNote.setText(allmenuList.get(position).getNote());


        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.allmenuImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allmenuList.get(position).getName());
                i.putExtra("price", allmenuList.get(position).getPrice());
                i.putExtra("rating", allmenuList.get(position).getRating());
                i.putExtra("description", allmenuList.get(position).getDescription());
                i.putExtra("image", allmenuList.get(position).getImageUrl());

                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return allmenuList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Allmenu> filteredList = new ArrayList<>();

            if (constraint.toString().isEmpty()) {
                filteredList.addAll(allmenuListAll);
            } else {
                for (Allmenu allmenu: allmenuListAll) {
                    if (allmenu.getName().toString().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(allmenu);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }
        //run on UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            allmenuList.clear();
            allmenuList.addAll((Collection<? extends Allmenu>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder{

        TextView allmenuName, allmenuNote, allmenuRating, allmenuTime, allmenuCharges, allmenuPrice;
        ImageView allmenuImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            allmenuName = itemView.findViewById(R.id.cartName);
            allmenuNote = itemView.findViewById(R.id.cartNote);
            allmenuCharges = itemView.findViewById(R.id.cartDeliveryCharge);
            allmenuRating = itemView.findViewById(R.id.cartRating);
            allmenuTime = itemView.findViewById(R.id.cartDeliverytime);
            allmenuPrice = itemView.findViewById(R.id.cartPrice);
            allmenuImage = itemView.findViewById(R.id.cartImage);
        }
    }

}
