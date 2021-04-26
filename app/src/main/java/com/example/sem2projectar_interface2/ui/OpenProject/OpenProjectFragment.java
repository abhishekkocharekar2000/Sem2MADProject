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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sem2projectar_interface2.BrowseModels;
import com.example.sem2projectar_interface2.GetProjectNames;
import com.example.sem2projectar_interface2.MyAdapter;
import com.example.sem2projectar_interface2.OpenVideos;
import com.example.sem2projectar_interface2.R;
import com.example.sem2projectar_interface2.ui.Upload.UploadFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
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

    FirebaseDatabase db = FirebaseDatabase.getInstance();

    DatabaseReference root2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        openProjectViewModel =
                ViewModelProviders.of(this).get(OpenProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_open, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getContext());
        String personName = acct.getDisplayName();

        root2 = db.getReference().child("Projects").child(personName);

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
                String pName = list.get(position).getProject_Name();
                String cName = list.get(position).getClient_Name();
                String location = list.get(position).getLocation();
                Bundle bundle = new Bundle();
                bundle.putString("Project",pName);
                bundle.putString("Client",cName);
                bundle.putString("Location",location);
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                UploadFragment uf = new UploadFragment();
                uf.setArguments(bundle);
                fr.replace(R.id.nav_host_fragment,uf,null).addToBackStack(null).commit();
            }
        });

        return root;
    }

}