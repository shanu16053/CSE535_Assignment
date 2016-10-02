package com.example.shanu.seminarregistration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final String COUNT_STUDENT = "Number_of_Student ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        SharedPreferences count = getSharedPreferences(COUNT_STUDENT, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = count.edit();
        edit.commit();
    }
    public void register(View view) {
        Intent intent = new Intent(this, SqliteActivity.class);
          startActivity(intent);

    }
    public void sugetion(View view) {
        Intent intent = new Intent(this, InternalActivity.class);
        startActivity(intent);
    }

    public void feedback(View view) {
        Intent intent = new Intent(this, ExternalStorageActivity.class);
        startActivity(intent);
    }
    public void countStudent(View view)
    {
        SharedPreferences count = getSharedPreferences(COUNT_STUDENT, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = count.edit();
        int newcount = count.getInt(COUNT_STUDENT,0 ) ;
        Toast.makeText(this, "Number of student =" + newcount , Toast.LENGTH_LONG).show();
        edit.commit();
    }


}
