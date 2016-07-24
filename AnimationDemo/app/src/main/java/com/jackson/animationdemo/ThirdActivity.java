package com.jackson.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by 90720 on 2016/7/24.
 */
public class ThirdActivity extends AppCompatActivity{

    private ListView listView;

    private String[] jacks=new String[15];



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        listView= (ListView) findViewById(R.id.list_view);
        initData();
        listView.setAdapter(new ArrayAdapter<String>(ThirdActivity.this,android.R.layout.simple_list_item_1,jacks));
        LayoutAnimationController lac=new LayoutAnimationController(AnimationUtils.loadAnimation(ThirdActivity.this,R.anim.set_in));
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);//顺序随机
        listView.setLayoutAnimation(lac);
        listView.startLayoutAnimation();
    }

    private void initData() {
        for (int i=0;i<15;i++){
            jacks[i]="I Love You第"+i+"年";
        }
    }

}
