package org.apache.commons.net.util;

import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Charsets {
    public static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    public static Charset toCharset(String str, String str2) {
        return str == null ? Charset.forName(str2) : Charset.forName(str);
    }
}
