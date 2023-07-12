package com.amap.api.col.s;

import com.amap.api.col.s.C4373ae;
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
    private final LinkedHashMap<C4373ae.C4375b, Object> e = new LinkedHashMap<>();
    private final Object f = new Object();
    private final LinkedHashMap<C4373ae.C4375b, Object> g = new LinkedHashMap<>();
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
    public Object b(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        if (linkedHashMap == null || c4375b == null) {
            return null;
        }
        return linkedHashMap.get(c4375b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object c(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        if (linkedHashMap == null || c4375b == null) {
            return null;
        }
        return linkedHashMap.remove(c4375b);
    }

    private void b(C4373ae.C4375b c4375b, Object obj) {
        synchronized (this.f) {
            a();
            b();
            this.e.put(c4375b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        if (linkedHashMap == null || c4375b == null) {
            return false;
        }
        return linkedHashMap.containsKey(c4375b);
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if ((currentTimeMillis - this.d) / 1000 > this.b) {
            this.e.clear();
            this.d = currentTimeMillis;
        }
    }

    public final C4373ae.C4376c a(C4373ae.C4375b c4375b) {
        if (this.a && c4375b != null && b(c4375b)) {
            b();
            synchronized (this.f) {
                if (a(this.e, c4375b)) {
                    return new C4373ae.C4376c(b(this.e, c4375b), true);
                }
                synchronized (this.h) {
                    if (a(this.g, c4375b)) {
                        while (!a(this.e, c4375b) && a(this.g, c4375b)) {
                            try {
                                this.h.wait(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        this.g.put(c4375b, null);
                    }
                }
                return new C4373ae.C4376c(b(this.e, c4375b), false);
            }
        }
        return null;
    }

    public final boolean b(C4373ae.C4375b c4375b) {
        if (c4375b != null && c4375b.a != null) {
            Iterator<String> it = this.i.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && c4375b.a.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(C4373ae.C4375b c4375b, Object obj) {
        if (this.a && c4375b != null && b(c4375b)) {
            b(c4375b, obj);
            synchronized (this.h) {
                c(this.g, c4375b);
                this.h.notify();
            }
        }
    }

    private void a() {
        int size = this.e.size();
        if (size <= 0 || size < this.c) {
            return;
        }
        C4373ae.C4375b c4375b = null;
        Iterator<C4373ae.C4375b> it = this.e.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C4373ae.C4375b next = it.next();
            if (next != null) {
                c4375b = next;
                break;
            }
        }
        c(this.e, c4375b);
    }

    public void a(C4373ae.C4374a c4374a) {
        if (c4374a != null) {
            this.a = c4374a.a();
            this.b = c4374a.b();
            this.c = c4374a.c();
        }
    }
}
