package com.example.logonrm.alarmemanager;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmeReceiver extends BroadcastReceiver{

    private MediaPlayer mp = null;
    public AlarmeReceiver() {}

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, R.raw.acabou);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }

}
