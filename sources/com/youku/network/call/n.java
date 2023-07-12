package com.youku.network.call;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.q;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class n implements Callback {
    private Handler a;
    private com.youku.network.a b;
    private com.youku.network.a.e c;
    private com.youku.network.d d;
    private AtomicBoolean e;

    public n(Handler handler, com.youku.network.a aVar, com.youku.network.a.b bVar) {
        this.d = com.youku.network.d.a();
        this.e = new AtomicBoolean(false);
        this.a = handler;
        this.b = aVar;
        this.c = (com.youku.network.a.e) bVar;
    }

    public n(com.youku.network.a aVar, com.youku.network.a.b bVar) {
        this(null, aVar, bVar);
    }

    public void a(final com.youku.network.d dVar) {
        com.youku.network.a aVar;
        if (!this.e.compareAndSet(false, true) || (aVar = this.b) == null) {
            return;
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.youku.network.call.OkHttpListener$1
                @Override // java.lang.Runnable
                public void run() {
                    com.youku.network.a aVar2;
                    aVar2 = n.this.b;
                    aVar2.a(dVar);
                }
            });
        } else {
            aVar.a(dVar);
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.d.a(iOException);
        com.youku.network.d a = com.youku.network.config.b.a(this.d, iOException, -3004);
        this.d = a;
        a(a);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, q qVar) {
        com.youku.network.d a = this.c.a((com.youku.network.a.e) qVar);
        this.d = a;
        a(a);
    }
}
