package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class jh {
    jh a;

    public jh() {
    }

    private boolean d() {
        jh jhVar = this.a;
        if (jhVar != null) {
            return jhVar.c();
        }
        return true;
    }

    public void a(boolean z) {
        jh jhVar = this.a;
        if (jhVar != null) {
            jhVar.a(z);
        }
    }

    protected abstract boolean a();

    public int b() {
        jh jhVar = this.a;
        return Math.min(Integer.MAX_VALUE, jhVar != null ? jhVar.b() : Integer.MAX_VALUE);
    }

    public boolean c() {
        if (d()) {
            return a();
        }
        return false;
    }

    public jh(jh jhVar) {
        this.a = jhVar;
    }

    public void a(int i) {
        jh jhVar = this.a;
        if (jhVar != null) {
            jhVar.a(i);
        }
    }
}
