package com.example.hp2.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Adapter extends AppCompatActivity {

    ListView listView;
    ArrayList<User> userList;
    UserAdapter adapter;

    void initList(){
        listView = (ListView)findViewById(R.id.listview1);

        User u1 = new User(R.drawable.ic_launcher,"John","9999999999");
        User u2 = new User(R.drawable.ic_launcher,"Jennie","888888888");
        User u3 = new User(R.drawable.ic_launcher,"Jack","7777799999");
        User u4 = new User(R.drawable.ic_launcher,"Jim","666669999");
        User u5 = new User(R.drawable.ic_launcher,"Joe","33339999");

        userList = new ArrayList<>();
        userList.add(u1); //0
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5); //4

        adapter = new UserAdapter(this,R.layout.listitem,userList);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        initList();

    }
}
