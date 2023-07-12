package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.g7;
import tb.jp0;
import tb.st1;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LinePagerIndicator extends View implements IPagerIndicator {
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

    public LinePagerIndicator(Context context) {
        super(context);
        this.mStartInterpolator = new LinearInterpolator();
        this.mEndInterpolator = new LinearInterpolator();
        this.mLineRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = wr2.a(context, 3.0d);
        this.mLineWidth = wr2.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getMode() {
        return this.mMode;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public float getRoundRadius() {
        return this.mRoundRadius;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float b;
        float b2;
        float b3;
        float f2;
        float f3;
        int i3;
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
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<st1> list) {
        this.mPositionDataList = list;
    }

    public void setColors(Integer... numArr) {
        this.mColors = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public void setMode(int i) {
        if (i != 2 && i != 0 && i != 1) {
            throw new IllegalArgumentException("mode " + i + " not supported.");
        }
        this.mMode = i;
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.mXOffset = f;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
