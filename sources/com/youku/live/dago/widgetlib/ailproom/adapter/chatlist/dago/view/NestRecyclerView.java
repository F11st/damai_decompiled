package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NestRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int firstVisibleItemPosition;
    private boolean isBottomToTop;
    private boolean isTopToBottom;
    private int lastVisibleItemPosition;
    private float mLastY;

    public NestRecyclerView(Context context) {
        this(context, null);
    }

    private void isIntercept(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-609528327")) {
            ipChange.ipc$dispatch("-609528327", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.isTopToBottom = false;
        this.isBottomToTop = false;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            this.firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        }
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        Log.d("nestScrolling", GXTemplateEngine.g.TYPE_ON_SCROLL_STATE_CHANGED);
        if (childCount > 0) {
            if (this.lastVisibleItemPosition == itemCount - 1) {
                Log.d("nestScrolling", "触底了");
                if (canScrollVertically(-1) && f < this.mLastY) {
                    Log.d("nestScrolling", "不能向上滑动");
                    this.isBottomToTop = true;
                    return;
                }
                Log.d("nestScrolling", "向下滑动");
            } else if (this.firstVisibleItemPosition == 0) {
                Log.d("nestScrolling", "触顶了");
                if (canScrollVertically(1) && f > this.mLastY) {
                    Log.d("nestScrolling", "不能向下滑动");
                    this.isTopToBottom = true;
                    return;
                }
                Log.d("nestScrolling", "向上滑动");
            }
        }
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
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestRecyclerView.$ipChange
            java.lang.String r1 = "1136193295"
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
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestRecyclerView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public NestRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastY = 0.0f;
        this.isTopToBottom = false;
        this.isBottomToTop = false;
    }
}
