package cn.damai.tetris.component.home.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRecentBean;
import cn.damai.tetris.component.home.widget.HomepageRecentList;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RecentShowPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<String> a = new ArrayList<>();
    private Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> b = new HashMap();
    private TrackInfo c;

    public void a(ArrayList<String> arrayList, Map<Integer, ArrayList<HomePageRecentBean.Labels.HomePageRecentItems>> map, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069149190")) {
            ipChange.ipc$dispatch("-2069149190", new Object[]{this, arrayList, map, trackInfo});
            return;
        }
        this.a = arrayList;
        this.b = map;
        this.c = trackInfo;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156070439")) {
            ipChange.ipc$dispatch("156070439", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "700065662") ? ((Integer) ipChange.ipc$dispatch("700065662", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219404355")) {
            return ((Integer) ipChange.ipc$dispatch("219404355", new Object[]{this, obj})).intValue();
        }
        if (getCount() > 0) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003490281")) {
            return ipChange.ipc$dispatch("-2003490281", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        HomepageRecentList homepageRecentList = new HomepageRecentList(viewGroup.getContext());
        homepageRecentList.setData(i, this.a.get(i), this.b.get(Integer.valueOf(i)), this.c);
        viewGroup.addView(homepageRecentList);
        return homepageRecentList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1643533306") ? ((Boolean) ipChange.ipc$dispatch("-1643533306", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
