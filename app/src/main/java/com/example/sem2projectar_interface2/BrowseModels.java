package com.example.sem2projectar_interface2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BrowseModels extends AppCompatActivity {

    public static final String EXTRA_TEXT= "com.example.artesting.EXTRA_TEXT";

    ListView listView;
    String mTitle[] = {"Bed","Chair","Couch","Book Shelf","Couch","Drums","Piano","Bed","Desk","Couch","Study Table","Corner Table",
    "Bench","Piano"};
    String mDescription[] = {"Bed with side tables", "Chair with arm rest","Black Couch","Wooden Book Shelf",
    "Couch with leg rest","Blue and yellow drum set","Black Piano","Basic wooden bed","Office desk","Red Couch",
            "Study table with three drawers","Vintage corner table","Wooden bench","Wooden Piano"};
    int images[] = {R.drawable.bedwithsidetables, R.drawable.armrestchair,R.drawable.blackcouch,R.drawable.bookshelf,
    R.drawable.couchwithlegrest,R.drawable.drums,R.drawable.blackpiano,R.drawable.bed,R.drawable.officedesk,
    R.drawable.redcouch,R.drawable.studytable,R.drawable.vintagecornertable,R.drawable.woodenchair,R.drawable.woodenpiano};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_models);
        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        final String t1 = "bedwithsidetables.sfb";
        final String t2 = "armrestchair.sfb";
        final String t3 = "blackcouch.sfb";
        final String t4 = "bookshelf.sfb";
        final String t5 = "couchwithlegrest.sfb";
        final String t6 = "drums.sfb";
        final String t7 = "blackpiano.sfb";
        final String t8 = "bed.sfb";
        final String t9 = "officedesk.sfb";
        final String t10 = "redcouch.sfb";
        final String t11 = "studytable.sfb";
        final String t12 = "vintagecornertable.sfb";
        final String t13 = "woodenchair.sfb";
        final String t14 = "woodenpiano.sfb";

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t1);
                    startActivity(i);
                }
                if(position == 1){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t2);
                    startActivity(i);
                }
                if(position == 2){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t3);
                    startActivity(i);
                }
                if(position == 3){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t4);
                    startActivity(i);
                }
                if(position == 4){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t5);
                    startActivity(i);
                }
                if(position == 5){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t6);
                    startActivity(i);
                }
                if(position == 6){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t7);
                    startActivity(i);
                }
                if(position == 7){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t8);
                    startActivity(i);
                }
                if(position == 8){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t9);
                    startActivity(i);
                }
                if(position == 9){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t10);
                    startActivity(i);
                }
                if(position == 10){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t11);
                    startActivity(i);
                }
                if(position == 11){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t12);
                    startActivity(i);
                }
                if(position == 12){
                    Intent i = new Intent(BrowseModels.this,CameraActivity.class);
                    i.putExtra(EXTRA_TEXT,t13);
                    startActivity(i);
                }
                if(position == 13) {
                    Intent i = new Intent(BrowseModels.this, CameraActivity.class);
                    i.putExtra(EXTRA_TEXT, t14);
                    startActivity(i);
                }
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