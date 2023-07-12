package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NestViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mLastY;

    public NestViewPager(Context context) {
        super(context, null);
        this.mLastY = 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestViewPager.$ipChange
            java.lang.String r1 = "966386925"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r6
            r2[r5] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            int r0 = r7.getAction()
            if (r0 == 0) goto L3c
            if (r0 == r5) goto L34
            if (r0 == r3) goto L2c
            r1 = 3
            if (r0 == r1) goto L34
            goto L49
        L2c:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r5)
            goto L49
        L34:
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
            goto L49
        L3c:
            float r0 = r7.getY()
            r6.mLastY = r0
            android.view.ViewParent r0 = r6.getParent()
            r0.requestDisallowInterceptTouchEvent(r4)
        L49:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestViewPager.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public NestViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastY = 0.0f;
    }
}
