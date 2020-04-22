package demo.notification.com.notification;

import android.app.Application;
import android.content.Context;
import android.os.Handler;



/**
 * Created by lv on 2019/3/12 for stores
 */
public class MyApplication extends Application {
    private static Context context;
    private static Handler mHandler;//主线程Handler
    private static long mMainThreadId;//主线程id
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();

    }



    public static Context getContext() {
        return context;
    }

    public static Handler getMainHandler() {
        return mHandler;
    }
    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static void setMainThreadId(long mMainThreadId) {
        MyApplication.mMainThreadId = mMainThreadId;
    }
}
