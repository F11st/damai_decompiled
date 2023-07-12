package tb;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class hc1 {
    private static final hc1 b = new hc1();
    private final LruCache<String, com.airbnb.lottie.a> a = new LruCache<>(20);

    @VisibleForTesting
    hc1() {
    }

    public static hc1 b() {
        return b;
    }

    @Nullable
    public com.airbnb.lottie.a a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void c(@Nullable String str, com.airbnb.lottie.a aVar) {
        if (str == null) {
            return;
        }
        this.a.put(str, aVar);
    }
}
