package com.example.android.staffnotbook;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Staff extends AppCompatActivity implements View.OnClickListener {

    TextView textView_Worker_1, textView_Worker_2, textView_Worker_3, textView_Worker_4,
             textView_Worker_5, textView_Worker_6, textView_Worker_7, textView_Worker_8,
             textView_Worker_9, textView_Worker_10, textView_Manager_1,
             textView_Manager_2, textView_Manager_3, textView_Manager_4, textView_Manager_5,
             textView_Manager_6, textView_Manager_7, textView_Manager_8, textView_Manager_9,
             textView_Manager_10 ;

    DBHelper dbHelper;
    AlertDialog.Builder ad;
    Context context = Staff.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff);

        textView_Worker_1 = (TextView) this.findViewById(R.id.textView_Worker_1);
        textView_Worker_2 = (TextView) this.findViewById(R.id.textView_Worker_2);
        textView_Worker_3 = (TextView) this.findViewById(R.id.textView_Worker_3);
        textView_Worker_4 = (TextView) this.findViewById(R.id.textView_Worker_4);
        textView_Worker_5 = (TextView) this.findViewById(R.id.textView_Worker_5);
        textView_Worker_6 = (TextView) this.findViewById(R.id.textView_Worker_6);
        textView_Worker_7 = (TextView) this.findViewById(R.id.textView_Worker_7);
        textView_Worker_8 = (TextView) this.findViewById(R.id.textView_Worker_8);
        textView_Worker_9 = (TextView) this.findViewById(R.id.textView_Worker_9);
        textView_Worker_10 = (TextView) this.findViewById(R.id.textView_Worker_10);
        textView_Manager_1 = (TextView) this.findViewById(R.id.textView_Manager_1);
        textView_Manager_2 = (TextView) this.findViewById(R.id.textView_Manager_2);
        textView_Manager_3 = (TextView) this.findViewById(R.id.textView_Manager_3);
        textView_Manager_4 = (TextView) this.findViewById(R.id.textView_Manager_4);
        textView_Manager_5 = (TextView) this.findViewById(R.id.textView_Manager_5);
        textView_Manager_6 = (TextView) this.findViewById(R.id.textView_Manager_6);
        textView_Manager_7 = (TextView) this.findViewById(R.id.textView_Manager_7);
        textView_Manager_8 = (TextView) this.findViewById(R.id.textView_Manager_8);
        textView_Manager_9 = (TextView) this.findViewById(R.id.textView_Manager_9);
        textView_Manager_10 = (TextView) this.findViewById(R.id.textView_Manager_10);

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_WORKER, null, null, null, null, null, null);

        if (cursor.getCount() !=0){

        for (int i =0; i<cursor.getCount();i++) {

            switch (i) {

                case 0:
                    cursor.moveToPosition(0);
                    int w1 = cursor.getPosition() + 1;
                    String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_1.setText("" + w1 + ". " + w2 + " " + w3 + " " + "◲");
                    break;
                case 1:
                    cursor.moveToPosition(1);
                    int w11 = cursor.getPosition() + 1;
                    String w22 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w33 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_2.setText("" + w11 + ". " + w22 + " " + w33 + " " + "◲");
                    break;
                case 2:
                    cursor.moveToPosition(2);
                    int w111 = cursor.getPosition() + 1;
                    String w222 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w333 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_3.setText("" + w111 + ". " + w222 + " " + w333 + " " + "◲");
                    break;
                case 3:
                    cursor.moveToPosition(3);
                    int w1111 = cursor.getPosition() + 1;
                    String w2222 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3333 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_4.setText("" + w1111 + ". " + w2222 + " " + w3333 + " " + "◲");
                    break;
                case 4:
                    cursor.moveToPosition(4);
                    int w1112 = cursor.getPosition() + 1;
                    String w2223 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3334 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_5.setText("" + w1112 + ". " + w2223 + " " + w3334 + " " + "◲");
                    break;
                case 5:
                    cursor.moveToPosition(5);
                    int w1115 = cursor.getPosition() + 1;
                    String w2225 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3335 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_6.setText("" + w1115 + ". " + w2225 + " " + w3335 + " " + "◲");
                    break;
                case 6:
                    cursor.moveToPosition(6);
                    int w1116 = cursor.getPosition() + 1;
                    String w2226 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3336 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_7.setText("" + w1116 + ". " + w2226 + " " + w3336 + " " + "◲");
                    break;
                case 7:
                    cursor.moveToPosition(7);
                    int w1117 = cursor.getPosition() + 1;
                    String w2227 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3337 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_8.setText("" +w1117 + ". " + w2227 + " " + w3337 + " " + "◲");
                    break;
                case 8:
                    cursor.moveToPosition(8);
                    int w1118 = cursor.getPosition() + 1;
                    String w2228 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3338 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_9.setText("" + w1118 + ". " + w2228 + " " + w3338 + " " + "◲");
                    break;
                case 9:
                    cursor.moveToPosition(9);
                    int w1119 = cursor.getPosition() + 1;
                    String w2229 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w3339 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    textView_Worker_10.setText("" + w1119 + ". " + w2229 + " " + w3339 + " " + "◲");
                    break;
            }
        }
        cursor.close();

        Cursor cursorM = database.query(DBHelper.TABLE_MANAGER, null, null, null, null, null, null);

        for (int i =0; i<cursorM.getCount();i++) {

            switch (i) {

                case 0:
                    cursorM.moveToPosition(0);
                    int w1 = cursorM.getPosition() + 1;
                    String w2 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_1.setText("" + w1 + ". " + w2 + " " + w3 + " " + "◲");
                    break;
                case 1:
                    cursorM.moveToPosition(1);
                    int w11 = cursorM.getPosition() + 1;
                    String w22 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w33 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_2.setText("" + w11 + ". " + w22 + " " + w33 + " " + "◲");
                    break;
                case 2:
                    cursorM.moveToPosition(2);
                    int w111 = cursorM.getPosition() + 1;
                    String w222 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w333 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_3.setText("" + w111 + ". " + w222 + " " + w333 + " " + "◲");
                    break;
                case 3:
                    cursorM.moveToPosition(3);
                    int w1111 = cursorM.getPosition() + 1;
                    String w2222 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3333 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_4.setText("" + w1111 + ". " + w2222 + " " + w3333 + " " + "◲");
                    break;
                case 4:
                    cursorM.moveToPosition(4);
                    int w1112 = cursorM.getPosition() + 1;
                    String w2223 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3334 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_5.setText("" + w1112 + ". " + w2223 + " " + w3334 + " " + "◲");
                    break;
                case 5:
                    cursorM.moveToPosition(5);
                    int w1115 = cursorM.getPosition() + 1;
                    String w2225 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3335 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_6.setText("" + w1115 + ". " + w2225 + " " + w3335 + " " + "◲");
                    break;
                case 6:
                    cursorM.moveToPosition(6);
                    int w1116 = cursorM.getPosition() + 1;
                    String w2226 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3336 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_7.setText("" + w1116 + ". " + w2226 + " " + w3336 + " " + "◲");
                    break;
                case 7:
                    cursorM.moveToPosition(7);
                    int w1117 = cursorM.getPosition() + 1;
                    String w2227 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3337 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_8.setText("" + w1117 + ". " + w2227 + " " + w3337 + " " + "◲");
                    break;
                case 8:
                    cursorM.moveToPosition(8);
                    int w1118 = cursorM.getPosition() + 1;
                    String w2228 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3338 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_9.setText("" + w1118 + ". " + w2228 + " " + w3338 + " " + "◲");
                    break;
                case 9:
                    cursorM.moveToPosition(9);
                    int w1119 = cursorM.getPosition() + 1;
                    String w2229 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w3339 = cursorM.getString(cursorM.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    textView_Manager_10.setText("" + w1119 + ". " + w2229 + " " + w3339 + " " + "◲");
                    break;
            }
        }
        cursorM.close();
        dbHelper.close();}
    }

    public void back(View view){
        Intent intent = new Intent(Staff.this, MainActivity.class);
        startActivity(intent);
    }

    public void clear(View view){

        ad = new AlertDialog.Builder(context);
        ad.setMessage("The list will be deleted!" + "\n" + "\n" + "Are you sure?");
        ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {
                textView_Worker_1.setText("");
                textView_Worker_1.setText("");
                textView_Worker_2.setText("");
                textView_Worker_3.setText("");
                textView_Worker_4.setText("");
                textView_Worker_5.setText("");
                textView_Worker_6.setText("");
                textView_Worker_7.setText("");
                textView_Worker_8.setText("");
                textView_Worker_9.setText("");
                textView_Worker_10.setText("");
                textView_Manager_1.setText("");
                textView_Manager_2.setText("");
                textView_Manager_3.setText("");
                textView_Manager_4.setText("");
                textView_Manager_5.setText("");
                textView_Manager_6.setText("");
                textView_Manager_7.setText("");
                textView_Manager_8.setText("");
                textView_Manager_9.setText("");
                textView_Manager_10.setText("");

                Toast.makeText(context, "List cleared",
                        Toast.LENGTH_SHORT).show();
            }
        });
        ad.setNegativeButton("No", null);
        ad.show();
    }

    @Override
    public void onClick(View view) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_WORKER, null, null, null, null, null, null);
        if (cursor.getCount() !=0) {

            switch (view.getId()) {

                case R.id.textView_Worker_1:
                    cursor.moveToPosition(0);
                    String w = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w1 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w2 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w3 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w4 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w
                            + "\n" + "Last name:        " + w1
                            + "\n" + "Phone:               " + w2
                            + "\n" + "Year of birth:     " + w3
                            + "\n" + "Manager:           " + w4);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_2:
                    cursor.moveToPosition(1);
                    String w111 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w11 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w21 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w31 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w41 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w111
                            + "\n" + "Last name:        " + w11
                            + "\n" + "Phone:               " + w21
                            + "\n" + "Year of birth:     " + w31
                            + "\n" + "Manager:           " + w41);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_3:
                    cursor.moveToPosition(2);
                    String w22 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w122 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w222 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w32 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w42 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w22
                            + "\n" + "Last name:        " + w122
                            + "\n" + "Phone:               " + w222
                            + "\n" + "Year of birth:     " + w32
                            + "\n" + "Manager:           " + w42);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_4:
                    cursor.moveToPosition(3);
                    String w44 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w14 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w24 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w34 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w444 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w44
                            + "\n" + "Last name:        " + w14
                            + "\n" + "Phone:               " + w24
                            + "\n" + "Year of birth:     " + w34
                            + "\n" + "Manager:           " + w444);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_5:
                    cursor.moveToPosition(4);
                    String w5 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w15 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w25 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w35 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w45 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w5
                            + "\n" + "Last name:        " + w15
                            + "\n" + "Phone:               " + w25
                            + "\n" + "Year of birth:     " + w35
                            + "\n" + "Manager:           " + w45);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_6:
                    cursor.moveToPosition(5);
                    String w6 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w16 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w26 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w36 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w46 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w6
                            + "\n" + "Last name:        " + w16
                            + "\n" + "Phone:               " + w26
                            + "\n" + "Year of birth:     " + w36
                            + "\n" + "Manager:           " + w46);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_7:
                    cursor.moveToPosition(6);
                    String w7 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w17 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w27 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w37 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w47 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w7
                            + "\n" + "Last name:        " + w17
                            + "\n" + "Phone:               " + w27
                            + "\n" + "Year of birth:     " + w37
                            + "\n" + "Manager:           " + w47);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_8:
                    cursor.moveToPosition(7);
                    String w8 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w18 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w28 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w38 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w48 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w8
                            + "\n" + "Last name:        " + w18
                            + "\n" + "Phone:               " + w28
                            + "\n" + "Year of birth:     " + w38
                            + "\n" + "Manager:           " + w48);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_9:
                    cursor.moveToPosition(8);
                    String w9 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w19 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w29 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w39 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w49 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w9
                            + "\n" + "Last name:        " + w19
                            + "\n" + "Phone:               " + w29
                            + "\n" + "Year of birth:     " + w39
                            + "\n" + "Manager:           " + w49);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Worker_10:
                    cursor.moveToPosition(9);
                    String w55 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME));
                    String w155 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_LASTNAME));
                    String w255 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_PHONE));
                    String w355 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_YEAR));
                    String w455 = cursor.getString(cursor.getColumnIndex(DBHelper.KEY_MANAGER));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w55
                            + "\n" + "Last name:        " + w155
                            + "\n" + "Phone:               " + w255
                            + "\n" + "Year of birth:     " + w355
                            + "\n" + "Manager:           " + w455);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;
            }
        }
        cursor.close();

        Cursor cursor1 = database.query(DBHelper.TABLE_MANAGER, null, null,
                null, null, null, null);

        if (cursor1.getCount() !=0) {

            switch (view.getId()) {

                case R.id.textView_Manager_1:
                    cursor1.moveToPosition(0);
                    String w = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w1 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w2 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w3 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w4 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w
                            + "\n" + "Last name:        " + w1
                            + "\n" + "Phone:               " + w2
                            + "\n" + "Year of birth:     " + w3
                            + "\n" + "Department:      " + w4);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_2:
                    cursor1.moveToPosition(1);
                    String w111 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w11 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w21 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w31 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w41 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w111
                            + "\n" + "Last name:        " + w11
                            + "\n" + "Phone:               " + w21
                            + "\n" + "Year of birth:     " + w31
                            + "\n" + "Department:      " + w41);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_3:
                    cursor1.moveToPosition(2);
                    String w22 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w122 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w222 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w32 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w42 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w22
                            + "\n" + "Last name:        " + w122
                            + "\n" + "Phone:               " + w222
                            + "\n" + "Year of birth:     " + w32
                            + "\n" + "Department:      " + w42);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_4:
                    cursor1.moveToPosition(3);
                    String w44 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w14 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w24 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w34 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w444 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w44
                            + "\n" + "Last name:        " + w14
                            + "\n" + "Phone:               " + w24
                            + "\n" + "Year of birth:     " + w34
                            + "\n" + "Department:      " + w444);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_5:
                    cursor1.moveToPosition(4);
                    String w5 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w15 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w25 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w35 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w45 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w5
                            + "\n" + "Last name:        " + w15
                            + "\n" + "Phone:               " + w25
                            + "\n" + "Year of birth:     " + w35
                            + "\n" + "Department:      " + w45);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_6:
                    cursor1.moveToPosition(5);
                    String w6 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w16 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w26 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w36 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w46 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w6
                            + "\n" + "Last name:        " + w16
                            + "\n" + "Phone:               " + w26
                            + "\n" + "Year of birth:     " + w36
                            + "\n" + "Department:      " + w46);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_7:
                    cursor1.moveToPosition(6);
                    String w7 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w17 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w27 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w37 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w47 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w7
                            + "\n" + "Last name:        " + w17
                            + "\n" + "Phone:               " + w27
                            + "\n" + "Year of birth:     " + w37
                            + "\n" + "Department:      " + w47);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_8:
                    cursor1.moveToPosition(7);
                    String w8 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w18 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w28 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w38 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w48 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w8
                            + "\n" + "Last name:        " + w18
                            + "\n" + "Phone:               " + w28
                            + "\n" + "Year of birth:     " + w38
                            + "\n" + "Department:      " + w48);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_9:
                    cursor1.moveToPosition(8);
                    String w9 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w19 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w29 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w39 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w49 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w9
                            + "\n" + "Last name:        " + w19
                            + "\n" + "Phone:               " + w29
                            + "\n" + "Year of birth:     " + w39
                            + "\n" + "Department:      " + w49);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;

                case R.id.textView_Manager_10:
                    cursor1.moveToPosition(9);
                    String w55 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_NAME_M));
                    String w155 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_LASTNAME_M));
                    String w255 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_PHONE_M));
                    String w355 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_YEAR_M));
                    String w455 = cursor1.getString(cursor1.getColumnIndex(DBHelper.KEY_DEPARTMENT));
                    ad = new AlertDialog.Builder(context);
                    ad.setMessage("Name:                " + w55
                            + "\n" + "Last name:        " + w155
                            + "\n" + "Phone:               " + w255
                            + "\n" + "Year of birth:     " + w355
                            + "\n" + "Department:      " + w455);
                    ad.setPositiveButton("Ok", null);
                    ad.show();
                    break;
            }
        }
        cursor1.close();
        dbHelper.close();
    }
}

