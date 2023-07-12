package com.alibaba.motu.crashreporter2;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.util.Printer;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
class LooperMessagePrinter implements Printer {
    private final Callback callback;
    private long startedTime = SystemClock.uptimeMillis();
    private long cpuTime = SystemClock.currentThreadTimeMillis();
    private MessageMaker maker = new MessageMaker();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public interface Callback {
        void onLongMessage(String str);

        void onMessage(String str);
    }

    public LooperMessagePrinter(Callback callback) {
        this.callback = callback;
    }

    @Override // android.util.Printer
    @TargetApi(23)
    public void println(String str) {
        long uptimeMillis = SystemClock.uptimeMillis() - this.startedTime;
        String createMessage = this.maker.createMessage(str, uptimeMillis, SystemClock.currentThreadTimeMillis() - this.cpuTime);
        if (uptimeMillis > 500 && !str.startsWith(">>")) {
            this.callback.onLongMessage(createMessage);
        }
        this.callback.onMessage(createMessage);
        this.startedTime = SystemClock.uptimeMillis();
        this.cpuTime = SystemClock.currentThreadTimeMillis();
    }
}
