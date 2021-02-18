package com.example.sem2projectar_interface2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BrowseModels extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Bed","Chair","Couch","Book Shelf","Corner Table","Couch","Drums","Piano","Bed","Desk","Couch","Study Table","Corner Table",
    "Bench","Piano"};
    String mDescription[] = {"Bed with side tables", "Chair with arm rest","Black Couch","Wooden Book Shelf","Corner table with lamp",
    "Couch with leg rest","Blue and yellow drum set","Black Piano","Basic wooden bed","Office desk","Red Couch",
            "Study table with three drawers","Vintage corner table","Wooden bench","Wooden Piano"};
    int images[] = {R.drawable.bedwithsidetables, R.drawable.armrestchair,R.drawable.blackcouch,R.drawable.bookshelf,
    R.drawable.cornertable,R.drawable.couchwithlegrest,R.drawable.drums,R.drawable.blackpiano,R.drawable.bed,R.drawable.officedesk,
    R.drawable.redcouch,R.drawable.studytable,R.drawable.vintagecornertable,R.drawable.woodenchair,R.drawable.woodenpiano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_models);
        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
    public class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        public MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }


}