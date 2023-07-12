package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected MultiItemTypeSupport<T> mMultiItemTypeSupport;

    public MultiItemCommonAdapter(Context context, List<T> list, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1, list);
        this.mMultiItemTypeSupport = multiItemTypeSupport;
        if (multiItemTypeSupport == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211559982")) {
            return ((Integer) ipChange.ipc$dispatch("-211559982", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        MultiItemTypeSupport<T> multiItemTypeSupport = this.mMultiItemTypeSupport;
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.getItemViewType(i, this.mDatas.get(i));
        }
        return super.getItemViewType(i);
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.adapter.CommonAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785476607")) {
            return (View) ipChange.ipc$dispatch("-785476607", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        MultiItemTypeSupport<T> multiItemTypeSupport = this.mMultiItemTypeSupport;
        if (multiItemTypeSupport == null) {
            return super.getView(i, view, viewGroup);
        }
        CommonViewHolder commonViewHolder = CommonViewHolder.get(this.mContext, view, viewGroup, multiItemTypeSupport.getLayoutId(i, getItem(i)), i);
        convert(commonViewHolder, i, getItem(i));
        return commonViewHolder.getConvertView();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072927127")) {
            return ((Integer) ipChange.ipc$dispatch("1072927127", new Object[]{this})).intValue();
        }
        MultiItemTypeSupport<T> multiItemTypeSupport = this.mMultiItemTypeSupport;
        if (multiItemTypeSupport != null) {
            return multiItemTypeSupport.getViewTypeCount();
        }
        return super.getViewTypeCount();
    }

    public MultiItemCommonAdapter(Context context, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1);
        this.mMultiItemTypeSupport = multiItemTypeSupport;
        if (multiItemTypeSupport == null) {
            throw new IllegalArgumentException("the mMultiItemTypeSupport can not be null.");
        }
    }
}
