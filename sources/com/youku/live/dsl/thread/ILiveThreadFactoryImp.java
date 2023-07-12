package com.youku.live.dsl.thread;

import cn.damai.utils.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;
import tb.ou1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ILiveThreadFactoryImp implements ILiveThreadFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.thread.ILiveThreadFactory
    public void excute(final Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267511010")) {
            ipChange.ipc$dispatch("1267511010", new Object[]{this, runnable});
        } else {
            ou1.a(new PriorityTask("workerThread", mu0.a(), 1) { // from class: com.youku.live.dsl.thread.ILiveThreadFactoryImp.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.utils.PriorityTask
                public void doTask() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "414906839")) {
                        ipChange2.ipc$dispatch("414906839", new Object[]{this});
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

    @Override // com.youku.live.dsl.thread.ILiveThreadFactory
    public void excuteWithPriority(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1821269387")) {
            ipChange.ipc$dispatch("1821269387", new Object[]{this, runnable, Integer.valueOf(i)});
        } else {
            excute(runnable);
        }
    }

    @Override // com.youku.live.dsl.thread.ILiveThreadFactory
    public void excuteWithType(Runnable runnable, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925050017")) {
            ipChange.ipc$dispatch("925050017", new Object[]{this, runnable, Integer.valueOf(i)});
        } else {
            excute(runnable);
        }
    }

    @Override // com.youku.live.dsl.thread.ILiveThreadFactory
    public void excuteWithTypePriority(Runnable runnable, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "84437566")) {
            ipChange.ipc$dispatch("84437566", new Object[]{this, runnable, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            excute(runnable);
        }
    }
}
