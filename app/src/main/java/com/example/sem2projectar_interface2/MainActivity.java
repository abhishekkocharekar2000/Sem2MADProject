package com.example.sem2projectar_interface2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View v){

        ed1 = findViewById(R.id.emailID);
        ed2 = findViewById(R.id.password);

        if(ed1.getText().toString().equals("Abhi") && ed2.getText().toString().equals("12345")) {
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(i);
            Toast.makeText(MainActivity.this, "Logged In.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Incorrect Id or Password", Toast.LENGTH_SHORT).show();
        }


    }

}
