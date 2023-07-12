package com.taobao.monitor.impl.data.lifecycle;

import com.taobao.application.common.IApmEventListener;
import com.taobao.application.common.impl.C6674a;
import tb.v6;
import tb.w9;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BackgroundForegroundEventImpl {
    private final w9 a = new w9();
    private final IApmEventListener b;
    private boolean c;
    private final Runnable d;
    private final Runnable e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundForegroundEventImpl() {
        new v6();
        this.b = C6674a.g().b();
        this.c = false;
        this.d = new Runnable() { // from class: com.taobao.monitor.impl.data.lifecycle.BackgroundForegroundEventImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (BackgroundForegroundEventImpl.this.c) {
                    BackgroundForegroundEventImpl.this.a.b(true);
                }
            }
        };
        this.e = new Runnable() { // from class: com.taobao.monitor.impl.data.lifecycle.BackgroundForegroundEventImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (BackgroundForegroundEventImpl.this.c) {
                    BackgroundForegroundEventImpl.this.b.onEvent(50);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.c = false;
        this.a.a(false);
        this.a.b(false);
        this.b.onEvent(2);
        C6674a.g().getAsyncHandler().removeCallbacks(this.d);
        C6674a.g().getAsyncHandler().removeCallbacks(this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.c = true;
        this.a.a(true);
        this.b.onEvent(1);
        C6674a.g().getAsyncHandler().postDelayed(this.d, 300000L);
        C6674a.g().getAsyncHandler().postDelayed(this.e, 10000L);
    }
}
