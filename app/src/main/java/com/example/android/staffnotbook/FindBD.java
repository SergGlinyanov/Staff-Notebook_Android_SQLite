package com.example.android.staffnotbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FindBD extends AppCompatActivity {

    String[] status = {"Worker", "Manager"};
    DBHelper dbHelper;
    Toast toast;
    AlertDialog.Builder ad;
    Context context = FindBD.this;


    public void showInfo(String text) {
        toast = Toast.makeText(FindBD.this, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_bd);

        Spinner spinner = (Spinner) findViewById(R.id.status1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, status);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void btnFind(View view) {

        Spinner spinner = (Spinner) findViewById(R.id.status1);
        String selected = spinner.getSelectedItem().toString();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        if (selected.equalsIgnoreCase("Worker")) {

            EditText name = (EditText) findViewById(R.id.find_last_name);

            if (name.getText().toString().equalsIgnoreCase("")) {
                ad = new AlertDialog.Builder(context);
                ad.setMessage("Enter your request.");
                ad.setPositiveButton("Ok", null);
                ad.show();
            } else {

                Cursor cursor = database.query(DBHelper.TABLE_WORKER, null, null, null, null, null, null);

                if (cursor.getCount() != 0) {
                    String summ = "";

                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                        String w1 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                        String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                        String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                        String w4 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));

                        if (w1.equalsIgnoreCase(name.getText().toString())) {

                            summ = summ + "Name:                " + w + "\n" +
                                    "Last Name:       " + w1 + "\n" +
                                    "Phone:               " + w2 + "\n" +
                                    "Year of birth:    " + w3 + "\n" +
                                    "Manager:          " + w4 + "\n" + "\n";
                        }
                    }
                    if (summ.equalsIgnoreCase("")) {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("No matches found.");
                        ad.setPositiveButton("Ok", null);
                        ad.show();
                    } else {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage(summ);
                        ad.setPositiveButton("Ok", null);
                        ad.show();
                    }
                }
                cursor.close();
            }
        } else if (selected.equalsIgnoreCase("Manager")) {

            EditText name = (EditText) findViewById(R.id.find_last_name);

            if (name.getText().toString().equalsIgnoreCase("")) {
                ad = new AlertDialog.Builder(context);
                ad.setMessage("Enter your request.");
                ad.setPositiveButton("Ok", null);
                ad.show();
            } else {

                Cursor cursor1 = database.query(DBHelper.TABLE_MANAGER, null, null, null, null, null, null);

                if (cursor1.getCount() != 0) {
                    String summ = "";

                    for (int i = 0; i < cursor1.getCount(); i++) {
                        cursor1.moveToPosition(i);
                        String w = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                        String w1 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                        String w2 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                        String w3 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                        String w4 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));

                        if (w1.equalsIgnoreCase(name.getText().toString())) {

                            summ = summ + "Name:                " + w + "\n" +
                                    "Last Name:       " + w1 + "\n" +
                                    "Phone:               " + w2 + "\n" +
                                    "Year of birth:    " + w3 + "\n" +
                                    "Manager:          " + w4 + "\n" + "\n";

                        }
                    }
                    if (summ.equalsIgnoreCase("")) {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("No matches found.");
                        ad.setPositiveButton("Ok", null);
                        ad.show();

                    } else {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage(summ);
                        ad.setPositiveButton("Ok", null);
                        ad.show();
                    }
                }
                cursor1.close();
            }
        }
        dbHelper.close();
    }

    public void btnRemove(View view) {

        Spinner spinner = (Spinner) findViewById(R.id.status1);
        String selected = spinner.getSelectedItem().toString();
        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        if (selected.equalsIgnoreCase("Worker")) {

           final EditText name = (EditText) findViewById(R.id.find_first_name);

            if (name.getText().toString().equalsIgnoreCase("")) {
                ad = new AlertDialog.Builder(context);
                ad.setMessage("Enter your request.");
                ad.setPositiveButton("Ok", null);
                ad.show();
            } else {

                Cursor cursor = database.query(DBHelper.TABLE_WORKER, null, null, null, null, null, null);

                if (cursor.getCount() != 0) {
                    String summ = "";

                    for (int i = 0; i < cursor.getCount(); i++) {
                        cursor.moveToPosition(i);
                        String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));

                        if (w.equalsIgnoreCase(name.getText().toString())) {
                            summ = w;
                            database.execSQL("DELETE FROM " + DBHelper.TABLE_WORKER + " WHERE " + DBHelper.KEY_LASTNAME + "= '" + w + "'");
                            database.delete(DBHelper.TABLE_STAFF, null, null);
                            database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                                    DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                                    + " SELECT " + DBHelper.KEY_NAME + "," + DBHelper.KEY_LASTNAME + "," + DBHelper.KEY_PHONE +
                                    "," + DBHelper.KEY_YEAR + " FROM " + DBHelper.TABLE_WORKER + ";");
                            database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                                    DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                                    + " SELECT " + DBHelper.KEY_NAME_M + "," + DBHelper.KEY_LASTNAME_M + "," + DBHelper.KEY_PHONE_M +
                                    "," + DBHelper.KEY_YEAR_M + " FROM " + DBHelper.TABLE_MANAGER + ";");
                        }
                    }
                    if (summ.equalsIgnoreCase("")) {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("No matches found.");
                        ad.setPositiveButton("Ok", null);
                        ad.show();
                    } else {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("Worker " + summ + " remove.");
                        ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                name.setText("");

                            }
                        });
                        ad.show();
                    }
                }
                cursor.close();
            }
        } else if (selected.equalsIgnoreCase("Manager")) {

             final EditText name = (EditText) findViewById(R.id.find_first_name);

            if (name.getText().toString().equalsIgnoreCase("")) {
                ad = new AlertDialog.Builder(context);
                ad.setMessage("Enter your request.");
                ad.setPositiveButton("Ok", null);
                ad.show();
            } else {

                Cursor cursor1 = database.query(DBHelper.TABLE_MANAGER, null, null, null, null, null, null);

                if (cursor1.getCount() != 0) {
                    String summ = "";

                    for (int i = 0; i < cursor1.getCount(); i++) {
                        cursor1.moveToPosition(i);
                        String w = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));

                        if (w.equalsIgnoreCase(name.getText().toString())) {
                            summ = w;
                            database.execSQL("DELETE FROM " + DBHelper.TABLE_MANAGER + " WHERE " + DBHelper.KEY_LASTNAME_M + "= '" + w + "'");
                            database.delete(DBHelper.TABLE_STAFF, null, null);
                            database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                                    DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                                    + " SELECT " + DBHelper.KEY_NAME + "," + DBHelper.KEY_LASTNAME + "," + DBHelper.KEY_PHONE +
                                    "," + DBHelper.KEY_YEAR + " FROM " + DBHelper.TABLE_WORKER + ";");
                            database.execSQL("INSERT INTO " + DBHelper.TABLE_STAFF + "(" + DBHelper.KEY_NAME_S  + "," +
                                    DBHelper.KEY_LASTNAME_S + "," + DBHelper.KEY_PHONE_S + "," + DBHelper.KEY_YEAR_S + ") "
                                    + " SELECT " + DBHelper.KEY_NAME_M + "," + DBHelper.KEY_LASTNAME_M + "," + DBHelper.KEY_PHONE_M +
                                    "," + DBHelper.KEY_YEAR_M + " FROM " + DBHelper.TABLE_MANAGER + ";");

                        }
                    }
                    if (summ.equalsIgnoreCase("")) {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("No matches found.");
                        ad.setPositiveButton("Ok", null);
                        ad.show();

                    } else {
                        ad = new AlertDialog.Builder(context);
                        ad.setMessage("Manager " + summ + " removed.");
                        ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                name.setText("");

                            }
                        });
                        ad.show();
                    }
                }
                cursor1.close();
            }
        }
        dbHelper.close();
    }

    public void btnSortName(View view) {

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_STAFF, null, null,
                null, null, null, DBHelper.KEY_NAME_S);

        String summ = "";
        if (cursor.getCount() != 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME_S));
                String w1 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME_S));
                String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE_S));
                String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR_S));

                summ = summ + "Name:                " + w + "\n" +
                        "Last Name:       " + w1 + "\n" +
                        "Phone:               " + w2 + "\n" +
                        "Year of birth:    " + w3 + "\n" + "\n" ;
            }
        }
        cursor.close();
        dbHelper.close();

        if (summ.equalsIgnoreCase("")){
            ad =new AlertDialog.Builder(context);
            ad.setMessage("List is empty. Fill in the list.");
            ad.setPositiveButton("Ok",null);
            ad.show();

        }
        else {    ad =new AlertDialog.Builder(context);
            ad.setMessage(summ);
            ad.setPositiveButton("Ok",null);
            ad.show();}
    }

    public void btnSortYear(View view) {

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_STAFF, null, null,
                null, null, null, DBHelper.KEY_YEAR_S);

        String summ = "";
        if (cursor.getCount() != 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToPosition(i);
                String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME_S));
                String w1 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME_S));
                String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE_S));
                String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR_S));

                summ = summ + "Name:                " + w + "\n" +
                        "Last Name:       " + w1 + "\n" +
                        "Phone:               " + w2 + "\n" +
                        "Year of birth:    " + w3 + "\n" + "\n" ;
            }
        }
        cursor.close();
        dbHelper.close();

        if (summ.equalsIgnoreCase("")){
            ad =new AlertDialog.Builder(context);
            ad.setMessage("List is empty. Fill in the list.");
            ad.setPositiveButton("Ok",null);
            ad.show();

        }
        else {
            ad =new AlertDialog.Builder(context);
            ad.setMessage(summ);
            ad.setPositiveButton("Ok",null);
            ad.show();}
    }

    public void backBD(View view){
        Intent intent = new Intent(FindBD.this, MainActivity.class);
        startActivity(intent);
    }

}
