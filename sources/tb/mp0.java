package tb;

import androidx.fragment.app.Fragment;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mp0 {
    public static String a(Fragment fragment) {
        return fragment == null ? "" : fragment.getClass().getName();
    }

    public static String b(Fragment fragment) {
        return fragment == null ? "" : fragment.getClass().getSimpleName();
    }
}
