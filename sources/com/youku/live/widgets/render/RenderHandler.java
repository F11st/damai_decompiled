package com.youku.live.widgets.render;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class RenderHandler extends Handler {
    private static transient /* synthetic */ IpChange $ipChange;

    public RenderHandler() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1085694871")) {
            ipChange.ipc$dispatch("1085694871", new Object[]{this, message});
        } else {
            super.handleMessage(message);
        }
    }

    public final boolean post(String str, Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2110884045")) {
            return ((Boolean) ipChange.ipc$dispatch("-2110884045", new Object[]{this, str, runnable})).booleanValue();
        }
        Message obtain = Message.obtain(this, runnable);
        obtain.what = str.hashCode();
        return sendMessageDelayed(obtain, 0L);
    }
}
