package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.star.GiftStarItemView;
import com.youku.live.dago.widgetlib.interactive.gift.view.pageview.GiftBaseView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class GiftViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<? extends GiftBaseView> list;
    private List<String> titles;

    public GiftViewPagerAdapter(List<? extends GiftBaseView> list, List<String> list2) {
        this.list = list;
        this.titles = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "104327466")) {
            ipChange.ipc$dispatch("104327466", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView(this.list.get(i));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1763154881") ? ((Integer) ipChange.ipc$dispatch("1763154881", new Object[]{this})).intValue() : this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "417432299")) {
            return (CharSequence) ipChange.ipc$dispatch("417432299", new Object[]{this, Integer.valueOf(i)});
        }
        List<String> list = this.titles;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.titles.get(i);
    }

    public GiftStarItemView getStarItemView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374979924")) {
            return (GiftStarItemView) ipChange.ipc$dispatch("1374979924", new Object[]{this});
        }
        List<? extends GiftBaseView> list = this.list;
        if (list == null || list.size() <= 0) {
            return null;
        }
        for (int i = 0; i < this.list.size(); i++) {
            GiftBaseView giftBaseView = this.list.get(i);
            if (giftBaseView != null) {
                for (GiftShowAdapter giftShowAdapter : giftBaseView.mCategoryAllAdapterGV.keySet()) {
                    if (giftShowAdapter.getCurrentSelectedView() != null && giftShowAdapter.getCheckedBean() != null && giftShowAdapter.getCheckedBean().girdViewType == 1 && giftShowAdapter.getCheckedBean().isChecked && giftShowAdapter.getCurrentSelectedView() != null) {
                        return (GiftStarItemView) giftShowAdapter.getCurrentSelectedView();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public View getView(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-674681443") ? (View) ipChange.ipc$dispatch("-674681443", new Object[]{this, Integer.valueOf(i)}) : this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1585139660")) {
            return ipChange.ipc$dispatch("-1585139660", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        viewGroup.addView(this.list.get(i), new ViewGroup.LayoutParams(-1, -1));
        return this.list.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-398276445") ? ((Boolean) ipChange.ipc$dispatch("-398276445", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "197415362")) {
            ipChange.ipc$dispatch("197415362", new Object[]{this});
            return;
        }
        super.notifyDataSetChanged();
        ((ILog) Dsl.getService(ILog.class)).i("liulei-datachange", "GiftViewPagerAdapter notifyDataSetChanged");
    }
}
