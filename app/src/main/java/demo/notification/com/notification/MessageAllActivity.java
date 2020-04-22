package demo.notification.com.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lin.timeline.TimeLineDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.lin.timeline.TimeLineDecoration.BEGIN;
import static com.lin.timeline.TimeLineDecoration.CUSTOM;
import static com.lin.timeline.TimeLineDecoration.END;
import static com.lin.timeline.TimeLineDecoration.NORMAL;

public class MessageAllActivity extends AppCompatActivity implements OrderAdapter.OnOrderClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private OrderAdapter adapter;
    @BindView(R.id.iv_order)
    ImageView iv_order;
    private List<Order> analogs;
    SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences("date", Context.MODE_PRIVATE);
    private boolean aBoolean;
    private String appname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        String name = getIntent().getStringExtra("name");
        appname = getIntent().getStringExtra("appname");
        aBoolean = sharedPreferences.getBoolean(name,false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        HashMap<String,Integer> map= new HashMap<String, Integer>();
        map.put("chat",R.drawable.myc);
        map.put("email",R.drawable.start);
        map.put("Music",R.drawable.yinyue);
        map.put("game",R.drawable.youxi);
        map.put("SocialMedia",R.drawable.smedia);
        map.put("Others",R.drawable.qita);




        adapter = new OrderAdapter(this, this);
        recyclerView.setAdapter(adapter);
        if(!aBoolean){
            initData(appname);
        }

    }


    private void initData(String appname) {
        analogs = new ArrayList<>();

        InfoOrder textOrder0 = new InfoOrder();
        textOrder0.icon=R.drawable.facebookmessenger;
        textOrder0.subTitle = appname;
        textOrder0.isCustom = true;
        textOrder0.title = "How are you?";
        textOrder0.time = "15:10";
        analogs.add(textOrder0);
        InfoOrder textOrder1 = new InfoOrder();
        textOrder1.icon=R.drawable.imessage;
        textOrder1.subTitle = appname;
        textOrder1.isCustom = true;
        textOrder1.title = "How have you been?";
        textOrder1.time = "07:20";
        analogs.add(textOrder1);
        InfoOrder textOrder2 = new InfoOrder();
        textOrder2.icon= R.drawable.line;
        textOrder2.subTitle = appname;
        textOrder2.isCustom = true;
        textOrder2.title = "Greetings with People Met Often";
        textOrder2.time = "16:32";
        analogs.add(textOrder2);
        InfoOrder textOrder3 = new InfoOrder();
        textOrder3.icon=R.drawable.viber;
        textOrder3.subTitle = appname;
        textOrder3.isCustom = true;
        textOrder3.title = "How are you doing? I can’t complain too much";
        textOrder3.time = "13:56";
        analogs.add(textOrder3);
        InfoOrder textOrder4 = new InfoOrder();
        textOrder4.icon=R.drawable.whatsapp;
        textOrder4.subTitle = appname;
        textOrder4.isCustom = true;
        textOrder4.isCustom = true;
        textOrder4.title = "Don’t regret anything that ever made you smile";

        textOrder4.time = "23:34";
        analogs.add(textOrder4);
        InfoOrder textOrder5 = new InfoOrder();
        textOrder5.icon=R.drawable.applemusic;
        textOrder5.subTitle = appname;
        textOrder5.isCustom = true;
        textOrder5.isCustom = true;
        textOrder5.title = "In love folly is always sweet.";
        textOrder5.time = "20:36";


        InfoOrder textOrder6 = new InfoOrder();
        textOrder6.icon=R.drawable.applemusic;
        textOrder6.subTitle = appname;
        textOrder6.isCustom = true;
        textOrder6.isCustom = true;
        textOrder6.title = "When the whole world is about to rain, let’s make it clear in our heart together";
        textOrder6.time = "20:36";
        analogs.add(textOrder6);
        InfoOrder textOrder7 = new InfoOrder();
        textOrder7.icon=R.drawable.itunesstore;
        textOrder7.subTitle = appname;
        textOrder7.isCustom = true;
        textOrder7.isCustom = true;
        textOrder7.title = "Life is a journey, not the destination, but the scenery along the should be and the mood at the view.";
        textOrder7.time = "21:36";
        analogs.add(textOrder7);
        InfoOrder textOrder8 = new InfoOrder();
        textOrder8.icon=R.drawable.shazammusic;
        textOrder8.subTitle = appname;
        textOrder8.isCustom = true;
        textOrder8.isCustom = true;
        textOrder8.title = "I lied when I said I didn’t like you. I lied when I said I didn’t care. I lie every time I try to tell myself I will never fall for you";
        textOrder8.time = "11:36";
        analogs.add(textOrder8);
        InfoOrder textOrder9 = new InfoOrder();
        textOrder9.icon=R.drawable.socialspotify;
        textOrder9.subTitle = appname;
        textOrder9.isCustom = true;
        textOrder9.isCustom = true;
        textOrder9.title = "Happiness is a way station between too much and too little";
        textOrder9.time = "23:36";
        analogs.add(textOrder9);

        InfoOrder textOrder10 = new InfoOrder();
        textOrder10.icon=R.drawable.youtubemusic;
        textOrder10.subTitle = appname;
        textOrder10.isCustom = true;
        textOrder10.isCustom = true;
        textOrder10.title = "One needs 3 things to be truly happy living in the world: some thing to do, some one to love, some thing to hope for";
        textOrder10.time = "10:36";
        analogs.add(textOrder10);



        adapter.setItems(analogs);
    }

    @Override
    public void onLookClick(int position) {

    }

    @Override
    public void onCallClick(int position) {

    }

    @Override
    public void onLocationClick(int position) {
        analogs.remove(position);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.iv_order)
    public void onClick(View view) {
        if(!aBoolean) {
            Collections.shuffle(analogs);
            adapter.notifyDataSetChanged();
        }

    }
}
