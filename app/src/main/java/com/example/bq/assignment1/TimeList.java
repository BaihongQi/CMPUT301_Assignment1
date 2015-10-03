package com.example.bq.assignment1;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * Created by bq on 9/29/15.
 */
public class TimeList extends Object{
    private final String FILENAME = "LatencyData.sav";
    //static ArrayList <Double>times=new ArrayList<Double>();
    private ArrayList times=new ArrayList<Double>();
    private Context context;
    //private Double mostRecentTime;


    public TimeList(Context context) {
        this.context=context;
    }
    public void addLatency(Double time){
        times.add(time);
    }
    public void setTimes(ArrayList<Double> times){
        this.times=times;
    }
    public ArrayList<Double> getAllTimes(){
        return times;
    }
    public void clearTimes(){
        times.removeAll(times);
    }
    public ArrayList<Double> getLastTen() {
        if (times.size() <= 10) {
            return times;
        } else {
            ArrayList lastTen = new ArrayList<Double>();
            for (int i = 1; i < 11; i++) {
                //if ((times.size() - i) > 0) {
                    lastTen.add(times.get(times.size() - i));
                //}
            }
            return lastTen;
        }
    }
    public ArrayList<Double> getLastHundred() {
        if (times.size() <= 100) {
            return times;
        } else {
            ArrayList lastHundred = new ArrayList<Double>();
            for (int i = 1; i < 101; i++) {
                //if ((times.size() - i) > 0) {
                    lastHundred.add(times.get(times.size() - i));
                //}
            }
            return lastHundred;
        }
    }
    public void saveInFile() {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(times,writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new  RuntimeException(e);
        } catch (IOException e) {
            throw new  RuntimeException(e);
        }
    }

    public void loadFromFile() {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson =new Gson();
            //Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<Double>>() {}.getType();
            times=(gson.fromJson(in, listType));
        } catch (FileNotFoundException e) {
            times= new ArrayList<Double>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
