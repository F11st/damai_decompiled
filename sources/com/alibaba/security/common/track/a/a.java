package com.alibaba.security.common.track.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.common.track.RPTrack;
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
/* loaded from: classes8.dex */
public final class a {
    private static final String f = "RPTrackManager";
    private static final int g = 10;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 5000;
    private static final boolean k = false;
    public LastExitTrackMsg a;
    RPTrack.TrackStrategy b;
    final List<TrackLog> c;
    public com.alibaba.security.common.track.b.a d;
    public final b e;
    private Context l;
    private final ThreadPoolExecutor m;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.common.track.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0165a {
        private static final a a = new a((byte) 0);

        private C0165a() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b extends Handler {
        private final a a;

        public b(a aVar) {
            super(Looper.getMainLooper());
            this.a = aVar;
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

    /* synthetic */ a(byte b2) {
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

    private a() {
        this.e = new b(this);
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

    private static a a() {
        return C0165a.a;
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
        com.alibaba.security.common.track.b.a aVar = this.d;
        if (aVar != null) {
            aVar.a(arrayList);
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

    private void a(com.alibaba.security.common.track.b.a aVar) {
        this.d = aVar;
    }

    public final void a(final TrackLog trackLog) {
        this.m.execute(new Runnable() { // from class: com.alibaba.security.common.track.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.c.add(trackLog);
                if (!a.this.e.hasMessages(1)) {
                    a.this.e.sendEmptyMessageDelayed(1, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
                }
                if (a.this.c.size() >= a.this.b.getTrackCacheSize()) {
                    a.a(a.this);
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
                    a.a(a.this);
                    a.this.b(z);
                }
            });
        }
    }

    private void a(LastExitTrackMsg lastExitTrackMsg) {
        this.a = lastExitTrackMsg;
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(new TrackLog[aVar.c.size()]));
        Collections.copy(arrayList, aVar.c);
        com.alibaba.security.common.track.b.a aVar2 = aVar.d;
        if (aVar2 != null) {
            aVar2.a(arrayList);
            aVar.c.clear();
        }
    }
}
