package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.b */
/* loaded from: classes3.dex */
final class HandlerC8103b extends Handler {
    private final C8105d a;
    private final int b;
    private final EventBus c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC8103b(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.b = i;
        this.a = new C8105d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C8108g c8108g, Object obj) {
        C8104c a = C8104c.a(c8108g, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C8104c b = this.a.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.a.b();
                        if (b == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.e(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (sendMessage(obtainMessage())) {
                this.d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.d = false;
        }
    }
}
