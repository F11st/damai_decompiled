package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class hd2 implements ModuleClassResolver {
    public d51 a;

    @NotNull
    public final d51 a() {
        d51 d51Var = this.a;
        if (d51Var != null) {
            return d51Var;
        }
        b41.A("resolver");
        return null;
    }

    public final void b(@NotNull d51 d51Var) {
        b41.i(d51Var, "<set-?>");
        this.a = d51Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    @Nullable
    public ClassDescriptor resolveClass(@NotNull JavaClass javaClass) {
        b41.i(javaClass, "javaClass");
        return a().b(javaClass);
    }
}
