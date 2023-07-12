package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ao {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f93a;

    /* renamed from: a  reason: collision with other field name */
    private a f94a;

    /* renamed from: a  reason: collision with other field name */
    private volatile b f95a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f96a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<b> f97a;

        public a() {
            super("PackageProcessor");
            this.f97a = new LinkedBlockingQueue<>();
        }

        private void a(int i, b bVar) {
            try {
                ao.this.f93a.sendMessage(ao.this.f93a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }

        public void a(b bVar) {
            try {
                this.f97a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = ao.this.a > 0 ? ao.this.a : AbsPerformance.LONG_NIL;
            while (!ao.this.f96a) {
                try {
                    b poll = this.f97a.poll(j, TimeUnit.SECONDS);
                    ao.this.f95a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (ao.this.a > 0) {
                        ao.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* renamed from: c */
        public void mo765c() {
        }
    }

    public ao() {
        this(false);
    }

    public ao(boolean z) {
        this(z, 0);
    }

    public ao(boolean z, int i) {
        this.f93a = null;
        this.f96a = false;
        this.a = 0;
        this.f93a = new ap(this, Looper.getMainLooper());
        this.b = z;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f94a = null;
        this.f96a = true;
    }

    public synchronized void a(b bVar) {
        if (this.f94a == null) {
            a aVar = new a();
            this.f94a = aVar;
            aVar.setDaemon(this.b);
            this.f96a = false;
            this.f94a.start();
        }
        this.f94a.a(bVar);
    }

    public void a(b bVar, long j) {
        this.f93a.postDelayed(new aq(this, bVar), j);
    }
}
