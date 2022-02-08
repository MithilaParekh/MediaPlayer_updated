package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AsApplicationResource extends AppCompatActivity {
    Button start,stop,pause;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asapplicationresource);
        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        pause=findViewById(R.id.pause);
        MediaPlayer p=MediaPlayer.create(this,R.raw.ringtone);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.stop();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.pause();
            }
        });


    }

}
