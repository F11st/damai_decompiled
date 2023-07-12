package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.vivo.push.model.C7493a;
import com.vivo.push.util.C7513f;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7533z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.cache.a */
/* loaded from: classes11.dex */
public final class C7445a extends AbstractC7447c<C7493a> {
    public C7445a(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    protected final String a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    public final List<C7493a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split("@#")) {
                String trim = str2.trim();
                String[] split = trim.trim().split(",");
                if (split.length >= 2) {
                    try {
                        arrayList.add(new C7493a(split[0], trim.substring(split[0].length() + 1)));
                    } catch (Exception e) {
                        C7523p.d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(e)));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    final String b(String str) throws Exception {
        return new String(C7513f.a(C7513f.a(e()), C7513f.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final C7493a c(String str) {
        synchronized (AbstractC7447c.a) {
            for (T t : this.b) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }

    public final int b() {
        C7493a c = c("push_mode");
        if (c != null && !TextUtils.isEmpty(c.b())) {
            try {
                return Integer.parseInt(c.b());
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public static boolean a(int i) {
        if (i != -1) {
            return (i & 1) != 0;
        }
        return C7533z.b("persist.sys.log.ctrl", "no").equals(BQCCameraParam.VALUE_YES);
    }
}
