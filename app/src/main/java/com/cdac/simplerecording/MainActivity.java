package com.cdac.simplerecording;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button startBtn, stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filepath = String.valueOf(Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_DOWNLOADS));
        wavClass wavObj = new wavClass(filepath);
        startBtn = findViewById(R.id.startRecord);
        stopBtn = findViewById(R.id.stopRecord);
        startBtn.setOnClickListener(v -> {
            stopBtn.setEnabled(true);
            stopBtn.setBackgroundColor(Color.rgb(47, 156, 156));
            startBtn.setEnabled(false);
            startBtn.setBackgroundColor(Color.GRAY);
            wavObj.startRecording(this);
     /*       if(checkWritePermission()) {
                wavObj.startRecording();
            }
            if(!checkWritePermission()){
                requestWritePermission();
            }*/
        });
        stopBtn.setOnClickListener(v -> {
            wavObj.stopRecording();
            stopBtn.setEnabled(false);
            stopBtn.setBackgroundColor(Color.GRAY);
            startBtn.setEnabled(true);
            startBtn.setBackgroundColor(Color.rgb(47, 156, 156));

        });
    }
}