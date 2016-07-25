package com.jackson.animationdemo;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button alphaBtn,scaleBtn,translateBtn,rotateBtn,frameBtn,
            layoutBtn,objectBtn,valueBtn,animSet1,animSet2,animSet3,animSet4,bollFlower;

    ImageView imageView;

    Animation loadAnimation;

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
        animSet1= (Button) findViewById(R.id.animation_set1);
        animSet2= (Button) findViewById(R.id.animation_set2);
        animSet3= (Button) findViewById(R.id.animation_set3);
        animSet4= (Button) findViewById(R.id.animation_set4);
        bollFlower= (Button) findViewById(R.id.button_boll_flower);
        imageView= (ImageView) findViewById(R.id.imageView);


        alphaBtn.setOnClickListener(this);
        scaleBtn.setOnClickListener(this);
        translateBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        frameBtn.setOnClickListener(this);
        layoutBtn.setOnClickListener(this);
        objectBtn.setOnClickListener(this);
        valueBtn.setOnClickListener(this);
        animSet1.setOnClickListener(this);
        animSet2.setOnClickListener(this);
        animSet3.setOnClickListener(this);
        animSet4.setOnClickListener(this);
        bollFlower.setOnClickListener(this);
        imageView.setOnClickListener(this);

    }

    /**
     * 通过配置文件实现--更简单比较固定
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_alpha:

                loadAnimation= AnimationUtils.loadAnimation(this,R.anim.tween_alpha);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.button_scale:
                loadAnimation= AnimationUtils.loadAnimation(this,R.anim.tween_scale);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.button_translate:
                loadAnimation= AnimationUtils.loadAnimation(this,R.anim.tween_translate);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.button_rotate:
                loadAnimation= AnimationUtils.loadAnimation(this,R.anim.tween_rotate);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.animation_set1:
                //在配置文件中设置延迟startOffset实现动画续播
                loadAnimation=AnimationUtils.loadAnimation(this,R.anim.set1);
                imageView.startAnimation(loadAnimation);
                break;
            case R.id.animation_set2:
                //设置动画监听器,监听第一个动画播完后播放第二个动画
                loadAnimation=AnimationUtils.loadAnimation(this,R.anim.tween_translate);
                imageView.startAnimation(loadAnimation);
                final Animation loadAnimation2=AnimationUtils.loadAnimation(this,R.anim.tween_rotate);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        imageView.startAnimation(loadAnimation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.animation_set3:
                //Activity切换动画
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.set_in,R.anim.set_out);
                break;
            case R.id.animation_set4:
                //通过代码实现闪烁
                AlphaAnimation alphaAnimation=new AlphaAnimation(0.1f,1.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setRepeatCount(10);
                alphaAnimation.setRepeatMode(Animation.REVERSE);//倒序播放 正序播放时restart
                imageView.startAnimation(alphaAnimation);
                break;

            case R.id.button_frame:
                imageView.setImageResource(R.drawable.anim_list);
                break;

            case R.id.button_layout:
                startActivity(new Intent(MainActivity.this,ThirdActivity.class));
                break;
            case R.id.button_object:
                startActivity(new Intent(MainActivity.this,ObjectAnimatorActivity.class));
                break;
            case R.id.button_boll_flower:
                startActivity(new Intent(MainActivity.this,BollFlowerActivity.class));
                break;
            //ObjectAnimator继承自ValueAnimator,不能控制属性,不会响应动画,就是一个数值发生器
            case R.id.button_value:
                ValueAnimator animator=ValueAnimator.ofInt(0,100);
                animator.setDuration(5000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        //实现计时器的动画效果
                        Integer value= (Integer) valueAnimator.getAnimatedValue();
                        valueBtn.setText("value:"+value);
                    }
                });
                animator.start();
                //ValueAnimator.ofFloat()等等功能强大
                break;
            case R.id.imageView:
                Toast.makeText(MainActivity.this, "哈哈,我被点击了,我太高兴了...", Toast.LENGTH_SHORT).show();
                break;

        }

    }
    /**
     * 通过java代码实现--更灵活
     * @param view
     */
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.button_alpha:
//
//                break;
//            case R.id.button_scale:
//
//                break;
//            case R.id.button_translate:
//                  TranslateAnimation animation=new Translation(0,200,0,0);//fromX,toX,fromY,toY
    //              animation.setDuration=(1000);
    //              imageView.startAnimation(animation);
//                break;
//            case R.id.button_rotate:
//
//                break;
//            case R.id.button_frame:
//
//                break;
//            case R.id.button_layout:
//
//                break;
//            case R.id.button_object:
//
//                break;
//            case R.id.button_value:
//
//                break;
//            case R.id.imageView:
//                Toast.makeText(MainActivity.this, "哈哈,我被点击了,我太高兴了...", Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//
//    }
}
