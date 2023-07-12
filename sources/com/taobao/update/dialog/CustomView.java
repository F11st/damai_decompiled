package com.taobao.update.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomView extends RelativeLayout {
    static final String ANDROIDXML = "http://schemas.android.com/apk/res/android";
    static final String MATERIALDESIGNXML = "http://schemas.android.com/apk/res-auto";
    boolean animation;
    int beforeBackground;
    final int disabledBackgroundColor;
    public boolean isLastTouch;

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.disabledBackgroundColor = Color.parseColor("#E2E2E2");
        this.isLastTouch = false;
        this.animation = false;
    }

    @Override // android.view.View
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.animation = false;
    }

    @Override // android.view.View
    protected void onAnimationStart() {
        super.onAnimationStart();
        this.animation = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.animation) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setBackgroundColor(this.beforeBackground);
        } else {
            setBackgroundColor(this.disabledBackgroundColor);
        }
        invalidate();
    }
}
