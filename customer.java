package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class customer extends AppCompatActivity {
    TextView[] txtNum;
    EditText name,phone,mail;
    String[] Stringitem = new String[9];

    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer);
        txtNum = new TextView[9];
        for(int i = 0; i < 9; i++) {
            txtNum[i] = new TextView(this);
        }
        txtNum[0] = (TextView) findViewById(R.id.beefTxt);
        txtNum[1] = (TextView) findViewById(R.id.porkTxt);
        txtNum[2] = (TextView) findViewById(R.id.fishTxt);
        txtNum[3] = (TextView) findViewById(R.id.colaTxt);
        txtNum[4] = (TextView) findViewById(R.id.spriteTxt);
        txtNum[5] = (TextView) findViewById(R.id.teaTxt);
        txtNum[6] = (TextView) findViewById(R.id.friesTxt);
        txtNum[7] = (TextView) findViewById(R.id.chickenTxt);
        txtNum[8] = (TextView) findViewById(R.id.applepieTxt);

        name = (EditText) findViewById(R.id.etName);
        phone = (EditText) findViewById(R.id.etPhone);
        mail = (EditText) findViewById(R.id.etEmail);
    }


    public void homepage(View view){
        Intent intent1 = new Intent(this , MainActivity.class);
        startActivity(intent1);
    }
    public void backPage(View view) {
        finish();
    }
    public void resetToZero(View view) {
        txtNum[0].setText("0");
        txtNum[1].setText("0");
        txtNum[2].setText("0");
        txtNum[3].setText("0");
        txtNum[4].setText("0");
        txtNum[5].setText("0");
        txtNum[6].setText("0");
        txtNum[7].setText("0");
        txtNum[8].setText("0");
        name.setText("");
        phone.setText("");
        mail.setText("");
    }

    public void addData(){
        String _name,_phone,_mail;
        _name = name.getText().toString().trim();
        _phone = phone.getText().toString().trim();
        _mail = mail.getText().toString().trim();
        price();
        Intent intent = new Intent(this , checkorder.class);
        Bundle bundle = new Bundle();
        bundle.putString("beef", "牛肉漢堡x" + Stringitem[0]);
        bundle.putString("pork", "豬排漢堡x" + Stringitem[1]);
        bundle.putString("fish", "魚排漢堡x" + Stringitem[2]);
        bundle.putString("cola", "可樂x" + Stringitem[3]);
        bundle.putString("sprite", "雪碧x" + Stringitem[4]);
        bundle.putString("tea", "檸檬紅茶x" + Stringitem[5]);
        bundle.putString("fries", "薯條x" + Stringitem[6]);
        bundle.putString("chicken", "雞塊x" + Stringitem[7]);
        bundle.putString("applepie", "蘋果派x" + Stringitem[8]);
        bundle.putString("name", "名字：" + _name);
        bundle.putString("phone","電話：" + _phone);
        bundle.putString("mail", "信箱：" + _mail);
        bundle.putString("total", "價格：" + total);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void price(){
        int[] intitem = new int[9];
        for(int i=0 ; i<9 ; i++){
            intitem[i] = Integer.parseInt(Stringitem[i]);
        }
        total = 66*intitem[0] + 63*intitem[1] + 60*intitem[2] + 30*(intitem[3]+intitem[4]+intitem[5])+50*(intitem[6]+intitem[7]+intitem[8]);
    }

    public void checkcorrect(View view){
        for(int i=0 ; i<9 ; i++){
            Stringitem[i] = txtNum[i].getText().toString();
        }
        if (name.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || mail.getText().toString().isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("注意！！")
                    .setMessage(
                            "請輸入姓名、電話、郵件"
                    )
                    .setPositiveButton("好！", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    })
                    .setCancelable(false)
                    .show();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("確定訂單嗎")
                    .setMessage(
                            "牛肉漢堡x" + Stringitem[0] + "\n"+ "豬排漢堡x" + Stringitem[1] + "\n" +
                                    "魚排漢堡x" + Stringitem[2] + "\n"+ "可樂x" + Stringitem[3] + "\n" +
                                    "雪碧x" + Stringitem[4] + "\n"+ "檸檬紅茶x" + Stringitem[5] + "\n" +
                                    "薯條x" + Stringitem[6] + "\n"+ "雞塊x" + Stringitem[7] + "\n"+
                                    "蘋果派x" + Stringitem[8]
                    )
                    .setPositiveButton("確定！", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            addData();
                        }
                    })
                    .setNegativeButton("取消",null)
                    .setCancelable(false)
                    .show();
        }
    }

    public void beefadd(View view) {
        int temp = Integer.parseInt(txtNum[0].getText().toString());
        temp++;
        txtNum[0].setText(Integer.toString(temp));
    }
    public void beefminus(View view) {
        int temp = Integer.parseInt(txtNum[0].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[0].setText(Integer.toString(temp));
        }
    }
    public void porkadd(View view) {
        int temp = Integer.parseInt(txtNum[1].getText().toString());
        temp++;
        txtNum[1].setText(Integer.toString(temp));
    }
    public void porkminus(View view) {
        int temp = Integer.parseInt(txtNum[1].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[1].setText(Integer.toString(temp));
        }
    }
    public void fishadd(View view) {
        int temp = Integer.parseInt(txtNum[2].getText().toString());
        temp++;
        txtNum[2].setText(Integer.toString(temp));
    }
    public void fishminus(View view) {
        int temp = Integer.parseInt(txtNum[2].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[2].setText(Integer.toString(temp));
        }
    }
    public void colaadd(View view) {
        int temp = Integer.parseInt(txtNum[3].getText().toString());
        temp++;
        txtNum[3].setText(Integer.toString(temp));
    }
    public void colaminus(View view) {
        int temp = Integer.parseInt(txtNum[3].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[3].setText(Integer.toString(temp));
        }
    }
    public void spriteadd(View view) {
        int temp = Integer.parseInt(txtNum[4].getText().toString());
        temp++;
        txtNum[4].setText(Integer.toString(temp));
    }
    public void spriteminus(View view) {
        int temp = Integer.parseInt(txtNum[4].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[4].setText(Integer.toString(temp));
        }
    }
    public void teaadd(View view) {
        int temp = Integer.parseInt(txtNum[5].getText().toString());
        temp++;
        txtNum[5].setText(Integer.toString(temp));
    }
    public void teaminus(View view) {
        int temp = Integer.parseInt(txtNum[5].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[5].setText(Integer.toString(temp));
        }
    }
    public void friesadd(View view) {
        int temp = Integer.parseInt(txtNum[6].getText().toString());
        temp++;
        txtNum[6].setText(Integer.toString(temp));
    }
    public void friesminus(View view) {
        int temp = Integer.parseInt(txtNum[6].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[6].setText(Integer.toString(temp));
        }
    }
    public void chickenadd(View view) {
        int temp = Integer.parseInt(txtNum[7].getText().toString());
        temp++;
        txtNum[7].setText(Integer.toString(temp));
    }
    public void chickenminus(View view) {
        int temp = Integer.parseInt(txtNum[7].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[7].setText(Integer.toString(temp));
        }
    }
    public void applepieadd(View view) {
        int temp = Integer.parseInt(txtNum[8].getText().toString());
        temp++;
        txtNum[8].setText(Integer.toString(temp));
    }
    public void applepieminus(View view) {
        int temp = Integer.parseInt(txtNum[8].getText().toString());
        if(temp == 0 ){
            return;
        }else {
            temp--;
            txtNum[8].setText(Integer.toString(temp));
        }
    }

}
