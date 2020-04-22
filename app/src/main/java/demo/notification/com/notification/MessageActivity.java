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

public class MessageActivity extends AppCompatActivity implements OrderAdapter.OnOrderClickListener {
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



        final TimeLineDecoration decoration = new TimeLineDecoration(this)
                .setLineColor(android.R.color.black)
                .setLineWidth(1)
                .setLeftDistance(73)
                .setTopDistance(10)
                .setBeginMarker(map.get(name))
                .setEndMarker(map.get(name))
                .setCustomMarker(map.get(name))
                .setMarkerRadius(4)
                .setMarkerColor(R.color.white)
                .setCallback(new TimeLineDecoration.TimeLineAdapter() {

                    @Override
                    public int getTimeLineType(int position) {
                        if (position == 0) return BEGIN;
                        else if (position == adapter.getItemCount() - 1) return END;
                        else if (adapter.getItem(position).isCustom) return CUSTOM;
                        else return NORMAL;
                    }
                });
        recyclerView.addItemDecoration(decoration);

        adapter = new OrderAdapter(this, this);
        recyclerView.setAdapter(adapter);
        if(!aBoolean){
            initData(appname);
        }

    }


    private void initData(String appname) {
        analogs = new ArrayList<>();

        int icon = getIntent().getIntExtra("icon", 0);
        String type = getIntent().getStringExtra("type");
        if ("1".equals(type)) {
            TextOrder textOrder0 = new TextOrder();
            textOrder0.isCustom = true;
            textOrder0.title = "How are you?";
            textOrder0.time = "08:10";
            analogs.add(textOrder0);
            TextOrder textOrder1 = new TextOrder();
            textOrder1.isCustom = true;
            textOrder1.title = "How have you been?";
            textOrder1.time = "08:20";
            analogs.add(textOrder1);
            TextOrder textOrder2 = new TextOrder();
            textOrder2.isCustom = true;
            textOrder2.title = "Greetings with People Met Often";
            textOrder2.time = "13:32";
            analogs.add(textOrder2);
            TextOrder textOrder3 = new TextOrder();
            textOrder3.isCustom = true;
            textOrder3.title = "How are you doing? I can’t complain too much";
            textOrder3.time = "13:56";
            analogs.add(textOrder3);
            TextOrder textOrder4 = new TextOrder();
            textOrder4.isCustom = true;
            textOrder4.isCustom = true;
            textOrder4.title = "Don’t regret anything that ever made you smile";
            textOrder4.subTitle = "【";
            textOrder4.time = "15:34";
            analogs.add(textOrder4);
            TextOrder textOrder5 = new TextOrder();
            textOrder5.isCustom = true;
            textOrder5.isCustom = true;
            textOrder5.title = "Happiness is a way station between too much and too little";
            textOrder5.subTitle = "";
            textOrder5.time = "20:36";
            analogs.add(textOrder5);
        } else {
            InfoOrder textOrder0 = new InfoOrder();
            textOrder0.icon=icon;
            textOrder0.subTitle = appname;
            textOrder0.isCustom = true;
            textOrder0.title = "How are you?";
            textOrder0.time = "15:10";
            analogs.add(textOrder0);
            InfoOrder textOrder1 = new InfoOrder();
            textOrder1.icon=icon;
            textOrder1.subTitle = appname;
            textOrder1.isCustom = true;
            textOrder1.title = "How have you been?";
            textOrder1.time = "07:20";
            analogs.add(textOrder1);
            InfoOrder textOrder2 = new InfoOrder();
            textOrder2.icon=icon;
            textOrder2.subTitle = appname;
            textOrder2.isCustom = true;
            textOrder2.title = "Greetings with People Met Often";
            textOrder2.time = "16:32";
            analogs.add(textOrder2);
            InfoOrder textOrder3 = new InfoOrder();
            textOrder3.icon=icon;
            textOrder3.subTitle = appname;
            textOrder3.isCustom = true;
            textOrder3.title = "How are you doing? I can’t complain too much";
            textOrder3.time = "13:56";
            analogs.add(textOrder3);
            InfoOrder textOrder4 = new InfoOrder();
            textOrder4.icon=icon;
            textOrder4.subTitle = appname;
            textOrder4.isCustom = true;
            textOrder4.isCustom = true;
            textOrder4.title = "Don’t regret anything that ever made you smile";

            textOrder4.time = "23:34";
            analogs.add(textOrder4);
            InfoOrder textOrder5 = new InfoOrder();
            textOrder5.icon=icon;
            textOrder5.subTitle = appname;
            textOrder5.isCustom = true;
            textOrder5.isCustom = true;
            textOrder5.title = "The hard part isn’t making the decision. It’s living with it";

            textOrder5.time = "20:36";
            analogs.add(textOrder5);
        }


        adapter.setItems(analogs);
    }

    @Override
    public void onLookClick(int position) {
        Toast.makeText(this, "查看订单", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCallClick(int position) {
        Toast.makeText(this, "联系卖家", Toast.LENGTH_SHORT).show();
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
