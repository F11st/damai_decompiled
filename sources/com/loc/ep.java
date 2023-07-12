package com.loc;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ep<T> {
    public String a;
    private File b;
    private Handler e;
    private String f;
    private boolean g;
    private boolean c = false;
    private Map<String, C5829b> d = new ConcurrentHashMap();
    private Runnable h = new Runnable() { // from class: com.loc.ep.2
        @Override // java.lang.Runnable
        public final void run() {
            if (ep.this.c) {
                if (ep.this.g) {
                    ep.this.s();
                    ep.t(ep.this);
                }
                if (ep.this.e != null) {
                    ep.this.e.postDelayed(ep.this.h, DateUtils.MILLIS_PER_MINUTE);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.ep$a */
    /* loaded from: classes10.dex */
    public final class C5828a implements Comparator<String> {
        C5828a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return ep.a(((C5829b) ep.this.d.get(str2)).c, ((C5829b) ep.this.d.get(str)).c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.ep$b */
    /* loaded from: classes10.dex */
    public static class C5829b {
        int a;
        long b;
        long c;

        public C5829b(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }
    }

    public ep(Context context, String str, Handler handler) {
        this.f = null;
        if (context == null) {
            return;
        }
        this.e = handler;
        this.a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f = m1.e0(context);
        try {
            this.b = new File(context.getFilesDir().getPath(), this.a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        p();
    }

    public static int a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    private void j(T t, long j) {
        if (t == null || o(t) < 0) {
            return;
        }
        String i = i(t);
        C5829b c5829b = this.d.get(i);
        if (c5829b == null) {
            e(t, j);
            this.d.put(i, new C5829b(l(t), o(t), j));
            this.g = true;
            return;
        }
        c5829b.c = j;
        if (c5829b.a == l(t)) {
            e(t, c5829b.b);
            return;
        }
        e(t, j);
        c5829b.a = l(t);
        c5829b.b = o(t);
        this.g = true;
    }

    private void p() {
        try {
            for (String str : m1.l(this.b)) {
                String[] split = new String(e1.h(p1.g(str), this.f), "UTF-8").split(",");
                this.d.put(split[0], new C5829b(Integer.parseInt(split[1]), Long.parseLong(split[2]), split.length >= 4 ? Long.parseLong(split[3]) : m1.B()));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (m() > 0) {
            this.d.size();
            if (h() > 0) {
                long B = m1.B();
                Iterator<Map.Entry<String, C5829b>> it = this.d.entrySet().iterator();
                while (it.hasNext()) {
                    if (B - this.d.get(it.next().getKey()).c > h()) {
                        it.remove();
                    }
                }
            }
            if (this.d.size() > m()) {
                ArrayList arrayList = new ArrayList(this.d.keySet());
                Collections.sort(arrayList, new C5828a());
                for (int m = (int) m(); m < arrayList.size(); m++) {
                    this.d.remove(arrayList.get(m));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, C5829b> entry : this.d.entrySet()) {
            String str = entry.getKey() + "," + entry.getValue().a + "," + entry.getValue().b + "," + entry.getValue().c;
            try {
                sb.append(p1.f(e1.e(str.getBytes("UTF-8"), this.f)) + StringUtils.LF);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        m1.m(this.b, sb2);
    }

    static /* synthetic */ boolean t(ep epVar) {
        epVar.g = false;
        return false;
    }

    public final void c() {
        Handler handler;
        if (!this.c && (handler = this.e) != null) {
            handler.removeCallbacks(this.h);
            this.e.postDelayed(this.h, DateUtils.MILLIS_PER_MINUTE);
        }
        this.c = true;
    }

    public final void d(T t) {
        j(t, m1.B());
    }

    abstract void e(T t, long j);

    public final void f(List<T> list) {
        long B = m1.B();
        for (T t : list) {
            j(t, B);
        }
        if (this.d.size() >= list.size()) {
            this.g = true;
        }
        if (this.d.size() > 16384 || m() <= 0) {
            this.d.clear();
            for (T t2 : list) {
                this.d.put(i(t2), new C5829b(l(t2), o(t2), B));
            }
        }
    }

    public final void g(boolean z) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        if (!z) {
            this.h.run();
        }
        this.c = false;
    }

    abstract long h();

    public abstract String i(T t);

    abstract int l(T t);

    abstract long m();

    abstract long o(T t);

    public final long r(T t) {
        return (m1.B() - o(t)) / 1000;
    }
}
