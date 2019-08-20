package com.qljy.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.qljy.myapplication.R;

public class Fragment4 extends Fragment {
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment4,container,false);
        textView=rootView.findViewById(R.id.text_view4);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //popBackStack的方法
                //1.无参数条件小只pop第一个
                //2.有参数条件下pop第一个参数是 到哪,第二个参数是包不包括第一个参数本身；包括的话选true，执行完下面的会直接出现fragment1;包括的话选false，执行完下面的会直接出现fragment2
                Navigation.findNavController(view).popBackStack(R.id.fragment2,false);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
