package com.youku.network.a;

import android.text.TextUtils;
import com.youku.httpcommunication.C7926c;

/* compiled from: Taobao */
/* renamed from: com.youku.network.a.a */
/* loaded from: classes3.dex */
public abstract class AbstractC7975a<I, O> implements InterfaceC7976b<I, O> {
    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return C7926c.d(str);
            }
        }
        return str;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(";");
        for (int i = 0; i != split.length; i++) {
            split[i] = b(split[i]);
        }
        return TextUtils.join(";", split);
    }
}
