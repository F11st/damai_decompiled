package com.youku.live.dago.widgetlib.interactive.gift.view.pageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class NoScrollGridView extends GridView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isClickable;
    private boolean isOnMeasure;

    public NoScrollGridView(Context context) {
        super(context);
        this.isClickable = true;
    }

    public boolean isOnMeasure() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1364058647") ? ((Boolean) ipChange.ipc$dispatch("-1364058647", new Object[]{this})).booleanValue() : this.isOnMeasure;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "741419509") ? ((Boolean) ipChange.ipc$dispatch("741419509", new Object[]{this, motionEvent})).booleanValue() : !this.isClickable || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-71041555")) {
            ipChange.ipc$dispatch("-71041555", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        this.isOnMeasure = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "10993275")) {
            ipChange.ipc$dispatch("10993275", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.isOnMeasure = true;
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "35920783") ? ((Boolean) ipChange.ipc$dispatch("35920783", new Object[]{this, motionEvent})).booleanValue() : this.isClickable && super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899514980")) {
            ipChange.ipc$dispatch("1899514980", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isClickable = z;
        }
    }

    public NoScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isClickable = true;
    }
}
