package com.alibaba.analytics.core.sync;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UploadTask implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        UploadQueueMgr.getInstance().add("i");
    }
}
