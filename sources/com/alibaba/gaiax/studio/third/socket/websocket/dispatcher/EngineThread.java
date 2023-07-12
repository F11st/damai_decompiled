package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import android.os.Process;
import com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.eb1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class EngineThread extends Thread {
    private ExecutorService executorService;
    private boolean stop;
    private String TAG = "WSEngineThread";
    private ArrayBlockingQueue<a.C0143a> jobQueue = new ArrayBlockingQueue<>(10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(final a.C0143a c0143a) {
        if (this.jobQueue.offer(c0143a)) {
            return;
        }
        eb1.b(this.TAG, "Offer response to Engine failed!start an thread to put.");
        if (this.executorService == null) {
            this.executorService = Executors.newCachedThreadPool();
        }
        this.executorService.execute(new Runnable() { // from class: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.EngineThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (EngineThread.this.stop) {
                    return;
                }
                try {
                    EngineThread.this.jobQueue.put(c0143a);
                } catch (Exception e) {
                    if (EngineThread.this.stop) {
                        eb1.c(EngineThread.this.TAG, "put response failed!", e);
                    } else {
                        EngineThread.this.interrupt();
                    }
                }
            }
        });
    }

    void quit() {
        this.stop = true;
        this.jobQueue.clear();
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Process.setThreadPriority(10);
        while (!this.stop) {
            try {
                a.C0143a take = this.jobQueue.take();
                if (take.a) {
                    take.d.onSendDataError(take.c, take.e);
                } else {
                    take.b.onResponse(take.d, take.e);
                }
                a.C0143a.b(take);
            } catch (InterruptedException unused) {
                if (this.stop) {
                    return;
                }
            } catch (Exception e) {
                eb1.c(this.TAG, "run()->Exception", e);
            }
        }
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        this.stop = false;
        super.start();
    }
}
