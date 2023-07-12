package com.youku.live.dago.widgetlib.interactive.gift.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CommonViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private View mConvertView;
    private int mLayoutId;
    private int mPosition;
    private SparseArray<View> mViews = new SparseArray<>();

    public CommonViewHolder(Context context, View view, ViewGroup viewGroup, int i) {
        this.mContext = context;
        this.mConvertView = view;
        this.mPosition = i;
        this.mConvertView.setTag(this);
    }

    public static CommonViewHolder get(Context context, View view, ViewGroup viewGroup, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321275673")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("-1321275673", new Object[]{context, view, viewGroup, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (view == null) {
            CommonViewHolder commonViewHolder = new CommonViewHolder(context, LayoutInflater.from(context).inflate(i, viewGroup, false), viewGroup, i2);
            commonViewHolder.mLayoutId = i;
            return commonViewHolder;
        }
        CommonViewHolder commonViewHolder2 = (CommonViewHolder) view.getTag();
        commonViewHolder2.mPosition = i2;
        return commonViewHolder2;
    }

    public View getConvertView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-273412894") ? (View) ipChange.ipc$dispatch("-273412894", new Object[]{this}) : this.mConvertView;
    }

    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1625211104") ? ((Integer) ipChange.ipc$dispatch("-1625211104", new Object[]{this})).intValue() : this.mLayoutId;
    }

    public <T extends View> T getView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193867144")) {
            return (T) ipChange.ipc$dispatch("-193867144", new Object[]{this, Integer.valueOf(i)});
        }
        T t = (T) this.mViews.get(i);
        if (t == null) {
            T t2 = (T) this.mConvertView.findViewById(i);
            this.mViews.put(i, t2);
            return t2;
        }
        return t;
    }

    public CommonViewHolder setOnClickListener(int i, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515507657")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("1515507657", new Object[]{this, Integer.valueOf(i), onClickListener});
        }
        getView(i).setOnClickListener(onClickListener);
        return this;
    }

    public CommonViewHolder setOnLongClickListener(int i, View.OnLongClickListener onLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1778275967")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("-1778275967", new Object[]{this, Integer.valueOf(i), onLongClickListener});
        }
        getView(i).setOnLongClickListener(onLongClickListener);
        return this;
    }

    public CommonViewHolder setOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-892614373")) {
            return (CommonViewHolder) ipChange.ipc$dispatch("-892614373", new Object[]{this, Integer.valueOf(i), onTouchListener});
        }
        getView(i).setOnTouchListener(onTouchListener);
        return this;
    }

    public void updatePosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-854860365")) {
            ipChange.ipc$dispatch("-854860365", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPosition = i;
        }
    }
}
