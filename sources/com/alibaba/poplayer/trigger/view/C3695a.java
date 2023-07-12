package com.alibaba.poplayer.trigger.view;

import java.util.Collection;
import java.util.LinkedHashSet;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.trigger.view.a */
/* loaded from: classes8.dex */
class C3695a<T> {
    private Collection<T> b;
    private boolean d;
    private Collection<T> a = new LinkedHashSet();
    private final C3696a<T> c = new C3696a<>();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.view.a$a */
    /* loaded from: classes8.dex */
    static class C3696a<T> {
        Collection<T> a;
        private int b;

        C3696a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Collection<T> b() {
            return this.a;
        }
    }

    private Collection<T> c() {
        if (this.d) {
            if (this.b == null) {
                this.b = new LinkedHashSet(this.a);
            }
            return this.b;
        }
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(T t) {
        Collection<T> c = c();
        if (c.contains(t)) {
            return;
        }
        c.add(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.d) {
            this.d = false;
            Collection<T> collection = this.b;
            if (collection != null) {
                this.a = collection;
                this.c.a.clear();
                ((C3696a) this.c).b = 0;
            }
            this.b = null;
            return;
        }
        throw new IllegalStateException("Iteration not started");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(T t) {
        c().remove(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return c().size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3696a<T> f() {
        if (!this.d) {
            this.d = true;
            this.b = null;
            C3696a<T> c3696a = this.c;
            Collection<T> collection = this.a;
            c3696a.a = collection;
            ((C3696a) c3696a).b = collection.size();
            return this.c;
        }
        throw new IllegalStateException("Iteration already started");
    }
}
