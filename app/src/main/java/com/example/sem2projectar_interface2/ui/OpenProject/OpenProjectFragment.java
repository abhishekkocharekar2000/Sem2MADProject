package com.example.sem2projectar_interface2.ui.OpenProject;

import android.content.Context;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.BrowseModels;
import com.example.sem2projectar_interface2.R;

public class OpenProjectFragment extends Fragment {

    ListView listView;
    String mTitle[] = {"Bed","Chair","Couch","Book Shelf","Corner Table","Couch","Drums","Piano","Bed","Desk","Couch","Study Table","Corner Table",
            "Bench","Piano"};
    String mDescription[] = {"Bed with side tables", "Chair with arm rest","Black Couch","Wooden Book Shelf","Corner table with lamp",
            "Couch with leg rest","Blue and yellow drum set","Black Piano","Basic wooden bed","Office desk","Red Couch",
            "Study table with three drawers","Vintage corner table","Wooden bench","Wooden Piano"};
    int images[] = {R.drawable.bedwithsidetables, R.drawable.armrestchair,R.drawable.blackcouch,R.drawable.bookshelf,
            R.drawable.cornertable,R.drawable.couchwithlegrest,R.drawable.drums,R.drawable.blackpiano,R.drawable.bed,R.drawable.officedesk,
            R.drawable.redcouch,R.drawable.studytable,R.drawable.vintagecornertable,R.drawable.woodenchair,R.drawable.woodenpiano};

    private OpenProjectViewModel openProjectViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        openProjectViewModel =
                ViewModelProviders.of(this).get(OpenProjectViewModel.class);
        View root = inflater.inflate(R.layout.fragment_open, container, false);

        return root;
    }

}