package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class b extends Handler {
    private final d a;
    private final int b;
    private final EventBus c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.b = i;
        this.a = new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar, Object obj) {
        c a = c.a(gVar, obj);
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
                c b = this.a.b();
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
