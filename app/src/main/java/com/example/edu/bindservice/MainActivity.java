package com.example.edu.bindservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonM=findViewById(R.id.buttonM);
        buttonM.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        intent= new Intent(this,PlayStop.class);
        startActivity(intent);

    }
}
