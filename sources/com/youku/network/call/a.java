package com.youku.network.call;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    protected static Handler a = new Handler(Looper.getMainLooper());
    public static boolean b = true;
    protected com.youku.network.c c;
    protected com.youku.network.a.b d;

    public com.youku.network.d a() {
        return null;
    }

    public void a(Handler handler, final com.youku.network.a aVar, final com.youku.network.d dVar) {
        if (aVar != null) {
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.youku.network.call.BaseCall$1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(dVar);
                    }
                });
            } else {
                aVar.a(dVar);
            }
        }
    }

    public void a(com.youku.network.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.youku.network.c cVar) {
    }

    public void b() {
    }

    public void b(com.youku.network.a aVar) {
    }

    public com.youku.network.c c() {
        return this.c;
    }
}
