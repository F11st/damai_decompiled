package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativeFastText extends View {
    public StaticLayout staticLayout;
    private float translateX;
    private float translateY;

    public DXNativeFastText(Context context) {
        this(context, null);
    }

    public StaticLayout getStaticLayout() {
        return this.staticLayout;
    }

    public float getTranslateY() {
        return this.translateY;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.translateX, this.translateY);
        StaticLayout staticLayout = this.staticLayout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        canvas.restore();
    }

    public void setStaticLayout(StaticLayout staticLayout) {
        this.staticLayout = staticLayout;
    }

    public void setTranslateX(float f) {
        this.translateX = f;
    }

    public void setTranslateY(float f) {
        this.translateY = f;
    }

    public DXNativeFastText(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DXNativeFastText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
