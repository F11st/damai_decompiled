package com.youku.live.livesdk.wkit.component.common.utils;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class RecyclerHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    public static LinearLayoutManager createLayoutManager(int i, Context context, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "856871847") ? (LinearLayoutManager) ipChange.ipc$dispatch("856871847", new Object[]{Integer.valueOf(i), context, Boolean.valueOf(z)}) : new LinearLayoutManager(context, i, z);
    }

    public static LinearLayoutManager getHorizontalLayout(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1929844399") ? (LinearLayoutManager) ipChange.ipc$dispatch("-1929844399", new Object[]{context}) : createLayoutManager(0, context, false);
    }

    public static LinearLayoutManager getVerticalLayout(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1914763777") ? (LinearLayoutManager) ipChange.ipc$dispatch("-1914763777", new Object[]{context}) : createLayoutManager(1, context, false);
    }
}
