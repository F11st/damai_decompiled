package com.alipay.sdk.m.p;

import android.text.TextUtils;
import com.alipay.sdk.m.u.C4302e;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.p.b */
/* loaded from: classes12.dex */
public final class C4268b {
    public final String a;
    public final String b;

    public C4268b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new JSONObject(this.b);
        } catch (Exception e) {
            C4302e.a(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.a, this.b);
    }
}
