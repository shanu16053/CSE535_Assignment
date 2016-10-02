package com.example.shanu.seminarregistration;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class ExternalStorageActivity extends AppCompatActivity {
    private EditText mFeedback;
    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        mFeedback = (EditText) findViewById(R.id.feedback);
        mSendButton = (Button) findViewById(R.id.send_button);
        mSendButton.setOnClickListener((new View.OnClickListener() {
            public void onClick(View arg0) {
                writeFeedback();
            }
        }
        ));
    }
    private void writeFeedback() {
        String mesage = mFeedback.getText().toString().trim() + "/n";
        String state;
        state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File Dir = Environment.getExternalStorageDirectory();
            File Dirr = new File(Dir.getAbsolutePath() + "/feedback");
            Dirr.mkdirs();
            File file = new File(Dirr, "fdback.txt");
            FileOutputStream outputStream;

            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(mesage.getBytes());
                outputStream.close();
                mFeedback.setText("");
                Toast.makeText(this, "feedback saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(this, "ExternalStorage not found", Toast.LENGTH_SHORT).show();
        }


    }

}
