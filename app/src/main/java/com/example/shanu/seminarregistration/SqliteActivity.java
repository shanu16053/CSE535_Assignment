package com.example.shanu.seminarregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }
    public void insert(View view) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    public void remove(View view) {
        Intent intent = new Intent(this, RemoveActivity.class);
        startActivity(intent);
    }
    public void update(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivity(intent);
    }
}
