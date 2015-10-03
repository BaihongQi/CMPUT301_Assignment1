package com.example.bq.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreePlayer extends ActionBarActivity {
    BuzzerTime myBuzzerTime=new BuzzerTime((this));
    private TextView text;
    private ArrayList buzzerdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myBuzzerTime.loadFromFile();
        buzzerdata=myBuzzerTime.getBuzzers();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_player);
        //myBuzzerTime=new BuzzerTime(this);
        //Button playeroneButton=(Button)findViewById(R.id.playerone);
        //Button playertwoButton=(Button)findViewById(R.id.playertwo);
    }
    public void onePress(View view){
        //text = (TextView)findViewById(R.id.textView5);
        //text.setText("Player one pressed");
        Integer num=31;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(ThreePlayer.this);
        adb.setMessage("player one pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView) findViewById(R.id.textView6);
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
        //text = (TextView)findViewById(R.id.textView5);
        //text.setText("Player two pressed");
        Integer num=32;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(ThreePlayer.this);
        adb.setMessage("player two pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView)findViewById(R.id.textView6);
                text.setText("Restarted, you can now buzzer");
                //Intent intent = getIntent();
                //finish();
                //startActivity(intent);
            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    public void threePress(View view){
        //text = (TextView)findViewById(R.id.textView5);
        //text.setText("Player two pressed");
        Integer num=33;
        buzzerdata.add(num);
        myBuzzerTime.setBuzzers(buzzerdata);
        myBuzzerTime.saveInFile();
        AlertDialog.Builder adb= new AlertDialog.Builder(ThreePlayer.this);
        adb.setMessage("player three pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                text = (TextView)findViewById(R.id.textView6);
                text.setText("Restarted, you can now buzzer");
                //Intent intent = getIntent();
                //finish();
                //startActivity(intent);
            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player, menu);
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
