package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private int layoutId;
    protected Context mContext;
    protected List<T> mDatas;

    public CommonAdapter(Context context, int i, List<T> list) {
        ArrayList arrayList = new ArrayList();
        this.mDatas = arrayList;
        this.mContext = context;
        arrayList.addAll(list);
        this.layoutId = i;
    }

    public void add(int i, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856842470")) {
            ipChange.ipc$dispatch("856842470", new Object[]{this, Integer.valueOf(i), t});
            return;
        }
        this.mDatas.add(i, t);
        notifyDataSetChanged();
    }

    public void addAll(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1008656991")) {
            ipChange.ipc$dispatch("-1008656991", new Object[]{this, list});
            return;
        }
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-912829395")) {
            ipChange.ipc$dispatch("-912829395", new Object[]{this});
            return;
        }
        this.mDatas.clear();
        notifyDataSetChanged();
    }

    public boolean contains(T t) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "972809809") ? ((Boolean) ipChange.ipc$dispatch("972809809", new Object[]{this, t})).booleanValue() : this.mDatas.contains(t);
    }

    public abstract void convert(CommonViewHolder commonViewHolder, int i, T t);

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1930009898") ? ((Integer) ipChange.ipc$dispatch("1930009898", new Object[]{this})).intValue() : this.mDatas.size();
    }

    public List<T> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-146469171") ? (List) ipChange.ipc$dispatch("-146469171", new Object[]{this}) : this.mDatas;
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477054848")) {
            return (T) ipChange.ipc$dispatch("-477054848", new Object[]{this, Integer.valueOf(i)});
        }
        if (i >= getCount()) {
            return null;
        }
        return this.mDatas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2098820001") ? ((Long) ipChange.ipc$dispatch("2098820001", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537405937")) {
            return (View) ipChange.ipc$dispatch("-1537405937", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        CommonViewHolder commonViewHolder = CommonViewHolder.get(this.mContext, view, viewGroup, this.layoutId, i);
        convert(commonViewHolder, i, getItem(i));
        return commonViewHolder.getConvertView();
    }

    public void remove(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-766326840")) {
            ipChange.ipc$dispatch("-766326840", new Object[]{this, t});
            return;
        }
        this.mDatas.remove(t);
        notifyDataSetChanged();
    }

    public void replaceAll(List<T> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-454524428")) {
            ipChange.ipc$dispatch("-454524428", new Object[]{this, list});
            return;
        }
        this.mDatas.clear();
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void set(T t, T t2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92847120")) {
            ipChange.ipc$dispatch("-92847120", new Object[]{this, t, t2});
        } else {
            set(this.mDatas.indexOf(t), (int) t2);
        }
    }

    public void set(int i, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "496168423")) {
            ipChange.ipc$dispatch("496168423", new Object[]{this, Integer.valueOf(i), t});
            return;
        }
        this.mDatas.set(i, t);
        notifyDataSetChanged();
    }

    public void add(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871404491")) {
            ipChange.ipc$dispatch("-1871404491", new Object[]{this, t});
            return;
        }
        this.mDatas.add(t);
        notifyDataSetChanged();
    }

    public void remove(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "827364759")) {
            ipChange.ipc$dispatch("827364759", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mDatas.remove(i);
        notifyDataSetChanged();
    }

    public CommonAdapter(Context context, int i) {
        this.mDatas = new ArrayList();
        this.mContext = context;
        this.layoutId = i;
    }
}
