package de.greenrobot.event;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class g {
    final Object a;
    final e b;
    final int c;
    volatile boolean d = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Object obj, e eVar, int i) {
        this.a = obj;
        this.b = eVar;
        this.c = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a == gVar.a && this.b.equals(gVar.b);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.d.hashCode();
    }
}
