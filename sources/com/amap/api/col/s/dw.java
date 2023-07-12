package com.amap.api.col.s;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dw extends ea {
    private int a;
    private String b;

    public dw(String str, ea eaVar) {
        super(eaVar);
        this.a = 30;
        this.b = str;
    }

    @Override // com.amap.api.col.s.ea
    protected final boolean a() {
        return a(this.b) >= this.a;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            cl.c(th, "fus", "gfn");
            return 0;
        }
    }
}
