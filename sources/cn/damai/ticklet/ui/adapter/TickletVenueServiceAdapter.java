package cn.damai.ticklet.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.damai.ticklet.bean.TickletVenueMapBean;
import cn.damai.ticklet.ui.fragment.TickletVenueServiceListFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletVenueServiceAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<TickletVenueServiceListFragment> a;
    private ArrayList<TickletVenueMapBean> b;

    public TickletVenueServiceAdapter(FragmentManager fragmentManager, ArrayList<TickletVenueServiceListFragment> arrayList, ArrayList<TickletVenueMapBean> arrayList2) {
        super(fragmentManager);
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.a = arrayList;
        this.b = arrayList2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1712181495") ? ((Integer) ipChange.ipc$dispatch("-1712181495", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1701467421") ? (Fragment) ipChange.ipc$dispatch("1701467421", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1943729728") ? ((Long) ipChange.ipc$dispatch("-1943729728", new Object[]{this, Integer.valueOf(i)})).longValue() : super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1567218227") ? (CharSequence) ipChange.ipc$dispatch("1567218227", new Object[]{this, Integer.valueOf(i)}) : this.b.get(i).pageTitle;
    }
}
