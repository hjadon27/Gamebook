package org.mosibloom.gametextbook;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NoSnooze extends ActionBarActivity {


    Button noSnooze;
    Button cancel;
    MediaPlayer lightmyfire;    static int time = 10;
    public void callNoSnooze(View view){
        countDownTimer.onTick(100);
        if(time==0){
            lightmyfire.start();
        }
    }

    public void onCancel(View view){
        countDownTimer.cancel();
        time = 10;
    }

    //    timmer class
    CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

        public void onTick(long millisUntilFinished) {
            time--;
            if(time==0){
                countDownTimer.onFinish();
            }
        }
        public void onFinish() {
            onCancel(getCurrentFocus());
        }
    }.start();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_snooze);
//        noSnooze = (Button) findViewById(R.id.nosnoozebtc);
//        cancel = (Button) findViewById(R.id.cancelbtn);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_no_snooze, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
