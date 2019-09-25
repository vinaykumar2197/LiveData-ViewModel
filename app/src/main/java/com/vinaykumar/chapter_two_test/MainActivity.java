package com.vinaykumar.chapter_two_test;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel ;

    TextView tvCountVal;
    FloatingActionButton fbAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCountVal = (TextView) findViewById(R.id.tv_count_val);
        fbAdd = (FloatingActionButton) findViewById(R.id.fb_increment);



        mainActivityViewModel=ViewModelProviders.of(this).get(MainActivityViewModel.class);


//        tvCountVal.setText(""+mainActivityViewModel.getInitialCount());
//        mainActivityViewModel.mutableLiveData.observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(@Nullable Integer integer) {
//                tvCountVal.setText(mainActivityViewModel.getInitialCount().toString());
//            }
//        });

        LiveData<Integer> count = mainActivityViewModel.getInitialCount();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                tvCountVal.setText("Count is: "+integer);
            }
        });
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.getCurrentCount();
            }
        });

    }
}
