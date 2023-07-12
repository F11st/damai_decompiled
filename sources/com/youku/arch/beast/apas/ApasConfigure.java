package com.youku.arch.beast.apas;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IConfigCenter;
import com.youku.alixplayer.util.Destructable;
import com.youku.sopalladium.SoLoaderGui;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ApasConfigure extends IConfigCenter implements Destructable {
    private static transient /* synthetic */ IpChange $ipChange;

    static {
        try {
            System.loadLibrary("beast");
        } catch (Throwable unused) {
            SoLoaderGui.loadSoWithRelinker("beast");
        }
    }

    private native void deinit();

    @Override // com.youku.alixplayer.util.Destructable
    public void destruct() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1216489171")) {
            ipChange.ipc$dispatch("1216489171", new Object[]{this});
        } else {
            deinit();
        }
    }

    @Override // com.youku.alixplayer.IConfigCenter
    protected native long init();
}
