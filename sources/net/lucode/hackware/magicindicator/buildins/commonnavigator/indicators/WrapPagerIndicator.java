package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import tb.jp0;
import tb.st1;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WrapPagerIndicator extends View implements IPagerIndicator {
    private Interpolator mEndInterpolator;
    private int mFillColor;
    private int mHorizontalPadding;
    private Paint mPaint;
    private List<st1> mPositionDataList;
    private RectF mRect;
    private float mRoundRadius;
    private boolean mRoundRadiusSet;
    private Interpolator mStartInterpolator;
    private int mVerticalPadding;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.mStartInterpolator = new LinearInterpolator();
        this.mEndInterpolator = new LinearInterpolator();
        this.mRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mVerticalPadding = wr2.a(context, 6.0d);
        this.mHorizontalPadding = wr2.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public int getHorizontalPadding() {
        return this.mHorizontalPadding;
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

    public int getVerticalPadding() {
        return this.mVerticalPadding;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mFillColor);
        RectF rectF = this.mRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        List<st1> list = this.mPositionDataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        st1 a = jp0.a(this.mPositionDataList, i);
        st1 a2 = jp0.a(this.mPositionDataList, i + 1);
        RectF rectF = this.mRect;
        int i3 = a.e;
        rectF.left = (i3 - this.mHorizontalPadding) + ((a2.e - i3) * this.mEndInterpolator.getInterpolation(f));
        RectF rectF2 = this.mRect;
        rectF2.top = a.f - this.mVerticalPadding;
        int i4 = a.g;
        rectF2.right = this.mHorizontalPadding + i4 + ((a2.g - i4) * this.mStartInterpolator.getInterpolation(f));
        RectF rectF3 = this.mRect;
        rectF3.bottom = a.h + this.mVerticalPadding;
        if (!this.mRoundRadiusSet) {
            this.mRoundRadius = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<st1> list) {
        this.mPositionDataList = list;
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
    }

    public void setHorizontalPadding(int i) {
        this.mHorizontalPadding = i;
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
        this.mRoundRadiusSet = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i) {
        this.mVerticalPadding = i;
    }
}
