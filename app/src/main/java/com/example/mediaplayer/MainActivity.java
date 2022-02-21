package com.example.playmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    Button start, stop, pause;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        ActivityCompat.requestPermissions( this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.MANAGE_EXTERNAL_STORAGE
                }, 1
        );


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
                File file = new File("/sdcard/Music/It_is_realme.mp3");
                if (file.exists()) {
                    Uri uri = Uri.fromFile(file);

                    // Initialize the media player
                    mp = MediaPlayer.create(getApplicationContext(), uri);

                    // Start playing music

                    mp.start();

                    Toast.makeText(getApplicationContext(), "Music playing.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}

