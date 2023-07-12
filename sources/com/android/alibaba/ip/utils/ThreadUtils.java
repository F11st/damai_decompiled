package com.android.alibaba.ip.utils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ThreadUtils {
    public static void asyncExcute(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: com.android.alibaba.ip.utils.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
        thread.setName("thread-instantpatch");
        thread.setPriority(10);
        thread.start();
    }

    public static void syncExcute(Runnable runnable) {
        runnable.run();
    }
}
