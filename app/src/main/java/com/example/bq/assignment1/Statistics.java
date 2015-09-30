package com.example.bq.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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






    public void startStat(){
        ArrayList times=TimeList.getAllTimes();
        ArrayList lastTen=TimeList.getLastTen();
        ArrayList lastHundred= TimeList.getLastHundred();
        bodyText= (TextView) findViewById(R.id.screen_text);


        bodyText.setText("Single Player Stat:\n" +"Average of all times: " + findAve(times) + " seconds\n"
                        + "Average of last ten: " + findAve(lastTen) + " seconds\n"+
                        "Average of last hundred: " + findAve(lastHundred) + " seconds\n"+"mini of all"+findMin(times)+"max of all"+findMax(times)+"median of all"+findMedian(times));



    }
    public Float findMin(ArrayList list){
        float min=(float)list.get(0);
        for(int i=0;i<list.size();i++){
            if ((float)list.get(i)<min){
                min=(float)list.get(i);
            }
        }
        return min;
    }

    public Float findMax(ArrayList list){
        float max=(float)list.get(0);
        for(int i=0;i<list.size();i++){
            if ((float)list.get(i)>max){
                max=(float)list.get(i);
            }
        }
        return max;
    }
    public Float findMedian(ArrayList list){
        float median;
        float[] floatArray = new float[list.size()];
        for (int i=0;i<list.size();i++) {
            floatArray[i] = ((float)list.get(i));
        }
        Arrays.sort(floatArray);
        if (floatArray.length % 2 == 0){
            median = (floatArray[floatArray.length/2] + floatArray[floatArray.length/2 - 1])/2;
        } else {
            median = floatArray[floatArray.length / 2];
        }
        return median;
    }
    public Float findAve(ArrayList list){
        float Ave;
        float sum=0;
        float[] floatArray = new float[list.size()];
        for (int i=0;i<list.size();i++) {
            floatArray[i] = ((float)list.get(i));
        }
        for(float i :floatArray){
            sum += i;
        }
        Ave=sum/list.size();
        return Ave;
    }










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
    /*private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson =new Gson();
            //Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<Float>>() {}.getType();
            StatisticsController.setSingleStatistics(gson.fromJson(in,listType));
        } catch (FileNotFoundException e) {
            //tweets = new ArrayList<Tweet>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }*/




}

