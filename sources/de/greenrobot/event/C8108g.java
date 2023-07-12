package de.greenrobot.event;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: de.greenrobot.event.g */
/* loaded from: classes3.dex */
public final class C8108g {
    final Object a;
    final C8106e b;
    final int c;
    volatile boolean d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8108g(Object obj, C8106e c8106e, int i) {
        this.a = obj;
        this.b = c8106e;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C8108g) {
            C8108g c8108g = (C8108g) obj;
            return this.a == c8108g.a && this.b.equals(c8108g.b);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.d.hashCode();
    }
}
