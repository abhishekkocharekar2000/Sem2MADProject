package com.example.sem2projectar_interface2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View v){

        if(ed1.getText().toString().equals("Abhishek") && ed2.getText().toString().equals("1234")) {
            Intent i = new Intent(RegisterActivity.this, Main2Activity.class);
            startActivity(i);
            Toast.makeText(RegisterActivity.this, "Logged In.", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(RegisterActivity.this, "Incorrect Id or Password", Toast.LENGTH_SHORT).show();
        }


    }

}
