package com.taobao.update.datasource;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class PatchRunnable implements Runnable {
    private UpdateListener updateListener;

    public PatchRunnable(UpdateListener updateListener) {
        this.updateListener = updateListener;
    }

    public UpdateListener getUpdateListener() {
        return this.updateListener;
    }
}
