package com.baseproject.basecard.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CustomView extends ImageView {
    private Drawable mDrawable;

    public CustomView(Context context) {
        super(context);
    }

    private void initattrs(AttributeSet attributeSet) {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public void setMask(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initattrs(attributeSet);
    }
}
