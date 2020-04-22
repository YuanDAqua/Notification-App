package demo.notification.com.notification;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.library.bubbleview.BubbleTextView;
import com.lin.poweradapter.AdapterDelegate;
import com.lin.poweradapter.PowerViewHolder;

import java.util.List;

import butterknife.BindView;


/**
 *
 * Created by lin18 on 2017/8/23.
 */

public abstract class AbsOrderDelegate extends AdapterDelegate<Order, PowerViewHolder> {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @CallSuper
    @Override
    protected void onBindViewHolder(@NonNull Order item, int position, @NonNull PowerViewHolder holder, @NonNull List<Object> payloads) {
        final Context context = holder.itemView.getContext();
        final AbsChildViewHolder vh = (AbsChildViewHolder) holder;
        final int color = ContextCompat.getColor(context, item.isHead ? R.color.colorAccent : android.R.color.darker_gray);
        vh.time.setTextColor(color);
        vh.time.setText(item.time);
        vh.title.setText(item.title);
        vh.subtitle.setText(item.subTitle);
        int visibility = vh.subtitle.getVisibility();
        if(visibility==View.VISIBLE){
            Drawable drawable = ContextCompat.getDrawable(context,item.icon);
            //vh.subtitle.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);
            ((ImageTextButton)vh.subtitle).setDrawableLeft(drawable);
        }

    }

    static class AbsChildViewHolder extends BaseViewHolder {

        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.subtitle)
        TextView subtitle;
        @BindView(R.id.btnDelete)
        Button btnDelete;
        AbsChildViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutResId) {
            super(parent, layoutResId);
        }
    }

}
