package tb;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ch1 {
    @NotNull
    public static final ch1 INSTANCE = new ch1();
    @NotNull
    private static final C9006a a = new C9006a(null, null, null);
    @Nullable
    private static C9006a b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.ch1$a */
    /* loaded from: classes3.dex */
    public static final class C9006a {
        @JvmField
        @Nullable
        public final Method a;
        @JvmField
        @Nullable
        public final Method b;
        @JvmField
        @Nullable
        public final Method c;

        public C9006a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private ch1() {
    }

    private final C9006a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            C9006a c9006a = new C9006a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            b = c9006a;
            return c9006a;
        } catch (Exception unused) {
            C9006a c9006a2 = a;
            b = c9006a2;
            return c9006a2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl baseContinuationImpl) {
        b41.i(baseContinuationImpl, "continuation");
        C9006a c9006a = b;
        if (c9006a == null) {
            c9006a = a(baseContinuationImpl);
        }
        if (c9006a == a) {
            return null;
        }
        Method method = c9006a.a;
        Object invoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = c9006a.b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = c9006a.c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
