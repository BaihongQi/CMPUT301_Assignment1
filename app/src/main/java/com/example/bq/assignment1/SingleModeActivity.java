package com.example.bq.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SingleModeActivity extends ActionBarActivity {
    //ArrayList<Double> times=new ArrayList<Double>();
    private TextView bodyText;
    private Double randomNum;
    private Boolean ifclicked;
    Timer mytimer;
    private Random rn;
    long starttime;
    double diff;
    TimeList myTimeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mode);
        bodyText = (TextView)findViewById(R.id.textView4);
        bodyText.setText("click react to start the game");
        ifclicked=Boolean.FALSE;//show if the the game have already start
        myTimeList=new TimeList(this);
    }
//http://stackoverflow.com/questions/4597690/android-timer-how

    public void click(View view) {
        // if the game have not started yet,clcik to start
        if(ifclicked==Boolean.FALSE){
            bodyText.setText("game Start! click as quick as you can after you see the click button");
            Button mainButton=(Button)findViewById(R.id.react);
            mainButton.setText("react");
            ifclicked=Boolean.TRUE;
            rn=new Random();
            randomNum=new Double(rn.nextInt(1991)+10);
            mytimer = new Timer();
            starttime=System.currentTimeMillis();
            mytimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            diff = System.currentTimeMillis() - starttime;
                            if (diff >= (Double) randomNum) {
                                bodyText.setText("click");
                                ifclicked=Boolean.TRUE;
                            }
                        }
                    });
                }
            },0, 100);
        }else{
            //check if the game has started, then click to stop and show latency
            diff = System.currentTimeMillis() - starttime;
            mytimer.cancel();
            if(diff<(double)randomNum){
                bodyText.setText("you press early");
                Button mainButton=(Button)findViewById(R.id.react);
                mainButton.setText("start");
                //starttime=System.currentTimeMillis();
                ifclicked=Boolean.FALSE;
            }else{
                Double latency=(Double)(diff -randomNum);
                latency= latency/1000.0;
                myTimeList.addLatency(latency);
                myTimeList.saveInFile();
                bodyText.setText("Your latency is" + Double.toString(latency) + "s");
                Button mainButton=(Button)findViewById(R.id.react);
                mainButton.setText("start");
                ifclicked=Boolean.FALSE;

            }

        }

    }


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
