package com.example.kamil.magicsquares;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public EditText text1;
    public EditText text2;
    public EditText text3;
    public EditText text4;
    public EditText text5;
    public EditText text6;
    public EditText text7;
    public EditText text8;
    public EditText text9;
    public TextView textV1;
    public TextView textV2;
    public TextView textV3;
    public TextView textV4;
    public TextView textV5;
    public TextView textV6;
    //public TextView check;

    int[] table = new int[6];
    public void generating() {
        textV1 = (TextView) findViewById(R.id.textView1);
        textV2 = (TextView) findViewById(R.id.textView2);
        textV3 = (TextView) findViewById(R.id.textView3);
        textV4 = (TextView) findViewById(R.id.textView4);
        textV5 = (TextView) findViewById(R.id.textView5);
        textV6 = (TextView) findViewById(R.id.textView6);
        Random generate = new Random();
        int x = 0;
        while (x != 90) {
            x=0;
            for (int i = 0; i < 6; i++) {
                table[i] = generate.nextInt(10) + 10;
                x+=table[i];
            }

        }
        textV1.setText(String.valueOf(table[0]));
        textV2.setText(String.valueOf(table[1]));
        textV3.setText(String.valueOf(table[2]));
        textV4.setText(String.valueOf(table[3]));
        textV5.setText(String.valueOf(table[4]));
        textV6.setText(String.valueOf(table[5]));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generating();

    }



    public void close(View view){
       finish();
    }

    public boolean check(){
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        text9 = (EditText) findViewById(R.id.editText9);
        int t1 = Integer.parseInt(text1.getText().toString());
        int t2 = Integer.parseInt(text2.getText().toString());
        int t3 = Integer.parseInt(text3.getText().toString());
        int t4 = Integer.parseInt(text4.getText().toString());
        int t5 = Integer.parseInt(text5.getText().toString());
        int t6 = Integer.parseInt(text6.getText().toString());
        int t7 = Integer.parseInt(text7.getText().toString());
        int t8 = Integer.parseInt(text8.getText().toString());
        int t9 = Integer.parseInt(text9.getText().toString());
        int sum = t1+t2+t3+t4+t5+t6+t7+t8+t9;
        boolean checked;
        checked=false;
        if(sum == 45){
            int row1,row2,row3,col1,col2,col3;
            row1=t1+t2+t3;
            row2=t4+t5+t6;
            row3=t7+t8+t9;
            col1=t1+t4+t7;
            col2=t2+t5+t8;
            col3=t3+t6+t9;
            if (row1==table[0] && row2==table[1] && row3==table[2]){
                if (col1==table[5] && col2==table[4] && col3==table[3]){
                    checked=true;

                }
            }
        }
        else {
            checked=false;
        }

        return checked;
    }
    public void submit(View view){
        if(check()){
            Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "BAD", Toast.LENGTH_SHORT).show();
        }
    }
}
