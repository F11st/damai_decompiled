package com.taobao.accs.utl;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Base62Utils {
    private static final int BASE = 62;
    private static final String digitsChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encode(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0 || i == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (j != 0) {
            int i2 = BASE;
            sb.append(digitsChar.charAt((int) (j % i2)));
            j /= i2;
        }
        return sb.reverse().toString();
    }
}
