package com.example.sem2projectar_interface2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.hardware.Camera;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class CameraActivity extends AppCompatActivity {

    FloatingActionButton add;
    private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Intent i = getIntent();
        String t = i.getStringExtra(BrowseModels.EXTRA_TEXT);

        add = findViewById(R.id.floatingActionButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CameraActivity.this, BrowseModels.class);
                startActivity(i);
            }
        });

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.arFragment);

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