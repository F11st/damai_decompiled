package com.alibaba.security.biometrics.jni;

import com.alibaba.security.biometrics.C3739a;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class VersionKey {
    public static final String FL_SDK_VERSION = "3.3.0";
    public static final String RP_SDK_VERSION = formatVersion(C3739a.g);

    public static String formatVersion(String str) {
        int indexOf;
        if (str != null && (indexOf = str.indexOf("-")) != -1) {
            String substring = str.substring(0, indexOf);
            if (!substring.isEmpty()) {
                return substring;
            }
        }
        return str;
    }
}
