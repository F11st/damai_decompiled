package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.m.e.C4178e;
import com.alipay.sdk.m.u.C4316l;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.a.d */
/* loaded from: classes10.dex */
public final class C4062d extends AbstractC4059a {
    public C4062d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.InterfaceC4061c
    public final Object a() {
        try {
            String str = new String(this.b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt(C4316l.a);
            if (i == 1000) {
                return this.a == String.class ? jSONObject.optString("result") : C4178e.a(jSONObject.optString("result"), this.a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("response  =");
            sb.append(new String(this.b));
            sb.append(":");
            sb.append(e);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e.getMessage());
        }
    }
}
