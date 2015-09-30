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
        //Intent intent = new Intent(MainActivity.this,SingleModeIntroActivity.class);
        //startActivity(intent);
        AlertDialog.Builder adb= new AlertDialog.Builder(MainActivity.this);
        adb.setMessage("this is introduction");
        adb.setPositiveButton("dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //text = (TextView) findViewById(R.id.textView5);
                //text.setText("Restarted, you can now buzzer");
                Intent intent = new Intent(MainActivity.this,SingleModeActivity.class);
                startActivity(intent);

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void buzzerMode (View view){
        Intent intent = new Intent(MainActivity.this,BuzzerActivity.class);
        startActivity(intent);
    }
    public void statistics (View view){
        Intent intent = new Intent(MainActivity.this,Statistics.class);
        startActivity(intent);
    }

}
