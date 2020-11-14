package com.example.fourthhomework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
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

public class ThirdFragment extends Fragment {
    private ImageView thirdImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceSate){
        View view=inflater.inflate(R.layout.third_picture,container,false);
         thirdImage= (ImageView)view.findViewById(R.id.t_picture);
       sendUrlRequest("https://p.pstatp.com/origin/1382400000b859e1c2339");
        return view;
    }
    public void setThirdImage(Bitmap bitmap){
        thirdImage.setImageBitmap(bitmap);
    }
   private void sendUrlRequest(String url){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                    /*byte[] picture = (byte[]) msg.obj;
                    Bitmap bitmap = BitmapFactory.decodeByteArray(picture, 0, picture.length);*/
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] picture_bytes=response.body().bytes();
                final Bitmap bitmap= BitmapFactory.decodeByteArray(picture_bytes,0,picture_bytes.length);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setThirdImage(bitmap);
                    }
                });

            }

        });

    }
}
