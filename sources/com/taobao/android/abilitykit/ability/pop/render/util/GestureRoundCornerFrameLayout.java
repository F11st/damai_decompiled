package com.taobao.android.abilitykit.ability.pop.render.util;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class GestureRoundCornerFrameLayout extends FrameLayout {
    private IGestureHandler mGestureHandler;
    private a mRoundCornerLayoutHelper;

    public GestureRoundCornerFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(final Canvas canvas) {
        this.mRoundCornerLayoutHelper.a(canvas, new Runnable() { // from class: com.taobao.android.abilitykit.ability.pop.render.util.GestureRoundCornerFrameLayout.1
            @Override // java.lang.Runnable
            public void run() {
                GestureRoundCornerFrameLayout.super.dispatchDraw(canvas);
            }
        });
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IGestureHandler iGestureHandler = this.mGestureHandler;
        if (iGestureHandler != null) {
            return iGestureHandler.onInterceptTouchEvent(motionEvent, this);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IGestureHandler iGestureHandler = this.mGestureHandler;
        if (iGestureHandler != null) {
            iGestureHandler.onTouchEvent(motionEvent, this);
            return true;
        }
        return true;
    }

    public void setGestureHandler(IGestureHandler iGestureHandler) {
        this.mGestureHandler = iGestureHandler;
    }

    public void setRadius(float f) {
        setRadius(f, f, f, f);
    }

    public GestureRoundCornerFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setRadius(float f, float f2, float f3, float f4) {
        this.mRoundCornerLayoutHelper.h(f, f2, f3, f4);
    }

    public GestureRoundCornerFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRoundCornerLayoutHelper = new a(this);
    }
}
