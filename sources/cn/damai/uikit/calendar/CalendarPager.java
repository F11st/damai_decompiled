package cn.damai.uikit.calendar;

import android.content.Context;
import android.view.MotionEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class CalendarPager extends BetterViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean pagingEnabled;

    public CalendarPager(Context context) {
        super(context);
        this.pagingEnabled = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1562470716") ? ((Boolean) ipChange.ipc$dispatch("-1562470716", new Object[]{this, Integer.valueOf(i)})).booleanValue() : this.pagingEnabled && super.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1822871766") ? ((Boolean) ipChange.ipc$dispatch("1822871766", new Object[]{this, Integer.valueOf(i)})).booleanValue() : this.pagingEnabled && super.canScrollVertically(i);
    }

    public boolean isPagingEnabled() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "255429514") ? ((Boolean) ipChange.ipc$dispatch("255429514", new Object[]{this})).booleanValue() : this.pagingEnabled;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1453029996") ? ((Boolean) ipChange.ipc$dispatch("1453029996", new Object[]{this, motionEvent})).booleanValue() : this.pagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1302468920") ? ((Boolean) ipChange.ipc$dispatch("1302468920", new Object[]{this, motionEvent})).booleanValue() : this.pagingEnabled && super.onTouchEvent(motionEvent);
    }

    public void setPagingEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984642738")) {
            ipChange.ipc$dispatch("-984642738", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.pagingEnabled = z;
        }
    }
}
