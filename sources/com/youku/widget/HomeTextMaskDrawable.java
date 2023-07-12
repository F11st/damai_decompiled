package com.youku.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class HomeTextMaskDrawable extends ShapeDrawable {
    private static final String TAG = "HomeTextMaskDrawable";
    private static Paint mPaint;
    protected String mText;
    private float mTextBaselineY;
    protected float mTextCenterX;
    private int mTextColor;
    private int mTextSize;

    static {
        Paint paint = new Paint();
        mPaint = paint;
        paint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    public HomeTextMaskDrawable(Shape shape) {
        super(shape);
        this.mText = "Test";
        this.mTextColor = SupportMenu.CATEGORY_MASK;
        this.mTextSize = 20;
    }

    protected float getStringWidth(String str) {
        return mPaint.measureText(str);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
        setTextLocation();
        canvas.drawText(this.mText, this.mTextCenterX, this.mTextBaselineY, mPaint);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    protected void setTextLocation() {
        mPaint.setTextSize(this.mTextSize);
        mPaint.setColor(this.mTextColor);
        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float f = fontMetrics.descent;
        float intrinsicHeight = ((getIntrinsicHeight() / 2) - f) + ((f - fontMetrics.ascent) / 2.0f);
        this.mTextCenterX = getIntrinsicWidth() / 2.0f;
        this.mTextBaselineY = intrinsicHeight;
    }

    public void setTextSize(int i) {
        this.mTextSize = i;
    }
}
