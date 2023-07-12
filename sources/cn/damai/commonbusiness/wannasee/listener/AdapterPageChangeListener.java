package cn.damai.commonbusiness.wannasee.listener;

import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AdapterPageChangeListener implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-123506029")) {
            ipChange.ipc$dispatch("-123506029", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1168948686")) {
            ipChange.ipc$dispatch("-1168948686", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654123618")) {
            ipChange.ipc$dispatch("-654123618", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
