package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.commonbusiness.view.DmViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fy2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CustomViewPager extends DmViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    PointF curP;
    PointF downP;
    private fy2 helper;

    public CustomViewPager(Context context) {
        super(context);
        this.downP = new PointF();
        this.curP = new PointF();
        this.helper = new fy2(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870524287")) {
            ipChange.ipc$dispatch("1870524287", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // cn.damai.commonbusiness.view.DmViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1019516917") ? ((Boolean) ipChange.ipc$dispatch("-1019516917", new Object[]{this, motionEvent})).booleanValue() : super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "934953761")) {
            ipChange.ipc$dispatch("934953761", new Object[]{this, Integer.valueOf(i)});
        } else {
            setCurrentItem(i, true);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081158701")) {
            ipChange.ipc$dispatch("-1081158701", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        fy2 fy2Var = this.helper;
        if (fy2Var != null && fy2Var.a() != null) {
            ViewPagerScroller a = this.helper.a();
            if (Math.abs(getCurrentItem() - i) > 1) {
                a.setNoDuration(true);
                super.setCurrentItem(i, z);
                a.setNoDuration(false);
                return;
            }
            a.setNoDuration(false);
            super.setCurrentItem(i, z);
            return;
        }
        super.setCurrentItem(i, z);
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downP = new PointF();
        this.curP = new PointF();
        this.helper = new fy2(this);
    }
}
