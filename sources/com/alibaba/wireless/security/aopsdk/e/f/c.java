package com.alibaba.wireless.security.aopsdk.e.f;

import org.json.JSONObject;

/* compiled from: ExecutionConfig.java */
/* loaded from: classes.dex */
public class c extends a {
    private static final int l = 1000;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "dh", type = com.alibaba.wireless.security.aopsdk.e.e.b.STRING)
    public String j;
    public int d = 0;
    private final Object e = new Object();
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "sr", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int f = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "ir", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int g = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "nr", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int h = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "tr", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int i = -1;
    @com.alibaba.wireless.security.aopsdk.e.e.a(key = "rs", type = com.alibaba.wireless.security.aopsdk.e.e.b.INT)
    public int k = -1;

    @Override // com.alibaba.wireless.security.aopsdk.e.f.a
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
        String str = this.j;
        if (str != null) {
            if (com.alibaba.wireless.security.aopsdk.e.g.a.b(str)) {
                int i = this.f;
                if (i == -1) {
                    i = 1000;
                }
                this.f = i;
            } else {
                this.f = Integer.MAX_VALUE;
            }
        }
        int i2 = this.f;
        this.f = i2 != -1 ? i2 : 1000;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        boolean z = false;
        synchronized (this.e) {
            int i = this.f;
            if (i > 0) {
                int i2 = this.d + 1;
                this.d = i2;
                if (i2 >= i) {
                    this.d = i2 - i;
                    z = true;
                }
            }
        }
        return z;
    }
}
