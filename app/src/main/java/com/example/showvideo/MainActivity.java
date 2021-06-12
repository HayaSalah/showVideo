package com.example.showvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3, btn4;
    String u1="https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4";
    String u2 ="https://www.youtube.com/watch?v=5mB5Yw5fGww&t=118s";
    String u3 ="https://www.youtube.com/watch?v=BD95BJZKJtc";
    String u4 ="https://www.youtube.com/watch?v=0_t5HYJNPsU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button_v1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.button_v2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.button_v3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.button_v4);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_v1:
                GoToShowVideo(u1);
                break;
            case R.id.button_v2:
                GoToShowVideo(u2);
                break;
            case R.id.button_v3:
                GoToShowVideo(u3);
                break;
            case R.id.button_v4:
                GoToShowVideo(u4);

                break;

        }
    }

    private void GoToShowVideo(String uri) {
        Intent intent = new Intent(this, showVideo.class);
        intent.putExtra("uri", uri);
        startActivity(intent);
    }
}