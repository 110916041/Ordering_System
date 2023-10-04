package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgWc = (ImageView) findViewById(R.id.wc);
        imgWc.setScaleY(-1);
    }
    public void cusBtn(View view){
        Intent intent = new Intent(this , customer.class);
        startActivity(intent);
    }
    public void stfBtn(View view){
        Intent intent = new Intent(this , login.class);
        startActivity(intent);
    }
    public void onBackPressed(){
        Intent i=  new  Intent(Intent.ACTION_MAIN);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addCategory(Intent.CATEGORY_HOME);
        startActivity(i);
    }
}