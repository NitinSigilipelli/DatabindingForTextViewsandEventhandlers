package com.example.databindingfortextviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.databindingfortextviews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Person person1 = new Person("Nitin","Nitin@gmail.com");
        //TextViews
        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );
        activityMainBinding.setPerson(person1);

        //Binding the Handler
        clickHandler = new MainActivityClickHandler(this);
        activityMainBinding.setClickHandler(clickHandler);


    }
    public class MainActivityClickHandler{
        Context context;

        public MainActivityClickHandler(Context context) {
            this.context = context;
        }
        //First Button Click handling
        public void onButton1Click(View view){
            Toast.makeText(context, "Hello my friends", Toast.LENGTH_SHORT).show();
        }
        //Second Button Click handling
        public void onButton2Click(View view){
            Toast.makeText(context, "Bye Bye my Friends", Toast.LENGTH_SHORT).show();
        }

    }
}