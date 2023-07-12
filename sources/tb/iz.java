package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iz {
    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = str.length();
        long j = length;
        if (length <= 96) {
            int i = 0;
            while (i < (length & (-4))) {
                j = (j * 67503105) + (str.charAt(i) * 769) + (str.charAt(i + 1) * 513) + (str.charAt(i + 2) * 257) + str.charAt(i + 3);
                i += 4;
            }
            while (i < length) {
                j = (j * 257) + str.charAt(i);
                i++;
            }
        }
        return j + (j << (length & 31));
    }
}
