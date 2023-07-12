package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
public class TriangularPagerIndicator extends View implements IPagerIndicator {
    private float mAnchorX;
    private int mLineColor;
    private int mLineHeight;
    private Paint mPaint;
    private Path mPath;
    private List<st1> mPositionDataList;
    private boolean mReverse;
    private Interpolator mStartInterpolator;
    private int mTriangleHeight;
    private int mTriangleWidth;
    private float mYOffset;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.mPath = new Path();
        this.mStartInterpolator = new LinearInterpolator();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = wr2.a(context, 3.0d);
        this.mTriangleWidth = wr2.a(context, 14.0d);
        this.mTriangleHeight = wr2.a(context, 8.0d);
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public int getLineHeight() {
        return this.mLineHeight;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public int getTriangleHeight() {
        return this.mTriangleHeight;
    }

    public int getTriangleWidth() {
        return this.mTriangleWidth;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public boolean isReverse() {
        return this.mReverse;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mLineColor);
        if (this.mReverse) {
            canvas.drawRect(0.0f, (getHeight() - this.mYOffset) - this.mTriangleHeight, getWidth(), ((getHeight() - this.mYOffset) - this.mTriangleHeight) + this.mLineHeight, this.mPaint);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.mLineHeight) - this.mYOffset, getWidth(), getHeight() - this.mYOffset, this.mPaint);
        }
        this.mPath.reset();
        if (this.mReverse) {
            this.mPath.moveTo(this.mAnchorX - (this.mTriangleWidth / 2), (getHeight() - this.mYOffset) - this.mTriangleHeight);
            this.mPath.lineTo(this.mAnchorX, getHeight() - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX + (this.mTriangleWidth / 2), (getHeight() - this.mYOffset) - this.mTriangleHeight);
        } else {
            this.mPath.moveTo(this.mAnchorX - (this.mTriangleWidth / 2), getHeight() - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX, (getHeight() - this.mTriangleHeight) - this.mYOffset);
            this.mPath.lineTo(this.mAnchorX + (this.mTriangleWidth / 2), getHeight() - this.mYOffset);
        }
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
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
        int i3 = a.a;
        float f2 = i3 + ((a.c - i3) / 2);
        int i4 = a2.a;
        this.mAnchorX = f2 + (((i4 + ((a2.c - i4) / 2)) - f2) * this.mStartInterpolator.getInterpolation(f));
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<st1> list) {
        this.mPositionDataList = list;
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
    }

    public void setLineHeight(int i) {
        this.mLineHeight = i;
    }

    public void setReverse(boolean z) {
        this.mReverse = z;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i) {
        this.mTriangleHeight = i;
    }

    public void setTriangleWidth(int i) {
        this.mTriangleWidth = i;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
