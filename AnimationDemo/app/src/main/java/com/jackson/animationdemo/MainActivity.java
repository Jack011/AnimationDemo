package com.jackson.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button alphaBtn,scaleBtn,translateBtn,rotateBtn,frameBtn,layoutBtn,objectBtn,valueBtn;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphaBtn= (Button) findViewById(R.id.button_alpha);
        scaleBtn= (Button) findViewById(R.id.button_scale);
        translateBtn= (Button) findViewById(R.id.button_translate);
        rotateBtn= (Button) findViewById(R.id.button_rotate);
        frameBtn= (Button) findViewById(R.id.button_frame);
        layoutBtn= (Button) findViewById(R.id.button_layout);
        objectBtn= (Button) findViewById(R.id.button_object);
        valueBtn= (Button) findViewById(R.id.button_value);
        imageView= (ImageView) findViewById(R.id.imageView);


        alphaBtn.setOnClickListener(this);
        scaleBtn.setOnClickListener(this);
        translateBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        frameBtn.setOnClickListener(this);
        layoutBtn.setOnClickListener(this);
        objectBtn.setOnClickListener(this);
        valueBtn.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_alpha:

                break;
            case R.id.button_scale:

                break;
            case R.id.button_translate:

                break;
            case R.id.button_rotate:

                break;
            case R.id.button_frame:

                break;
            case R.id.button_layout:

                break;
            case R.id.button_object:

                break;
            case R.id.button_value:

                break;
            case R.id.imageView:
                Toast.makeText(MainActivity.this, "哈哈,我被点击了,我太高兴了...", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
