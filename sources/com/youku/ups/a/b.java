package com.youku.ups.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.BitSet;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class b {
    private static final BitSet a = new BitSet(256);

    static {
        for (int i = 97; i <= 122; i++) {
            a.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            a.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            a.set(i3);
        }
        BitSet bitSet = a;
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        bitSet.set(42);
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        if (!TextUtils.isEmpty(str2)) {
            if (a(str2)) {
                sb.append(str2);
            } else {
                sb.append(b(str2));
            }
        }
        sb.append("&");
    }

    private static boolean a(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F');
    }

    public static boolean a(String str) {
        boolean z = false;
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!a.get(charAt)) {
                if (charAt == '%' && i + 2 < str.length()) {
                    int i2 = i + 1;
                    char charAt2 = str.charAt(i2);
                    i = i2 + 1;
                    char charAt3 = str.charAt(i);
                    if (a(charAt2) && a(charAt3)) {
                    }
                }
                z = true;
                break;
            }
            i++;
        }
        return !z;
    }

    public static String b(String str) {
        if (str != null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static String c(String str) {
        if (str != null) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }
}
