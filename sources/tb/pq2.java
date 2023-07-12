package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class pq2 {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }
}
