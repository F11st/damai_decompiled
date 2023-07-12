package com.alibaba.security.common.track.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.track.RPTrack;
import com.alibaba.security.common.track.b.InterfaceC3832a;
import com.alibaba.security.common.track.model.LastExitTrackMsg;
import com.alibaba.security.common.track.model.TrackLog;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.track.a.a */
/* loaded from: classes8.dex */
public final class C3829a {
    private static final String f = "RPTrackManager";
    private static final int g = 10;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 5000;
    private static final boolean k = false;
    public LastExitTrackMsg a;
    RPTrack.TrackStrategy b;
    final List<TrackLog> c;
    public InterfaceC3832a d;
    public final HandlerC3831b e;
    private Context l;
    private final ThreadPoolExecutor m;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.track.a.a$a */
    /* loaded from: classes8.dex */
    public static final class C3830a {
        private static final C3829a a = new C3829a((byte) 0);

        private C3830a() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.track.a.a$b */
    /* loaded from: classes8.dex */
    public static class HandlerC3831b extends Handler {
        private final C3829a a;

        public HandlerC3831b(C3829a c3829a) {
            super(Looper.getMainLooper());
            this.a = c3829a;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                this.a.a(false);
            } else if (i != 2) {
            } else {
                this.a.e.removeCallbacksAndMessages(null);
            }
        }
    }

    /* synthetic */ C3829a(byte b) {
        this();
    }

    private static RPTrack.TrackStrategy e() {
        return new RPTrack.TrackStrategy.Builder().setTrackCacheSize(10).build();
    }

    private LastExitTrackMsg f() {
        return this.a;
    }

    private void g() {
        this.e.removeCallbacksAndMessages(null);
    }

    private C3829a() {
        this.e = new HandlerC3831b(this);
        this.c = new ArrayList();
        this.b = e();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.alibaba.security.common.track.a.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "rpsdk-rpTrackManager");
            }
        });
        this.m = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private static C3829a a() {
        return C3830a.a;
    }

    private void b() {
        a(false);
    }

    private void c() {
        if (this.c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[this.c.size()]));
        Collections.copy(arrayList, this.c);
        InterfaceC3832a interfaceC3832a = this.d;
        if (interfaceC3832a != null) {
            interfaceC3832a.a(arrayList);
            this.c.clear();
        }
    }

    private void d() {
        a(true);
        this.e.sendEmptyMessageDelayed(2, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    public final void a(Context context, RPTrack.TrackStrategy trackStrategy) {
        this.l = context;
        if (trackStrategy == null) {
            trackStrategy = e();
        }
        this.b = trackStrategy;
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(boolean z) {
        this.e.removeMessages(1);
        if (z) {
            return;
        }
        this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
    }

    private void a(InterfaceC3832a interfaceC3832a) {
        this.d = interfaceC3832a;
    }

    public final void a(final TrackLog trackLog) {
        this.m.execute(new Runnable() { // from class: com.alibaba.security.common.track.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                C3829a.this.c.add(trackLog);
                if (!C3829a.this.e.hasMessages(1)) {
                    C3829a.this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                }
                if (C3829a.this.c.size() >= C3829a.this.b.getTrackCacheSize()) {
                    C3829a.a(C3829a.this);
                }
            }
        });
    }

    public final void a(final boolean z) {
        if (this.c.isEmpty()) {
            b(z);
        } else {
            this.m.execute(new Runnable() { // from class: com.alibaba.security.common.track.a.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    C3829a.a(C3829a.this);
                    C3829a.this.b(z);
                }
            });
        }
    }

    private void a(LastExitTrackMsg lastExitTrackMsg) {
        this.a = lastExitTrackMsg;
    }

    static /* synthetic */ void a(C3829a c3829a) {
        if (c3829a.c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[c3829a.c.size()]));
        Collections.copy(arrayList, c3829a.c);
        InterfaceC3832a interfaceC3832a = c3829a.d;
        if (interfaceC3832a != null) {
            interfaceC3832a.a(arrayList);
            c3829a.c.clear();
        }
    }
}
