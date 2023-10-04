package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class checkorder extends AppCompatActivity {
    SQLiteDatabase db;

    static final String DB_NAME = "OrderDB";
    static final String TB_NAME = "Orderlist";
    static final String[] FROM = new String[]{"name", "phone", "email", "beef", "pork", "fish", "cola", "sprite", "tea", "fries", "chicken", "applepie", "total"};
    String[] Stringitem = new String[13];
    ListView lv;
    Cursor cur;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkorder);
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        String createTable = "CREATE TABLE IF NOT EXISTS " + TB_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(32), " +
                "phone VARCHAR(16), " +
                "email VARCHAR(64), " +
                "beef VARCHAR(8), " +
                "pork VARCHAR(8), " +
                "fish VARCHAR(8), " +
                "cola VARCHAR(8), " +
                "sprite VARCHAR(8), " +
                "tea VARCHAR(8), " +
                "fries VARCHAR(8), " +
                "chicken VARCHAR(8), " +
                "applepie VARCHAR(8), " +
                "total VARCHAR(8))";
        db.execSQL(createTable);
        getData();
        cur = db.rawQuery("SELECT * FROM " + TB_NAME, null);
        if (cur.getCount() == 0) {
            return;
        }

        adapter = new SimpleCursorAdapter(this,
                R.layout.item, cur,
                FROM,
                new int[]{R.id.name, R.id.phone, R.id.email, R.id._beef, R.id._pork,R.id._fish,R.id._cola,
                        R.id._sprite,R.id._tea,R.id._fries,R.id._chicken,R.id._applepie,R.id.total}, 0);

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }
    public void getData(){
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            Stringitem[0] = bundle.getString("name");
            Stringitem[1] = bundle.getString("phone");
            Stringitem[2] = bundle.getString("mail");
            Stringitem[3] = bundle.getString("beef");
            Stringitem[4] = bundle.getString("pork");
            Stringitem[5] = bundle.getString("fish");
            Stringitem[6] = bundle.getString("cola");
            Stringitem[7] = bundle.getString("sprite");
            Stringitem[8] = bundle.getString("tea");
            Stringitem[9] = bundle.getString("fries");
            Stringitem[10] = bundle.getString("chicken");
            Stringitem[11] = bundle.getString("applepie");
            Stringitem[12] = bundle.getString("total");
        }
        ContentValues cv = new ContentValues(13);
        for(int i=0 ; i<13 ; i++){
            cv.put(FROM[i], Stringitem[i]);
        }
        db.insert(TB_NAME, null, cv);
    }
    public void homepage(View view){
        Intent intent1 = new Intent(this , MainActivity.class);
        startActivity(intent1);
    }
}