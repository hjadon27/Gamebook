package org.mosibloom.gametextbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;


public class MosiBloomWelcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosi_bloom_welcome);
        countDownTimer.onTick(100);
    }


    @Override
    protected void onPause() {
        super.onPause();
        System.exit(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    int time = 7;
    //    timmer class
    CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

        public void onTick(long millisUntilFinished) {
        time--;
            if(time==0){
                countDownTimer.onFinish();
            }
        }
        public void onFinish() {
           switchGame(getCurrentFocus());
        }
    }.start();


    public void switchGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    }
