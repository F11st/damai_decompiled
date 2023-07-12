package cn.damai.projectfilter.adapter;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import cn.damai.projectfilter.bean.FilterBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class FastDiffCallback extends DiffUtil.Callback {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<FilterBean> a;
    public List<FilterBean> b;

    public FastDiffCallback(List<FilterBean> list, List<FilterBean> list2) {
        this.a = list;
        this.b = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-67720297")) {
            return ((Boolean) ipChange.ipc$dispatch("-67720297", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        FilterBean filterBean = this.b.get(i2);
        FilterBean filterBean2 = this.a.get(i);
        if (filterBean == null || filterBean2 == null) {
            return false;
        }
        return (TextUtils.equals(filterBean.name, filterBean2.name) && TextUtils.equals(filterBean.value, filterBean2.value) && filterBean.isSelected == filterBean2.isSelected) ? false : false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-614150297")) {
            return ((Boolean) ipChange.ipc$dispatch("-614150297", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        FilterBean filterBean = this.b.get(i2);
        FilterBean filterBean2 = this.a.get(i);
        if (filterBean == null || filterBean2 == null) {
            return false;
        }
        return (TextUtils.equals(filterBean.name, filterBean2.name) && TextUtils.equals(filterBean.value, filterBean2.value)) ? false : false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917628454")) {
            return ((Integer) ipChange.ipc$dispatch("1917628454", new Object[]{this})).intValue();
        }
        List<FilterBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1200644415")) {
            return ((Integer) ipChange.ipc$dispatch("1200644415", new Object[]{this})).intValue();
        }
        List<FilterBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
