package cn.damai.message.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageListMainAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;
    private List<String> b;

    public MessageListMainAdapter(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
        super(fragmentManager);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "901419672") ? ((Integer) ipChange.ipc$dispatch("901419672", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "206127022") ? (Fragment) ipChange.ipc$dispatch("206127022", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1466090895") ? ((Long) ipChange.ipc$dispatch("1466090895", new Object[]{this, Integer.valueOf(i)})).longValue() : super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-164601534") ? (CharSequence) ipChange.ipc$dispatch("-164601534", new Object[]{this, Integer.valueOf(i)}) : this.b.get(i);
    }
}
