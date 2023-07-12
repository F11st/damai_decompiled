package cn.damai.tetris.component.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TabStyle implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean describe;

    public boolean isShowDateAndVenue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2035977168") ? ((Boolean) ipChange.ipc$dispatch("2035977168", new Object[]{this})).booleanValue() : this.describe;
    }
}
