package com.example.shanu.seminarregistration;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.RegDbHelper;
import database.RegistrationContact;

public class UpdateActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private EditText mRollnoEditText;
    private Button mUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mNameEditText = (EditText) findViewById(R.id.name);
        mRollnoEditText = (EditText) findViewById(R.id.rollno);
        mUpdateButton= (Button) findViewById(R.id.update_button);
        mUpdateButton.setOnClickListener((new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                updateStudent();
            }
        }
        ));
    }
    private void updateStudent() {
        String nameString = mNameEditText.getText().toString().trim();
        String rollnoString = mRollnoEditText.getText().toString().trim();
        RegDbHelper mDbHelper = new RegDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RegistrationContact.Schema.COLUMN_ST_NAME , nameString);

        String selection = RegistrationContact.Schema.COLUMN_ST_ROLLNO + " LIKE ?";
        String[] selectionArgs = { rollnoString };

        int upid = db.update( RegistrationContact.Schema.TABLE_NAME, values, selection, selectionArgs);

        if(upid >= 1 )
        {
            Toast.makeText(this, "succesfully updated", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "no record found", Toast.LENGTH_SHORT).show();
        }

    }
}

