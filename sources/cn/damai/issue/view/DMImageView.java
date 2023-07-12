package cn.damai.issue.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import cn.damai.comment.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private int mCornerRadius;
    private int mDefaultImageId;
    private Delegate mDelegate;
    private boolean mIsCircle;
    private boolean mIsSquare;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface Delegate {
        void onDrawableChanged(Drawable drawable);
    }

    public DMImageView(Context context) {
        this(context, null);
    }

    public static RoundedBitmapDrawable getCircleDrawable(Context context, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864066689")) {
            return (RoundedBitmapDrawable) ipChange.ipc$dispatch("-1864066689", new Object[]{context, bitmap});
        }
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        create.setAntiAlias(true);
        create.setCircular(true);
        return create;
    }

    public static RoundedBitmapDrawable getRoundedDrawable(Context context, Bitmap bitmap, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1337058594")) {
            return (RoundedBitmapDrawable) ipChange.ipc$dispatch("1337058594", new Object[]{context, bitmap, Float.valueOf(f)});
        }
        RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        create.setAntiAlias(true);
        create.setCornerRadius(f);
        return create;
    }

    private void initBorderPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227419533")) {
            ipChange.ipc$dispatch("1227419533", new Object[]{this});
            return;
        }
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
    }

    private void initCustomAttr(int i, TypedArray typedArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618405461")) {
            ipChange.ipc$dispatch("1618405461", new Object[]{this, Integer.valueOf(i), typedArray});
        } else if (i == R$styleable.DMImageView_android_src) {
            this.mDefaultImageId = typedArray.getResourceId(i, 0);
        } else if (i == R$styleable.DMImageView_dm_iv_isCircle) {
            this.mIsCircle = typedArray.getBoolean(i, this.mIsCircle);
        } else if (i == R$styleable.DMImageView_dm_iv_cornerRadius) {
            this.mCornerRadius = typedArray.getDimensionPixelSize(i, this.mCornerRadius);
        } else if (i == R$styleable.DMImageView_dm_iv_isSquare) {
            this.mIsSquare = typedArray.getBoolean(i, this.mIsSquare);
        } else if (i == R$styleable.DMImageView_dm_iv_borderWidth) {
            this.mBorderWidth = typedArray.getDimensionPixelSize(i, this.mBorderWidth);
        } else if (i == R$styleable.DMImageView_dm_iv_borderColor) {
            this.mBorderColor = typedArray.getColor(i, this.mBorderColor);
        }
    }

    private void initCustomAttrs(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165628756")) {
            ipChange.ipc$dispatch("165628756", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DMImageView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            initCustomAttr(obtainStyledAttributes.getIndex(i), obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
    }

    private void notifyDrawableChanged(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156574982")) {
            ipChange.ipc$dispatch("156574982", new Object[]{this, drawable});
            return;
        }
        Delegate delegate = this.mDelegate;
        if (delegate != null) {
            delegate.onDrawableChanged(drawable);
        }
    }

    private void setDefaultImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144788115")) {
            ipChange.ipc$dispatch("1144788115", new Object[]{this});
            return;
        }
        int i = this.mDefaultImageId;
        if (i != 0) {
            setImageResource(i);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086026611")) {
            ipChange.ipc$dispatch("-1086026611", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!this.mIsCircle || this.mBorderWidth <= 0) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - ((this.mBorderWidth * 1.0f) / 2.0f), this.mBorderPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1881472976")) {
            ipChange.ipc$dispatch("-1881472976", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mIsCircle || this.mIsSquare) {
            setMeasuredDimension(ImageView.getDefaultSize(0, i), ImageView.getDefaultSize(0, i2));
            i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
            i2 = i;
        }
        super.onMeasure(i, i2);
    }

    public void setDelegate(Delegate delegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712883916")) {
            ipChange.ipc$dispatch("1712883916", new Object[]{this, delegate});
        } else {
            this.mDelegate = delegate;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1080030488")) {
            ipChange.ipc$dispatch("-1080030488", new Object[]{this, drawable});
            return;
        }
        boolean z = drawable instanceof BitmapDrawable;
        if (z && this.mCornerRadius > 0) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                super.setImageDrawable(getRoundedDrawable(getContext(), bitmap, this.mCornerRadius));
            } else {
                super.setImageDrawable(drawable);
            }
        } else if (z && this.mIsCircle) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap2 != null) {
                super.setImageDrawable(getCircleDrawable(getContext(), bitmap2));
            } else {
                super.setImageDrawable(drawable);
            }
        } else {
            super.setImageDrawable(drawable);
        }
        notifyDrawableChanged(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051785425")) {
            ipChange.ipc$dispatch("-2051785425", new Object[]{this, Integer.valueOf(i)});
        } else {
            setImageDrawable(getResources().getDrawable(i));
        }
    }

    public DMImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCornerRadius = 0;
        this.mIsCircle = false;
        this.mIsSquare = false;
        this.mBorderWidth = 0;
        this.mBorderColor = -1;
        initCustomAttrs(context, attributeSet);
        initBorderPaint();
        setDefaultImage();
    }
}
