package anetwork.channel.unified;

import anetwork.channel.interceptor.Callback;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import tb.z12;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b {
    public final z12 a;
    public Callback b;
    public final String c;
    public volatile AtomicBoolean d = new AtomicBoolean();
    public volatile IUnifiedTask e = null;
    public volatile MultiPathTask f = null;
    public volatile Future g = null;

    public b(z12 z12Var, Callback callback) {
        this.a = z12Var;
        this.c = z12Var.i;
        this.b = callback;
    }

    public void a() {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
    }

    public void b() {
        if (this.e != null) {
            this.e.cancel();
            this.e = null;
        }
    }

    public void c() {
        Future future = this.g;
        if (future != null) {
            future.cancel(true);
            this.g = null;
        }
    }
}
