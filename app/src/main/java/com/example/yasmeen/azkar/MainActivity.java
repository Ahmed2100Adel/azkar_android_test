package com.example.yasmeen.azkar;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mor, azan;
    MediaPlayer mySound;
    Button send;
    boolean play= true;
NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mor =(Button)findViewById(R.id.mor);
        azan =(Button)findViewById(R.id.azan);
        send =(Button)findViewById(R.id.send);
        mySound = MediaPlayer.create(this,R.raw.videoplayback);
        mySound.setLooping(false);
        mySound.start();

        /*if(mySound.isPlaying()){
            mySound.stop();
        }*/
       // mySound.start();
        manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        NotificationCompat.Builder nbuild=new NotificationCompat.Builder(this);
        nbuild.setContentTitle("Azakr");
        nbuild.setContentText(" صلى على رسول الله");
        nbuild.setSmallIcon(R.drawable.aba);
        nbuild.setColor(getResources().getColor(R.color.noti));
        Intent i = new Intent(this,MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent respeninten= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        nbuild.setContentIntent(respeninten);
        nbuild.addAction(R.drawable.aba,"read",respeninten);

        manager.notify(id,nbuild.build());
        nbuild.setColor(getResources().getColor(R.color.noti));
        id++;

    }
    @Override
    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            mySound.stop();
        }
    }
    public void onUserLeaveHint() {
        mySound.stop();
        super.onUserLeaveHint();
        play =false;
        send.setText("play");
    }
    public void azan (View view){
        Intent i = new Intent(this,morning.class);
        startActivity(i);
    }
    public void mor (View view){
        Intent i = new Intent(this,azan.class);
        startActivity(i);
    }
    public void even (View view){
        Intent i = new Intent(this,evening.class);
        startActivity(i);
    }
    public void sleep (View view){
        Intent i = new Intent(this,sleep.class);
        startActivity(i);
    }
    public void house (View view){
        Intent i = new Intent(this,house.class);
        startActivity(i);
    }
    public void food (View view){
        Intent i = new Intent(this,fodd.class);
        startActivity(i);
    }
    public void mosq (View view){
        Intent i = new Intent(this,mosq.class);
        startActivity(i);
    }
    public void pray (View view){
        Intent i = new Intent(this,pray.class);
        startActivity(i);
    }
    public void send (View view){
        if(play==true){
mySound.stop();
        play =false;
           send.setText("play");
        }else if(play==false)
            {
                mySound = MediaPlayer.create(this,R.raw.videoplayback);
                mySound.setLooping(false);
                mySound.start();
                send.setText("stop");
                play=true;

            }
    }
    static int id =1;
    public void noty(View view)
    {

        NotificationCompat.Builder nbuild=new NotificationCompat.Builder(this);
               nbuild.setContentTitle("Azakr");
                nbuild.setContentText(" صلى على رسول الله");
                nbuild.setSmallIcon(R.drawable.aba);
            nbuild.setColor(getResources().getColor(R.color.noti));

        Intent i = new Intent(this,MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent respeninten= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        nbuild.setContentIntent(respeninten);
        nbuild.addAction(R.drawable.aba,"read",respeninten);

         manager.notify(id,nbuild.build());

        id++;
    }



}
