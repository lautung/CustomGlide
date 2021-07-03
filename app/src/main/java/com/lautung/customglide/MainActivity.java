package com.lautung.customglide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1, imageView2, imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);

        findViewById(R.id.t1).setOnClickListener(this);
        findViewById(R.id.t2).setOnClickListener(this);
        findViewById(R.id.t3).setOnClickListener(this);

        // 使用
        // Glide.with(this).load("https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg").into(imageView);
    }

    // 加载此图片：https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg
    public void t1() {
        Glide.with(this)
                .load("https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg")
                .into(imageView1); // inio 不能在异步线程运行
    }

    public void t2() {
        Glide.with(this)
                .load("https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg")
                .into(imageView2);
    }

    public void t3() {
        Glide.with(this)
                .load("https://cn.bing.com/sa/simg/hpb/LaDigue_EN-CA1115245085_1920x1080.jpg")
                .into(imageView3);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 1.侵入代码很强
        // 以前的 框架
        /*XXXXX.unDestroy();
        XXXXX.unDestroy();
        XXXXX.unDestroy();*/

        // Glide 你不用写这句话，内部会监听你什么释放了
        // GLide 对 Activity 生命周期方法监听管理
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.t1:
                t1();
                break;
            case R.id.t2:
                t2();
                break;
            case R.id.t3:
                t3();
                break;
        }
    }
}
