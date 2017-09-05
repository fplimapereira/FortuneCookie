package com.pereira.felipe.fortunecookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cunoraz.gifview.library.GifView;

public class MessageActivity extends AppCompatActivity {

    GifView gif;
    Button acao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        HandleAppCrash.deploy(this, MessageActivity.class);
        gif = (GifView) findViewById(R.id.gif);
        gif.setGifResource(R.mipmap.giphy);
        gif.pause();
        acao = (Button) findViewById(R.id.acao);
        acao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gif.isPaused()){
                    gif.play();
                }else{
                    gif.pause();
                }
            }
        });

        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gif.isPaused()){
                    gif.play();
                }else{
                    gif.pause();
                }
            }
        });
    }
}
