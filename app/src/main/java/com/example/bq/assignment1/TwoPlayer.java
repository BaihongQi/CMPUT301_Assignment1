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

public class TwoPlayer extends ActionBarActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
        Button playeroneButton=(Button)findViewById(R.id.playerone);
        Button playertwoButton=(Button)findViewById(R.id.playertwo);

    }
    //http://stackoverflow.com/questions/2115758/how-to-display-alert-dialog-in-android
    public void onePress(View view){
        //text = (TextView)findViewById(R.id.textView5);
        //text.setText("Player one pressed");
        AlertDialog.Builder adb= new AlertDialog.Builder(TwoPlayer.this);
        adb.setMessage("player one pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //text = (TextView) findViewById(R.id.textView5);
                //text.setText("Restarted, you can now buzzer");
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void twoPress(View view){
        //text = (TextView)findViewById(R.id.textView5);
        //text.setText("Player two pressed");
        AlertDialog.Builder adb= new AlertDialog.Builder(TwoPlayer.this);
        adb.setMessage("player two pressed first");
        adb.setPositiveButton("ok, restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //text = (TextView)findViewById(R.id.textView5);
                //text.setText("Restarted, you can now buzzer");
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        adb.setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player, menu);
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
