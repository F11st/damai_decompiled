package com.alibaba.wireless.security.aopsdk.e;

import com.alibaba.wireless.security.aopsdk.e.f.e;
import com.alibaba.wireless.security.aopsdk.e.f.f;
import com.alibaba.wireless.security.aopsdk.e.f.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: RuleManager.java */
/* loaded from: classes.dex */
public class d implements Observer {
    private static d c = null;
    private static final String d = "AOP-RULE";
    public Map<String, List<b>> a = new HashMap();
    private g b;

    /* compiled from: RuleManager.java */
    /* loaded from: classes.dex */
    public class a {
        public int a;
        public e b;

        public a(int i, e eVar) {
            com.alibaba.wireless.security.aopsdk.e.f.c cVar;
            this.a = i;
            this.b = eVar;
            if (d.this.b != null && (cVar = d.this.b.f) != null) {
                if (eVar.g == -1) {
                    eVar.g = cVar.g;
                }
                if (eVar.f == -1) {
                    eVar.f = cVar.f;
                }
                if (eVar.i == -1) {
                    eVar.i = cVar.i;
                }
                if (eVar.h == -1) {
                    eVar.h = cVar.h;
                }
            }
        }
    }

    /* compiled from: RuleManager.java */
    /* loaded from: classes.dex */
    public static class b {
        public int a;
        public List<a> b;

        public b(int i, List<a> list) {
            this.a = i;
            this.b = list;
        }
    }

    private d() {
    }

    public Map<String, List<b>> b() {
        return this.a;
    }

    public g c() {
        return this.b;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        g gVar = (g) obj;
        this.b = gVar;
        com.alibaba.wireless.security.aopsdk.i.a.b(d, "top level config updated");
        if (gVar.g != null) {
            HashMap hashMap = new HashMap();
            for (com.alibaba.wireless.security.aopsdk.e.f.d dVar : gVar.g) {
                String str = dVar.d;
                ArrayList arrayList = new ArrayList();
                for (f fVar : dVar.e) {
                    arrayList.add(new b(fVar.d, a(fVar)));
                }
                hashMap.put(str, arrayList);
            }
            this.a = hashMap;
            com.alibaba.wireless.security.aopsdk.i.a.b(d, "Strategy map updated with " + this.a.size() + " proxies");
            return;
        }
        this.a = new HashMap();
        com.alibaba.wireless.security.aopsdk.i.a.b(d, "startegy map update to empty");
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (c == null) {
                c = new d();
            }
            dVar = c;
        }
        return dVar;
    }

    private List<a> a(f fVar) {
        ArrayList arrayList = new ArrayList();
        for (e eVar : fVar.e) {
            arrayList.add(new a(eVar.m, eVar));
        }
        return arrayList;
    }

    public List<b> a(String str) {
        return this.a.get(str);
    }
}
