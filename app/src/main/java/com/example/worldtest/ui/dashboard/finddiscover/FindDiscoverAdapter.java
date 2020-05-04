package com.example.worldtest.ui.dashboard.finddiscover;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtest.R;
import com.example.worldtest.ui.dashboard.Moment;

import java.util.ArrayList;
import java.util.List;

public class FindDiscoverAdapter extends RecyclerView.Adapter<FindDiscoverAdapter.baseDiscoverViewHolder>{
    private static final String TAG =FindDiscoverAdapter.class.getSimpleName();

    private List<Moment> momentList = new ArrayList<>();

    public FindDiscoverAdapter(List<Moment> list) {
        System.out.println( "setVerticalDataList: " + list.size());
        momentList = list;
    }


    @Override
    public baseDiscoverViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_find_discover_only_word, parent, false);
        return new baseDiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder( baseDiscoverViewHolder holder, int position) {

        holder.txt_user_name.setText(momentList.get(position).getUser_name());
        holder.txt_content.setText(momentList.get(position).getContent());
        holder.txt_publish_time.setText(momentList.get(position).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return momentList == null ? 0 : momentList.size();
    }

    public class baseDiscoverViewHolder extends RecyclerView.ViewHolder {

        TextView  txt_content,txt_user_name,txt_publish_time;
        //ImageView imageView;

        public baseDiscoverViewHolder(View itemView) {
            super(itemView);
            txt_content = itemView.findViewById(R.id.txt_content);
            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            txt_publish_time = itemView.findViewById(R.id.txt_publish_time);
            //imageView=itemView.findViewById(R.id.img_avatar);
        }
    }
}
