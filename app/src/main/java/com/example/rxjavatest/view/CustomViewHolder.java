package com.example.rxjavatest.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxjavatest.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView tv_title, tv_desc;
    ImageView iv_cake;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_desc = itemView.findViewById(R.id.tv_desc);
        iv_cake = itemView.findViewById(R.id.iv_cake);
    }
}
