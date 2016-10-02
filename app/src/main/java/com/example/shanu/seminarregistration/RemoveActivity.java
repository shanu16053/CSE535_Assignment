package com.example.shanu.seminarregistration;

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

public class RemoveActivity extends AppCompatActivity {
    public static final String COUNT_STUDENT = "Number_of_Student ";
    private EditText mNameEditText;
    private EditText mRollnoEditText;
    private Button mDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        mNameEditText = (EditText) findViewById(R.id.name);
        mRollnoEditText = (EditText) findViewById(R.id.rollno);
        mDeleteButton= (Button) findViewById(R.id.delete);
        mDeleteButton.setOnClickListener((new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                deleteStudent();
            }
        }
        ));
    }
    private void deleteStudent() {
        String nameString = mNameEditText.getText().toString().trim();
        String rollnoString = mRollnoEditText.getText().toString().trim();
        RegDbHelper mDbHelper = new RegDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String selection = RegistrationContact.Schema.COLUMN_ST_ROLLNO + " LIKE ?";


        String[] selectionArgs = { rollnoString };

        int delid= db.delete(RegistrationContact.Schema.TABLE_NAME, selection, selectionArgs);

        if(delid >= 1 )
        {
            SharedPreferences count = getSharedPreferences(COUNT_STUDENT, Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = count.edit();
            int newcount = count.getInt(COUNT_STUDENT, 0) - delid;
            edit.putInt(COUNT_STUDENT, newcount);
            edit.commit();
            Toast.makeText(this, "succesfully deleted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No record found", Toast.LENGTH_SHORT).show();
        }

    }
}
