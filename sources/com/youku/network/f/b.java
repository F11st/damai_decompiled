package com.youku.network.f;

import android.text.TextUtils;
import java.net.URI;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str.replaceFirst(URI.create(str).getHost(), str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
