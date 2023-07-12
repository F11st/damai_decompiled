package com.alibaba.gaiax.studio.third.socket.websocket;

import com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import tb.eb1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DefaultReconnectManager implements ReconnectManager {
    private C3392b b;
    private ReconnectManager.OnConnectListener c;
    private final Object a = new Object();
    private volatile boolean f = false;
    private volatile boolean g = false;
    private final ExecutorService h = Executors.newSingleThreadExecutor();
    private int i = 1;
    private int j = 1;
    private volatile boolean d = false;
    private volatile boolean e = false;

    public DefaultReconnectManager(C3392b c3392b, ReconnectManager.OnConnectListener onConnectListener) {
        this.b = c3392b;
        this.c = onConnectListener;
    }

    static /* synthetic */ int e(DefaultReconnectManager defaultReconnectManager) {
        int i = defaultReconnectManager.i;
        defaultReconnectManager.i = i + 1;
        return i;
    }

    static /* synthetic */ int l(DefaultReconnectManager defaultReconnectManager) {
        int i = defaultReconnectManager.j;
        defaultReconnectManager.j = i + 1;
        return i;
    }

    private Runnable m() {
        return new Runnable() { // from class: com.alibaba.gaiax.studio.third.socket.websocket.DefaultReconnectManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (DefaultReconnectManager.this.e || DefaultReconnectManager.this.f) {
                    DefaultReconnectManager.this.d = false;
                    return;
                }
                eb1.a("WSDefaultRM", "开始重连:" + DefaultReconnectManager.this.i);
                DefaultReconnectManager.e(DefaultReconnectManager.this);
                DefaultReconnectManager.this.d = true;
                DefaultReconnectManager.this.g = false;
                try {
                    int g = DefaultReconnectManager.this.b.l().g();
                    int i = 0;
                    while (true) {
                        if (i >= g) {
                            break;
                        }
                        i++;
                        eb1.d("WSDefaultRM", String.format("第%s次重连", Integer.valueOf(i)));
                        DefaultReconnectManager.this.b.o();
                        synchronized (DefaultReconnectManager.this.a) {
                            try {
                                DefaultReconnectManager.this.a.wait(DefaultReconnectManager.this.b.l().a());
                                if (!DefaultReconnectManager.this.g) {
                                    if (DefaultReconnectManager.this.f) {
                                    }
                                } else {
                                    eb1.d("WSDefaultRM", "reconnectOnce success!");
                                    DefaultReconnectManager.this.c.onConnected();
                                    return;
                                }
                            } catch (InterruptedException unused) {
                            }
                        }
                        break;
                    }
                    eb1.d("WSDefaultRM", "reconnectOnce failed!");
                    DefaultReconnectManager.this.c.onDisconnect();
                } finally {
                    eb1.a("WSDefaultRM", "重连结束:" + DefaultReconnectManager.this.j);
                    DefaultReconnectManager.l(DefaultReconnectManager.this);
                    DefaultReconnectManager.this.d = false;
                    eb1.d("WSDefaultRM", "reconnecting = false");
                }
            }
        };
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void destroy() {
        this.e = true;
        stopReconnect();
        this.b = null;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void onConnectError(Throwable th) {
        this.g = false;
        synchronized (this.a) {
            eb1.d("WSDefaultRM", "onConnectError(Throwable)->BLOCK.notifyAll()");
            this.a.notifyAll();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void onConnected() {
        this.g = true;
        synchronized (this.a) {
            eb1.d("WSDefaultRM", "onConnected()->BLOCK.notifyAll()");
            this.a.notifyAll();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public boolean reconnecting() {
        return this.d;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void startReconnect() {
        if (this.d) {
            eb1.d("WSDefaultRM", "Reconnecting, do not call again.");
        } else if (this.e) {
            eb1.b("WSDefaultRM", "ReconnectManager is destroyed!!!");
        } else {
            this.f = false;
            this.d = true;
            try {
                this.h.execute(m());
            } catch (RejectedExecutionException e) {
                eb1.c("WSDefaultRM", "线程队列已满，无法执行此次任务。", e);
                this.d = false;
            }
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.ReconnectManager
    public void stopReconnect() {
        this.f = true;
        ExecutorService executorService = this.h;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }
}
