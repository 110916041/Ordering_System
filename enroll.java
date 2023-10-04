package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enroll extends AppCompatActivity
        implements View.OnClickListener{

    private Button clear, comfirm;
    private EditText account, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enroll);

        account = (EditText) findViewById(R.id.account);
        passwd = (EditText) findViewById(R.id.passwd);
        comfirm = (Button) findViewById(R.id.signin);
        clear = (Button) findViewById(R.id.setaccount);

        comfirm.setOnClickListener(this);
        clear.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.signin) {
            SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("id", account.getText().toString());
            editor.putString("password", passwd.getText().toString());
            editor.apply();

            String str = account.getText().toString();
            String str1 = passwd.getText().toString();
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(enroll.this, "帳號不能為空", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(str1)) {
                Toast.makeText(enroll.this, "密碼不能為空", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(enroll.this, "註冊成功!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(enroll.this, login.class);
                startActivity(intent1);
            }
        } else if (v.getId() == R.id.setaccount) {
            account.setText("");
            passwd.setText("");
        } else {
            Toast.makeText(enroll.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void backPage(View view) {
        finish();
    }
}