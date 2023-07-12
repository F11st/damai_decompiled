package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class yg1 {
    private static final ConcurrentMap<b13, WeakReference<d42>> a = new ConcurrentHashMap();

    @NotNull
    public static final d42 a(@NotNull Class<?> cls) {
        b41.i(cls, "$this$getOrCreateModule");
        ClassLoader f = ReflectClassUtilKt.f(cls);
        b13 b13Var = new b13(f);
        ConcurrentMap<b13, WeakReference<d42>> concurrentMap = a;
        WeakReference<d42> weakReference = concurrentMap.get(b13Var);
        if (weakReference != null) {
            d42 d42Var = weakReference.get();
            if (d42Var != null) {
                b41.h(d42Var, AdvanceSetting.NETWORK_TYPE);
                return d42Var;
            }
            concurrentMap.remove(b13Var, weakReference);
        }
        d42 a2 = d42.Companion.a(f);
        while (true) {
            try {
                ConcurrentMap<b13, WeakReference<d42>> concurrentMap2 = a;
                WeakReference<d42> putIfAbsent = concurrentMap2.putIfAbsent(b13Var, new WeakReference<>(a2));
                if (putIfAbsent == null) {
                    return a2;
                }
                d42 d42Var2 = putIfAbsent.get();
                if (d42Var2 != null) {
                    return d42Var2;
                }
                concurrentMap2.remove(b13Var, putIfAbsent);
            } finally {
                b13Var.a(null);
            }
        }
    }
}
