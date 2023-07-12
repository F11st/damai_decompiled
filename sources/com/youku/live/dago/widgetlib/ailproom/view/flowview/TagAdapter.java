package com.youku.live.dago.widgetlib.ailproom.view.flowview;

import android.util.Log;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class TagAdapter<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Deprecated
    private HashSet<Integer> mCheckedPosList = new HashSet<>();
    private OnDataChangedListener mOnDataChangedListener;
    private List<T> mTagDatas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnDataChangedListener {
        void onChanged();
    }

    public TagAdapter(List<T> list) {
        this.mTagDatas = list;
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724705405")) {
            return ((Integer) ipChange.ipc$dispatch("1724705405", new Object[]{this})).intValue();
        }
        List<T> list = this.mTagDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "712858509") ? (T) ipChange.ipc$dispatch("712858509", new Object[]{this, Integer.valueOf(i)}) : this.mTagDatas.get(i);
    }

    public TagStyle getItemStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-213564655")) {
            return (TagStyle) ipChange.ipc$dispatch("-213564655", new Object[]{this, Integer.valueOf(i)});
        }
        return null;
    }

    @Deprecated
    HashSet<Integer> getPreCheckedList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-926172852") ? (HashSet) ipChange.ipc$dispatch("-926172852", new Object[]{this}) : this.mCheckedPosList;
    }

    public abstract View getView(FlowLayout flowLayout, int i, T t);

    public void notifyDataChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537598438")) {
            ipChange.ipc$dispatch("537598438", new Object[]{this});
            return;
        }
        OnDataChangedListener onDataChangedListener = this.mOnDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onChanged();
        }
    }

    public void onSelected(int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-768456808")) {
            ipChange.ipc$dispatch("-768456808", new Object[]{this, Integer.valueOf(i), view});
            return;
        }
        Log.d("zhy", "onSelected " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1807872710")) {
            ipChange.ipc$dispatch("-1807872710", new Object[]{this, onDataChangedListener});
        } else {
            this.mOnDataChangedListener = onDataChangedListener;
        }
    }

    public boolean setSelected(int i, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931429497")) {
            return ((Boolean) ipChange.ipc$dispatch("1931429497", new Object[]{this, Integer.valueOf(i), t})).booleanValue();
        }
        return false;
    }

    @Deprecated
    public void setSelectedList(int... iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "734052730")) {
            ipChange.ipc$dispatch("734052730", new Object[]{this, iArr});
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        setSelectedList(hashSet);
    }

    public void unSelected(int i, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-985616482")) {
            ipChange.ipc$dispatch("-985616482", new Object[]{this, Integer.valueOf(i), view});
            return;
        }
        Log.d("zhy", "unSelected " + i);
    }

    @Deprecated
    public TagAdapter(T[] tArr) {
        this.mTagDatas = new ArrayList(Arrays.asList(tArr));
    }

    @Deprecated
    public void setSelectedList(Set<Integer> set) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985035219")) {
            ipChange.ipc$dispatch("1985035219", new Object[]{this, set});
            return;
        }
        this.mCheckedPosList.clear();
        if (set != null) {
            this.mCheckedPosList.addAll(set);
        }
        notifyDataChanged();
    }
}
