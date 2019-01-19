package com.example.android.staffnotbook;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.staffnotbook.Add;
import com.example.android.staffnotbook.DBHelper;
import com.example.android.staffnotbook.Find;
import com.example.android.staffnotbook.Staff;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    AlertDialog.Builder ad;
    Context context = MainActivity.this;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void staff(View view){
        Intent intent = new Intent(MainActivity.this, Staff.class);
        startActivity(intent);
    }

    public void addStaff(View view){
        Intent intent = new Intent(MainActivity.this, Add.class);
        startActivity(intent);
    }

    public void findStaff(View view){
        Intent intent = new Intent(MainActivity.this, Find.class);
        startActivity(intent);
    }

    public void find(View view){
        Intent intent = new Intent(MainActivity.this, FindBD.class);
        startActivity(intent);
    }

    public void clearAll(View view){

        dbHelper = new DBHelper(this);
        ad = new AlertDialog.Builder(context);
        ad.setMessage("The list will be deleted!" + "\n" + "\n" + "Are you sure?");
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                database.delete(DBHelper.TABLE_MANAGER, null, null);
                database.delete(DBHelper.TABLE_WORKER, null, null);
                database.delete(DBHelper.TABLE_STAFF, null, null);
                toast = Toast.makeText(MainActivity.this, "List cleared.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        ad.setNegativeButton("No", null);
        ad.show();

    }

    public void testList(View view){
        Toast toast;
        toast = Toast.makeText(MainActivity.this, "Test list loaded.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        DBHelper dbHelper;
        dbHelper = new DBHelper(this);
        SQLiteDatabase database15 = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME, "Tom");
        contentValues.put(DBHelper.KEY_LASTNAME, "Smit");
        contentValues.put(DBHelper.KEY_PHONE, "88008885522");
        contentValues.put(DBHelper.KEY_YEAR, "1956");
        contentValues.put(DBHelper.KEY_MANAGER, "Tramp");
        database15.insert(DBHelper.TABLE_WORKER, null, contentValues);

        contentValues.put(DBHelper.KEY_NAME, "John");
        contentValues.put(DBHelper.KEY_LASTNAME, "Do");
        contentValues.put(DBHelper.KEY_PHONE, "88008885533");
        contentValues.put(DBHelper.KEY_YEAR, "1961");
        contentValues.put(DBHelper.KEY_MANAGER, "Tramp");
        database15.insert(DBHelper.TABLE_WORKER, null, contentValues);

        contentValues.put(DBHelper.KEY_NAME, "Ivan");
        contentValues.put(DBHelper.KEY_LASTNAME, "Urgant");
        contentValues.put(DBHelper.KEY_PHONE, "88008881111");
        contentValues.put(DBHelper.KEY_YEAR, "1975");
        contentValues.put(DBHelper.KEY_MANAGER, "Putin");
        database15.insert(DBHelper.TABLE_WORKER, null, contentValues);

        contentValues.put(DBHelper.KEY_NAME, "Sergey");
        contentValues.put(DBHelper.KEY_LASTNAME, "Lavrov");
        contentValues.put(DBHelper.KEY_PHONE, "88008881111");
        contentValues.put(DBHelper.KEY_YEAR, "1970");
        contentValues.put(DBHelper.KEY_MANAGER, "Putin");
        database15.insert(DBHelper.TABLE_WORKER, null, contentValues);

        ContentValues contentValues1 = new ContentValues();

        contentValues1.put(DBHelper.KEY_NAME_M, "Donald");
        contentValues1.put(DBHelper.KEY_LASTNAME_M, "Tramp");
        contentValues1.put(DBHelper.KEY_PHONE_M, "88001115511");
        contentValues1.put(DBHelper.KEY_YEAR_M, "1959");
        contentValues1.put(DBHelper.KEY_DEPARTMENT, "USA");
        database15.insert(DBHelper.TABLE_MANAGER, null, contentValues1);

        contentValues1.put(DBHelper.KEY_NAME_M, "Vladimir");
        contentValues1.put(DBHelper.KEY_LASTNAME_M, "Putin");
        contentValues1.put(DBHelper.KEY_PHONE_M, "88000000000");
        contentValues1.put(DBHelper.KEY_YEAR_M, "1949");
        contentValues1.put(DBHelper.KEY_DEPARTMENT, "Russia");
        database15.insert(DBHelper.TABLE_MANAGER, null, contentValues1);
        database15.delete(DBHelper.TABLE_STAFF, null, null);
        database15.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                + " SELECT " + DBHelper.KEY_NAME + "," + DBHelper.KEY_LASTNAME + "," + DBHelper.KEY_PHONE +
                "," + DBHelper.KEY_YEAR + " FROM " + DBHelper.TABLE_WORKER + ";");
        database15.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                + " SELECT " + DBHelper.KEY_NAME_M + "," + DBHelper.KEY_LASTNAME_M + "," + DBHelper.KEY_PHONE_M +
                "," + DBHelper.KEY_YEAR_M + " FROM " + DBHelper.TABLE_MANAGER + ";");

        dbHelper.close();


    }



}
