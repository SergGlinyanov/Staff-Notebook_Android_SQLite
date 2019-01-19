package com.example.android.staffnotbook;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Find extends AppCompatActivity {

    DBHelper dbHelper;
    TextView managers, workers;

    public void back(View view){
        Intent intent = new Intent(Find.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_WORKER, null, null, null, null, null, null);
        Cursor cursor1 = database.query(DBHelper.TABLE_MANAGER, null, null, null, null, null, null);

        managers = (TextView) this.findViewById(R.id.managers);
        workers = (TextView) this.findViewById(R.id.workers);
        managers.setMovementMethod(new ScrollingMovementMethod());
        workers.setMovementMethod(new ScrollingMovementMethod());

        workers.setText("");
        managers.setText("");
        if (cursor != null) {


                for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        int id = cursor.getPosition() + 1;
                        String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                        String w1 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                        String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                        String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                        String w4 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                        String row = ("   " + id + ". " + w + " " + w1 + "\n       Phone: " + w2 + "\n       Year of birth: " + w3 + "\n       Manager: " +  w4 + "\n" + "\n");
                        workers.setText(workers.getText() + row);
                    }
            }
            cursor.close();

            if (cursor1 != null) {
                for (int i = 0; i < cursor1.getCount(); i++) {
                    cursor1.moveToPosition(i);
                    int id = cursor1.getPosition() + 1;
                    String w = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w1 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w2 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w3 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w4 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    String row = ("   " + id + ". " + w + " " + w1 + "\n       Phone: " + w2 + "\n       Year of birth: " + w3 + "\n       Department: " +  w4 + "\n" +"\n");
                    managers.setText(managers.getText() + row);
                }
            }
        cursor1.close();
        dbHelper.close();
    }


}

//    ContentValues contentValues = new ContentValues();{}

