package com.meizu.cloud.pushsdk.d.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class a {
    protected final Context a;
    protected final f b;
    protected final int c;
    protected final int d;
    protected final int e;
    protected final TimeUnit f;
    protected final AtomicBoolean g;
    private final String h;
    private final com.meizu.cloud.pushsdk.c.c.g i;
    private Uri.Builder j;
    private d k;
    private b l;
    private h m;
    private final SSLSocketFactory n;
    private final HostnameVerifier o;
    private String p;
    private final long q;
    private final long r;
    private final com.meizu.cloud.pushsdk.c.c.a s;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0261a {
        protected final String a;
        protected final Context b;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;
        protected f c = null;
        protected d d = d.POST;
        protected b e = b.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected com.meizu.cloud.pushsdk.c.c.a o = new com.meizu.cloud.pushsdk.c.c.e();

        public C0261a(String str, Context context, Class<? extends a> cls) {
            this.a = str;
            this.b = context;
        }

        public C0261a a(int i) {
            this.g = i;
            return this;
        }

        public C0261a a(com.meizu.cloud.pushsdk.c.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                String simpleName = C0261a.class.getSimpleName();
                com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "set new call " + aVar, new Object[0]);
            }
            return this;
        }

        public C0261a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public C0261a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public C0261a b(int i) {
            this.h = i;
            return this;
        }

        public C0261a c(int i) {
            this.i = i;
            return this;
        }
    }

    public a(C0261a c0261a) {
        String simpleName = a.class.getSimpleName();
        this.h = simpleName;
        this.i = com.meizu.cloud.pushsdk.c.c.g.a("application/json; charset=utf-8");
        this.g = new AtomicBoolean(false);
        this.k = c0261a.d;
        this.b = c0261a.c;
        this.a = c0261a.b;
        this.l = c0261a.e;
        this.m = c0261a.f;
        this.n = c0261a.m;
        this.o = c0261a.n;
        this.c = c0261a.g;
        this.d = c0261a.i;
        this.e = c0261a.h;
        this.q = c0261a.j;
        this.r = c0261a.k;
        this.p = c0261a.a;
        this.f = c0261a.l;
        this.s = c0261a.o;
        c();
        com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        a(aVar, "");
        this.j.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.j.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.j.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.meizu.cloud.pushsdk.d.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        com.meizu.cloud.pushsdk.d.a.b bVar = new com.meizu.cloud.pushsdk.d.a.b("push_group_data", arrayList2);
        String str = this.h;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "final SelfDescribingJson " + bVar, new Object[0]);
        String uri = this.j.build().toString();
        return new i.a().a(uri).a(j.a(this.i, bVar.toString())).c();
    }

    private void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception unused) {
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Unable to close source data", new Object[0]);
            }
        }
    }

    private void a(com.meizu.cloud.pushsdk.d.a.a aVar, String str) {
        if ("".equals(str)) {
            str = com.meizu.cloud.pushsdk.d.f.e.a();
        }
        aVar.a(WPKFactory.CONF_SERVER_TIME, str);
    }

    private void c() {
        StringBuilder sb;
        String str;
        String str2 = this.h;
        com.meizu.cloud.pushsdk.d.f.c.a(str2, "security " + this.m, new Object[0]);
        if (this.m == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.j = Uri.parse(sb.toString()).buildUpon();
        if (this.k == d.GET) {
            this.j.appendPath("i");
        } else {
            this.j.appendEncodedPath("push_data_report/mobile");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(i iVar) {
        k kVar = null;
        try {
            com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Sending request: %s", iVar);
            kVar = this.s.a(iVar);
            return kVar.a();
        } catch (IOException e) {
            com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request sending failed: %s", Log.getStackTraceString(e));
            return -1;
        } finally {
            a(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<e> a(c cVar) {
        int size = cVar.a().size();
        LinkedList<Long> b = cVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        long j = 22;
        if (this.k == d.GET) {
            for (int i = 0; i < size; i++) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(b.get(i));
                com.meizu.cloud.pushsdk.d.a.a aVar = cVar.a().get(i);
                linkedList.add(new e(aVar.b() + 22 > this.q, a(aVar), linkedList2));
            }
        } else {
            int i2 = 0;
            while (i2 < size) {
                LinkedList linkedList3 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList = new ArrayList<>();
                long j2 = 0;
                int i3 = i2;
                while (i3 < this.l.a() + i2 && i3 < size) {
                    com.meizu.cloud.pushsdk.d.a.a aVar2 = cVar.a().get(i3);
                    long b2 = aVar2.b() + j;
                    if (b2 + 88 > this.r) {
                        ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList4 = new LinkedList();
                        arrayList2.add(aVar2);
                        linkedList4.add(b.get(i3));
                        linkedList.add(new e(true, a(arrayList2), linkedList4));
                    } else {
                        j2 += b2;
                        if (j2 + 88 + (arrayList.size() - 1) > this.r) {
                            linkedList.add(new e(false, a(arrayList), linkedList3));
                            ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList3 = new ArrayList<>();
                            LinkedList linkedList5 = new LinkedList();
                            arrayList3.add(aVar2);
                            linkedList5.add(b.get(i3));
                            arrayList = arrayList3;
                            linkedList3 = linkedList5;
                            j2 = b2;
                        } else {
                            arrayList.add(aVar2);
                            linkedList3.add(b.get(i3));
                        }
                    }
                    i3++;
                    j = 22;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList3));
                }
                i2 += this.l.a();
                j = 22;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.j.clearQuery().build().toString();
    }
}
