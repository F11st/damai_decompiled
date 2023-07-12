package com.alibaba.gaiax.studio.third.socket.websocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.gaiax.studio.third.socket.websocket.request.Request;
import java.util.ArrayDeque;
import java.util.Queue;
import tb.eb1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class WebSocketEngine {
    private OptionThread a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class OptionThread extends Thread {
        private HandlerC3390b mHandler;

        private OptionThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Looper.prepare();
            this.mHandler = new HandlerC3390b();
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class ReRunnable implements Runnable {
        private static Queue<ReRunnable> POOL = new ArrayDeque(10);
        private Request request;
        private int type;
        private WebSocketWrapper webSocketWrapper;

        private ReRunnable() {
        }

        static ReRunnable obtain() {
            ReRunnable poll = POOL.poll();
            return poll == null ? new ReRunnable() : poll;
        }

        void release() {
            POOL.offer(this);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.alibaba.gaiax.studio.third.socket.websocket.request.Request, com.alibaba.gaiax.studio.third.socket.websocket.WebSocketWrapper] */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            try {
                WebSocketWrapper webSocketWrapper = this.webSocketWrapper;
                if (webSocketWrapper != null && ((i = this.type) != 0 || this.request != null)) {
                    if (i == 0) {
                        webSocketWrapper.v(this.request);
                    } else if (i == 1) {
                        webSocketWrapper.t();
                    } else if (i == 2) {
                        webSocketWrapper.k();
                    } else if (i == 3) {
                        webSocketWrapper.j();
                    }
                }
            } finally {
                this.webSocketWrapper = null;
                this.request = null;
                release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.WebSocketEngine$b */
    /* loaded from: classes6.dex */
    public static class HandlerC3390b extends Handler {
        private HandlerC3390b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketEngine() {
        OptionThread optionThread = new OptionThread();
        this.a = optionThread;
        optionThread.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler == null) {
            socketWrapperListener.onConnectFailed(new Exception("WebSocketEngine not start!"));
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 1;
        obtain.webSocketWrapper = webSocketWrapper;
        this.a.mHandler.post(obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(WebSocketWrapper webSocketWrapper) {
        if (this.a.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 3;
            obtain.webSocketWrapper = webSocketWrapper;
            this.a.mHandler.post(obtain);
            return;
        }
        eb1.b("WSWebSocketEngine", "WebSocketEngine not start!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebSocketWrapper webSocketWrapper, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler != null) {
            ReRunnable obtain = ReRunnable.obtain();
            obtain.type = 2;
            obtain.webSocketWrapper = webSocketWrapper;
            this.a.mHandler.post(obtain);
            return;
        }
        eb1.b("WSWebSocketEngine", "WebSocketEngine not start!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(WebSocketWrapper webSocketWrapper, Request request, SocketWrapperListener socketWrapperListener) {
        if (this.a.mHandler == null) {
            socketWrapperListener.onSendDataError(request, 2, null);
            return;
        }
        ReRunnable obtain = ReRunnable.obtain();
        obtain.type = 0;
        obtain.request = request;
        obtain.webSocketWrapper = webSocketWrapper;
        this.a.mHandler.post(obtain);
    }
}
