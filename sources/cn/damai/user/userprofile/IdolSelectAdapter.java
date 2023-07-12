package cn.damai.user.userprofile;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.damai.user.userprofile.bean.IdolData;
import cn.damai.user.userprofile.bean.IdolSelectRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class IdolSelectAdapter extends FragmentPagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<IdolSelectFragment> a;
    private Object[] b;
    Map<Integer, List<IdolData>> c;

    public IdolSelectAdapter(FragmentManager fragmentManager, List<IdolSelectFragment> list, Object[] objArr) {
        super(fragmentManager);
        this.a = new ArrayList();
        this.b = new Object[5];
        this.a = list;
        this.b = objArr;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1087902024") ? ((Integer) ipChange.ipc$dispatch("-1087902024", new Object[]{this})).intValue() : this.a.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-231186546") ? (Fragment) ipChange.ipc$dispatch("-231186546", new Object[]{this, Integer.valueOf(i)}) : this.a.get(i);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "988387759") ? ((Long) ipChange.ipc$dispatch("988387759", new Object[]{this, Integer.valueOf(i)})).longValue() : super.getItemId(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-685717943")) {
            return ((Integer) ipChange.ipc$dispatch("-685717943", new Object[]{this, obj})).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708332898")) {
            return (CharSequence) ipChange.ipc$dispatch("708332898", new Object[]{this, Integer.valueOf(i)});
        }
        return this.b[i] + "";
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-279321059")) {
            return ipChange.ipc$dispatch("-279321059", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        IdolSelectFragment idolSelectFragment = (IdolSelectFragment) super.instantiateItem(viewGroup, i);
        Map<Integer, List<IdolData>> map = this.c;
        if (map == null) {
            return idolSelectFragment;
        }
        List<IdolData> list = map.get(Integer.valueOf(i));
        if (idolSelectFragment.getArguments() != null) {
            idolSelectFragment.getArguments().putSerializable("data", (Serializable) list);
            idolSelectFragment.getArguments().putString("type", IdolSelectRequest.tabIds.get(i));
        }
        return idolSelectFragment;
    }
}
