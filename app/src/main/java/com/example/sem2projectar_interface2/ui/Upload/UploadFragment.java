package com.example.sem2projectar_interface2.ui.Upload;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class UploadFragment extends Fragment {

    private UploadViewModel uploadViewModel;

    public UploadFragment(){
        //required empty constructor
    }


    TextView pName,cName,location;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        uploadViewModel = ViewModelProviders.of(this).get(UploadViewModel.class);
        View root = inflater.inflate(R.layout.fragment_upload, container, false);

        pName = root.findViewById(R.id.pN);
        cName = root.findViewById(R.id.cN);
        location = root.findViewById(R.id.l);

        Bundle bundle = this.getArguments();
        String p = bundle.getString("Project");
        String c = bundle.getString("Client");
        String l = bundle.getString("Location");
        pName.setText(p);
        cName.setText(c);
        location.setText(l);


        return root;
    }



}