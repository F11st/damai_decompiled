package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span;

import android.graphics.Color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ItemBaseBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public Color background;

    public ItemBaseBean setBackground(Color color) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384300128")) {
            return (ItemBaseBean) ipChange.ipc$dispatch("1384300128", new Object[]{this, color});
        }
        this.background = color;
        return this;
    }
}
