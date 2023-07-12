package cn.damai.videobrowse.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.commonbusiness.view.DmViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ControlScrollViewPager extends DmViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean canScroll;

    public ControlScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-871967662") ? ((Boolean) ipChange.ipc$dispatch("-871967662", new Object[]{this, motionEvent})).booleanValue() : super.dispatchTouchEvent(motionEvent);
    }

    @Override // cn.damai.commonbusiness.view.DmViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75847991")) {
            return ((Boolean) ipChange.ipc$dispatch("75847991", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.canScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // cn.damai.commonbusiness.view.DmViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960190989")) {
            return ((Boolean) ipChange.ipc$dispatch("960190989", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.canScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026728921")) {
            ipChange.ipc$dispatch("-1026728921", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.canScroll = z;
        }
    }

    public ControlScrollViewPager(Context context) {
        super(context);
    }
}
