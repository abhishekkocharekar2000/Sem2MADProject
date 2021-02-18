package com.example.sem2projectar_interface2.ui.OpenProject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.R;

public class OpenProjectFragment extends Fragment {

    private OpenProjectViewModel openProjectViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        openProjectViewModel =
                ViewModelProviders.of(this).get(OpenProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);

        return root;
    }
}