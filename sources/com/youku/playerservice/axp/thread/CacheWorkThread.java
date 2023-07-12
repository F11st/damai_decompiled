package com.youku.playerservice.axp.thread;

import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheWorkThread {
    private static HandlerThread thread;

    private CacheWorkThread() {
    }

    private static HandlerThread getInstance() {
        if (thread == null) {
            synchronized (CacheWorkThread.class) {
                if (thread == null) {
                    HandlerThread handlerThread = new HandlerThread("CacheWorkThread");
                    thread = handlerThread;
                    handlerThread.start();
                }
            }
        }
        return thread;
    }

    public static Looper getLooper() {
        return getInstance().getLooper();
    }
}
