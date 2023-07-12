package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C7523p;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.q */
/* loaded from: classes11.dex */
public abstract class AbstractC7498q {
    protected Context a;
    protected Handler b;
    private final Object c = new Object();

    /* compiled from: Taobao */
    /* renamed from: com.vivo.push.q$a */
    /* loaded from: classes11.dex */
    class HandlerC7499a extends Handler {
        public HandlerC7499a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AbstractC7498q.this.b(message);
        }
    }

    public AbstractC7498q() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new HandlerC7499a(handlerThread.getLooper());
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
                C7523p.e(simpleName, ("Dead worker dropping a message: " + message.what) + " (Thread " + Thread.currentThread().getId() + jn1.BRACKET_END_STR);
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
