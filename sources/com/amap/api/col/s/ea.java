package com.amap.api.col.s;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ea {
    ea c;

    public ea() {
    }

    public void a(boolean z) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.a(z);
        }
    }

    protected abstract boolean a();

    public int b() {
        ea eaVar = this.c;
        return Math.min(Integer.MAX_VALUE, eaVar != null ? eaVar.b() : Integer.MAX_VALUE);
    }

    public final boolean c() {
        ea eaVar = this.c;
        if (eaVar != null ? eaVar.c() : true) {
            return a();
        }
        return false;
    }

    public ea(ea eaVar) {
        this.c = eaVar;
    }

    public void a(int i) {
        ea eaVar = this.c;
        if (eaVar != null) {
            eaVar.a(i);
        }
    }
}
