package tb;

import android.text.TextUtils;
import com.taobao.android.sopatch.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bk2 {
    private static final ke2 a = new ke2();

    public static void a(String str) {
        if (!jj2.a(Constants.NEED_SO_PATCH, false) || TextUtils.isEmpty(str)) {
            return;
        }
        a.b(str);
    }
}
