package com.example.bq.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class FourPlayer extends ActionBarActivity {
    BuzzerTime myBuzzerTime=new BuzzerTime((this));
    private TextView text;
    private ArrayList buzzerdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myBuzzerTime.loadFromFile();
        buzzerdata=myBuzzerTime.getBuzzers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);

    }

    //when somebody press player1, then add 41 to the arraylist
    public void onePress(View view){
        Integer num=41;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(FourPlayer.this);
        adb.setMessage("player one pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView) findViewById(R.id.textView7);
                text.setText("Restarted, you can now buzzer");
                //Intent intent = getIntent();
                //finish();
                //startActivity(intent);

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void twoPress(View view){
        Integer num=42;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(FourPlayer.this);
        adb.setMessage("player two pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView) findViewById(R.id.textView7);
                text.setText("Restarted, you can now buzzer");


            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void threePress(View view){
        Integer num=43;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        //myBuzzerTime.addBuzzers(num);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(FourPlayer.this);
        adb.setMessage("player three pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView) findViewById(R.id.textView7);
                text.setText("Restarted, you can now buzzer");

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void fourPress(View view){
        Integer num=44;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        //myBuzzerTime.addBuzzers(num);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(FourPlayer.this);
        adb.setMessage("player four pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView) findViewById(R.id.textView7);
                text.setText("Restarted, you can now buzzer");

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player, menu);
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
