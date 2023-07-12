package com.baseproject.utils.speedtest;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baseproject.utils.speedtest.C4666a;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.b.a.C7892a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.b63;
import tb.l83;
import tb.n83;
import tb.z63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SpeedTestRequest {
    private static final String q = "SpeedTestRequest";
    private volatile boolean a;
    private Worker[] c;
    private C4664c d;
    private Foreman e;
    private ScheduledExecutorService f;
    private long h;
    private long[] i;
    private C4666a.C4667a j;
    private C4666a k;
    private InterfaceC4662a l;
    private int m;
    private int n;
    private volatile l83 p;
    private List<b63> b = Collections.synchronizedList(new LinkedList());
    private LinkedBlockingQueue<Runnable> g = new LinkedBlockingQueue<>();
    private Object o = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class Foreman implements Runnable {
        Foreman() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpeedTestRequest.this.a) {
                return;
            }
            SpeedTestRequest.this.a = true;
            l83 l83Var = new l83();
            l83Var.b = SpeedTestRequest.this.k.b;
            int unused = SpeedTestRequest.this.m;
            int unused2 = SpeedTestRequest.this.n;
            l83Var.c = "" + SpeedTestRequest.this.k.c;
            String str = SpeedTestRequest.this.k.a;
            l83Var.d = SpeedTestRequest.this.j.f;
            l83Var.e = SpeedTestRequest.this.j.a;
            l83Var.f = SpeedTestRequest.this.j.b;
            l83Var.g = SpeedTestRequest.this.j.d;
            int i = SpeedTestRequest.this.j.e;
            l83Var.p = SpeedTestRequest.this.j.g;
            l83Var.i = (b63[]) SpeedTestRequest.this.b.toArray(new b63[SpeedTestRequest.this.b.size()]);
            for (int i2 = 0; i2 < SpeedTestRequest.this.j.e; i2++) {
                SpeedTestRequest.this.h += SpeedTestRequest.this.i[i2];
            }
            l83Var.h = ((SpeedTestRequest.this.h / 1000) * 8) / SpeedTestRequest.this.j.d;
            if (SpeedTestRequest.this.l != null) {
                SpeedTestRequest.this.l.a(l83Var);
            }
            SpeedTestRequest.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class HttpWorker extends Worker {
        public HttpWorker(int i) {
            super(i);
        }

        @Override // java.lang.Runnable
        public void run() {
            int read;
            String str = SpeedTestRequest.q;
            C7892a.a(str, "worker[" + this.index + "] start working for task " + SpeedTestRequest.this.j.f);
            while (!SpeedTestRequest.this.a) {
                HttpURLConnection httpURLConnection = null;
                b63 b63Var = new b63();
                try {
                    try {
                        URL url = new URL(SpeedTestRequest.this.j.a);
                        String host = url.getHost();
                        String a = TextUtils.isEmpty(SpeedTestRequest.this.j.b) ? C4669f.a(host) : SpeedTestRequest.this.j.b;
                        httpURLConnection = (HttpURLConnection) (a.contains(":") ? new URL(SpeedTestRequest.this.j.a).openConnection() : new URL(SpeedTestRequest.this.j.a.replaceFirst(host, a)).openConnection());
                        httpURLConnection.setConnectTimeout(this.mConnectTimeout);
                        httpURLConnection.setReadTimeout(this.mReadTiemout);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        if (url.getProtocol().equals("https")) {
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new n83());
                        }
                        httpURLConnection.setRequestProperty(BizTime.HOST, TextUtils.isEmpty(SpeedTestRequest.this.j.c) ? url.getHost() : SpeedTestRequest.this.j.c);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        httpURLConnection.connect();
                        b63Var.b = SystemClock.elapsedRealtime() - elapsedRealtime;
                        b63Var.a = httpURLConnection.getResponseCode();
                        if (!SpeedTestRequest.this.a) {
                            SpeedTestRequest.this.b.add(b63Var);
                        }
                        String str2 = SpeedTestRequest.q;
                        C7892a.a(str2, "tcp_conn_time:" + b63Var.b);
                        String str3 = SpeedTestRequest.q;
                        C7892a.a(str3, "status_code:" + b63Var.a);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        byte[] bArr = new byte[128];
                        while (!SpeedTestRequest.this.a && (read = inputStream.read(bArr)) > 0) {
                            long[] jArr = SpeedTestRequest.this.i;
                            int i = this.index;
                            jArr[i] = jArr[i] + read;
                        }
                        C7892a.a(SpeedTestRequest.q, "read data complete");
                    } catch (IOException e) {
                        b63Var.a = -99;
                        if (!SpeedTestRequest.this.a && !SpeedTestRequest.this.b.isEmpty()) {
                            SpeedTestRequest.this.b.set(SpeedTestRequest.this.b.size() - 1, b63Var);
                        }
                        e.printStackTrace();
                        if (0 != 0) {
                        }
                    }
                    httpURLConnection.disconnect();
                } catch (Throwable th) {
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public abstract class Worker implements Runnable {
        protected int index;
        protected int mConnectTimeout = 10000;
        protected int mReadTiemout = 10000;

        public Worker() {
        }

        public Worker(int i) {
            this.index = i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.baseproject.utils.speedtest.SpeedTestRequest$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4662a {
        void a(l83 l83Var);
    }

    /* compiled from: Taobao */
    /* renamed from: com.baseproject.utils.speedtest.SpeedTestRequest$b */
    /* loaded from: classes10.dex */
    class C4663b implements InterfaceC4662a {
        C4663b() {
        }

        @Override // com.baseproject.utils.speedtest.SpeedTestRequest.InterfaceC4662a
        public void a(l83 l83Var) {
            C7892a.a(SpeedTestRequest.q, "sync exec finish normally!");
            SpeedTestRequest.this.p = l83Var;
            SpeedTestRequest.this.o.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.baseproject.utils.speedtest.SpeedTestRequest$c */
    /* loaded from: classes10.dex */
    public class C4664c extends ThreadPoolExecutor {

        /* compiled from: Taobao */
        /* renamed from: com.baseproject.utils.speedtest.SpeedTestRequest$c$a */
        /* loaded from: classes10.dex */
        class ThreadFactoryC4665a implements ThreadFactory {
            ThreadFactoryC4665a(SpeedTestRequest speedTestRequest) {
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        }

        public C4664c(SpeedTestRequest speedTestRequest, int i) {
            super(i, i, 0L, TimeUnit.SECONDS, speedTestRequest.g, new ThreadFactoryC4665a(speedTestRequest));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th) {
            C7892a.a(SpeedTestRequest.q, "afterExecute ");
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            String str = SpeedTestRequest.q;
            C7892a.a(str, "beforeExecute " + thread.getName());
        }
    }

    public SpeedTestRequest(Context context, C4666a c4666a, C4666a.C4667a c4667a, int i, int i2) {
        this.k = c4666a;
        this.j = c4667a;
        this.b.clear();
        this.f = Executors.newSingleThreadScheduledExecutor();
        this.e = new Foreman();
        this.d = new C4664c(this, c4667a.e);
        int i3 = c4667a.e;
        this.c = new Worker[i3];
        this.i = new long[i3];
        this.m = i;
        this.n = i2;
    }

    private void o() {
        for (int i = 0; i < this.c.length; i++) {
            if (this.j.g == z63.a) {
                AdapterForTLog.loge("SpeedTest", "use quic");
                this.c[i] = new HttpWorker(i);
            } else {
                AdapterForTLog.loge("SpeedTest", "use http");
                this.c[i] = new HttpWorker(i);
            }
            this.d.execute(this.c[i]);
        }
    }

    public void d() {
        C7892a.a(q, "exec");
        this.a = false;
        this.h = 0L;
        o();
        this.f.schedule(this.e, this.j.d, TimeUnit.SECONDS);
    }

    public void e(InterfaceC4662a interfaceC4662a) {
        this.l = interfaceC4662a;
    }

    public l83 h() {
        this.p = null;
        e(new C4663b());
        d();
        try {
            synchronized (this.o) {
                this.o.wait((this.j.d * 1000) + 2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.p;
    }

    public void j() {
        this.a = true;
        this.d.shutdown();
        this.f.shutdown();
    }

    public boolean k() {
        return !this.a;
    }
}
