package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class staff extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);

    }
    public void memu(View view){
        Intent intent = new Intent(this , memu.class);
        startActivity(intent);
    }
    public void check_order(View view){
        Intent intent = new Intent(this , checkorder2.class);
        startActivity(intent);
    }

    public void homepage(View view){
        Intent intent1 = new Intent(this , MainActivity.class);
        startActivity(intent1);
    }
}