package com.example.bq.assignment1;

import android.content.Context;

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
import java.util.ArrayList;

/**
 * Created by bq on 10/2/15.
 */
public class BuzzerTime extends Object{
    private final String FILENAME="BuzzerData.sav";
    private ArrayList buzzers=new ArrayList<Integer>();
    private Context context;
    public BuzzerTime(Context context) {
        this.context=context;
    }
    public void setBuzzers(ArrayList buzzers) {
        this.buzzers = buzzers;
    }
    public void clearBuzzers(){
        buzzers.removeAll(buzzers);
    }
    public ArrayList<Integer>getBuzzers(){
        return buzzers;
    }
    //using gson to save and load file
    public void saveInFile() {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(buzzers,writer);
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
            Type listType = new TypeToken<ArrayList<Integer>>() {}.getType();
            buzzers=(gson.fromJson(in, listType));
        } catch (FileNotFoundException e) {
            buzzers= new ArrayList<Integer>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
