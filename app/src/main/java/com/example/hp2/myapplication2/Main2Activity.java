package com.example.hp2.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText txt,txt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("act1", "oncreate");
        Toast.makeText(this,"Activity2 - oncrt",Toast.LENGTH_LONG).show();

        txt = (EditText) findViewById(R.id.editText3);
        txt5 = (EditText) findViewById(R.id.editText5);

        Intent rcv = getIntent();
        Bundle rcvBundle = rcv.getBundleExtra("keyBundle");
        String no1 = rcvBundle.getString("keyName");

        txt5.setText(no1);


        //String name = rcv.getStringExtra("keyName");
        //String phone = rcv.getStringExtra("keyPhone");
        //int age = rcv.getIntExtra("keyAge",0);
       // Bundle rcvBundle = rcv.getBundleExtra("keyBundle");
       // String name = rcvBundle.getString("keyName");
       // String phone = rcvBundle.getString("keyPhone");
       // int age = rcvBundle.getInt("keyAge");
       // txtData.setText(name+"\n"+phone+"\n"+age);
       // txt.setText(name+"\n"+phone+"\n"+age);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("act1", "onStart");
        Toast.makeText(this,"Activity2 - onstart",Toast.LENGTH_LONG).show();


    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityOne - onResume");
        Log.i("ActivityOne","onResume");
        Toast.makeText(this,"Activity2 - onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityOne - onPause");
        Log.i("ActivityOne","onPause");
        Toast.makeText(this,"Activity2 - onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityOne - onStop");
        Log.i("ActivityOne","onStop");
        Toast.makeText(this,"Activity2 - onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Activity2 - onDestroy");
        Log.i("ActivityOne","onDestroy");
        Toast.makeText(this,"ActivityOne - onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("ActivityOne - onRestart");
        Log.i("ActivityOne","onRestart");
        Toast.makeText(this,"ActivityOne - onRestart",Toast.LENGTH_LONG).show();
    }


    public void clickHandler2(View view){
        String txt1 = txt.getText().toString().trim();
        String txt2 = txt5.getText().toString().trim();



        Intent intent = new Intent(Main2Activity.this,Main4Activity.class);
        //intent.putExtra("keyName",txt);
        // intent.putExtra("keyPhone",txt2);
        //intent.putExtra("keyAge",20);
        Bundle bundle2 = new Bundle();
        bundle2.putString("keyName2",txt1);
        bundle2.putString("keyName3",txt2);

        intent.putExtra("keyBundle2",bundle2);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
