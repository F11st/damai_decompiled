package com.xiaomi.push;

import android.os.SystemClock;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class fw {
    private static final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f395a;

    /* renamed from: a  reason: collision with other field name */
    protected fx f398a;

    /* renamed from: a  reason: collision with other field name */
    protected XMPushService f400a;

    /* renamed from: a  reason: collision with other field name */
    protected int f396a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected long f397a = -1;

    /* renamed from: b  reason: collision with other field name */
    protected volatile long f405b = 0;

    /* renamed from: c  reason: collision with other field name */
    protected volatile long f408c = 0;

    /* renamed from: a  reason: collision with other field name */
    private LinkedList<Pair<Integer, Long>> f403a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<fz> f402a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    protected final Map<gb, C7660a> f404a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with other field name */
    protected final Map<gb, C7660a> f407b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    protected gi f399a = null;

    /* renamed from: a  reason: collision with other field name */
    protected String f401a = "";

    /* renamed from: b  reason: collision with other field name */
    protected String f406b = "";
    private int c = 2;
    protected final int b = a.getAndIncrement();
    private long e = 0;
    protected long d = 0;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.fw$a */
    /* loaded from: classes11.dex */
    public static class C7660a {
        private gb a;

        /* renamed from: a  reason: collision with other field name */
        private gj f409a;

        public C7660a(gb gbVar, gj gjVar) {
            this.a = gbVar;
            this.f409a = gjVar;
        }

        public void a(fl flVar) {
            this.a.a(flVar);
        }

        public void a(gn gnVar) {
            gj gjVar = this.f409a;
            if (gjVar == null || gjVar.mo906a(gnVar)) {
                this.a.a(gnVar);
            }
        }
    }

    static {
        f395a = false;
        try {
            f395a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        C7662gc.m919a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public fw(XMPushService xMPushService, fx fxVar) {
        this.f398a = fxVar;
        this.f400a = xMPushService;
        m913b();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m907a(int i) {
        synchronized (this.f403a) {
            if (i == 1) {
                this.f403a.clear();
            } else {
                this.f403a.add(new Pair<>(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f403a.size() > 6) {
                    this.f403a.remove(0);
                }
            }
        }
    }

    public int a() {
        return this.f396a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m908a() {
        return this.f408c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fx m909a() {
        return this.f398a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String mo910a() {
        return this.f398a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a  reason: collision with other method in class */
    public Map<gb, C7660a> m911a() {
        return this.f404a;
    }

    public void a(int i, int i2, Exception exc) {
        int i3 = this.c;
        if (i != i3) {
            AbstractC7535b.m586a(String.format("update the connection status. %1$s -> %2$s : %3$s ", a(i3), a(i), com.xiaomi.push.service.bk.a(i2)));
        }
        if (bj.b(this.f400a)) {
            m907a(i);
        }
        if (i == 1) {
            this.f400a.a(10);
            if (this.c != 0) {
                AbstractC7535b.m586a("try set connected while not connecting.");
            }
            this.c = i;
            for (fz fzVar : this.f402a) {
                fzVar.b(this);
            }
        } else if (i == 0) {
            if (this.c != 2) {
                AbstractC7535b.m586a("try set connecting while not disconnected.");
            }
            this.c = i;
            for (fz fzVar2 : this.f402a) {
                fzVar2.a(this);
            }
        } else if (i == 2) {
            this.f400a.a(10);
            int i4 = this.c;
            if (i4 == 0) {
                for (fz fzVar3 : this.f402a) {
                    fzVar3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (fz fzVar4 : this.f402a) {
                    fzVar4.a(this, i2, exc);
                }
            }
            this.c = i;
        }
    }

    public void a(fz fzVar) {
        if (fzVar == null || this.f402a.contains(fzVar)) {
            return;
        }
        this.f402a.add(fzVar);
    }

    public void a(gb gbVar, gj gjVar) {
        Objects.requireNonNull(gbVar, "Packet listener is null.");
        this.f404a.put(gbVar, new C7660a(gbVar, gjVar));
    }

    public abstract void a(gn gnVar);

    public abstract void a(bg.C7737b c7737b);

    public synchronized void a(String str) {
        if (this.c == 0) {
            AbstractC7535b.m586a("setChallenge hash = " + bo.a(str).substring(0, 8));
            this.f401a = str;
            a(1, 0, null);
        } else {
            AbstractC7535b.m586a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(fl[] flVarArr);

    /* renamed from: a */
    public boolean mo902a() {
        return false;
    }

    public synchronized boolean a(long j) {
        return this.e >= j;
    }

    public int b() {
        return this.c;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m912b() {
        return this.f398a.b();
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m913b() {
        String str;
        if (this.f398a.m917a() && this.f399a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f399a = new fu(this);
                return;
            }
            try {
                this.f399a = (gi) cls.getConstructor(fw.class, Writer.class, Reader.class).newInstance(this);
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    public abstract void b(int i, Exception exc);

    public abstract void b(fl flVar);

    public void b(fz fzVar) {
        this.f402a.remove(fzVar);
    }

    public void b(gb gbVar, gj gjVar) {
        Objects.requireNonNull(gbVar, "Packet listener is null.");
        this.f407b.put(gbVar, new C7660a(gbVar, gjVar));
    }

    public abstract void b(boolean z);

    /* renamed from: b  reason: collision with other method in class */
    public boolean m914b() {
        return this.c == 0;
    }

    public synchronized void c() {
        this.e = SystemClock.elapsedRealtime();
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m915c() {
        return this.c == 1;
    }

    public void d() {
        synchronized (this.f403a) {
            this.f403a.clear();
        }
    }
}
