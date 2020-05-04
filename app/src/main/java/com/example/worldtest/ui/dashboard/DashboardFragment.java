package com.example.worldtest.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.worldtest.R;
import com.example.worldtest.ui.dashboard.finddiscover.FindDiscover;

public class DashboardFragment extends Fragment {
    private View root;

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
    }

}