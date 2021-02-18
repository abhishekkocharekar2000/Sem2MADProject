package com.example.sem2projectar_interface2.ui.NewProject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.CameraActivity;
import com.example.sem2projectar_interface2.R;

public class NewProjectFragment extends Fragment {

    private NewProjectViewModel galleryViewModel;
    private Button b;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(NewProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_project, container, false);
        b = root.findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CameraActivity.class);
                startActivity(i);
            }
        });
        return root;
    }
}