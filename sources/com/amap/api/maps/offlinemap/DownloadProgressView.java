package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.amap.api.mapcore.util.a;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DownloadProgressView extends View {
    private String a;
    private int b;
    private int c;
    private float d;
    private float e;
    private TextPaint f;
    private TextPaint g;
    private float h;
    private float i;

    public DownloadProgressView(Context context) {
        super(context);
        this.b = SupportMenu.CATEGORY_MASK;
        this.c = SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(null, 0);
    }

    private void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C0211a.a, i, 0);
        this.a = obtainStyledAttributes.getString(0);
        this.b = obtainStyledAttributes.getColor(3, this.b);
        this.d = obtainStyledAttributes.getDimension(1, this.d);
        this.c = obtainStyledAttributes.getColor(2, this.c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f = textPaint;
        textPaint.setFlags(1);
        this.f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        double d;
        float f;
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        canvas.drawRect(new Rect(0, (int) (height * 0.8f), (int) (((getWidth() - paddingLeft) - paddingRight) * this.e), height), this.g);
        canvas.drawText(String.valueOf((int) (this.e * 100.0f)) + "%", (int) (this.e * f), (int) (d - 3.0d), this.f);
    }

    public void setProgress(int i) {
        if (i > 100 || i < 0) {
            return;
        }
        this.e = i / 100.0f;
        invalidate();
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = SupportMenu.CATEGORY_MASK;
        this.c = SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = SupportMenu.CATEGORY_MASK;
        this.c = SupportMenu.CATEGORY_MASK;
        this.d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, i);
    }

    private void a() {
        this.f.setTextSize(this.d);
        this.f.setColor(this.b);
        this.g.setColor(this.c);
        this.h = this.f.measureText(this.a);
        this.i = this.f.getFontMetrics().bottom;
    }
}
