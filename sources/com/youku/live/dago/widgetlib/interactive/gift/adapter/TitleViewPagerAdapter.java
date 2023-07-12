package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TitleViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<View> list;
    private List<String> titles;

    public TitleViewPagerAdapter(List<View> list) {
        this.list = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694328632")) {
            ipChange.ipc$dispatch("1694328632", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        List<View> list = this.list;
        if (list == null || list.size() <= i) {
            return;
        }
        viewGroup.removeView(this.list.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-721001905") ? ((Integer) ipChange.ipc$dispatch("-721001905", new Object[]{this})).intValue() : this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685508729")) {
            return (CharSequence) ipChange.ipc$dispatch("685508729", new Object[]{this, Integer.valueOf(i)});
        }
        List<String> list = this.titles;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.titles.get(i);
    }

    public View getView(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1079291051") ? (View) ipChange.ipc$dispatch("1079291051", new Object[]{this, Integer.valueOf(i)}) : this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1240256358")) {
            return ipChange.ipc$dispatch("1240256358", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        List<View> list = this.list;
        if (list == null || list.size() <= i) {
            return null;
        }
        viewGroup.addView(this.list.get(i));
        return this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1592676565") ? ((Boolean) ipChange.ipc$dispatch("1592676565", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }

    public TitleViewPagerAdapter(List<View> list, List<String> list2) {
        this.list = list;
        this.titles = list2;
    }
}
