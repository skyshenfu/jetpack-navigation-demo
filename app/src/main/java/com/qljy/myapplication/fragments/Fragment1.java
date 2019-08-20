package com.qljy.myapplication.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.qljy.myapplication.R;

public class Fragment1 extends Fragment {
    TextView textView;
    TextView withArgTextView;
    TextView toSecondTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment1,container,false);
        textView=rootView.findViewById(R.id.text_view1);
        withArgTextView=rootView.findViewById(R.id.text_view_arg);
        toSecondTextView=rootView.findViewById(R.id.text_view_to_activity);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //直接bundle传值，不需要使用safearg差价
                Bundle bundle=new Bundle();
                bundle.putString("KEY","一二三四");
                Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment2,bundle);

            }
        });
        withArgTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //隐式跳转
                NavController navController = Navigation.findNavController(view);
                navController.navigate(Uri.parse("https://www.ztyhero.com"));
            }
        });
        toSecondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Navigation.findNavController(view).navigate(R.id.action_fragment1_to_secondActivity);
            }
        });
    }
}
