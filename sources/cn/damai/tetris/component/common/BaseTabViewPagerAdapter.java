package cn.damai.tetris.component.common;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.tetris.component.common.bean.BaseTabResultItem;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseTabViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<String> a = new ArrayList<>();
    private List<BaseTabResultItem> b = new ArrayList();
    private JSONObject c;

    public void a(ArrayList<String> arrayList, List<BaseTabResultItem> list, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175154872")) {
            ipChange.ipc$dispatch("1175154872", new Object[]{this, arrayList, list, jSONObject});
            return;
        }
        this.a = arrayList;
        this.b = list;
        this.c = jSONObject;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308152394")) {
            ipChange.ipc$dispatch("-1308152394", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "316519757")) {
            return ((Integer) ipChange.ipc$dispatch("316519757", new Object[]{this})).intValue();
        }
        List<BaseTabResultItem> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757915308")) {
            return ((Integer) ipChange.ipc$dispatch("-757915308", new Object[]{this, obj})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "1316917288")) {
            return ipChange.ipc$dispatch("1316917288", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        BaseTabPagerView baseTabPagerView = new BaseTabPagerView(viewGroup.getContext());
        baseTabPagerView.setData(i, this.a.get(i), this.b.get(i), this.c);
        viewGroup.addView(baseTabPagerView);
        return baseTabPagerView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2106408297") ? ((Boolean) ipChange.ipc$dispatch("-2106408297", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
