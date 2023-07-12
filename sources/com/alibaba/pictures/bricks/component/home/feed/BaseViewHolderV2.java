package com.alibaba.pictures.bricks.component.home.feed;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class BaseViewHolderV2<T> extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    protected T a;

    public BaseViewHolderV2(View view) {
        super(view);
    }

    public void a(T t, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453115807")) {
            ipChange.ipc$dispatch("453115807", new Object[]{this, t, Integer.valueOf(i)});
            return;
        }
        this.a = t;
        b(t, i);
    }

    protected abstract void b(T t, int i);
}
