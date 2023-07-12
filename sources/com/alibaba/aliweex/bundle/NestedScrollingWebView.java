package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.uc.webview.export.extension.UCExtension;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class NestedScrollingWebView extends WVUCWebView implements NestedScrollingChild {
    private NestedScrollingChildHelper childHelper;
    private int lastY;
    private int nestedOffsetY;
    private final int[] scrollConsumed;
    private final int[] scrollOffset;

    public NestedScrollingWebView(Context context) {
        this(context, null);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView, com.uc.webview.export.internal.interfaces.IWebViewOverride
    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        int[] iArr;
        UCExtension uCExtension = getUCExtension();
        if (uCExtension != null) {
            if (uCExtension.ignoreTouchEvent()) {
                requestDisallowInterceptTouchEvent(true);
            } else {
                requestDisallowInterceptTouchEvent(false);
            }
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(obtain);
        if (actionMasked == 0) {
            this.nestedOffsetY = 0;
        }
        int y = (int) obtain.getY();
        obtain.offsetLocation(0.0f, this.nestedOffsetY);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.lastY - y;
                    if (dispatchNestedPreScroll(0, i, this.scrollConsumed, this.scrollOffset)) {
                        i -= this.scrollConsumed[1];
                        this.lastY = y - this.scrollOffset[1];
                        obtain.offsetLocation(0.0f, -iArr[1]);
                        this.nestedOffsetY += this.scrollOffset[1];
                    }
                    boolean coreDispatchTouchEvent = super.coreDispatchTouchEvent(obtain);
                    int[] iArr2 = this.scrollOffset;
                    if (dispatchNestedScroll(0, iArr2[1], 0, i, iArr2)) {
                        obtain.offsetLocation(0.0f, this.scrollOffset[1]);
                        this.nestedOffsetY += this.scrollOffset[1];
                        return coreDispatchTouchEvent;
                    }
                    return coreDispatchTouchEvent;
                } else if (actionMasked != 3) {
                    return false;
                }
            }
            boolean coreDispatchTouchEvent2 = super.coreDispatchTouchEvent(obtain);
            stopNestedScroll();
            return coreDispatchTouchEvent2;
        }
        boolean coreDispatchTouchEvent3 = super.coreDispatchTouchEvent(obtain);
        this.lastY = y;
        startNestedScroll(2);
        return coreDispatchTouchEvent3;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.childHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.childHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.childHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.childHelper.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.childHelper.stopNestedScroll();
    }

    public NestedScrollingWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
    }

    public NestedScrollingWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollOffset = new int[2];
        this.scrollConsumed = new int[2];
        this.childHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }
}
