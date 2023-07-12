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
    private static final a a = new a(null, null, null);
    @Nullable
    private static a b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @JvmField
        @Nullable
        public final Method a;
        @JvmField
        @Nullable
        public final Method b;
        @JvmField
        @Nullable
        public final Method c;

        public a(@Nullable Method method, @Nullable Method method2, @Nullable Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    private ch1() {
    }

    private final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = a;
            b = aVar2;
            return aVar2;
        }
    }

    @Nullable
    public final String b(@NotNull BaseContinuationImpl baseContinuationImpl) {
        b41.i(baseContinuationImpl, "continuation");
        a aVar = b;
        if (aVar == null) {
            aVar = a(baseContinuationImpl);
        }
        if (aVar == a) {
            return null;
        }
        Method method = aVar.a;
        Object invoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
