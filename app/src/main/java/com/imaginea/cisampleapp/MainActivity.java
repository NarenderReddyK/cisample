package com.imaginea.cisampleapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.btn_submit);
        final TextView messageLabel = (TextView) findViewById(R.id.lbl_message);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageLabel.setVisibility(View.VISIBLE);
            }
        });
    }

//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        View root = super.onCreateView(parent, name, context, attrs);
//
//
//        return root;
//    }


}
