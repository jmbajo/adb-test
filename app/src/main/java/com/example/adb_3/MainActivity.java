package com.example.adb_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button home_bt;
    Button swipe_bt;
    TextView input_tv;


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int x = (int)event.getX();
        int y = (int)event.getY();

        System.out.println("" + x +" " + y);

        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_bt = findViewById(R.id.home_bt);
        home_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process process = null;
                try {
//                    Process proc = Runtime.getRuntime().exec(new String[] { "su", "-c", "input keyevent 4"});
//                    proc.waitFor();
                    process = Runtime.getRuntime().exec("input keyevent 4");
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        swipe_bt = findViewById(R.id.screenshot_bt);
        swipe_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Process process = null;
                try {
//                    process = Runtime.getRuntime().exec("input keyevent 120");
                    process = Runtime.getRuntime().exec("input swipe " + input_tv.getText());
                    System.out.println("input swipe " + input_tv.getText());
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        input_tv = findViewById(R.id.input_coordinates);


    }
}