package com.example.hp2.myapplication2;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eTxtName;
    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTxtName = (EditText) findViewById(R.id.editText);
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);

        Log.i("ActivityOne","onCreate");
        Toast.makeText(this,"ActivityOne - onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("act1", "onStart");
        Toast.makeText(this,"ActivityOne - onstart",Toast.LENGTH_LONG).show();


    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityOne - onResume");
        Log.i("ActivityOne","onResume");
        Toast.makeText(this,"ActivityOne - onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityOne - onPause");
        Log.i("ActivityOne","onPause");
        Toast.makeText(this,"ActivityOne - onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityOne - onStop");
        Log.i("ActivityOne","onStop");
        Toast.makeText(this,"ActivityOne - onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityOne - onDestroy");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* menu.add(1,101,0,"songs");
        menu.addSubMenu(4,106,0,"dd");
        menu.addSubMenu("dd");
        menu.addSubMenu(4,106,0,"d11d");
        menu.add(1,102,0,"s1");
        menu.add(1,103,0,"s2");
        SubMenu fileMenu = menu.addSubMenu("File");
        SubMenu editMenu = menu.addSubMenu("Edit");
        fileMenu.add(1, 11, 0, "new");
        fileMenu.add(2, 22, 1, "save");
        editMenu.add(3, 33, 0, "undo");
        editMenu.add(4, 44, 1, "redo");
        */
        getMenuInflater().inflate(R.menu.jp,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        /*switch (id)
        {

            case 101:

                Toast.makeText(this,"You selected all songs",Toast.LENGTH_LONG).show();
                break;
            case 102:
                Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
                break;
            case 103:
                break;

        }*/
        switch (id){
            case R.id.allsongs:
                Intent intent = new Intent(MainActivity.this,listview.class);
                startActivity(intent);
                break;

            case R.id.lib:
                Intent intent1 = new Intent(MainActivity.this,MySensorActivity.class);
                startActivity(intent1);
                break;
            case R.id.rec:
                Intent intent2 = new Intent(MainActivity.this,MyLocationActivity.class);
                startActivity(intent2);
                break;
            case R.id.fav:
                Intent intent3 = new Intent(MainActivity.this,Fregments.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickHandler(View view){
        String txt = eTxtName.getText().toString().trim();

        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        //intent.putExtra("keyName",txt);
       // intent.putExtra("keyPhone",txt2);
        //intent.putExtra("keyAge",20);
        Bundle bundle = new Bundle();
        bundle.putString("keyName",txt);

        intent.putExtra("keyBundle",bundle);
        startActivity(intent);




        /*String num = eTxtName.getText().toString().trim();



        String code=num;
        int key=3;
        int result[] = new int[100];
        char[] arr = code.toCharArray();
        char[] arr2=new char[26];
       for(int i = 0 ;i<arr.length;i++){
            result[i] = (int)(arr[i]+key-97)%26 +97;
            System.out.println(result[i]);
        }


        for(int j = 0 ;j<arr.length;j++){

            arr2[j] = (char)result[j];
            System.out.print(arr2[j]);



        }

        String str = String.valueOf(arr2);

        Toast.makeText(this,str.toString(),Toast.LENGTH_LONG).show();*/


       // Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        //startActivity(intent);
    }
}
