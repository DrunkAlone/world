package com.example.worldtest.ui.dashboard.finddiscover;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtest.R;
import com.example.worldtest.ui.dashboard.Moment;

import java.util.ArrayList;
import java.util.List;

public  class DiscoverWithImageAdapter extends RecyclerView.Adapter<DiscoverWithImageAdapter.baseDiscoverViewHolder>{

    private List<Moment> momentList = new ArrayList<>();
    private String [] images1;
    private String images;
    public DiscoverWithImageAdapter(List<Moment> list) {
        System.out.println( "setVerticalDataList: " + list.size());
        momentList = list;
    }


    @Override
    public baseDiscoverViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_find_discover_word_and_image, parent, false);
        return new baseDiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder( baseDiscoverViewHolder holder, int position) {

        holder.txt_user_name.setText(momentList.get(position).getUser_name());
        holder.txt_content.setText(momentList.get(position).getContent());
        holder.txt_publish_time.setText(momentList.get(position).getCreatedAt());
        if(momentList.get(position).getPicture()!=null) {
            holder.mNineView.setLayoutManager(new NineGridLayoutManager(holder.mNineView.getContext()));
            images=momentList.get(position).getPicture();
            images1= images.split(";");
            holder.mNineView.setAdapter(new NineGridAdapter(images1));
           // holder.mNineView.setAdapter(new NineGridAdapter(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        return momentList == null ? 0 : momentList.size();
    }

    public class baseDiscoverViewHolder extends RecyclerView.ViewHolder {

        TextView  txt_content,txt_user_name,txt_publish_time;
        RecyclerView mNineView;

        public baseDiscoverViewHolder(View itemView) {
            super(itemView);
            txt_content = itemView.findViewById(R.id.txt_content);
            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            txt_publish_time = itemView.findViewById(R.id.txt_publish_time);
            mNineView = itemView.findViewById(R.id.nine_grid);
        }
    }
}
