package com.taobao.weex.ui.component.richtext.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.taobao.weex.adapter.IDrawableLoader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImgSpan extends ReplacementSpan implements IDrawableLoader.StaticTarget {
    private int height;
    private Drawable mDrawable;
    private View mView;
    private int width;

    public ImgSpan(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    private void setCallback() {
        View view;
        Drawable drawable = this.mDrawable;
        if (drawable == null || (view = this.mView) == null) {
            return;
        }
        drawable.setCallback(view);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.mDrawable != null) {
            canvas.save();
            canvas.translate(f, (i5 - this.mDrawable.getBounds().bottom) - paint.getFontMetricsInt().descent);
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            int i3 = -this.height;
            fontMetricsInt.ascent = i3;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i3;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }

    @Override // com.taobao.weex.adapter.IDrawableLoader.StaticTarget, com.taobao.weex.adapter.IDrawableLoader.DrawableTarget
    public void setDrawable(Drawable drawable, boolean z) {
        this.mDrawable = drawable;
        if (z) {
            drawable.setBounds(0, 0, this.width, this.height);
        }
        setCallback();
        this.mDrawable.invalidateSelf();
    }

    public void setView(View view) {
        this.mView = view;
        setCallback();
    }
}
