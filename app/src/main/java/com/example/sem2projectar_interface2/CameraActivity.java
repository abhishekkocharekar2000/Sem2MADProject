package com.example.sem2projectar_interface2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.hardware.Camera;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CameraActivity extends AppCompatActivity {

    Camera camera;
    FrameLayout framelayout;
    FloatingActionButton add;
    ShowCamera showCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        add = findViewById(R.id.floatingActionButton);

        framelayout = (FrameLayout)findViewById(R.id.frameLayout);

        camera = Camera.open();
        showCamera = new ShowCamera(this,camera);
        framelayout.addView(showCamera);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CameraActivity.this, BrowseModels.class);
                startActivity(i);
            }
        });

    }
}