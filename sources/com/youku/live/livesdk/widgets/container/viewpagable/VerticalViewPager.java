package com.youku.live.livesdk.widgets.container.viewpagable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VerticalViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;

    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651862453")) {
            ipChange.ipc$dispatch("-651862453", new Object[]{this});
            return;
        }
        setPageTransformer(true, new VerticalPageTransformer());
        setOverScrollMode(2);
    }

    private MotionEvent swapXY(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1311788721")) {
            return (MotionEvent) ipChange.ipc$dispatch("-1311788721", new Object[]{this, motionEvent});
        }
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090541514")) {
            return ((Boolean) ipChange.ipc$dispatch("1090541514", new Object[]{this, motionEvent})).booleanValue();
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(swapXY(motionEvent));
        swapXY(motionEvent);
        return onInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1060313626") ? ((Boolean) ipChange.ipc$dispatch("1060313626", new Object[]{this, motionEvent})).booleanValue() : super.onTouchEvent(swapXY(motionEvent));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
