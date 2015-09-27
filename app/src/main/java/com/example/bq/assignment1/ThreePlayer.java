package com.example.bq.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreePlayer extends ActionBarActivity {
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_player);
        Button playeroneButton=(Button)findViewById(R.id.playerone);
        Button playertwoButton=(Button)findViewById(R.id.playertwo);
    }
    public void onePress(View view){
        text = (TextView)findViewById(R.id.textView6);
        text.setText("Player one pressed");
    }

    public void twoPress(View view){
        text = (TextView)findViewById(R.id.textView6);
        text.setText("Player two pressed");
    }
    public void threePress(View view){
        text = (TextView)findViewById(R.id.textView6);
        text.setText("Player three pressed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player, menu);
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
