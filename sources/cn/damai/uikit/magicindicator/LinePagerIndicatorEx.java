package cn.damai.uikit.magicindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.g7;
import tb.jp0;
import tb.st1;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LinePagerIndicatorEx extends View implements IPagerIndicator {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> mColors;
    private Interpolator mEndInterpolator;
    private float mLineHeight;
    private RectF mLineRect;
    private float mLineWidth;
    private int mMode;
    private Paint mPaint;
    private List<st1> mPositionDataList;
    private float mRoundRadius;
    private Interpolator mStartInterpolator;
    private float mXOffset;
    private float mYOffset;

    public LinePagerIndicatorEx(Context context) {
        super(context);
        this.mStartInterpolator = new LinearInterpolator();
        this.mEndInterpolator = new LinearInterpolator();
        this.mLineRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540517653")) {
            ipChange.ipc$dispatch("-1540517653", new Object[]{this, context});
            return;
        }
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = wr2.a(context, 3.0d);
        this.mLineWidth = wr2.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "137947696") ? (List) ipChange.ipc$dispatch("137947696", new Object[]{this}) : this.mColors;
    }

    public Interpolator getEndInterpolator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1364005994") ? (Interpolator) ipChange.ipc$dispatch("-1364005994", new Object[]{this}) : this.mEndInterpolator;
    }

    public float getLineHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-93132420") ? ((Float) ipChange.ipc$dispatch("-93132420", new Object[]{this})).floatValue() : this.mLineHeight;
    }

    public RectF getLineRect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1183488344") ? (RectF) ipChange.ipc$dispatch("1183488344", new Object[]{this}) : this.mLineRect;
    }

    public float getLineWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-645365887") ? ((Float) ipChange.ipc$dispatch("-645365887", new Object[]{this})).floatValue() : this.mLineWidth;
    }

    public int getMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-496661865") ? ((Integer) ipChange.ipc$dispatch("-496661865", new Object[]{this})).intValue() : this.mMode;
    }

    public Paint getPaint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "797351142") ? (Paint) ipChange.ipc$dispatch("797351142", new Object[]{this}) : this.mPaint;
    }

    public float getRoundRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2093875277") ? ((Float) ipChange.ipc$dispatch("-2093875277", new Object[]{this})).floatValue() : this.mRoundRadius;
    }

    public Interpolator getStartInterpolator() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1280306479") ? (Interpolator) ipChange.ipc$dispatch("1280306479", new Object[]{this}) : this.mStartInterpolator;
    }

    public float getXOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2061857944") ? ((Float) ipChange.ipc$dispatch("-2061857944", new Object[]{this})).floatValue() : this.mXOffset;
    }

    public float getYOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2036595847") ? ((Float) ipChange.ipc$dispatch("2036595847", new Object[]{this})).floatValue() : this.mYOffset;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350757563")) {
            ipChange.ipc$dispatch("1350757563", new Object[]{this, canvas});
            return;
        }
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1464294636")) {
            ipChange.ipc$dispatch("-1464294636", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float b;
        float b2;
        float b3;
        float f2;
        float f3;
        int i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572701107")) {
            ipChange.ipc$dispatch("1572701107", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        List<st1> list = this.mPositionDataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.mColors;
        if (list2 != null && list2.size() > 0) {
            this.mPaint.setColor(g7.a(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
        }
        st1 a = jp0.a(this.mPositionDataList, i);
        st1 a2 = jp0.a(this.mPositionDataList, i + 1);
        int i4 = this.mMode;
        if (i4 == 0) {
            f3 = this.mXOffset;
            b = a.a + f3;
            f2 = a2.a + f3;
            b2 = a.c - f3;
            i3 = a2.c;
        } else if (i4 == 1) {
            f3 = this.mXOffset;
            b = a.e + f3;
            f2 = a2.e + f3;
            b2 = a.g - f3;
            i3 = a2.g;
        } else {
            b = a.a + ((a.b() - this.mLineWidth) / 2.0f);
            float b4 = a2.a + ((a2.b() - this.mLineWidth) / 2.0f);
            b2 = ((a.b() + this.mLineWidth) / 2.0f) + a.a;
            b3 = ((a2.b() + this.mLineWidth) / 2.0f) + a2.a;
            f2 = b4;
            this.mLineRect.left = b + ((f2 - b) * this.mStartInterpolator.getInterpolation(f));
            this.mLineRect.right = b2 + ((b3 - b2) * this.mEndInterpolator.getInterpolation(f));
            this.mLineRect.top = (getHeight() - this.mLineHeight) - this.mYOffset;
            this.mLineRect.bottom = getHeight() - this.mYOffset;
            invalidate();
        }
        b3 = i3 - f3;
        this.mLineRect.left = b + ((f2 - b) * this.mStartInterpolator.getInterpolation(f));
        this.mLineRect.right = b2 + ((b3 - b2) * this.mEndInterpolator.getInterpolation(f));
        this.mLineRect.top = (getHeight() - this.mLineHeight) - this.mYOffset;
        this.mLineRect.bottom = getHeight() - this.mYOffset;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "425823071")) {
            ipChange.ipc$dispatch("425823071", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<st1> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-63763041")) {
            ipChange.ipc$dispatch("-63763041", new Object[]{this, list});
        } else {
            this.mPositionDataList = list;
        }
    }

    public void setColors(Integer... numArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-525051411")) {
            ipChange.ipc$dispatch("-525051411", new Object[]{this, numArr});
        } else {
            this.mColors = Arrays.asList(numArr);
        }
    }

    public void setEndInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342618312")) {
            ipChange.ipc$dispatch("-342618312", new Object[]{this, interpolator});
            return;
        }
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467736512")) {
            ipChange.ipc$dispatch("467736512", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mLineHeight = f;
        }
    }

    public void setLineWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362921789")) {
            ipChange.ipc$dispatch("-362921789", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mLineWidth = f;
        }
    }

    public void setMode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694801387")) {
            ipChange.ipc$dispatch("1694801387", new Object[]{this, Integer.valueOf(i)});
        } else if (i != 2 && i != 0 && i != 1) {
            throw new IllegalArgumentException("mode " + i + " not supported.");
        } else {
            this.mMode = i;
        }
    }

    public void setRoundRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434436561")) {
            ipChange.ipc$dispatch("434436561", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mRoundRadius = f;
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1364741185")) {
            ipChange.ipc$dispatch("-1364741185", new Object[]{this, interpolator});
            return;
        }
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1264795972")) {
            ipChange.ipc$dispatch("-1264795972", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mXOffset = f;
        }
    }

    public void setYOffset(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233219965")) {
            ipChange.ipc$dispatch("1233219965", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mYOffset = f;
        }
    }
}
