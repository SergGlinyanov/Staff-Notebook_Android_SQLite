package com.example.android.staffnotbook;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;


public class Add extends AppCompatActivity  {

    String[] status = {"Worker", "Manager"};
    DBHelper dbHelper;
    Toast toast;
    AlertDialog.Builder ad;
    Context context = Add.this;


    public void showInfo (String text, int x, int y){
        toast = Toast.makeText(Add.this, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, x, y);
        toast.show();
    }

    public void back(View view){
        Intent intent = new Intent(Add.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        //Visibiliti EditText Department & Position
        Spinner spinner = (Spinner) findViewById(R.id.status);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                EditText department = (EditText) findViewById(R.id.department);
                EditText managerField = (EditText) findViewById(R.id.manager);

               if (position == 0){
                   department.setVisibility(View.GONE);
                   managerField.setVisibility(View.VISIBLE);
               }
               else if (position == 1){
                   department.setVisibility(View.VISIBLE);
                   managerField.setVisibility(View.GONE);
               }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        dbHelper = new DBHelper(this);
    }

    public void clearForm() {
        EditText lastName = (EditText) findViewById(R.id.last_name);
        EditText name = (EditText) findViewById(R.id.name);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText year = (EditText) findViewById(R.id.year);
        EditText department = (EditText) findViewById(R.id.department);
        EditText managerField = (EditText) findViewById(R.id.manager);

        lastName.setText("");
        name.setText("");
        phone.setText("");
        year.setText("");
        department.setText("");
        managerField.setText("");
    }

    // Method button "Add"

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void add_staff(View view) {

        EditText lastName = (EditText) findViewById(R.id.last_name);
        EditText name = (EditText) findViewById(R.id.name);
        EditText phone = (EditText) findViewById(R.id.phone);
        EditText year = (EditText) findViewById(R.id.year);
        EditText department = (EditText) findViewById(R.id.department);
        EditText managerField = (EditText) findViewById(R.id.manager);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Spinner spinner = (Spinner) findViewById(R.id.status);
        String selected = spinner.getSelectedItem().toString();

        boolean result = phone.getText().toString().matches("(\\+*)\\d{11}");
        boolean result1 = year.getText().toString().matches("^\\d{4}$");
        boolean zero = true;


        if (selected.equalsIgnoreCase("Worker")) {

            contentValues.put(DBHelper.KEY_NAME, name.getText().toString());
            contentValues.put(DBHelper.KEY_LASTNAME, lastName.getText().toString());
            contentValues.put(DBHelper.KEY_PHONE, phone.getText().toString());
            contentValues.put(DBHelper.KEY_YEAR, year.getText().toString());
            contentValues.put(DBHelper.KEY_MANAGER, managerField.getText().toString());

            if (name.getText().toString().equalsIgnoreCase("") ||
                    lastName.getText().toString().equalsIgnoreCase("") ||
                    phone.getText().toString().equalsIgnoreCase("") ||
                    year.getText().toString().equalsIgnoreCase("") ||
                    managerField.getText().toString().equalsIgnoreCase("")) zero = false;

            if (zero == true && result == true && result1 == true){

                ad = new AlertDialog.Builder(context);
                ad.setMessage("Worker added " + "\n" + "\n" +
                        "Name:                " + name.getText().toString() + "\n" +
                        "Last Name:       " + lastName.getText().toString()+ "\n" +
                        "Phone:               " + phone.getText().toString()+ "\n" +
                        "Year of birth:    " + year.getText().toString()+ "\n" +
                        "Manager:          " + managerField.getText().toString() + "\n" + "\n" + "\n" +
                        "Add another worker?");
                ad.setPositiveButton("Yes", null);
                ad.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Intent intent = new Intent(Add.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                ad.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        clearForm();
                    }
                });
                ad.show();

            database.insert(DBHelper.TABLE_WORKER, null, contentValues);
            database.delete(DBHelper.TABLE_STAFF, null, null);
            database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                        DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                        + " SELECT " + DBHelper.KEY_NAME + "," + DBHelper.KEY_LASTNAME + "," + DBHelper.KEY_PHONE +
                        "," + DBHelper.KEY_YEAR + " FROM " + DBHelper.TABLE_WORKER + ";");
            }
            else if (zero == false && result == true && result1 == true) showInfo ("Fill in all fields", 0,0);

        } else if (selected.equalsIgnoreCase("Manager")) {

            contentValues.put(DBHelper.KEY_NAME_M, name.getText().toString());
            contentValues.put(DBHelper.KEY_LASTNAME_M, lastName.getText().toString());
            contentValues.put(DBHelper.KEY_PHONE_M, phone.getText().toString());
            contentValues.put(DBHelper.KEY_YEAR_M, year.getText().toString());
            contentValues.put(DBHelper.KEY_DEPARTMENT, department.getText().toString());

            if (name.getText().toString().equalsIgnoreCase("") ||
                    lastName.getText().toString().equalsIgnoreCase("") ||
                    phone.getText().toString().equalsIgnoreCase("") ||
                    year.getText().toString().equalsIgnoreCase("") ||
                    department.getText().toString().equalsIgnoreCase("")) zero = false;

            if (zero == true && result == true && result1 == true){

                ad = new AlertDialog.Builder(context);
                ad.setMessage("Manager added " + "\n" + "\n" +
                        "Name:                " + name.getText().toString() + "\n" +
                        "Last Name:       " + lastName.getText().toString()+ "\n" +
                        "Phone:               " + phone.getText().toString()+ "\n" +
                        "Year of birth:    " + year.getText().toString()+ "\n" +
                        "Department:     " + department.getText().toString() + "\n" + "\n" + "\n" +
                        "Add another manager?");
                ad.setPositiveButton("Yes", null);
                ad.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Intent intent = new Intent(Add.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                ad.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        clearForm();
                    }
                });
                ad.show();

                database.insert(DBHelper.TABLE_MANAGER, null, contentValues);
                database.delete(DBHelper.TABLE_STAFF, null, null);
                database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                        DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                        + " SELECT " + DBHelper.KEY_NAME_M + "," + DBHelper.KEY_LASTNAME_M + "," + DBHelper.KEY_PHONE_M +
                        "," + DBHelper.KEY_YEAR_M + " FROM " + DBHelper.TABLE_MANAGER + ";");
            }
            else if (zero == false && result == true && result1 == true) showInfo ("Fill in all fields", 0,0);

        }

        //check EditText Phone & Year

        if (result == false) {
            showInfo ("Enter 11 digit phone number.", 0,-400);
        }


        if (result1 == true) {
            int i = Integer.parseInt(year.getText().toString());
            if (i > 2018 || i < 1920) {
                result1 = false;
                showInfo ("Invalid birth year",0,-150);
            }
        }
        if (result1 == false) {
            showInfo ("Invalid birth year",0,-150);
        }

        dbHelper.close();
        managerField.clearFocus();
    }


}
