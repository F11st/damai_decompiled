package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.C7523p;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.cache.b */
/* loaded from: classes11.dex */
public final class C7446b {
    private static volatile C7446b a;
    private InterfaceC7448d b;

    private C7446b() {
    }

    public static synchronized C7446b a() {
        C7446b c7446b;
        synchronized (C7446b.class) {
            if (a == null) {
                a = new C7446b();
            }
            c7446b = a;
        }
        return c7446b;
    }

    public final InterfaceC7448d a(Context context) {
        InterfaceC7448d interfaceC7448d = this.b;
        if (interfaceC7448d != null) {
            return interfaceC7448d;
        }
        try {
            Method method = ClientConfigManagerImpl.class.getMethod("getInstance", Context.class);
            C7523p.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            InterfaceC7448d interfaceC7448d2 = (InterfaceC7448d) method.invoke(null, context);
            this.b = interfaceC7448d2;
            return interfaceC7448d2;
        } catch (Exception e) {
            e.printStackTrace();
            C7523p.b("ConfigManagerFactory", "createConfig error", e);
            return null;
        }
    }
}
