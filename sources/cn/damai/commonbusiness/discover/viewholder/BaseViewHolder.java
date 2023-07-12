package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;

    public BaseViewHolder(View view) {
        super(view);
    }

    public static View b(Context context, ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-361060687") ? (View) ipChange.ipc$dispatch("-361060687", new Object[]{context, viewGroup, Integer.valueOf(i)}) : LayoutInflater.from(context).inflate(i, viewGroup, false);
    }

    public abstract void a(T t, int i);
}
