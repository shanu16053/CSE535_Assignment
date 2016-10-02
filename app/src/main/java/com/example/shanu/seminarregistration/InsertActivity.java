package com.example.shanu.seminarregistration;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.RegDbHelper;
import database.RegistrationContact;

public class InsertActivity extends AppCompatActivity {
    public static final String COUNT_STUDENT = "Number_of_Student ";

    private EditText mNameEditText;
    private EditText mRollnoEditText;
    private Button mSaveButton;
    private EditText mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mNameEditText = (EditText) findViewById(R.id.name);
        mRollnoEditText = (EditText) findViewById(R.id.rollno);
        mSaveButton= (Button) findViewById(R.id.save);
        mEmail = (EditText) findViewById(R.id.email);

        mSaveButton.setOnClickListener((new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                insertStudent();
            }
        }
        ));
    }
    private void insertStudent() {
        String nameString = mNameEditText.getText().toString().trim();
        String rollnoString = mRollnoEditText.getText().toString().trim();
        String emailString = mEmail.getText().toString().trim();

        RegDbHelper mDbHelper = new RegDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RegistrationContact.Schema.COLUMN_ST_NAME, nameString);
        values.put(RegistrationContact.Schema.COLUMN_ST_ROLLNO, rollnoString);
       // values.put(RegistrationContact.Schema.COLUMN_ST_EMAIL, emailString);
        long newId = db.insert(RegistrationContact.Schema.TABLE_NAME, null, values);

        if (newId == -1) {
            // If the  ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences count = getSharedPreferences(COUNT_STUDENT, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = count.edit();
            int newcount = count.getInt(COUNT_STUDENT, 0) + 1;
            edit.putInt(COUNT_STUDENT, newcount);
            edit.commit();

            Toast.makeText(this, "saved with row id: " + newId, Toast.LENGTH_SHORT).show();
        }
    }
}
