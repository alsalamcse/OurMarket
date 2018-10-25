package com.othman.ourmarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_mark);

    }

    @Override
    protected void onResume() {

        MyThread myThread1 = new MyThread();
        myThread1.start();
        super.onResume();
    }

    public class  MyThread extends Thread{
        @Override
        public void run() {
            try{
                sleep(3000);
                Intent i = new Intent(getApplicationContext(),MainTabsActivity.class);
                startActivity(i);

    }
    catch (InterruptedException e){
                e.printStackTrace();

    }

}}}
