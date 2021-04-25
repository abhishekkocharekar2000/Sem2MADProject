package com.example.sem2projectar_interface2.ui.NewProject;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.CameraActivity;
import com.example.sem2projectar_interface2.Main2Activity;
import com.example.sem2projectar_interface2.R;
import com.example.sem2projectar_interface2.ui.Screenshot;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.MODE_PRIVATE;
import static android.os.Environment.getExternalStorageDirectory;
import static android.os.Environment.getStorageDirectory;

public class NewProjectFragment extends Fragment {

    public static final String EXTRA_TEXT= "com.example.artesting.EXTRA_TEXT";
    private NewProjectViewModel galleryViewModel;
    private Button b;
    public EditText projectName,  clientName, location;
    public String projectname, clientsname, locationname, date, fileName;
    private FileOutputStream fileOutputStream;
    private  static  final  int PERMISSION_REQUEST_CODE = 7;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference root2;

    //private DatabaseReference projectNames;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //projectNames = FirebaseDatabase.getInstance().getReference("Projects");
        galleryViewModel =
                ViewModelProviders.of(this).get(NewProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_project, container, false);
        b = root.findViewById(R.id.button4);
        projectName = root.findViewById(R.id.newprojname);
        clientName = root.findViewById(R.id.newprojclientname);
        location = root.findViewById(R.id.newprojlocation);

        fileName = projectname+date;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectname = projectName.getText().toString();
                clientsname = clientName.getText().toString();
                locationname = location.getText().toString();

                root2 = db.getReference().child("Projects").child(projectname);

                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("Project_Name",projectname);

                hashMap.put("Client Name",clientsname);

                hashMap.put("Location",locationname);

                root2.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(),"Project Created!",Toast.LENGTH_SHORT).show();
                    }
                });

                Intent i = new Intent(getActivity(), CameraActivity.class);
                i.putExtra(EXTRA_TEXT, projectname);
                startActivity(i);

            }
        });
        return root;

    }

}