package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baseproject.ui.R$color;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CompatSwipeRefreshLayout extends SwipeRefreshLayout {
    private ScrollCompat mCompat;
    private float mPrevX;
    private int mTouchSlop;
    private float orgPosX;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ScrollCompat {
        boolean canChildScrollUp();
    }

    public CompatSwipeRefreshLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        int i = R$color.SwipeRefrshRingColor2;
        int i2 = R$color.SwipeRefrshRingColor1;
        setColorSchemeResources(i, i2, i, i2);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        ScrollCompat scrollCompat = this.mCompat;
        return scrollCompat != null ? scrollCompat.canChildScrollUp() : super.canChildScrollUp();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(motionEvent.getX() - this.mPrevX) > this.mTouchSlop) {
                return false;
            }
        } else {
            this.mPrevX = MotionEvent.obtain(motionEvent).getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setRingColor(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setScrollCompat(ScrollCompat scrollCompat) {
        this.mCompat = scrollCompat;
    }

    public CompatSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
