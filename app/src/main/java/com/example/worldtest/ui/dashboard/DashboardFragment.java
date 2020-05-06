package com.example.worldtest.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtest.R;
import com.example.worldtest.ui.dashboard.finddiscover.DiscoverWithImageAdapter;
import com.example.worldtest.ui.dashboard.finddiscover.FindDiscover;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static cn.bmob.v3.Bmob.getApplicationContext;

public class DashboardFragment extends Fragment {
    private View root;
    RecyclerView rcvVertical;
    LinearLayoutManager managerVertical;
    public static DashboardFragment newInstance() {
        Bundle args = new Bundle();
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initView(root);

        return root;
    }
    private void initView(View root){

        final Button b = root.findViewById(R.id.findDisButton);
        b.setOnClickListener(v -> {
            final EditText editText=getView().findViewById(R.id.findDisText);
            String discoverName=editText.getText().toString().trim();
            Intent intent=new Intent(getActivity(), FindDiscover.class);
            Bundle bundle = new Bundle();
            bundle.putString("discoverName", discoverName);
            intent.putExtras(bundle);
            startActivity(intent);

        });

        rcvVertical = root.findViewById(R.id.recycler_view);
        rcvVertical.setHasFixedSize(true);

        managerVertical = new LinearLayoutManager(root.getContext());
        rcvVertical.setLayoutManager(managerVertical);
        BmobQuery<Moment> bmobQuery = new BmobQuery<Moment>();
        bmobQuery.findObjects(new FindListener<Moment>() {  //按行查询
            @Override
            public void done(List<Moment> list, BmobException e) {
                if (e == null) {
                    //数据倒序显示,最新的数据在最上面
                    Collections.reverse(list);
                    List<Moment> moments = new ArrayList<>(list);
                    // System.out.println(moments.size());
                    DiscoverWithImageAdapter discoverWithImageAdapter=new DiscoverWithImageAdapter(moments) ;
                    rcvVertical.setAdapter(discoverWithImageAdapter);
                }
                else{
                    System.out.println(e.getMessage());
                }
            }
        });

    }

}