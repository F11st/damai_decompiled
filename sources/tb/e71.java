package tb;

import java.lang.ref.WeakReference;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e71 {
    private static kotlin.reflect.jvm.internal.pcollections.b<String, Object> a;

    static {
        kotlin.reflect.jvm.internal.pcollections.b<String, Object> b = kotlin.reflect.jvm.internal.pcollections.b.b();
        b41.h(b, "HashPMap.empty<String, Any>()");
        a = b;
    }

    @NotNull
    public static final <T> KClassImpl<T> a(@NotNull Class<T> cls) {
        b41.i(cls, "jClass");
        String name = cls.getName();
        Object c = a.c(name);
        if (c instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) c).get();
            if (b41.d(kClassImpl != null ? kClassImpl.getJClass() : null, cls)) {
                return kClassImpl;
            }
        } else if (c != null) {
            for (WeakReference weakReference : (WeakReference[]) c) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (b41.d(kClassImpl2 != null ? kClassImpl2.getJClass() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) c).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(c, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            kotlin.reflect.jvm.internal.pcollections.b<String, Object> f = a.f(name, weakReferenceArr);
            b41.h(f, "K_CLASS_CACHE.plus(name, newArray)");
            a = f;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        kotlin.reflect.jvm.internal.pcollections.b<String, Object> f2 = a.f(name, new WeakReference(kClassImpl4));
        b41.h(f2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        a = f2;
        return kClassImpl4;
    }
}
