package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class CheatAtivity extends AppCompatActivity {

    private final String TAG = "CheatActivity";
    private static final String CHEAT_INDEX = "CHEAT_INDEX";

    public static Intent newIntent(Context context,int i){
        Intent intent =new Intent(context,CheatAtivity.class);
        intent.putExtra(CHEAT_INDEX,i);
        return intent;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat_ativity);
        Log.d(TAG,"inside OnCreate");
        int i= getIntent().getIntExtra(CHEAT_INDEX, -999);
        Log.d(TAG,"Received value"+i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"inside Onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"inside OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"inside OnDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"inside OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"inside OnResume");
    }
}