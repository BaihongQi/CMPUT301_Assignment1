package com.example.bq.assignment1;

import java.util.ArrayList;

/**
 * Created by bq on 9/29/15.
 */
public class TimeList extends Object{
    static ArrayList times=new ArrayList<Float>();
    //private Float mostRecentTime;


    public static ArrayList<Float> getAllTimes(){
        return times;
    }
    public static void clearTimes(){
        times.clear();
    }
    public static ArrayList<Float> getLastTen(){
        ArrayList lastTen=new ArrayList<Float>();
        for (int i=0;i<11;i++){
            if ((times.size() - i) >= 0) {
               lastTen.add(times.get(times.size()-i));
            }
        }
        return lastTen;
    }
    public static ArrayList<Float> getLastHundred(){
        ArrayList lastHundred=new ArrayList<Float>();
        for (int i=0;i<101;i++){
            if ((times.size() - i) >= 0) {
                lastHundred.add(times.get(times.size() - i));
            }
        }
        return lastHundred;
    }

}
