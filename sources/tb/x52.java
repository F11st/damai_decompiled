package tb;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x52 {
    private static final List<String> a = new ArrayList();

    public static void a() {
        a.clear();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && a.contains(str);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a.add(str);
    }
}
