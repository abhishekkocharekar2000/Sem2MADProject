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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
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

    private NewProjectViewModel galleryViewModel;
    private Button b;
    public EditText projectName,  clientName, location;
    public String projectname, clientsname, locationname, date, fileName;
    private FileOutputStream fileOutputStream;
    private  static  final  int PERMISSION_REQUEST_CODE = 7;

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
        projectname = projectName.getText().toString();
        clientsname = clientName.getText().toString();
        locationname = location.getText().toString();
        date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        fileName = projectname+date;
        Intent intent = new Intent(getActivity(), Screenshot.class);
        intent.putExtra("PROJECT_NAME", projectname);
        startActivity(intent);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (projectname.isEmpty() || clientsname.isEmpty() || locationname.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        createDirectory("/EnvisageProjects/"+projectname.concat(date));
                        try {
                            save("/EnvisageProjects/"+projectname.concat(date)+"/Project Details.txt");
                            Toast.makeText(getActivity(), "Details Saved", Toast.LENGTH_LONG).show();
                        } catch (Exception e) { }
                    }else
                    {
                        askPermission();
                    }

                    Intent i = new Intent(getActivity(), CameraActivity.class);
                    startActivity(i);


                }

            }
        });
        return root;

    }

    public void save(String filename) {
        String proname = "Project Name - ".concat(projectname);
        String cliname = "Client Name - ".concat(clientsname);
        String locname = "Location - ".concat(locationname);
        File projectDetails = new File(Environment.getExternalStorageDirectory(),filename);
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(projectDetails);
            fos.write(proname.getBytes());
            fos.write("\n".getBytes());
            fos.write(cliname.getBytes());
            fos.write("\n".getBytes());
            fos.write(locname.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void askPermission() {

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {

        if (requestCode == PERMISSION_REQUEST_CODE)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                createDirectory("/EnvisageProjects/"+projectname.concat(date));
            }else
            {
                Toast.makeText(getActivity(),"Permission Denied",Toast.LENGTH_SHORT).show();
            }

        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void createDirectory(String folderName) {

        File file = new File(Environment.getExternalStorageDirectory(),folderName);

        if (!file.exists()){

            file.mkdir();

            Toast.makeText(getActivity(),"Successful",Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getActivity(),"Folder Already Exists",Toast.LENGTH_SHORT).show();
        }


}
}