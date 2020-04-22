package demo.notification.com.notification;

import android.support.annotation.Nullable;

import com.lin.poweradapter.DefaultAdapterDelegate;
import com.lin.poweradapter.MultiAdapter;
import com.lin.poweradapter.PowerViewHolder;

/**
 *
 * Created by lin18 on 2017/8/23.
 */

public class OrderAdapter extends MultiAdapter<Order, PowerViewHolder> {

    public OrderAdapter(@Nullable Object listener, @Nullable OnOrderClickListener clickListener) {
        super(listener);
        delegatesManager.addDelegate(new TextOrderDelegate(clickListener));
        delegatesManager.addDelegate(new InfoOrderDelegate(clickListener));
        delegatesManager.addDelegate(new LocationOrderDelegate(clickListener));
        delegatesManager.setFallbackDelegate(new DefaultAdapterDelegate<Order>());
    }

    public interface OnOrderClickListener {
        void onLookClick(int position);

        void onCallClick(int position);

        void onLocationClick(int position);
    }

}