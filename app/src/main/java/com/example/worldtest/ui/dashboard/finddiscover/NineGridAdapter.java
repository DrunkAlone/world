package com.example.worldtest.ui.dashboard.finddiscover;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtest.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;



public class NineGridAdapter extends RecyclerView.Adapter<NineGridAdapter.Holder> {
   // private static final int[] COLORS = {0xff00FFFF, 0xffDEB887, 0xff5F9EA0, 0xff7FFF00, 0xff6495ED, 0xffDC143C, 0xff008B8B, 0xff006400, 0xff2F4F4F, 0xffFF69B4, 0xffFF00FF, 0xffCD5C5C, 0xff90EE90, 0xff87CEFA, 0xff800000};

    private String [] images1;


   /* public NineGridAdapter(int i) {
        this.mCount = i;
    }*/
   public NineGridAdapter(String[] images1){
       this.images1=images1;
       System.out.println("images1.length:"+images1.length);
   }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nine_grid, parent, false);
        return new Holder(item);
    }


    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final Holder holder, final int position) {

       if(position<=images1.length) {
           System.out.println("image url:" + images1[position]);
           DisplayImageOptions options = new DisplayImageOptions.Builder()
                   .showImageOnLoading(R.drawable.timg)
                   .showImageOnFail(R.drawable.fail)
                   .cacheInMemory(true)
                   .cacheOnDisk(true)
                   .bitmapConfig(Bitmap.Config.RGB_565)
                   .build();
           ImageLoader.getInstance().displayImage(images1[position], holder.imageView, options);
       }
    }


    @Override
    public int getItemCount() {
        return images1.length;
    }
/*
    private int randomColor() {
        return COLORS[new Random().nextInt(COLORS.length)];
    }*/

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
