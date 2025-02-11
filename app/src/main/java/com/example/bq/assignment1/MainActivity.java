package com.example.bq.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
//react to the click of the button to another activity
    public void singleModeIntro(View view){
        AlertDialog.Builder adb= new AlertDialog.Builder(MainActivity.this);
        adb.setMessage("In this mode, click start button to start, then you should click as quick as you can after you see 'click' is shown on the screen. ");
        adb.setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this,SingleModeActivity.class);
                startActivity(intent);

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    //jump to buzzer activity
    public void buzzerMode (View view){
        Intent intent = new Intent(MainActivity.this,BuzzerActivity.class);
        startActivity(intent);
    }
    //jump to statistics activity
    public void statistics (View view){
        Intent intent = new Intent(MainActivity.this,Statistics.class);
        startActivity(intent);
    }

}
