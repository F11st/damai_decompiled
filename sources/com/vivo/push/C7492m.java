package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C7523p;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.m */
/* loaded from: classes11.dex */
public final class C7492m {
    private static final Handler a = new Handler(Looper.getMainLooper());
    private static final HandlerThread b;
    private static final Handler c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        c = new HandlerC7495n(handlerThread.getLooper());
    }

    public static void a(AbstractRunnableC7491l abstractRunnableC7491l) {
        if (abstractRunnableC7491l == null) {
            C7523p.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = abstractRunnableC7491l.a();
        Message message = new Message();
        message.what = a2;
        message.obj = abstractRunnableC7491l;
        c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }
}
