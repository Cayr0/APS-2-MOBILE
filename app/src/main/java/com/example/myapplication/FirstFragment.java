package com.example.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;

import jp.wasabeef.blurry.Blurry;

public class FirstFragment extends Fragment {
    ImageView imageView;
    View view2;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        view2 = inflater.inflate(R.layout.fragment_first, container, false);


        imageView = (ImageView) view2.findViewById(R.id.my_image_view);
       // myView = (View) view.findViewById(R.id.my_view);

        Glide.with(this).load("https://www.redentor.edu.br/img/core/logo.png").into(imageView);





        return view2;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Blurry.with(view.getContext()).capture(view).into(imageView);

                Blurry.with(view.getContext())
                        .radius(3)
                        .sampling(3)
                        .color(Color.argb(66, 25, 136, 140))
                        .async()
                       .animate(500)
                        .capture(view2)
                        .into(imageView);
            }
        });
    }
}