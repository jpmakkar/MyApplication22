package com.example.hp2.myapplication2;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hp 2 on 13-07-2017.
 */

public class UserAdapter extends ArrayAdapter<User>{


    Context context;
    int resource;
    ArrayList<User> userList;

    public UserAdapter(Context context, int resource, ArrayList<User> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        userList = objects;
    }

    // This shall be executed n number of times, where n is the size of ArrayList
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        // view is a reference variable which shall point to list_item
        view = LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtPhone = view.findViewById(R.id.textViewPhone);

        User user = userList.get(position);
        imageView.setBackgroundResource(user.getIcon());
        txtName.setText(user.getName());
        txtPhone.setText(user.getPhone());

        return view;
    }
}
