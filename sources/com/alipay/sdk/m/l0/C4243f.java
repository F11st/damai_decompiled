package com.alipay.sdk.m.l0;

import java.util.regex.Pattern;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.l0.f */
/* loaded from: classes12.dex */
public class C4243f {
    public static final Pattern a = Pattern.compile("([\t\r\n])+");

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m215a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str.length() > 0) {
            int i = 0;
            for (char c : str.toCharArray()) {
                i = (i * 31) + c;
            }
            return i;
        }
        return 0;
    }
}
