package com.example.hp2.myapplication2;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LowerFragment extends Fragment implements View.OnClickListener {

    Button btn;

    Context context;
    public LowerFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lower, container, false);

        context = getContext();

        btn = view.findViewById(R.id.button5);
        btn.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context,"Button Clicked",Toast.LENGTH_LONG).show();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        UpperFragment jp=new UpperFragment();
        jp.yo("jjj");

    }
}
