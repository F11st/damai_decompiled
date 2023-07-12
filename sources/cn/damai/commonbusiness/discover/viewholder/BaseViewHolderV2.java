package cn.damai.commonbusiness.discover.viewholder;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public abstract class BaseViewHolderV2<T> extends BaseViewHolder<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    protected T a;
    protected int b;

    public BaseViewHolderV2(View view) {
        super(view);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    public void a(T t, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-731630411")) {
            ipChange.ipc$dispatch("-731630411", new Object[]{this, t, Integer.valueOf(i)});
            return;
        }
        this.a = t;
        this.b = i;
        c(t, i);
    }

    protected abstract void c(T t, int i);
}
