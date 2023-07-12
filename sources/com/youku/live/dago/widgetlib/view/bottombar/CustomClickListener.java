package com.youku.live.dago.widgetlib.view.bottombar;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class CustomClickListener implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private long mLastClickTime;
    private long timeInterval;

    public CustomClickListener() {
        this.timeInterval = 1000L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190200055")) {
            ipChange.ipc$dispatch("-1190200055", new Object[]{this, view});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > this.timeInterval) {
            onSingleClick();
            this.mLastClickTime = currentTimeMillis;
            return;
        }
        onFastClick();
    }

    protected abstract void onFastClick();

    protected abstract void onSingleClick();

    public CustomClickListener(long j) {
        this.timeInterval = 1000L;
        this.timeInterval = j;
    }
}
