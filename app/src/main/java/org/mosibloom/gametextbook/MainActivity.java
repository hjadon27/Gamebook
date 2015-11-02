package org.mosibloom.gametextbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private List<Button> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getButtonList();

//        Button tictactoeBtn = (Button) findViewById(R.id.tictacbtn);
        Button memoryBtn = (Button) findViewById(R.id.memorybtn);

//        buttonList.add(tictactoeBtn);
        buttonList.add(memoryBtn);


        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void selectTicTac(View view) {
            Intent intent = new Intent(this, TicTacActivity.class);
            startActivity(intent);
    }
    public void selectMemory(View view) {
        Intent intent = new Intent(this, MemoryActivity.class);
        startActivity(intent);
    }
    /*public void selectGame(View button){
        Intent intent;
        switch(button.getId()){
            case R.id.tictacbtn:
                intent = new Intent(this, TicTacActivity.class);
                startActivity(intent);
                break;
            case R.id.memorybtn:
                intent = new Intent(this, MemoryActivity.class);
                startActivity(intent);
                break;
            default:
                Toast toast = Toast.makeText(getBaseContext(), "No such game available...", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 200);
                toast.show();
                break;
        }*/



    public List<Button> getButtonList() {
        if(buttonList==null) {
            buttonList = new ArrayList<Button>();
        }
        return buttonList;
    }

    public void setButtonList(List<Button> buttonList) {
        this.buttonList = buttonList;
    }
}
