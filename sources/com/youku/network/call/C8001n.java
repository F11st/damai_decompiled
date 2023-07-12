package com.youku.network.call;

import android.os.Handler;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.C7979e;
import com.youku.network.a.InterfaceC7976b;
import com.youku.network.config.C8003b;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.C8827q;
import okhttp3.Call;
import okhttp3.Callback;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.n */
/* loaded from: classes3.dex */
public class C8001n implements Callback {
    private Handler a;
    private InterfaceC7974a b;
    private C7979e c;
    private C8004d d;
    private AtomicBoolean e;

    public C8001n(Handler handler, InterfaceC7974a interfaceC7974a, InterfaceC7976b interfaceC7976b) {
        this.d = C8004d.a();
        this.e = new AtomicBoolean(false);
        this.a = handler;
        this.b = interfaceC7974a;
        this.c = (C7979e) interfaceC7976b;
    }

    public C8001n(InterfaceC7974a interfaceC7974a, InterfaceC7976b interfaceC7976b) {
        this(null, interfaceC7974a, interfaceC7976b);
    }

    public void a(final C8004d c8004d) {
        InterfaceC7974a interfaceC7974a;
        if (!this.e.compareAndSet(false, true) || (interfaceC7974a = this.b) == null) {
            return;
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.youku.network.call.OkHttpListener$1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC7974a interfaceC7974a2;
                    interfaceC7974a2 = C8001n.this.b;
                    interfaceC7974a2.a(c8004d);
                }
            });
        } else {
            interfaceC7974a.a(c8004d);
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.d.a(iOException);
        C8004d a = C8003b.a(this.d, iOException, -3004);
        this.d = a;
        a(a);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, C8827q c8827q) {
        C8004d a = this.c.a((C7979e) c8827q);
        this.d = a;
        a(a);
    }
}
