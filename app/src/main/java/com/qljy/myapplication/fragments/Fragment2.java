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

public class Fragment2 extends Fragment {
    TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment2,container,false);
        textView=rootView.findViewById(R.id.text_view2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这个方法是使用了safeargs插件才可以使用
                Fragment2Directions.ActionFragment2ToFragment3 action=Fragment2Directions.actionFragment2ToFragment3();
                //name是在目标Fragment定义的属性
                action.setName("pain");
                Navigation.findNavController(view).navigate(action);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //使用这个方法接受fragment1传过来的参数
        textView.setText(getArguments().getString("KEY"));
    }
}
