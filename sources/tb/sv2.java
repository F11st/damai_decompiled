package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class sv2 {
    @NotNull
    public static final byte[] a(@NotNull String[] strArr) {
        int i;
        b41.i(strArr, "strings");
        int i2 = 0;
        for (String str : strArr) {
            i2 += str.length();
        }
        byte[] bArr = new byte[i2];
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str2 = strArr[i3];
            i3++;
            int length2 = str2.length() - 1;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    i = i4 + 1;
                    bArr[i4] = (byte) str2.charAt(i5);
                    if (i5 == length2) {
                        break;
                    }
                    i5 = i6;
                    i4 = i;
                }
                i4 = i;
            }
        }
        return bArr;
    }
}
