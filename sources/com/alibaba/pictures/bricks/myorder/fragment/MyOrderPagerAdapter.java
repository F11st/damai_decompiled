package com.alibaba.pictures.bricks.myorder.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MyOrderPagerAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Fragment[] a;
    @NotNull
    private final String[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyOrderPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull Fragment[] fragmentArr, @NotNull String[] strArr) {
        super(fragmentManager);
        b41.i(fragmentManager, "fm");
        b41.i(fragmentArr, "fragments");
        b41.i(strArr, "titles");
        this.a = fragmentArr;
        this.b = strArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-281885681") ? ((Integer) ipChange.ipc$dispatch("-281885681", new Object[]{this})).intValue() : this.a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1367826601") ? (Fragment) ipChange.ipc$dispatch("-1367826601", new Object[]{this, Integer.valueOf(i)}) : this.a[i];
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1818987194") ? ((Long) ipChange.ipc$dispatch("-1818987194", new Object[]{this, Integer.valueOf(i)})).longValue() : super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-897037767") ? (CharSequence) ipChange.ipc$dispatch("-897037767", new Object[]{this, Integer.valueOf(i)}) : this.b[i];
    }
}
