package com.example.edu.bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayStop extends AppCompatActivity implements View.OnClickListener {
    private BackgroundMusicWithBindService mServiceBinder;

    private ServiceConnection myConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mServiceBinder = ((BackgroundMusicWithBindService.MyBinder) binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBinder = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_stop);
        Button buttonPlay=findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        Button buttonStop=findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(this);

        Intent intent=new Intent(this, BackgroundMusicWithBindService.class);
        bindService(intent,myConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPlay:
                mServiceBinder.play();
                break;

            case R.id.buttonStop:
                mServiceBinder.stop();
                break;
        }

    }
}
