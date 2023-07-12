package tb;

import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class gw2 {
    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
