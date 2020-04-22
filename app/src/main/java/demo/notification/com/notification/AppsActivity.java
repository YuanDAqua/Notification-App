package demo.notification.com.notification;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

/**
 * Created by lv on 2019/3/15 for Notification
 */
public class AppsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        BoomMenuButton bmb = findViewById(R.id.bmb);
        String type = getIntent().getStringExtra("TYPE");
        int[] icone= {} ;
        String iconemail_name[]={};
        if(type.equals("chat")){
            icone  = new int[]{R.drawable.facebookmessenger, R.drawable.imessage, R.drawable.line, R.drawable.viber, R.drawable.whatsapp};
            iconemail_name  =new String[] {"facebook-messenger","Imessage","line","viber","whatsapp"};
        }else if(type.equals("email")){
            icone  = new int[]{R.drawable.gmail,R.drawable.yahoo,R.drawable.outlook,R.drawable.zoho,R.drawable.icloud};
            iconemail_name  =new String[] {"Gmail","Yahoo","Outlook","Zoho","iCloud"};
        }else if(type.equals("Music")){
            icone  = new int[]{R.drawable.applemusic,R.drawable.itunesstore,R.drawable.shazammusic,R.drawable.socialspotify,R.drawable.youtubemusic};
            iconemail_name  =new String[] {"Gmail","Yahoo","Outlook","Zoho","iCloud"};
        }else if(type.equals("game")){
            icone  = new int[]{R.drawable.pokemon,R.drawable.skipspider,R.drawable.skysurfing,R.drawable.tankparty,R.drawable.worldofwarcraft};
            iconemail_name  =new String[] {"Pokemon","Skip Spider","Sky Surfing","tankParty","World-of Warcraft"};
        }else if(type.equals("SocialMedia")){
            icone  = new int[]{R.drawable.facebook,R.drawable.instagram,R.drawable.slack,R.drawable.snapchat,R.drawable.wechat};
            iconemail_name  =new String[] {"Facebook","instagram","slack","snapchat","wechat"};
        }else if(type.equals("Others")){
            icone  = new int[]{R.drawable.bus,R.drawable.fitness,R.drawable.nba,R.drawable.others,R.drawable.skipdishes};
            iconemail_name  =new String[] {"bus","fitness","NBA","others","skipdishes"};
        }

        for (int i = 0; i < icone.length; i++) {
            int[] finalIcone = icone;
            int finalI = i;
            String[] finalIconemail_name = iconemail_name;
            int finalI1 = i;
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder().listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    Intent intent  = new Intent(AppsActivity.this,MessageActivity.class);
                    if(type.equals("chat")||type.equals("SocialMedia")){
                        intent.putExtra("type","1");
                        intent.putExtra("name", type);
                        intent.putExtra("appname", finalIconemail_name[finalI1]);
                        intent.putExtra("icon", finalIcone[finalI]);
                        startActivity(intent);
                    }else{
                        intent.putExtra("type","2");
                        intent.putExtra("name", type);
                        intent.putExtra("appname", finalIconemail_name[finalI1]);
                        intent.putExtra("icon", finalIcone[finalI]);
                        startActivity(intent);
                    }
                }
            })
                    .normalImageRes(icone[i])

                    .normalText(iconemail_name[i]);
            bmb.addBuilder(builder);
        }
        bmb.setAutoBoom(true);
    }
}
