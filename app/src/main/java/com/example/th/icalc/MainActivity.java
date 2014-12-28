package com.example.th.icalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MyActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)
                findViewById(R.id.textView);
        if (savedInstanceState != null)   {
            textView.setText(
                    savedInstanceState.getCharSequence("myText"));}
        textView.append("WOOHOO\n");

        Button  button=(Button)findViewById(R.id.button);
        MyOnClickListener Listener=new
                MyOnClickListener();
        button.setOnClickListener(Listener);

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

    private int total = 0;

    List<String> inputs = new ArrayList<String>();

    public void onButtonClick(View v) {
        String num1 = "";
        String sign = "";

        Button button = (Button) v;
        String bText = (String) button.getText();
        //int value = Integer.parseInt(bText);
        inputs.add(bText);

        //total += value;

        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        for (String element : inputs) {
            if (!element.equals("+") && !element.equals("-") && !element.equals("*")
                    && !element.equals("/") && !element.equals("=")) {
                num1+= element;
                myTextView.setText(num1);
            } else {
                sign = element;
                myTextView.setText(sign);
            }
        }
        //myTextView.setText(Integer.toString(total));
    }

    @Override
    protected void onSaveInstanceState(
            Bundle savedInstanceState){
        savedInstanceState.putCharSequence(
                "myText",textView.getText());
        super.onSaveInstanceState(savedInstanceState);
    }

    View.OnClickListener Listener= new View.OnClickListener(){
    @Override
    public void onClick(View view) {
                    //Implement event handling
     }
     }
}
