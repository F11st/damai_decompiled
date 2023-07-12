package cn.damai.tetris.component.home.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.tetris.component.home.bean.HomePageRankBean;
import cn.damai.tetris.component.home.widget.HomepageRankTopList;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RankTopPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<String> a = new ArrayList<>();
    private Map<Integer, List<HomePageRankBean.Content.RankLists>> b = new HashMap();
    private TrackInfo c;

    public void a(ArrayList<String> arrayList, Map<Integer, List<HomePageRankBean.Content.RankLists>> map, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1064385085")) {
            ipChange.ipc$dispatch("1064385085", new Object[]{this, arrayList, map, trackInfo});
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
        if (AndroidInstantRuntime.support(ipChange, "-2097530006")) {
            ipChange.ipc$dispatch("-2097530006", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "175365633") ? ((Integer) ipChange.ipc$dispatch("175365633", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1312265440")) {
            return ((Integer) ipChange.ipc$dispatch("-1312265440", new Object[]{this, obj})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-85576204")) {
            return ipChange.ipc$dispatch("-85576204", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        HomepageRankTopList homepageRankTopList = new HomepageRankTopList(viewGroup.getContext());
        homepageRankTopList.setData(i, this.a.get(i), this.b.get(Integer.valueOf(i)), this.c);
        viewGroup.addView(homepageRankTopList);
        return homepageRankTopList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-53662109") ? ((Boolean) ipChange.ipc$dispatch("-53662109", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
