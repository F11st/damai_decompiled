package com.youku.network.call;

import android.os.Handler;
import android.os.Looper;
import com.youku.network.C7984c;
import com.youku.network.C8004d;
import com.youku.network.InterfaceC7974a;
import com.youku.network.a.InterfaceC7976b;

/* compiled from: Taobao */
/* renamed from: com.youku.network.call.a */
/* loaded from: classes13.dex */
public class C7987a {
    protected static Handler a = new Handler(Looper.getMainLooper());
    public static boolean b = true;
    protected C7984c c;
    protected InterfaceC7976b d;

    public C8004d a() {
        return null;
    }

    public void a(Handler handler, final InterfaceC7974a interfaceC7974a, final C8004d c8004d) {
        if (interfaceC7974a != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.BaseCall$1
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC7974a.a(c8004d);
                    }
                });
            } else {
                interfaceC7974a.a(c8004d);
            }
        }
    }

    public void a(InterfaceC7974a interfaceC7974a) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(C7984c c7984c) {
    }

    public void b() {
    }

    public void b(InterfaceC7974a interfaceC7974a) {
    }

    public C7984c c() {
        return this.c;
    }
}
