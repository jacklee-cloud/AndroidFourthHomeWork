package com.example.fourthhomework;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    public MyViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.fragmentList = list;
    }
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }
     @Override
    public Fragment getItem(int position) {
         return fragmentList.get(position);
    }
    @Override
    public int getCount(){
        //返回一个最大值，从而实现“无限循环”
        return Integer.MAX_VALUE;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position=position%fragmentList.size();
      return super.instantiateItem(container,position);

    }
    @Override
    public int getItemPosition(Object o){
        return super.getItemPosition(o);
    }


}
    /*private List<View> myViews;
    private View view;

    public MyViewPagerAdapter(List<View> myViews){
        this.myViews=myViews;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //由于已经在instantiateItem(@NonNull ViewGroup container, int position)方法中移除了视图，所以这里可以不写
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //在添加视图之前先判断视图是否已经有了父布局，如果有，则先移除再添加，否则会报错
        view=myViews.get(position%myViews.size());
        if (view.getParent()!=null){
            container.removeView(view);
        }
        container.addView(view);
        return view;
       *//* container.addView(myViews.get(position));
        return myViews.get(position%myViews.size());*//*
    }
    @Override
    public int getCount(){
        //返回一个最大值，从而实现“无限循环”
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View arg0,Object arg1){
        return arg0==arg1;
    }*/
/* @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);//显示第几个页面
    }
    @Override
    public int getCount(){
        //返回一个最大值，从而实现“无限循环”
        return Integer.MAX_VALUE;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //在添加视图之前先判断视图是否已经有了父布局，如果有，则先移除再添加，否则会报错
      position=position%fragmentList.size();
      return super.instantiateItem(container,position);

    }
*/


   /* @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //由于已经在instantiateItem(@NonNull ViewGroup container, int position)方法中移除了视图，所以这里可以不写
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //在添加视图之前先判断视图是否已经有了父布局，如果有，则先移除再添加，否则会报错
        view=myViews.get(position%myViews.size());
        if (view.getParent()!=null){
            container.removeView(view);
        }
        container.addView(view);
        return view;
       container.addView(myViews.get(position));
        return myViews.get(position%myViews.size());
    }
    @Override
    public int getCount(){
        //返回一个最大值，从而实现“无限循环”
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View arg0,Object arg1){
        return arg0==arg1;
    }*/