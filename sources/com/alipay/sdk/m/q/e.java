package com.alipay.sdk.m.q;

import android.content.Context;
import com.alipay.sdk.m.o.a;
import com.youku.usercenter.passport.PassportConfig;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.e
    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, Context context, String str) throws Throwable {
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "mdap post");
        byte[] a = com.alipay.sdk.m.n.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put(PassportConfig.STATISTIC_UTDID, com.alipay.sdk.m.s.b.d().c());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", com.alipay.sdk.m.u.e.b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put(Constants.Protocol.CONTENT_ENCODING, "Gzip");
        hashMap.put("productVersion", "15.8.11");
        a.b a2 = com.alipay.sdk.m.o.a.a(context, new a.C0196a(com.alipay.sdk.m.l.a.d, hashMap, a));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "mdap got " + a2);
        if (a2 != null) {
            boolean a3 = com.alipay.sdk.m.p.e.a(a2);
            try {
                byte[] bArr = a2.c;
                if (a3) {
                    bArr = com.alipay.sdk.m.n.b.b(bArr);
                }
                return new com.alipay.sdk.m.p.b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e) {
                com.alipay.sdk.m.u.e.a(e);
                return null;
            }
        }
        throw new RuntimeException("Response is null");
    }
}
