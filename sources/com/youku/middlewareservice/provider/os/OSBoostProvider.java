package com.youku.middlewareservice.provider.os;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface OSBoostProvider {
    void cancelCpuHighFreq();

    void cancelThreadPriority(int i);

    boolean isSupportBoost();

    boolean requestCpuHighFreq(int i, int i2);

    boolean requestThreadPriority(int i, int i2);

    void unregisterBoostType(int i);
}
