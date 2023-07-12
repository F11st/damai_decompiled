package com.alibaba.wireless.security.aopsdk.e.f;

import com.alibaba.wireless.security.aopsdk.e.e.AopAttribute;
import com.alibaba.wireless.security.aopsdk.e.e.AopAttributeType;
import com.alibaba.wireless.security.aopsdk.e.g.UtdidHashUtils;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.f.c */
/* loaded from: classes.dex */
public class ExecutionConfig extends BaseAopConfig {
    private static final int l = 1000;
    @AopAttribute(key = "dh", type = AopAttributeType.STRING)
    public String j;
    public int d = 0;
    private final Object e = new Object();
    @AopAttribute(key = "sr", type = AopAttributeType.INT)
    public int f = -1;
    @AopAttribute(key = "ir", type = AopAttributeType.INT)
    public int g = -1;
    @AopAttribute(key = "nr", type = AopAttributeType.INT)
    public int h = -1;
    @AopAttribute(key = "tr", type = AopAttributeType.INT)
    public int i = -1;
    @AopAttribute(key = "rs", type = AopAttributeType.INT)
    public int k = -1;

    @Override // com.alibaba.wireless.security.aopsdk.e.f.BaseAopConfig
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
        String str = this.j;
        if (str != null) {
            if (UtdidHashUtils.b(str)) {
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
