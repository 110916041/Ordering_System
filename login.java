package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity
        implements View.OnClickListener{

    private Button setaccount, signin;
    private EditText account, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        account=(EditText)findViewById(R.id.account);
        passwd=(EditText)findViewById(R.id.passwd);
        setaccount=(Button)findViewById(R.id.setaccount);
        signin=(Button)findViewById(R.id.signin);

        setaccount.setOnClickListener(this);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.setaccount) {
            Intent main =new Intent(login.this,enroll.class);
            startActivity(main);
        } else if (v.getId()==R.id.signin){
            String userid=account.getText().toString();
            String userpasswd=passwd.getText().toString();
            SharedPreferences preference=getSharedPreferences("data",MODE_PRIVATE);
            if ((userid.equals(preference.getString("id","")) && !(userid.equals("")))
                    &&userpasswd.equals(preference.getString("password",""))){
                SharedPreferences.Editor edit =preference.edit();
                edit.apply();
                Toast.makeText(login.this,"成功登入",Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this , staff.class);
                startActivity(intent1);
            } else {
                Toast.makeText(login.this,"登入失敗",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(login.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void backPage(View view) {
        finish();
    }
}