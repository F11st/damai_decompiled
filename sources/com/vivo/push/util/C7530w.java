package com.vivo.push.util;

import android.content.Context;
import tb.km1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.w */
/* loaded from: classes11.dex */
public final class C7530w extends C7509b {
    private static C7530w b;

    public static synchronized C7530w b() {
        C7530w c7530w;
        synchronized (C7530w.class) {
            if (b == null) {
                b = new C7530w();
            }
            c7530w = b;
        }
        return c7530w;
    }

    public final synchronized void a(Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c == null || c.length <= 0) ? new byte[]{km1.OP_CREATE_ARRAY, 32, km1.OP_CREATE_JSON, km1.OP_UNARY_MIN, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_JSON, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_CALL_DX_PARSER, km1.OP_INSERT_VALUE, 32, 32, 32} : c;
    }

    public final byte[] d() {
        byte[] c = c(b("com.vivo.push.secure_cache_key", ""));
        return (c == null || c.length <= 0) ? new byte[]{km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, 32, km1.OP_GOTO, km1.OP_UNARY_MIN, km1.OP_INSERT_KVPAIR, km1.OP_INSERT_VALUE, km1.OP_CREATE_ARRAY, km1.OP_CREATE_JSON} : c;
    }

    private static byte[] c(String str) {
        int i;
        byte[] bArr = null;
        try {
            String[] split = str.split(",");
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = Byte.parseByte(split[i2].trim());
            }
        } catch (Exception e) {
            C7523p.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr;
    }
}
