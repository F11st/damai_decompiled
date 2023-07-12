package com.amap.api.col.s;

import com.amap.api.col.s.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class af {
    private boolean a = true;
    private long b = 86400;
    private int c = 10;
    private long d = 0;
    private final LinkedHashMap<ae.b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<ae.b, Object> g = new LinkedHashMap<>();
    private final Object h = new Object();
    private ArrayList<String> i = new ArrayList<>();

    public af(String... strArr) {
        a(strArr);
    }

    private void a(String... strArr) {
        this.d = System.currentTimeMillis();
        this.e.clear();
        this.i.clear();
        for (String str : strArr) {
            if (str != null) {
                this.i.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.get(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object c(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return null;
        }
        return linkedHashMap.remove(bVar);
    }

    private void b(ae.b bVar, Object obj) {
        synchronized (this.f) {
            a();
            b();
            this.e.put(bVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        if (linkedHashMap == null || bVar == null) {
            return false;
        }
        return linkedHashMap.containsKey(bVar);
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    public final ae.c a(ae.b bVar) {
        if (this.a && bVar != null && b(bVar)) {
            b();
            synchronized (this.f) {
                if (a(this.e, bVar)) {
                    return new ae.c(b(this.e, bVar), true);
                }
                synchronized (this.h) {
                    if (a(this.g, bVar)) {
                        while (!a(this.e, bVar) && a(this.g, bVar)) {
                            try {
                                this.h.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.g.put(bVar, null);
                    }
                }
                return new ae.c(b(this.e, bVar), false);
            }
        }
        return null;
    }

    public final boolean b(ae.b bVar) {
        if (bVar != null && bVar.a != null) {
            Iterator<String> it = this.i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && bVar.a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(ae.b bVar, Object obj) {
        if (this.a && bVar != null && b(bVar)) {
            b(bVar, obj);
            synchronized (this.h) {
                c(this.g, bVar);
                this.h.notify();
            }
        }
    }

    private void a() {
        int size = this.e.size();
        if (size <= 0 || size < this.c) {
            return;
        }
        ae.b bVar = null;
        Iterator<ae.b> it = this.e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ae.b next = it.next();
            if (next != null) {
                bVar = next;
                break;
            }
        }
        c(this.e, bVar);
    }

    public void a(ae.a aVar) {
        if (aVar != null) {
            this.a = aVar.a();
            this.b = aVar.b();
            this.c = aVar.c();
        }
    }
}
