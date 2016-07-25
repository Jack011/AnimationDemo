package com.jackson.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 90720 on 2016/7/25.
 */
public class BollFlowerActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] res={R.id.imageView_a,R.id.imageView_b,R.id.imageView_c,R.id.imageView_d,
            R.id.imageView_e,R.id.imageView_f,R.id.imageView_g,R.id.imageView_h};
    private List<ImageView> imageViewList=new ArrayList<>();

    private static final int BOLL_RAUDIO=200;
    private boolean flag=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boll_flower_activity);
        initImageViewClick();
    }

    private void initImageViewClick() {
        for (int i=0;i<res.length;i++){
            ImageView imageView=(ImageView)findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_a:
                if (flag) {
                    startAnim();
                }else{
                    closeAnim();
                }
                break;
            default:
                Toast.makeText(BollFlowerActivity.this,view.getId()+"I love you!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 位除第一张图片外添加回收动画--translationY
     */
    private void closeAnim() {
        for (int i=1;i<res.length;i++){
            AnimatorSet set=new AnimatorSet();
            ObjectAnimator animator1=ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",i*150,0F);
            ObjectAnimator animator2=ObjectAnimator.ofFloat(imageViewList.get(i),"translationX",i*60,0F);
            set.playTogether(animator1,animator2);
            set.setDuration(1000);
            //增加依次弹出效果
            set.setStartDelay(i*260);
            //添加动画插值器---增加回弹效果
            set.setInterpolator(new BounceInterpolator());
            set.start();
            flag=true;
        }
    }

    /**
     * 位除第一张图片外添加展开动画--translationY
     */
    private void startAnim() {

        for (int i=1;i<res.length;i++){
            AnimatorSet set=new AnimatorSet();
            ObjectAnimator animator1=ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",0F,i*150);
            ObjectAnimator animator2=ObjectAnimator.ofFloat(imageViewList.get(i),"translationX",0F,i*60);
            set.playTogether(animator1,animator2);
            set.setDuration(1000);
            //增加依次弹出效果
            set.setStartDelay(i*260);
            //添加动画插值器---增加回弹效果
            set.setInterpolator(new BounceInterpolator());
            set.start();
            flag=false;
        }
    }


//    /**
//     * 位除第一张图片外欲四分之一圆展开动画--translationY/X----失败
//     */
//    private void startAnim() {
//
//        for (int i=0;i<res.length;i++){
//            AnimatorSet set=new AnimatorSet();
//            ObjectAnimator animator1=ObjectAnimator.ofFloat(imageViewList.get(i),"translationX",0F,i*60);
//            ObjectAnimator animator2=ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",0F,i*60);
//
//            set.playTogether(animator1,animator2);
//            set.setDuration(1000);
//            //增加依次弹出效果
//            set.setStartDelay(i*260);
//            //添加动画插值器---增加回弹效果
//            set.setInterpolator(new BounceInterpolator());
//
//            set.start();
//            flag=false;
//        }
//
//    }
}
