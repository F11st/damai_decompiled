package com.youku.network.a;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a<I, O> implements b<I, O> {
    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return com.youku.httpcommunication.c.d(str);
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
