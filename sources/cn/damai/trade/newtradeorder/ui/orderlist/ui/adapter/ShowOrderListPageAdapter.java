package cn.damai.trade.newtradeorder.ui.orderlist.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ShowOrderListPageAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private String[] a;
    private DamaiBaseMvpFragment[] b;

    public ShowOrderListPageAdapter(FragmentManager fragmentManager, String[] strArr, DamaiBaseMvpFragment[] damaiBaseMvpFragmentArr) {
        super(fragmentManager);
        this.a = strArr;
        this.b = damaiBaseMvpFragmentArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1055777392") ? ((Integer) ipChange.ipc$dispatch("-1055777392", new Object[]{this})).intValue() : this.a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-952216138") ? (Fragment) ipChange.ipc$dispatch("-952216138", new Object[]{this, Integer.valueOf(i)}) : this.b[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1080408006") ? (CharSequence) ipChange.ipc$dispatch("-1080408006", new Object[]{this, Integer.valueOf(i)}) : this.a[i];
    }
}
