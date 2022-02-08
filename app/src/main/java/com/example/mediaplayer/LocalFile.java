package com.example.mediaplayer;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mediaplayer.R;

import java.io.IOException;

public class LocalFile extends AppCompatActivity{
    Button start, stop, pause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asapplicationresource);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        pause = findViewById(R.id.pause);

        //final MediaPlayer p=new MediaPlayer();
        //Using Content Provider
        MediaPlayer p=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        try{

           // p.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Songs/kahi.mp3");
            //p.prepare();
            p.prepareAsync();
        }catch(Exception e){e.printStackTrace();}
        p.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                start.setEnabled(true);
                start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();

                        } else {
                            mediaPlayer.start();

                        }
                    }
                });
            }
        });

        /*stop.setOnClickListener(new View.OnClickListener() {
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

*/
    }



}
