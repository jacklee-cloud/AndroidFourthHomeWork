package com.example.fourthhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
   private static final String TAG="MainActivity";
    public ViewPager myViewPager;
    private ArrayList<Fragment> myFragmentViewList;
    private static int pagerCount=0;
    private static final int Update=1;//该动作表示更新UI
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message message){
            switch (message.what){
                case 1:
                    myViewPager.setCurrentItem(++pagerCount);
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewPager=(ViewPager)findViewById(R.id.view_pager);
        myFragmentViewList=new ArrayList<>();
        myFragmentViewList.add(new FirstFragment());
       myFragmentViewList.add(new SecondFragment());
       myFragmentViewList.add(new ThirdFragment());
        final MyViewPagerAdapter adapter=new MyViewPagerAdapter(getSupportFragmentManager(),myFragmentViewList);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);
        myViewPager.setPageTransformer(true,new RotateDownTransformer());
        new MyThread().start();
         }
         class MyThread extends Thread{
        //该线程用来持续不断地发送更新UI的信息
        @Override
             public void  run(){
           while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
               Message message=handler.obtainMessage();
            message.what=Update;
            handler.sendMessage(message);
           }

        }
         }


    }
