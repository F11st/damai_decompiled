package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class q {
    protected Context a;
    protected Handler b;
    private final Object c = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            q.this.b(message);
        }
    }

    public q() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.c) {
            Handler handler = this.b;
            if (handler == null) {
                String simpleName = getClass().getSimpleName();
                com.vivo.push.util.p.e(simpleName, ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + jn1.BRACKET_END_STR);
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
