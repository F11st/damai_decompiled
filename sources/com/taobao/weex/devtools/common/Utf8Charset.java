package com.taobao.weex.devtools.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Utf8Charset {
    public static final Charset INSTANCE = Charset.forName("UTF-8");
    public static final String NAME = "UTF-8";

    public static String decodeUTF8(byte[] bArr) {
        return new String(bArr, INSTANCE);
    }

    public static byte[] encodeUTF8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
