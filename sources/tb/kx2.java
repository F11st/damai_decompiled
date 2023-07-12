package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class kx2 {
    private static int a(String str, String str2) {
        int c = c(str);
        int c2 = c(str2);
        if (c > c2) {
            return 1;
        }
        return c < c2 ? -1 : 0;
    }

    public static boolean b(String str, String str2) {
        return -1 != a(str, str2);
    }

    private static int c(String str) {
        try {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                int length = split.length;
                int[] iArr = new int[length];
                for (int i = 0; i < split.length; i++) {
                    if (!TextUtils.isEmpty(split[i])) {
                        iArr[i] = Integer.parseInt(split[i]);
                    } else {
                        iArr[i] = 0;
                    }
                }
                int i2 = 1000000;
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    try {
                        i3 += iArr[i4] * i2;
                        i2 /= 100;
                    } catch (Exception unused) {
                    }
                }
                return i3;
            }
            return 0;
        } catch (Exception unused2) {
            return 0;
        }
    }
}
