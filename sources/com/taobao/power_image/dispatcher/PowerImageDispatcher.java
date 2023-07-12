package com.taobao.power_image.dispatcher;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PowerImageDispatcher {
    private static volatile PowerImageDispatcher d;
    private Handler a;
    private Handler b;
    private Looper c;

    public static PowerImageDispatcher c() {
        if (d == null) {
            synchronized (PowerImageDispatcher.class) {
                if (d == null) {
                    d = new PowerImageDispatcher();
                }
            }
        }
        return d;
    }

    public void d() {
        this.b = new Handler(Looper.getMainLooper());
        Thread thread = new Thread(new Runnable() { // from class: com.taobao.power_image.dispatcher.PowerImageDispatcher.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                PowerImageDispatcher.this.c = Looper.myLooper();
                PowerImageDispatcher.this.a = new Handler();
                Looper.loop();
            }
        });
        thread.setName("com.taobao.power_image.work");
        thread.start();
    }

    public void e(Runnable runnable) {
        if (runnable == null || this.b == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    public void f(Runnable runnable, long j) {
        Handler handler;
        if (runnable == null || (handler = this.b) == null) {
            return;
        }
        handler.postDelayed(runnable, j);
    }
}
