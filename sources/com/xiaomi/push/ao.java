package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
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
    private C7599a f94a;

    /* renamed from: a  reason: collision with other field name */
    private volatile AbstractC7600b f95a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f96a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.ao$a */
    /* loaded from: classes11.dex */
    public class C7599a extends Thread {

        /* renamed from: a  reason: collision with other field name */
        private final LinkedBlockingQueue<AbstractC7600b> f97a;

        public C7599a() {
            super("PackageProcessor");
            this.f97a = new LinkedBlockingQueue<>();
        }

        private void a(int i, AbstractC7600b abstractC7600b) {
            try {
                ao.this.f93a.sendMessage(ao.this.f93a.obtainMessage(i, abstractC7600b));
            } catch (Exception e) {
                AbstractC7535b.a(e);
            }
        }

        public void a(AbstractC7600b abstractC7600b) {
            try {
                this.f97a.add(abstractC7600b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = ao.this.a > 0 ? ao.this.a : AbsPerformance.LONG_NIL;
            while (!ao.this.f96a) {
                try {
                    AbstractC7600b poll = this.f97a.poll(j, TimeUnit.SECONDS);
                    ao.this.f95a = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (ao.this.a > 0) {
                        ao.this.a();
                    }
                } catch (InterruptedException e) {
                    AbstractC7535b.a(e);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.ao$b */
    /* loaded from: classes11.dex */
    public static abstract class AbstractC7600b {
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

    public synchronized void a(AbstractC7600b abstractC7600b) {
        if (this.f94a == null) {
            C7599a c7599a = new C7599a();
            this.f94a = c7599a;
            c7599a.setDaemon(this.b);
            this.f96a = false;
            this.f94a.start();
        }
        this.f94a.a(abstractC7600b);
    }

    public void a(AbstractC7600b abstractC7600b, long j) {
        this.f93a.postDelayed(new aq(this, abstractC7600b), j);
    }
}
