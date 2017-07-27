package com.example.hp2.myapplication2;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpperFragment extends Fragment implements View.OnClickListener {
TextView txt;
    Context context;
   String jppp;

    public UpperFragment() {
        // Required empty public constructor
    }
public void yo(String st){

    jppp=st;


}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_upper, container, false);
        context = getContext();

        txt =view1.findViewById(R.id.textView8);


        return view1;

    }

    @Override
    public void onClick(View view) {

    }
}
