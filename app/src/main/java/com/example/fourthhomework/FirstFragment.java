package com.example.fourthhomework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FirstFragment extends Fragment {
    private ImageView firstImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceSate){
        View view1=inflater.inflate(R.layout.first_picture,container,false);
        firstImage=(ImageView)view1.findViewById(R.id.f_picture);
       //每一个fragment中都有一个sendUrlRequest方法
        /*
        * 为什么不进行再次封装？
        *   因为我想在申请到网络图片后直接调用每个fragment各自的set方法对View进行初始化
        *   如果进行再次封装的话还没想好该怎么获得每个Fragment的实例
        *
        *
        *
        * */
       sendUrlRequest("https://ae01.alicdn.com/kf/Uf8cd7a9ee0054a1c85f95633ccb722fc3.jpg");
        return view1;
    }
    public void setFirstImage(Bitmap bitmap){
        firstImage.setImageBitmap(bitmap);
    }
    private void sendUrlRequest(String url){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] picture_bytes=response.body().bytes();
                final Bitmap bitmap= BitmapFactory.decodeByteArray(picture_bytes,0,picture_bytes.length);
                  getActivity().runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          setFirstImage(bitmap);
                      }
                  });

            }

        });

    }
}
