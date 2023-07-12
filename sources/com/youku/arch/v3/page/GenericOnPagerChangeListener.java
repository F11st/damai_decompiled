package com.youku.arch.v3.page;

import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/youku/arch/v3/page/GenericOnPagerChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "Ltb/wt2;", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "Lcom/youku/arch/v3/page/ActivityInterceptor;", "activityInterceptor", "Lcom/youku/arch/v3/page/ActivityInterceptor;", "<init>", "(Lcom/youku/arch/v3/page/ActivityInterceptor;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GenericOnPagerChangeListener implements ViewPager.OnPageChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final ActivityInterceptor activityInterceptor;

    public GenericOnPagerChangeListener(@Nullable ActivityInterceptor activityInterceptor) {
        this.activityInterceptor = activityInterceptor;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992063648")) {
            ipChange.ipc$dispatch("992063648", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ActivityInterceptor activityInterceptor = this.activityInterceptor;
        if (activityInterceptor == null) {
            return;
        }
        activityInterceptor.onPageScrollStateChanged(i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1159912767")) {
            ipChange.ipc$dispatch("1159912767", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
            return;
        }
        ActivityInterceptor activityInterceptor = this.activityInterceptor;
        if (activityInterceptor == null) {
            return;
        }
        activityInterceptor.onPageScrolled(i, f, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-651700245")) {
            ipChange.ipc$dispatch("-651700245", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ActivityInterceptor activityInterceptor = this.activityInterceptor;
        if (activityInterceptor == null) {
            return;
        }
        activityInterceptor.onPageSelected(i);
    }
}
