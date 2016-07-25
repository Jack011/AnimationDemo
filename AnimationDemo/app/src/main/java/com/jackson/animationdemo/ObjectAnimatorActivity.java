package com.jackson.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by 90720 on 2016/7/25.
 */
public class ObjectAnimatorActivity extends AppCompatActivity {

    ImageView myLove;
//    Button move;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animator_activity);
        myLove= (ImageView) findViewById(R.id.love);
//        move= (Button) findViewById(R.id.move);
    }

    /**
     * 使用ObjectAnimator实现传统Animation的动画效果
     * @param view
     */
//    public void move(View view){
//        //方法一:使用传统的Animation实现移动:得到你的人却得不到你的心--身在曹营心在汉
////        TranslateAnimation translateAnimation=new TranslateAnimation(0,260,0,260);
////        translateAnimation.setDuration(2600);
////        translateAnimation.setFillAfter(true);
////        myLove.startAnimation(translateAnimation);
//        //方法二:使用属性动画Animator实现位移:得到你的人并且得到你的心
////        ObjectAnimator.ofFloat(myLove,"translationX",0F,260F).setDuration(2600).start();//translationX(是指x轴的偏移量)与X(是指最终达到的绝对值)的区别:与scaleTo与scaleBY同理
////        ObjectAnimator.ofFloat(myLove,"translationY",0F,260F).setDuration(2600).start();
////        ObjectAnimator.ofFloat(myLove,"rotation",0F,350F).setDuration(2600).start();
//        //方法三:以上3动画异步执行,同时开始.这种效果可用PropertyValuesHolder实现
////        PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("translationX",0F,260F);
////        PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("translationY",0F,260F);
////        PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("rotation",0F,260F);
////        ObjectAnimator.ofPropertyValuesHolder(myLove,p1,p2,p3).setDuration(2600).start();//三种动画同时执行
//        //方法四:使用动画集AnimatorSet实现上述三种动画并且可以控制顺序
//        AnimatorSet set=new AnimatorSet();
//        ObjectAnimator anim1=ObjectAnimator.ofFloat(myLove,"translationX",0F,260F);//translationX(是指x轴的偏移量)与X(是指最终达到的绝对值)的区别:与scaleTo与scaleBY同理
//        ObjectAnimator anim2=ObjectAnimator.ofFloat(myLove,"translationY",0F,260F);
//        ObjectAnimator anim3=ObjectAnimator.ofFloat(myLove,"rotation",0F,350F);
////        set.playTogether(anim1,anim2,anim3);//1.三种动画同时执行
////        set.playSequentially(anim1,anim2,anim3);//2.三种动画顺序执行
//        //3先实现X轴Y轴平移动画后执行旋转
//        set.play(anim1).with(anim2);//1和2同时执行
//        set.play(anim3).after(anim1);//1执行完后执行3,或通过before
//        set.setDuration(2600).start();
//
//
//    }

    /**
     * 使用动画监听
     * @param view
     */
    public void move(View view){
        ObjectAnimator animator=ObjectAnimator.ofFloat(myLove,"alpha",0F,1.0F);
        animator.setDuration(2600);
        //使用Animator.AnimatorListener实现监听:必须实现其全部方法---代码冗余
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//                ObjectAnimator.ofFloat(myLove,"translationX",260F,360F).setDuration(2600).start();
//                ObjectAnimator.ofFloat(myLove,"translationY",260F,360F).setDuration(2600).start();
                  //先点击imageView后点击Button可实现位移接力效果
//                Toast.makeText(ObjectAnimatorActivity.this, "我要移动...", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
        //使用AnimatorListenerAdapter实现动画监听:可选择四种方法中的任意一种或多种方法---代码简洁
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ObjectAnimator.ofFloat(myLove,"translationX",0F,260F).setDuration(2600).start();
                ObjectAnimator.ofFloat(myLove,"translationY",0F,260F).setDuration(2600).start();

                Toast.makeText(ObjectAnimatorActivity.this, "我要移动...", Toast.LENGTH_SHORT).show();
            }
        });
        animator.start();

    }

    /**
     * imageView的点击事件
     * @param view
     */
    public void love(View view){
        ObjectAnimator.ofFloat(myLove,"translationX",0F,260F).setDuration(2600).start();
        ObjectAnimator.ofFloat(myLove,"translationY",0F,260F).setDuration(2600).start();

        Toast.makeText(ObjectAnimatorActivity.this, "I am so happy,because I fall in love with you!", Toast.LENGTH_SHORT).show();
    }
}
