package cn.damai.homepage.splash;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.homepage.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class SplashRoundProgressBar extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FILL = 1;
    public static final int STROKE = 0;
    private int max;
    private Paint paint;
    private int progress;
    private int roundColor;
    private int roundProgressColor;
    private float roundWidth;
    private int style;
    private int textColor;
    private boolean textIsDisplayable;
    private float textSize;

    public SplashRoundProgressBar(Context context) {
        this(context, null);
    }

    public int getCricleColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1089572294") ? ((Integer) ipChange.ipc$dispatch("1089572294", new Object[]{this})).intValue() : this.roundColor;
    }

    public int getCricleProgressColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "449840659") ? ((Integer) ipChange.ipc$dispatch("449840659", new Object[]{this})).intValue() : this.roundProgressColor;
    }

    public synchronized int getMax() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2001010685")) {
            return ((Integer) ipChange.ipc$dispatch("-2001010685", new Object[]{this})).intValue();
        }
        return this.max;
    }

    public synchronized int getProgress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456230652")) {
            return ((Integer) ipChange.ipc$dispatch("1456230652", new Object[]{this})).intValue();
        }
        return this.progress;
    }

    public float getRoundWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-705624530") ? ((Float) ipChange.ipc$dispatch("-705624530", new Object[]{this})).floatValue() : this.roundWidth;
    }

    public int getTextColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "580145841") ? ((Integer) ipChange.ipc$dispatch("580145841", new Object[]{this})).intValue() : this.textColor;
    }

    public float getTextSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1590298808") ? ((Float) ipChange.ipc$dispatch("1590298808", new Object[]{this})).floatValue() : this.textSize;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365525654")) {
            ipChange.ipc$dispatch("-1365525654", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i2 = (int) (f - (this.roundWidth / 2.0f));
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setAntiAlias(true);
        this.paint.setColor(Color.parseColor("#8A000000"));
        canvas.drawCircle(f, f, i2, this.paint);
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        float measureText = this.paint.measureText("跳过");
        if (this.textIsDisplayable && this.style == 0) {
            canvas.drawText("跳过", f - (measureText / 2.0f), f + (this.textSize / 2.0f), this.paint);
        }
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundProgressColor);
        float f2 = width - i2;
        float f3 = width + i2;
        RectF rectF = new RectF(f2, f2, f3, f3);
        int i3 = this.style;
        if (i3 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, -90.0f, (this.progress * 360) / this.max, false, this.paint);
        } else if (i3 != 1) {
        } else {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.progress != 0) {
                canvas.drawArc(rectF, -90.0f, (i * 360) / this.max, true, this.paint);
            }
        }
    }

    public void setCricleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "337066244")) {
            ipChange.ipc$dispatch("337066244", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.roundColor = i;
        }
    }

    public void setCricleProgressColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432426071")) {
            ipChange.ipc$dispatch("1432426071", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.roundProgressColor = i;
        }
    }

    public synchronized void setMax(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "35045991")) {
            ipChange.ipc$dispatch("35045991", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 0) {
            this.max = i;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public synchronized void setProgress(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190707674")) {
            ipChange.ipc$dispatch("-1190707674", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.progress = i;
            postInvalidate();
        }
    }

    public void setRoundWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1339649714")) {
            ipChange.ipc$dispatch("-1339649714", new Object[]{this, Float.valueOf(f)});
        } else {
            this.roundWidth = f;
        }
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026761095")) {
            ipChange.ipc$dispatch("-1026761095", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.textColor = i;
        }
    }

    public void setTextSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329564924")) {
            ipChange.ipc$dispatch("-1329564924", new Object[]{this, Float.valueOf(f)});
        } else {
            this.textSize = f;
        }
    }

    public SplashRoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplashRoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SplashRoundProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_roundColor, 0);
        this.roundProgressColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_roundProgressColor, 0);
        this.textColor = obtainStyledAttributes.getColor(R$styleable.SplashRoundProgressBar_textColor, 0);
        this.textSize = obtainStyledAttributes.getDimension(R$styleable.SplashRoundProgressBar_textSize, 15.0f);
        this.roundWidth = obtainStyledAttributes.getDimension(R$styleable.SplashRoundProgressBar_roundWidthProgressBar, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R$styleable.SplashRoundProgressBar_max, 100);
        this.textIsDisplayable = obtainStyledAttributes.getBoolean(R$styleable.SplashRoundProgressBar_textIsDisplayable, true);
        this.style = obtainStyledAttributes.getInt(R$styleable.SplashRoundProgressBar_style, 0);
        obtainStyledAttributes.recycle();
    }
}
