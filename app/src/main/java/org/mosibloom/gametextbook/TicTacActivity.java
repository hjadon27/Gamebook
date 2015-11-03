package org.mosibloom.gametextbook;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mosibloom.gametextbook.MyAlert;


public class TicTacActivity extends AppCompatActivity {

        int playerX = 0;
        int playerO = 0;
        TextView playerx;
        TextView playero;

        boolean tieCheck = true;


        int count = 0;
        Button b1;
        Button b2;
        Button b3;
        Button b4;
        Button b5;
        Button b6;
        Button b7;
        Button b8;
        Button b9;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tic_tac);

            b1 = (Button) findViewById(R.id.b1);
            b2 = (Button) findViewById(R.id.b2);
            b3 = (Button) findViewById(R.id.b3);
            b4 = (Button) findViewById(R.id.b4);
            b5 = (Button) findViewById(R.id.b5);
            b6 = (Button) findViewById(R.id.b6);
            b7 = (Button) findViewById(R.id.b7);
            b8 = (Button) findViewById(R.id.b8);
            b9 = (Button) findViewById(R.id.b9);


            playerx = (TextView) findViewById(R.id.playerXWinnings);
            playerx.setText("Player 1 :  wins");

            playero = (TextView) findViewById(R.id.playerOWinnings);
            playero.setText("Player 2 :  wins");


        }

        public void resetGame(View v) {
        /*Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);*/

        }

        public void restartGame() {b1.setBackgroundResource(R.drawable.tictactoe);
            tieCheck = true;
            count = 0;

            b2.setBackgroundResource(R.drawable.tictactoe);
            b3.setBackgroundResource(R.drawable.tictactoe);
            b4.setBackgroundResource(R.drawable.tictactoe);
            b5.setBackgroundResource(R.drawable.tictactoe);
            b6.setBackgroundResource(R.drawable.tictactoe);
            b7.setBackgroundResource(R.drawable.tictactoe);
            b8.setBackgroundResource(R.drawable.tictactoe);
            b9.setBackgroundResource(R.drawable.tictactoe);

            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);

            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
        }


        public void b1Click(View v) {

            if (count % 2 == 0) {
                b1.setText("X");

                b1.setBackgroundResource(R.drawable.cross);

                b1.setEnabled(false);


            } else {
                b1.setText("O");
                b1.setBackgroundResource(R.drawable.zero);


                b1.setEnabled(false);

            }
            gamelogic();
            count++;
        }

        public void b2Click(View v) {

            if (count % 2 == 0) {
                b2.setText("X");

                b2.setBackgroundResource(R.drawable.cross);

                b2.setEnabled(false);

            } else {
                b2.setText("O");


                b2.setBackgroundResource(R.drawable.zero);


                b2.setEnabled(false);

            }
            gamelogic();
            count++;
        }

        public void b3Click(View v) {

            if (count % 2 == 0) {
                b3.setText("X");

                b3.setBackgroundResource(R.drawable.cross);

                b3.setEnabled(false);


            } else {
                b3.setText("O");

                b3.setBackgroundResource(R.drawable.zero);


                b3.setEnabled(false);

            }
            gamelogic();
            count++;
        }

        public void b4Click(View v) {

            if (count % 2 == 0) {
                b4.setText("X");

                b4.setBackgroundResource(R.drawable.cross);


                b4.setEnabled(false);


            } else {
                b4.setText("O");

                b4.setBackgroundResource(R.drawable.zero);


                b4.setEnabled(false);
            }
            gamelogic();
            count++;
        }

        public void b5Click(View v) {

            if (count % 2 == 0) {
                b5.setText("X");

                b5.setBackgroundResource(R.drawable.cross);

                b5.setEnabled(false);


            } else {
                b5.setText("O");

                b5.setBackgroundResource(R.drawable.zero);


                b5.setEnabled(false);


            }
            gamelogic();
            count++;
        }

        public void b6Click(View v) {

            if (count % 2 == 0) {
                b6.setText("X");

                b6.setBackgroundResource(R.drawable.cross);

                b6.setEnabled(false);


            } else {
                b6.setText("O");

                b6.setBackgroundResource(R.drawable.zero);


                b6.setEnabled(false);

            }
            gamelogic();
            count++;
        }

        public void b7Click(View v) {

            if (count % 2 == 0) {
                b7.setText("X");

                b7.setBackgroundResource(R.drawable.cross);

                b7.setEnabled(false);


            } else {
                b7.setText("O");

                b7.setBackgroundResource(R.drawable.zero);

                b7.setEnabled(false);


            }
            gamelogic();
            count++;
        }

        public void b8Click(View v) {
            if (count % 2 == 0) {
                b8.setText("X");

                b8.setBackgroundResource(R.drawable.cross);

                b8.setEnabled(false);


            } else {
                b8.setText("O");

                b8.setBackgroundResource(R.drawable.zero);

                b8.setEnabled(false);


            }
            gamelogic();
            count++;
        }

        public void b9Click(View v) {
            if (count % 2 == 0) {
                b9.setText("X");

                b9.setBackgroundResource(R.drawable.cross);

                b9.setEnabled(false);


            } else {
                b9.setText("O");

                b9.setBackgroundResource(R.drawable.zero);


                b9.setEnabled(false);


            }
            gamelogic();
            count++;
        }

        public void gamelogic() {
            try {
                //Horizontal checks for player X
                boolean horiChecksX = (b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X"))
                        || (b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X"))
                        || (b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X"));

                //Vertical checks for player X
                boolean vertiChecksX =  (b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X"))
                        || (b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X"))
                        || (b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")) ;

                //Cross checks for player X
                boolean crossChecksForX =  (b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X"))
                        || (b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X"));

                // check if player X wins
                boolean playerXWins = (horiChecksX || vertiChecksX || crossChecksForX);


                //Horizontal checks for player O
                boolean horiChecksO = (b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O"))
                        ||(b4.getText().equals("O") && b5.getText().equals("O") && b6.getText().equals("O"))
                        ||(b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")) ;

                //Vertical checks for player O
                boolean vertiChecksO =  (b1.getText().equals("O") && b4.getText().equals("O") && b7.getText().equals("O"))
                        || (b2.getText().equals("O") && b5.getText().equals("O") && b8.getText().equals("O"))
                        || (b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O")) ;

                //Cross checks for player O
                boolean crossChecksForO = (b3.getText().equals("O") && b5.getText().equals("O") && b7.getText().equals("O"))
                        ||(b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O")) ;

                //Checks if player O wins
                boolean playerOWins = (horiChecksO || vertiChecksO || crossChecksForO);

                //Who wins
                if(playerXWins){ playerXWins();}
                if(playerOWins){ playerOWins();}

                //tie check
                if (count == 8 && tieCheck) {
                    tieMessage();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Winning message if player X wins
        public void playerXWins(){
            tieCheck = false;
            count = 0;
            restartGame();
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Winning Moment :)");
            alert.setMessage("Player X wins");
            playerX++;
            playerx.setText("Player X : " + playerX + " wins");
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    restartGame();

                }
            });
            alert.show();
        }

        //Winning message if player O wins
        public void playerOWins(){
            tieCheck = false;
            count = 0;
            restartGame();
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Winning Moment :)");
            alert.setMessage("Player O wins");
            playerO++;
            playero.setText("Player O : " + playerO + " wins");
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    restartGame();

                }
            });
            alert.show();
        }

        //Tie message
        public void tieMessage(){
            restartGame();
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Tie!!! :-|");
            alert.setMessage("Oopsss! that was a tie game.");

            restartGame();
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    restartGame();
                }
            });
            alert.show();
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
            if(id == R.id.action_switchgame){
                switchGame(getCurrentFocus());
            }
            if(id == R.id.action_resetgame){
                restartGame();
            }

            return super.onOptionsItemSelected(item);
        }

        public void switchGame(View view){
            Intent intent = new Intent(this, MainActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
    @Override
    public void onBackPressed() {
        /*AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Want to exit? :(");
        alert.setMessage("Are you sure you want to exit?");


        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                System.exit(0);


            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();*/

        MyAlert alert = new MyAlert();

        alert.show(getFragmentManager(), "my alert");
    }


}
