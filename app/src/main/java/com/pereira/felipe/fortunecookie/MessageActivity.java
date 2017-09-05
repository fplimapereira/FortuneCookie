package com.pereira.felipe.fortunecookie;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cunoraz.gifview.library.GifView;

public class MessageActivity extends AppCompatActivity {

    GifView gif;
    Button acao;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        HandleAppCrash.deploy(this, MessageActivity.class);
        gif = (GifView) findViewById(R.id.gif);
        gif.setGifResource(R.mipmap.giphy);
        gif.pause();
        mp = MediaPlayer.create(this, R.raw.crack);
        acao = (Button) findViewById(R.id.acao);
        acao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gif.isPaused()){
                    gif.play();
                    mp.start();
                }else{
                    gif.pause();
                }
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mp.release();
        mp=null;
    }
}
