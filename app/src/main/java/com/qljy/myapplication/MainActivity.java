package com.qljy.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NavController navController;
    TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView=findViewById(R.id.title_text_view);
        //获取NavHostFragment,要求 androidx.navigation.fragment.NavHostFragment
        navController= Navigation.findNavController(this,R.id.my_nav_host_fragment);
        //监听当前变化
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()){
                    case R.id.fragment1:
                        titleTextView.setText("界面一");
                        break;
                    case R.id.fragment2:
                        titleTextView.setText("界面二");
                        break;
                    case R.id.fragment3:
                        titleTextView.setText("界面三");
                        break;
                    case R.id.fragment4:
                        titleTextView.setText("界面四");
                        break;
                    case R.id.secondActivity:
                        Log.e("TAG", "activity" );
                        break;
                }
            }
        });


    }

}
