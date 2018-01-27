package com.example.yasmeen.azkar;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class evening extends AppCompatActivity {
    MediaPlayer mySound;
    boolean play= true;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action1,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);
        mySound = MediaPlayer.create(this,R.raw.msah );
        mySound.start();
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
    }
    public void restart(MenuItem item) {
        if(play==true){
            mySound.stop();
            play =false;

        }else if(play==false)
        {
            mySound = MediaPlayer.create(this,R.raw.msah);
            mySound.setLooping(false);
            mySound.start();

            play=true;

        }
    }
}
