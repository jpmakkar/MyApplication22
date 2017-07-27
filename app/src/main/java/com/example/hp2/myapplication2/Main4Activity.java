package com.example.hp2.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main4Activity extends AppCompatActivity {
    EditText txt5,txt6;
    TextView txtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txt5 = (EditText) findViewById(R.id.editText2);
        txt6 = (EditText) findViewById(R.id.editText4);
        txtt = (TextView) findViewById(R.id.textView2);
        Intent rcv = getIntent();
        Bundle rcvBundle = rcv.getBundleExtra("keyBundle2");
        String no1 = rcvBundle.getString("keyName2");
        String no2 = rcvBundle.getString("keyName3");





      int m=Integer.valueOf(no1);
        int n=Integer.valueOf(no2);
        txt5.setText(""+n);
        txt6.setText(""+m);
      jp(m,n);

    }
    void jp(int m,int n){
        int x=0;
        int z;

        int counter=1;
        while ((x+m)%n!=0)
        {
            z=(x+m)%n;
            x=z;

            counter++;
        }
        txtt.setText(""+counter);


    }
}
