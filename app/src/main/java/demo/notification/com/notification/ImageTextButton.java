package demo.notification.com.notification;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class ImageTextButton extends android.support.v7.widget.AppCompatTextView {
    private Drawable drawableLeft;
    private int scaleWidth; //dp值
    private int scaleHeight;
    public ImageTextButton(Context context) { super(context); }

    public ImageTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }
    public ImageTextButton(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); init(context, attrs); }


    public void init(Context context, AttributeSet attrs) { TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ImageTextButton); drawableLeft = typedArray.getDrawable(R.styleable.ImageTextButton_leftDrawable); scaleWidth = typedArray.getDimensionPixelOffset(R.styleable .ImageTextButton_drawableWidth, UIUtils.dip2Px(20)); scaleHeight = typedArray.getDimensionPixelOffset(R.styleable .ImageTextButton_drawableHeight, UIUtils.dip2Px(20)); }
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { super.onMeasure(widthMeasureSpec, heightMeasureSpec); if (drawableLeft != null) { drawableLeft.setBounds(0, 0, UIUtils.dip2Px(scaleWidth), UIUtils.dip2Px(scaleHeight)); } }
    @Override protected void onDraw(Canvas canvas) { super.onDraw(canvas); this.setCompoundDrawables(drawableLeft, null, null, null); }


    /**
     * 设置左侧图片并重绘
     * @param drawableLeft
     */ public void setDrawableLeft(Drawable drawableLeft) { this.drawableLeft = drawableLeft; invalidate(); }
    /**
     * 设置左侧图片并重绘
     * @param drawableLeftRes
     */ public void setDrawableLeft(int drawableLeftRes) { this.drawableLeft = UIUtils.getContext().getResources().getDrawable(drawableLeftRes); invalidate(); }

}
