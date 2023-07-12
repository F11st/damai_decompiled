package com.taobao.android.dinamicx.template.download;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXPriorityRunnable implements Runnable {
    long SEQ;
    public final int priority;
    private final Runnable runnable;

    public DXPriorityRunnable(int i, Runnable runnable) {
        this.priority = i;
        this.runnable = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.runnable.run();
    }
}
