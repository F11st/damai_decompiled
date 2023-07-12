package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.C7493a;
import com.vivo.push.util.C7513f;
import com.vivo.push.util.C7523p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.cache.e */
/* loaded from: classes11.dex */
public final class C7449e extends AbstractC7447c<C7493a> {
    public C7449e(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    protected final String a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    public final List<C7493a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(",");
            if (split.length >= 2) {
                try {
                    arrayList.add(new C7493a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e) {
                    C7523p.d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e)));
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.AbstractC7447c
    final String b(String str) throws Exception {
        return new String(C7513f.a(C7513f.a(e()), C7513f.a(f()), Base64.decode(str, 2)), "utf-8");
    }

    public final String c(String str) {
        synchronized (AbstractC7447c.a) {
            for (T t : this.b) {
                if (!TextUtils.isEmpty(t.a()) && t.a().equals(str)) {
                    return t.b();
                }
            }
            return null;
        }
    }
}
