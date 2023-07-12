package com.taobao.monitor.impl.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ThreadSwitcher {
    @SuppressLint({"StaticFieldLeak"})
    private static final ThreadSwitcher c = new ThreadSwitcher();
    private static final Queue<Bundle> d = new LinkedList();
    private final List<ThreadConversion> a = new ArrayList();
    private Handler b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ThreadConversion {
        void onThreadChanged(Message message);

        int what();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class a extends Handler {
        private final List<ThreadConversion> a;

        public a(Looper looper, List<ThreadConversion> list) {
            super(looper);
            this.a = list;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            List<ThreadConversion> list = this.a;
            if (list == null || message == null) {
                return;
            }
            for (ThreadConversion threadConversion : list) {
                if (threadConversion.what() == message.what) {
                    threadConversion.onThreadChanged(message);
                }
            }
        }
    }

    private ThreadSwitcher() {
    }

    public static ThreadSwitcher a() {
        return c;
    }

    public Bundle b() {
        Bundle poll = d.poll();
        return poll == null ? new Bundle() : poll;
    }

    public void c(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Queue<Bundle> queue = d;
        if (queue.size() < 100) {
            queue.add(bundle);
        }
        bundle.clear();
    }

    public void d(Message message) {
        this.b.sendMessage(message);
    }

    public void e(ThreadConversion threadConversion) {
        if (threadConversion == null) {
            return;
        }
        this.a.add(threadConversion);
    }

    public void f(HandlerThread handlerThread) {
        this.b = new a(handlerThread.getLooper(), this.a);
    }
}
