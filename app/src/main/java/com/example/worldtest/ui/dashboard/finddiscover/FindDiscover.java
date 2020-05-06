package com.example.worldtest.ui.dashboard.finddiscover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.worldtest.R;
import com.example.worldtest.ui.dashboard.Moment;
import com.example.worldtest.ui.home.find;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static com.example.worldtest.ActivityCollectorUtil.removeActivity;


public class FindDiscover extends AppCompatActivity  {

    String discoverName;
    RecyclerView rcvVertical;
    LinearLayoutManager managerVertical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_find_discover);
        Bundle bundle = this.getIntent().getExtras();
         discoverName=bundle.getString("discoverName");
       System.out.println("discoverName:"+discoverName);

        rcvVertical = findViewById(R.id.recycler_view);
        rcvVertical.setHasFixedSize(true);

        managerVertical = new LinearLayoutManager(this);
        rcvVertical.setLayoutManager(managerVertical);

        BmobQuery<Moment> query = new BmobQuery<Moment>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo("user_name", discoverName);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
         //query.setLimit(5);
        //执行查询方法
        query.findObjects(new FindListener<Moment>() {
            @Override
            public void done(List<Moment> list, BmobException e) {
                if(e == null){
                    if(list.size() == 0){
                        LinearLayout linearLayout=findViewById(R.id.discoverlayout);
                        System.out.println("done: 没有查到这个用户的ID");
                        linearLayout.setGravity(Gravity.CENTER);
                        linearLayout.setPadding(0,100,0,0);
                        ImageView imageView=new ImageView(FindDiscover.this);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,800);
                        imageView.setLayoutParams(params);

                        imageView.setImageResource(R.drawable.no_infor);
                        linearLayout.addView(imageView);

                    }else {
                        List<Moment> moments = new ArrayList<>(list);
                       // System.out.println(moments.size());
                        DiscoverWithImageAdapter discoverWithImageAdapter=new DiscoverWithImageAdapter(moments) ;
                        rcvVertical.setAdapter(discoverWithImageAdapter);
                    }
                }else {
                    System.out.println("done: 查询ID错误"+e.getMessage());
                }

            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        removeActivity(this);
    }


}
