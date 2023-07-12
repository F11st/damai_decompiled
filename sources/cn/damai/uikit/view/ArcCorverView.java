package cn.damai.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ArcCorverView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int GRAVITY_LEFT_BOTTOM = 3;
    private static final int GRAVITY_LEFT_TOP = 0;
    private static final int GRAVITY_RIGHT_BOTTOM = 2;
    private static final int GRAVITY_RIGHT_TOP = 1;
    private int coverColor;
    private int gravity;

    public ArcCorverView(Context context) {
        this(context, null);
    }

    private Bitmap drawRect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431575621")) {
            return (Bitmap) ipChange.ipc$dispatch("1431575621", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(this.coverColor);
        int i3 = this.gravity;
        if (i3 == 0) {
            canvas.drawRect(new RectF(0.0f, 0.0f, getWidth(), getWidth()), paint);
        } else if (i3 == 1) {
            canvas.drawRect(new RectF(getWidth() - getWidth(), 0.0f, getWidth(), getWidth()), paint);
        } else if (i3 == 2) {
            canvas.drawRect(new RectF(getWidth() - getWidth(), getHeight() - getWidth(), getWidth(), getHeight()), paint);
        } else if (i3 == 3) {
            canvas.drawRect(new RectF(0.0f, getHeight() - getWidth(), getWidth(), getHeight()), paint);
        }
        return createBitmap;
    }

    private Bitmap drawSector(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996470915")) {
            return (Bitmap) ipChange.ipc$dispatch("996470915", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-13244);
        int i3 = this.gravity;
        if (i3 == 0) {
            canvas.drawArc(new RectF(0.0f, 0.0f, getWidth() * 2, getWidth() * 2), 180.0f, 90.0f, true, paint);
        } else if (i3 == 1) {
            canvas.drawArc(new RectF(getWidth() - (getWidth() * 2), 0.0f, getWidth(), getWidth() * 2), 270.0f, 90.0f, true, paint);
        } else if (i3 == 2) {
            canvas.drawArc(new RectF(getWidth() - (getWidth() * 2), getHeight() - (getWidth() * 2), getWidth(), getHeight()), 0.0f, 90.0f, true, paint);
        } else if (i3 == 3) {
            canvas.drawArc(new RectF(0.0f, getWidth() - (getWidth() * 2), getWidth() * 2, getWidth()), 90.0f, 90.0f, true, paint);
        }
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "471668985")) {
            ipChange.ipc$dispatch("471668985", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        paint.setStyle(Paint.Style.FILL);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(drawSector(getWidth(), getHeight()), 0.0f, 0.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(drawRect(getWidth(), getHeight()), 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861024412")) {
            ipChange.ipc$dispatch("1861024412", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() > getMeasuredHeight() ? getMeasuredHeight() : getMeasuredWidth(), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public void setCoverColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "59947574")) {
            ipChange.ipc$dispatch("59947574", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.coverColor = i;
        }
    }

    public void setRadiansGravity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153255878")) {
            ipChange.ipc$dispatch("1153255878", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.gravity = i;
        }
    }

    public ArcCorverView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcCorverView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ArcCorverView);
        this.gravity = obtainStyledAttributes.getInt(R$styleable.ArcCorverView_arcGravity, 0);
        this.coverColor = obtainStyledAttributes.getColor(R$styleable.ArcCorverView_coverColor, -1);
    }
}
