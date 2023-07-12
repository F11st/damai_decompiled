package cn.damai.user.userhome.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserHomePagerAdapter extends FragmentStatePagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<Fragment> a;
    private Fragment b;

    public UserHomePagerAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public Fragment a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "44644210") ? (Fragment) ipChange.ipc$dispatch("44644210", new Object[]{this}) : this.b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679946537")) {
            return ((Integer) ipChange.ipc$dispatch("1679946537", new Object[]{this})).intValue();
        }
        List<Fragment> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206179581")) {
            return (Fragment) ipChange.ipc$dispatch("206179581", new Object[]{this, Integer.valueOf(i)});
        }
        List<Fragment> list = this.a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362869496")) {
            return ((Integer) ipChange.ipc$dispatch("362869496", new Object[]{this, obj})).intValue();
        }
        return -2;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1478145484") ? ipChange.ipc$dispatch("1478145484", new Object[]{this, viewGroup, Integer.valueOf(i)}) : (Fragment) super.instantiateItem(viewGroup, i);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "444152228")) {
            ipChange.ipc$dispatch("444152228", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        this.b = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
