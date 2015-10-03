package com.example.bq.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

public class Statistics extends ActionBarActivity {
    private static final String FILENAME = "file.sav";

    int twobuzzerone=0;
    int twobuzzertwo=0;
    int threebuzzerone=0;
    int threebuzzertwo=0;
    int threebuzzerthree=0;
    int fourbuzzerone=0;
    private TextView bodyText;
    //private ArrayList <Double>timelist = TimeList.getAllTimes();
    TimeList myTimeList=new TimeList((this));
    //ArrayList times;
    //ArrayList lastTen;
    //ArrayList lastHundred;

    public void startStat(){
        myTimeList.loadFromFile();
        /*ArrayList times=TimeList.getAllTimes();
        ArrayList lastTen=TimeList.getLastTen();
        ArrayList lastHundred= TimeList.getLastHundred();*/
        bodyText= (TextView) findViewById(R.id.screen_text);

        bodyText.setText("Single Player Stat:\n" +"Average of all times: " + findAve(myTimeList.getAllTimes()) + " seconds\n"
                        + "Average of last ten: " + findAve(myTimeList.getLastTen()) + " seconds\n"+
                        "Average of last hundred: " + findAve(myTimeList.getLastHundred()) + " seconds\n"+"mini of all"+findMin(myTimeList.getAllTimes())+"second\n"
                +"max of all"+findMax(myTimeList.getAllTimes())+"seconds\n" +
                "median of all"+findMedian(myTimeList.getAllTimes())+"seconds");



    }
    public Double findMin(ArrayList list){
        if (list.size()==0){
            return 0.0;
        }else {
            Double min = (Double) list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if ((Double) list.get(i) < min) {
                    min = (Double) list.get(i);
                }
            }
            return min;
        }
        }

    public Double findMax(ArrayList list){
        if (list.size()==0){
            return 0.0;
        }else {
            Double max = (Double) list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if ((Double) list.get(i) > max) {
                    max = (Double) list.get(i);
                }
            }
            return max;
        }
    }
    public Double findMedian(ArrayList list){
        if (list.size()==0){
            return 0.0;
        }else {
            Double median;
            Double[] DoubleArray = new Double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                DoubleArray[i] = ((Double) list.get(i));
            }
            Arrays.sort(DoubleArray);
            if (DoubleArray.length % 2 == 0) {
                median = (DoubleArray[DoubleArray.length / 2] + DoubleArray[DoubleArray.length / 2 - 1]) / 2;
            } else {
                median = DoubleArray[DoubleArray.length / 2];
            }
            return median;
        }
    }
    public Double findAve(ArrayList list){
        if (list.size()==0){
            return 0.0;
        }else {
            Double Ave;
            Double sum = 0.0;
            Double[] DoubleArray = new Double[list.size()];
            for (int i = 0; i < list.size(); i++) {
                DoubleArray[i] = ((Double) list.get(i));
            }
            for (Double i : DoubleArray) {
                sum += i;
            }
            Ave = sum / list.size();
            return Ave;
        }
    }
    public void clear(View view){
        myTimeList.clearTimes();
        myTimeList.saveInFile();
        startStat();
    }

    /*public void fillUpLatency(){
        times=myTimeList.getAllTimes();
        //lastTen=myTimeList.getLastTen();
        //lastHundred=myTimeList.getLastHundred();
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        startStat();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_statistics, menu);
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

