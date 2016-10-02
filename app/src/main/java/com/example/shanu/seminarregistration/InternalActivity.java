package com.example.shanu.seminarregistration;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class InternalActivity extends AppCompatActivity {

    private EditText mSuggestion;
    private Button mSendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        mSuggestion = (EditText) findViewById(R.id.sugmsg);
        mSendButton = (Button) findViewById(R.id.send);
        mSendButton.setOnClickListener((new View.OnClickListener() {
            public void onClick(View arg0) {
                writeSuggestion();
            }
        }
        ));
    }
    private void writeSuggestion() {
        String mesage = mSuggestion.getText().toString().trim() + "/n";
        String File_name = "suggestion.txt";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(File_name, Context.MODE_PRIVATE);
            outputStream.write(mesage.getBytes());
            outputStream.close();
            mSuggestion.setText("");
            Toast.makeText(this, "suggetion saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
