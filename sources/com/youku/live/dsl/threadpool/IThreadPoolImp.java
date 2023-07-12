package com.youku.live.dsl.threadpool;

import cn.damai.utils.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;
import tb.ou1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IThreadPoolImp implements IThreadPool {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.threadpool.IThreadPool
    public void excute(final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1165197374")) {
            ipChange.ipc$dispatch("-1165197374", new Object[]{this, runnable});
        } else {
            ou1.a(new PriorityTask("workerThread", mu0.a(), 1) { // from class: com.youku.live.dsl.threadpool.IThreadPoolImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.utils.PriorityTask
                public void doTask() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1440267593")) {
                        ipChange2.ipc$dispatch("-1440267593", new Object[]{this});
                        return;
                    }
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
