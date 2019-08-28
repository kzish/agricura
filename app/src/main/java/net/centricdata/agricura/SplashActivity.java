package net.centricdata.agricura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView txt_anim;
    ImageView img_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt_anim=(TextView) findViewById(R.id.txt_anim);
        img_logo=(ImageView) findViewById(R.id.img_logo);

        Animation ani_fade_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        txt_anim.startAnimation(ani_fade_in);

        ani_fade_in.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
            }
            @Override
            public void onAnimationEnd(Animation arg0) {
                Intent main =  new Intent(SplashActivity.this,MainActivity.class);
                main.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                finish();
            }
        });





    }
}
