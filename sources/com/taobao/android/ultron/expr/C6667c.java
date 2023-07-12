package com.taobao.android.ultron.expr;

import java.util.StringTokenizer;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.ultron.expr.c */
/* loaded from: classes12.dex */
public class C6667c {
    public static Object a(Object obj, String str) {
        Object obj2 = null;
        if (obj != null && str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ${.[]}", true);
            boolean z = false;
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.length() == 1) {
                    char charAt = nextToken.charAt(0);
                    if ('$' != charAt) {
                        if (' ' != charAt && '[' != charAt && ']' != charAt && '{' != charAt && '.' != charAt) {
                            if ('}' == charAt) {
                                break;
                            }
                        }
                    } else {
                        z = true;
                        obj2 = obj;
                    }
                }
                if (z) {
                    obj2 = C6670f.a(obj2, nextToken);
                }
            }
        }
        return obj2;
    }
}
