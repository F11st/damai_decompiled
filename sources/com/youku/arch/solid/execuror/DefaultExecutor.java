package com.youku.arch.solid.execuror;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DefaultExecutor implements Executor {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Handler mHandler;

    public DefaultExecutor() {
        HandlerThread handlerThread = new HandlerThread("SolidDefaultExecutor");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1134820087")) {
            ipChange.ipc$dispatch("1134820087", new Object[]{this, runnable});
        } else {
            this.mHandler.post(runnable);
        }
    }
}
