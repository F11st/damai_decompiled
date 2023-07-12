package com.alipay.sdk.m.q;

import android.content.Context;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.n.C4251b;
import com.alipay.sdk.m.o.C4261a;
import com.alipay.sdk.m.p.AbstractC4271e;
import com.alipay.sdk.m.p.C4268b;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.u.C4302e;
import com.youku.usercenter.passport.PassportConfig;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.network.util.Constants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.q.e */
/* loaded from: classes10.dex */
public class C4282e extends AbstractC4271e {
    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public String a(C4293a c4293a, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public Map<String, String> a(boolean z, String str) {
        return new HashMap();
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public JSONObject a() {
        return null;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.p.AbstractC4271e
    public C4268b a(C4293a c4293a, Context context, String str) throws Throwable {
        C4302e.d(C4230a.z, "mdap post");
        byte[] a = C4251b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put(PassportConfig.STATISTIC_UTDID, C4295b.d().c());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", C4302e.b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put(Constants.Protocol.CONTENT_ENCODING, "Gzip");
        hashMap.put("productVersion", "15.8.11");
        C4261a.C4263b a2 = C4261a.a(context, new C4261a.C4262a(C4230a.d, hashMap, a));
        C4302e.d(C4230a.z, "mdap got " + a2);
        if (a2 != null) {
            boolean a3 = AbstractC4271e.a(a2);
            try {
                byte[] bArr = a2.c;
                if (a3) {
                    bArr = C4251b.b(bArr);
                }
                return new C4268b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e) {
                C4302e.a(e);
                return null;
            }
        }
        throw new RuntimeException("Response is null");
    }
}
