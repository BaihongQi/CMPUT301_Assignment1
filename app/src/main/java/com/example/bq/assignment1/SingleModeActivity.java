package com.example.bq.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SingleModeActivity extends ActionBarActivity {
    private TextView bodyText;
    private int randomNum;
    private Boolean ifclicked;
    Timer mytimer;
    private Random rn;
    long starttime;
    float diff;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mode);
        bodyText = (TextView)findViewById(R.id.textView4);
        bodyText.setText("click react to start the game");
        ifclicked=Boolean.FALSE;
        //Button mainButton=(Button)findViewById(R.id.react);



    }
//http://stackoverflow.com/questions/4597690/android-timer-how

    public void click(View view) {
        if(ifclicked==Boolean.FALSE){
            bodyText.setText("game Start! click as quick as you can after you see the click button");
            Button mainButton=(Button)findViewById(R.id.react);
            mainButton.setText("react");
            ifclicked=Boolean.TRUE;
            rn=new Random();
            randomNum=rn.nextInt(1991)+10;
            mytimer = new Timer();
            starttime=System.currentTimeMillis();
            //bodyText.setText("start " + Integer.toString((int)starttime));
            mytimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            diff = System.currentTimeMillis() - starttime;
                            if (diff >= (float) randomNum) {
                                bodyText.setText("click");
                                ifclicked=Boolean.TRUE;
                            }
                        }
                    });
                }
            },0, 100);
        }else{
            diff = System.currentTimeMillis() - starttime;
            mytimer.cancel();
            if(diff<(float)randomNum){
                bodyText.setText("you press early");
                Button mainButton=(Button)findViewById(R.id.react);
                mainButton.setText("start");
                //starttime=System.currentTimeMillis();
                ifclicked=Boolean.FALSE;
            }else{
                float latency=diff -randomNum;
                latency=(float)(latency/1000.0);
                StatisticsController.getSingleStatistics().add(latency);
                bodyText.setText("Your latency is" + Float.toString(latency) + "s");// /*+ "\nStart " + Integer.toString((int)starttime) + " End " + Integer.toString((int)(System.currentTimeMillis()))*/);
                Button mainButton=(Button)findViewById(R.id.react);
                mainButton.setText("start");
                ifclicked=Boolean.FALSE;

            }

        }

    }
    /*public void click(View view) {
        if(iclick==1){
            bodyText.setText("game Start! click as quick as you can after you see the click button");
            rn=new Random();
            //randomNum=rn.nextInt(1991)+10;
            randomNum=1000;
            mytimer = new Timer();
            starttime=System.currentTimeMillis();
            mytimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            diff = System.currentTimeMillis() - starttime;
                            if (diff >= (float) randomNum) {
                                ifclicked = Boolean.TRUE;
                                bodyText.setText("click");
                            }
        }
    }
                }*/





    /*public void click(View view) {
        if(ifclicked==Boolean.FALSE){
            bodyText.setText("game Start! click as quick as you can after you see the clik button");
            rn=new Random();
            //randomNum=rn.nextInt(1991)+10;
            randomNum=1000;
            mytimer = new Timer();
            starttime=System.currentTimeMillis();
            mytimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            diff = System.currentTimeMillis() - starttime;
                            if (diff >= (float) randomNum) {
                                ifclicked=Boolean.TRUE;
                                bodyText.setText("click");
                            }else{
                                bodyText.setText("you press early");
                                //starttime=System.currentTimeMillis();
                                ifclicked=Boolean.FALSE;
                            }
                        }
                    });
                }
            },0,1000);
        }else{
            float latency=diff -randomNum;
            latency=(float)(latency/1000.0);
            bodyText.setText("Your latency is"+Float.toString(latency));
            ifclicked=Boolean.FALSE;

            }

        }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_mode, menu);
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
