package demo.notification.com.notification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("date", Context.MODE_PRIVATE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layoyt_1 = findViewById(R.id.layoyt_1);
        LinearLayout layoyt_2 = findViewById(R.id.layoyt_2);
        LinearLayout layoyt_3 = findViewById(R.id.layoyt_3);
        LinearLayout layoyt_5 = findViewById(R.id.layoyt_5);
        LinearLayout layoyt_4 = findViewById(R.id.layoyt_4);
        LinearLayout layoyt_6 = findViewById(R.id.layoyt_6);

        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("chat",false);
        edit.putBoolean("email",false);
        edit.putBoolean("Music",false);
        edit.putBoolean("game",false);
        edit.putBoolean("SocialMedia",false);
        edit.putBoolean("Others",false);
        edit.commit();

        new QBadgeView(this).bindTarget(layoyt_1).setBadgeNumber(15).setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("email",true);
                edit.commit();
            }
        });
        new QBadgeView(this).bindTarget(layoyt_2).setBadgeText("new").setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("chat",true);
                edit.commit();
            }
        });
        new QBadgeView(this).bindTarget(layoyt_3).setBadgeText("10+").setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("game",true);
                edit.commit();
            }
        });
        new QBadgeView(this).bindTarget(layoyt_4).setBadgeNumber(5).setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("Music",true);
                edit.commit();
            }
        });
        new QBadgeView(this).bindTarget(layoyt_5).setBadgeNumber(25).setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("Others",true);
                edit.commit();
            }
        });
        new QBadgeView(this).bindTarget(layoyt_6).setBadgeNumber(16).setGravityOffset(10,0,true)
                .setBadgeGravity(Gravity.END | Gravity.TOP).setShowShadow(true).setBadgeTextSize(15.0f,true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                edit.putBoolean("SocialMedia",true);
                edit.commit();
            }
        });

        layoyt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","email");
                startActivity(intent);
            }
        });
        layoyt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","chat");
                startActivity(intent);
            }
        });
        layoyt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","game");
                startActivity(intent);
            }
        });
        layoyt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","Music");
                startActivity(intent);
            }
        });
        layoyt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","Others");
                startActivity(intent);
            }
        });
        layoyt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AppsActivity.class);
                intent.putExtra("TYPE","SocialMedia");
                startActivity(intent);
            }
        });
    }


}
