package cn.damai.uikit.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BannerViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean scrollable;

    public BannerViewPager(Context context) {
        super(context);
        this.scrollable = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1938498323") ? ((Boolean) ipChange.ipc$dispatch("-1938498323", new Object[]{this, motionEvent})).booleanValue() : this.scrollable && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "645181847") ? ((Boolean) ipChange.ipc$dispatch("645181847", new Object[]{this, motionEvent})).booleanValue() : this.scrollable && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469330955")) {
            ipChange.ipc$dispatch("1469330955", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.scrollable = z;
        }
    }

    public BannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
    }
}
