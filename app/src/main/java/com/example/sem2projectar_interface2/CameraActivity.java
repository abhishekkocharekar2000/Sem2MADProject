package com.example.sem2projectar_interface2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.FrameLayout;
import android.hardware.Camera;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sem2projectar_interface2.ui.Screenshot;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import static java.text.DateFormat.getDateInstance;

public class CameraActivity extends AppCompatActivity {

    public ArFragment arFragment;
    private Screenshot s;
    HorizontalScrollView h;
    FloatingActionButton f;
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14;
    final String t1 = "bedwithsidetables.sfb";
    final String t2 = "armrestchair.sfb";
    final String t3 = "blackcouch.sfb";
    final String t4 = "bookshelf.sfb";
    final String t5 = "couchwithlegrest.sfb";
    final String t6 = "drums.sfb";
    final String t7 = "blackpiano.sfb";
    final String t8 = "bed.sfb";
    final String t9 = "officedesk.sfb";
    final String t10 = "redcouch.sfb";
    final String t11 = "studytable.sfb";
    final String t12 = "vintagecornertable.sfb";
    final String t13 = "woodenchair.sfb";
    final String t14 = "woodenpiano.sfb";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        h = findViewById(R.id.horizontalScrollView);
        f = findViewById(R.id.floatingActionButton);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.arFragment);

        Intent i = getIntent();
        String t = i.getStringExtra(BrowseModels.EXTRA_TEXT);

        //verifyStoragePermission(this);
        Toast.makeText(CameraActivity.this, "Started Recording", Toast.LENGTH_SHORT).show();

        f.setOnClickListener(view -> {
            if(s == null){
                s = new Screenshot();
                s.setSceneView(arFragment.getArSceneView());

                int orientation = getResources().getConfiguration().orientation;

                s.setVideoQuality(CamcorderProfile.QUALITY_HIGH, orientation);
            }

            boolean isRecording = s.onToggleRecord();

            if(isRecording)
                Toast.makeText(CameraActivity.this, "Started Recording", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(CameraActivity.this, "Stopped Recording", Toast.LENGTH_SHORT).show();


        });

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t1);
            }
        });

        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t2);
            }
        });

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t3);
            }
        });

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t4);
            }
        });

        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t5);
            }
        });

        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t6);
            }
        });

        img7 = findViewById(R.id.img7);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t7);
            }
        });

        img8 = findViewById(R.id.img8);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t8);
            }
        });

        img9 = findViewById(R.id.img9);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t9);
            }
        });

        img10 = findViewById(R.id.img10);
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t10);
            }
        });

        img11 = findViewById(R.id.img11);
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t11);
            }
        });

        img12 = findViewById(R.id.img12);
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t12);
            }
        });

        img13 = findViewById(R.id.img13);
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t13);
            }
        });

        img14 = findViewById(R.id.img14);
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AR(t14);

            }
        });


    }

    @Override
    public void onResume(){
        super.onResume();

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

    }

    public void AR(String t){
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse(t))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable));
        });
    }
    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {

        AnchorNode node = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
        transformableNode.setParent(node);
        transformableNode.setRenderable(modelRenderable);

        arFragment.getArSceneView().getScene().addChild(node);
        transformableNode.select();


    }

}