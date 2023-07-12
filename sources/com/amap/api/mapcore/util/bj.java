package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class bj {
    private static bj a;
    private jj b;
    private LinkedHashMap<String, jk> c = new LinkedHashMap<>();
    private boolean d = true;

    private bj(boolean z, int i) {
        if (z) {
            try {
                this.b = jj.a(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static bj a(int i) {
        return a(true, i);
    }

    public static void c() {
        a = null;
    }

    public void b() {
        a();
        jj.a();
        this.b = null;
        c();
    }

    private static synchronized bj a(boolean z, int i) {
        bj bjVar;
        synchronized (bj.class) {
            try {
                bj bjVar2 = a;
                if (bjVar2 == null) {
                    a = new bj(z, i);
                } else if (z && bjVar2.b == null) {
                    bjVar2.b = jj.a(i);
                }
                bjVar = a;
            }
        }
        return bjVar;
    }

    public void b(bi biVar) {
        bf bfVar = (bf) this.c.get(biVar.b());
        if (bfVar != null) {
            synchronized (this.c) {
                bfVar.b();
                this.c.remove(biVar.b());
            }
        }
    }

    public void a() {
        synchronized (this.c) {
            if (this.c.size() < 1) {
                return;
            }
            for (Map.Entry<String, jk> entry : this.c.entrySet()) {
                entry.getKey();
                ((bf) entry.getValue()).a();
            }
            this.c.clear();
        }
    }

    public void a(bi biVar) {
        synchronized (this.c) {
            bf bfVar = (bf) this.c.get(biVar.b());
            if (bfVar == null) {
                return;
            }
            bfVar.a();
            this.c.remove(biVar.b());
        }
    }

    public void a(bi biVar, Context context, AMap aMap) throws gb {
        if (!this.c.containsKey(biVar.b())) {
            bf bfVar = new bf((bz) biVar, context.getApplicationContext(), aMap);
            synchronized (this.c) {
                this.c.put(biVar.b(), bfVar);
            }
        }
        this.b.a(this.c.get(biVar.b()));
    }
}
