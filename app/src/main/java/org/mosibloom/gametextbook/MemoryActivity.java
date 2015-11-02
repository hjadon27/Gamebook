package org.mosibloom.gametextbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mosi.bloom.game.support.Card;
import mosi.bloom.game.support.Player;

/**
 * @Author: Harendra Kumar
 */
public class MemoryActivity extends ActionBarActivity {

//    Construstor
    public MemoryActivity(){
        super();
        btnList = new ArrayList<Button>();
        faces = new ArrayList<String>();
        faceNumMap = new HashMap<String, Integer>();
    }

//    static and instance variables
    static int counter=0;
    static int btnColor = R.color.background_material_dark;
    static int level = 0;
    public int time=0;
    public static final String HIGHSCORE_MEMORY_KEY = "highScoreMemory";
    static int highscore=0;
    static List<String> faces;
    static Map<String, Integer> faceNumMap;
    Button click1;
    Button click2;
    Player pOne;
    int state =0;
    int gameOver=16;
    Map<Integer, Integer> btnMap = new HashMap<Integer, Integer>();
    List<Button> btnList = new ArrayList<Button>();
    TextView moves;
    TextView highscoreField;
    TextView tv;
    MediaPlayer matchSound;
    MediaPlayer winSound;
    RelativeLayout relativeLayout;
    SharedPreferences sharedPreferences ;

    public void putCardFaces(int level) {
        faceNumMap.clear();
        switch (level){
            case 0:
                faceNumMap.put("bin", R.drawable.bin);faceNumMap.put("ragon", R.drawable.ragon);
                faceNumMap.put("camera", R.drawable.camera);faceNumMap.put("drov", R.drawable.drov);
                faceNumMap.put("zero", R.drawable.zero);faceNumMap.put("cross", R.drawable.cross);
                faceNumMap.put("lense", R.drawable.lense); faceNumMap.put("vallet", R.drawable.vallet);
                break;
            case 1:
                selectTheme(R.color.material_blue_grey_950, R.color.link_text_material_dark);
                faceNumMap.put("bin", R.drawable.one);faceNumMap.put("ragon", R.drawable.two);
                faceNumMap.put("camera", R.drawable.three);faceNumMap.put("drov", R.drawable.four);
                faceNumMap.put("zero", R.drawable.five);faceNumMap.put("cross", R.drawable.six);
                faceNumMap.put("lense", R.drawable.seven); faceNumMap.put("vallet", R.drawable.eight);
                break;
            case 2:
                selectTheme(R.color.ripple_material_light, R.color.link_text_material_light);
                faceNumMap.put("bin", R.drawable.one2);faceNumMap.put("ragon", R.drawable.two2);
                faceNumMap.put("camera", R.drawable.three2);faceNumMap.put("drov", R.drawable.four2);
                faceNumMap.put("zero", R.drawable.five2);faceNumMap.put("cross", R.drawable.six2);
                faceNumMap.put("lense", R.drawable.seven2); faceNumMap.put("vallet", R.drawable.eight2);
                break;

            case 3:
                selectTheme(R.color.material_blue_grey_800, R.color.ripple_material_light);
                faceNumMap.put("bin", R.drawable.bin1);faceNumMap.put("ragon", R.drawable.ragon1);
                faceNumMap.put("camera", R.drawable.camera1);faceNumMap.put("drov", R.drawable.drov1);
                faceNumMap.put("zero", R.drawable.zero1);faceNumMap.put("cross", R.drawable.cross1);
                faceNumMap.put("lense", R.drawable.lense1); faceNumMap.put("vallet", R.drawable.vallet1);
                break;
            default:
                faceNumMap.put("bin", R.drawable.bin);
                faceNumMap.put("ragon", R.drawable.ragon);
                faceNumMap.put("camera", R.drawable.camera);
                faceNumMap.put("drov", R.drawable.drov);
                faceNumMap.put("zero", R.drawable.zero);
                faceNumMap.put("cross", R.drawable.cross);
                faceNumMap.put("vallet", R.drawable.vallet);
                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        counter=state=0;

        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button b10 = (Button) findViewById(R.id.b10);
        Button b11 = (Button) findViewById(R.id.b11);
        Button b12 = (Button) findViewById(R.id.b12);
        Button b13 = (Button) findViewById(R.id.b13);
        Button b14 = (Button) findViewById(R.id.b14);
        Button b15 = (Button) findViewById(R.id.b15);
        Button b16 = (Button) findViewById(R.id.b16);

        moves = (TextView) findViewById(R.id.moves);
        highscoreField = (TextView) findViewById(R.id.highscore);
//        tv = (TextView) findViewById(R.id.timer);

//        List of Buttons in 4X4 matrix
        btnList.add(b1);btnList.add(b2);btnList.add(b3);btnList.add(b4);
        btnList.add(b5);btnList.add(b6);btnList.add(b7);btnList.add(b8);
        btnList.add(b9);btnList.add(b10);btnList.add(b11);btnList.add(b12);
        btnList.add(b13);btnList.add(b14);btnList.add(b15);btnList.add(b16);

//         Map for button name and id

        putCardFaces(level);

//        player created
        pOne = Player.createPlayer("Harendra");
        pOne.init();
        setButtonText();

        sharedPreferences = getBaseContext().getSharedPreferences(HIGHSCORE_MEMORY_KEY, Context.MODE_PRIVATE);
        highscore = sharedPreferences.getInt(HIGHSCORE_MEMORY_KEY, highscore);
        highscoreField.setText("Highscore : " + highscore);
        countDownTimer.onTick(100);
        matchSound = MediaPlayer.create(this, R.drawable.matchsound);
        winSound = MediaPlayer.create(this, R.drawable.levelcomplete);


    }

//      reset Game
    public void resetGame(View v) {
        setButtonText();
        countDownTimer.onTick(100);
    }

//    Game logic at each button click

    public void btnClick(View v) {

            Button b = (Button) findViewById(v.getId());
        if(b.isEnabled()){
            if(state==0) {
                b.setEnabled(false);

                b.setBackgroundResource(faceNumMap.get(b.getText()));
                gameOver--;
                click1 = b;
                state++;
                counter++;
            }
            else if(state==1){
                b.setEnabled(false);

                b.setBackgroundResource(faceNumMap.get(b.getText()));
                gameOver--;
                click2 = b;
                state++;
                if(click1.getText().equals(click2.getText())&&gameOver!=0) {
                    if (matchSound.isPlaying()) {
                        matchSound.seekTo(0);
                    }else {
                        matchSound.start();
                    }
                }
            }else{
                if(!click1.getText().equals(click2.getText())){

                    gameOver+=2;
                    click1.setEnabled(true);
                    click1.setBackgroundResource(btnColor);
                    click2.setEnabled(true);
                    click2.setBackgroundResource(btnColor);

                }
                b.setEnabled(false);

                b.setBackgroundResource(faceNumMap.get(b.getText()));
                gameOver--;
                state=1;
                click1 = b;
                counter++;
            }
        }
        if(gameOver==0){
            state = 0;
            levelComplete("Level" + level);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(HIGHSCORE_MEMORY_KEY, highscore);
            editor.commit();
        }
        moves.setText("Moves : " + counter + "      Level : " + level);
    }



    //Tie message
    public void levelComplete(String levelName){

        if(winSound.isPlaying()) {
            winSound.seekTo(0);
        }else {
            winSound.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String moveAlert = "Your total moves : " + counter;
        String scoreAlert = "Score : " + getScore();
        String cardsAlert = "Cards : " + "4X4 (16 cards)";
        String highscoreAlert = calculateHighScore();
        String timer = "Time Elasped " + time;
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Level " + level + " Completed !");
        alert.setMessage(moveAlert + "\n" + scoreAlert + "\n"
                + "\n" + timer + "\n" + cardsAlert + "\n"
                + "\n" + highscoreAlert);
        if(level<3) {
            level++;
            putCardFaces(level);
        }
        gameOver = 16;
//        restartGame();
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame(getCurrentFocus());
            }
        });
        alert.show();
    }

    public int getScore(){
        return (114 - counter)*10;
    }

    public String calculateHighScore(){
        Toast toast ;
        String returnValue;
        int previousHigh = highscore;
        highscore = getScore();
        if(previousHigh>highscore) {
            toast= Toast.makeText(getBaseContext(),"Your score is : "+ highscore, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 200);
            toast.show();
            returnValue = "Highscore: " + previousHigh;
            highscore = previousHigh;
        }else{
            toast= Toast.makeText(getBaseContext(), "New Highscore is : "+ highscore, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 200);
            toast.show();
            returnValue = "New Highscore : " + highscore;
        }
        return returnValue;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void switchGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_switchgame){
            switchGame(getCurrentFocus());
        }
        if(id == R.id.action_resetgame){
            resetGame(getCurrentFocus());
        }
        if (id == R.id.themebw){
            selectTheme(R.color.background_material_dark, R.color.button_material_light);
        }
        if (id == R.id.themewb){
            selectTheme(R.color.button_material_light, R.color.background_material_dark);
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectTheme(int backgrd, int buttonColor){
        relativeLayout.setBackgroundResource(backgrd);
        btnColor = buttonColor;
        resetGame(getCurrentFocus());
    }


    public void setButtonText(){
        Card.getDeck(true);
        counter= 0;
        state = 0;
        time = 0;
        countDownTimer.onTick(100);
        gameOver = 16;
        highscoreField.setText("Highscore : " + highscore);
        for(int loop = 0;loop<btnList.size();loop++) {
            btnList.get(loop).setText(Card.getDeck().get(loop).getValue());
            btnList.get(loop).setBackgroundResource(btnColor);
            btnList.get(loop).setEnabled(true);
            btnMap.put(btnList.get(loop).getId(), loop );
        }
        System.out.print(Card.getDeck());
    }


//    public void timer(){
        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                time ++;
                tv = (TextView) findViewById(R.id.timer);
                tv.setText("Elapsed Time : " + time + "         ");
            }
            public void onFinish() {
                tv.setText("done!");
            }
        }.start();

    public void setTextValue(int text){
        tv.setText(String.valueOf(time));
    }
}
