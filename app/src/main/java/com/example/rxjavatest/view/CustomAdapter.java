package com.example.rxjavatest.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.rxjavatest.R;
import com.example.rxjavatest.model.PojoCake;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<PojoCake> dataSet;

    public void setDataset(List<PojoCake> dataSet){
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CustomViewHolder(
                LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout,
                        viewGroup,
                        false));
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Picasso.get().load(dataSet.get(i).image).into(customViewHolder.iv_cake);
        customViewHolder.tv_desc.setText(dataSet.get(i).desc);
        customViewHolder.tv_title.setText(dataSet.get(i).title);
    }

    @Override
    public int getItemCount() {
        return dataSet != null ?
                dataSet.size() : 0;
    }
}
