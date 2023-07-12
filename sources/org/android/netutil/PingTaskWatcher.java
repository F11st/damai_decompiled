package org.android.netutil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PingTaskWatcher {
    void OnEntry(int i, int i2, double d);

    void OnFailed(int i);

    void OnFinished();
}
