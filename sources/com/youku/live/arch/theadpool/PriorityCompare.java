package com.youku.live.arch.theadpool;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.theadpool.PriorityRunnable;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PriorityCompare<T extends PriorityRunnable> implements Comparator<T> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1644270733") ? ((Integer) ipChange.ipc$dispatch("1644270733", new Object[]{this, t, t2})).intValue() : t2.getPriority() - t.getPriority();
    }
}
