package com.taobao.downloader.adpater;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ThreadExecutor {
    void execute(Runnable runnable, boolean z);

    void postDelayed(Runnable runnable, long j);
}
