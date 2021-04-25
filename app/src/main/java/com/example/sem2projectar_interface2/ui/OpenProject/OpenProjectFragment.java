package com.example.sem2projectar_interface2.ui.OpenProject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sem2projectar_interface2.BrowseModels;
import com.example.sem2projectar_interface2.GetProjectNames;
import com.example.sem2projectar_interface2.MyAdapter;
import com.example.sem2projectar_interface2.OpenVideos;
import com.example.sem2projectar_interface2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenProjectFragment extends Fragment {

    private OpenProjectViewModel openProjectViewModel;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList<GetProjectNames> list;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root2 = db.getReference().child("Projects");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        openProjectViewModel =
                ViewModelProviders.of(this).get(OpenProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_open, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new MyAdapter(getContext(),list);

        recyclerView.setAdapter(adapter);

        root2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    GetProjectNames Names = dataSnapshot.getValue(GetProjectNames.class);
                    list.add(Names);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(getContext(), OpenVideos.class);
                //i.putExtra(EXTRA_TEXT,name);
                //i.putExtra(EXTRA_NUMBER,number);
                startActivity(i);
            }
        });

        return root;
    }

}