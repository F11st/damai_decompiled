package com.youku.arch.beast.threading;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WorkerFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    private static WorkerThread mWorkThread = new WorkerThread();

    public static WorkerThread get() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "856843420") ? (WorkerThread) ipChange.ipc$dispatch("856843420", new Object[0]) : mWorkThread;
    }

    public static void run(final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320934504")) {
            ipChange.ipc$dispatch("1320934504", new Object[]{runnable});
        } else {
            new Thread() { // from class: com.youku.arch.beast.threading.WorkerFactory.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1555941379")) {
                        ipChange2.ipc$dispatch("-1555941379", new Object[]{this});
                    } else {
                        runnable.run();
                    }
                }
            }.start();
        }
    }
}
