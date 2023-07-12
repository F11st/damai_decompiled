package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.utils.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class UploadQueueMgr implements Runnable {
    public static final String MSGTYPE_INTERVAL = "i";
    public static final String MSGTYPE_REALTIME = "r";
    private boolean isRunning = false;
    private static BlockingQueue<String> queueCache = new LinkedBlockingQueue();
    private static UploadQueueMgr mUploadQueueMgr = new UploadQueueMgr();

    public static UploadQueueMgr getInstance() {
        return mUploadQueueMgr;
    }

    public void add(String str) {
        if (!queueCache.contains(str)) {
            try {
                queueCache.put(str);
                Logger.f("", "queueCache put", str, "queueCache size", Integer.valueOf(queueCache.size()));
                return;
            } catch (Exception e) {
                Logger.f("", e);
                return;
            }
        }
        Logger.f("", "queueCache contains", str);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.isRunning) {
            try {
                String take = queueCache.take();
                Logger.f("", "take queueCache size", Integer.valueOf(queueCache.size()));
                if ("i".equals(take)) {
                    C3134f.i().m();
                } else if (MSGTYPE_REALTIME.equals(take)) {
                    C3133e.h().j();
                }
            } catch (Throwable th) {
                Logger.f("", th);
            }
        }
    }

    public synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            hl2.c().d(null, getInstance(), 0L);
        }
    }
}
