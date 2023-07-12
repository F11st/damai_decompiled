package com.amap.api.mapcore.util;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class jd extends jh {
    private int b;
    private String c;

    public jd(int i, String str, jh jhVar) {
        super(jhVar);
        this.b = i;
        this.c = str;
    }

    @Override // com.amap.api.mapcore.util.jh
    protected boolean a() {
        return a(this.c) >= this.b;
    }

    public int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            hd.c(th, "fus", "gfn");
            return 0;
        }
    }
}
