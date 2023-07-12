package tb;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b02 implements JavaClassFinder {
    @NotNull
    private final ClassLoader a;

    public b02(@NotNull ClassLoader classLoader) {
        b41.i(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public JavaClass findClass(@NotNull JavaClassFinder.a aVar) {
        String y;
        b41.i(aVar, "request");
        hj a = aVar.a();
        hp0 h = a.h();
        b41.h(h, "classId.packageFqName");
        String b = a.i().b();
        b41.h(b, "classId.relativeClassName.asString()");
        y = kotlin.text.o.y(b, '.', '$', false, 4, null);
        if (!h.d()) {
            y = h.b() + '.' + y;
        }
        Class<?> a2 = c02.a(this.a, y);
        if (a2 != null) {
            return new ReflectJavaClass(a2);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public JavaPackage findPackage(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return new m02(hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder
    @Nullable
    public Set<String> knownClassNamesInPackage(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "packageFqName");
        return null;
    }
}
