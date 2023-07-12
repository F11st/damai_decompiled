package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;
import tb.wr2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ClipPagerTitleView extends View implements IMeasurablePagerTitleView {
    private int mClipColor;
    private float mClipPercent;
    private boolean mLeftToRight;
    private Paint mPaint;
    private String mText;
    private Rect mTextBounds;
    private int mTextColor;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.mTextBounds = new Rect();
        init(context);
    }

    private void init(Context context) {
        int a = wr2.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextSize(a);
        int a2 = wr2.a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mTextBounds) + getPaddingTop() + getPaddingBottom();
        }
        return Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.mTextBounds) + getPaddingTop() + getPaddingBottom(), size);
    }

    private void measureTextBounds() {
        Paint paint = this.mPaint;
        String str = this.mText;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.mTextBounds);
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds) + getPaddingLeft() + getPaddingRight();
        }
        return Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds) + getPaddingLeft() + getPaddingRight(), size);
    }

    public int getClipColor() {
        return this.mClipColor;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds) / 2);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds) / 2);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public float getTextSize() {
        return this.mPaint.getTextSize();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onDeselected(int i, int i2) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.mPaint.setColor(this.mTextColor);
        float width = (getWidth() - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.mTextBounds)) / 2;
        float f = height;
        canvas.drawText(this.mText, width, f, this.mPaint);
        canvas.save(2);
        if (this.mLeftToRight) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.mClipPercent, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.mClipPercent), 0.0f, getWidth(), getHeight());
        }
        this.mPaint.setColor(this.mClipColor);
        canvas.drawText(this.mText, width, f, this.mPaint);
        canvas.restore();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onEnter(int i, int i2, float f, boolean z) {
        this.mLeftToRight = z;
        this.mClipPercent = f;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onLeave(int i, int i2, float f, boolean z) {
        this.mLeftToRight = !z;
        this.mClipPercent = 1.0f - f;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        measureTextBounds();
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
    public void onSelected(int i, int i2) {
    }

    public void setClipColor(int i) {
        this.mClipColor = i;
        invalidate();
    }

    public void setText(String str) {
        this.mText = str;
        requestLayout();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.mPaint.setTextSize(f);
        requestLayout();
    }
}
