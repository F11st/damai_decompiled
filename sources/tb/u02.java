package tb;

import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class u02 implements KotlinClassFinder {
    @NotNull
    private final ClassLoader a;
    @NotNull
    private final ee b;

    public u02(@NotNull ClassLoader classLoader) {
        b41.i(classLoader, "classLoader");
        this.a = classLoader;
        this.b = new ee();
    }

    private final KotlinClassFinder.AbstractC8373a a(String str) {
        t02 a;
        Class<?> a2 = c02.a(this.a, str);
        if (a2 == null || (a = t02.Factory.a(a2)) == null) {
            return null;
        }
        return new KotlinClassFinder.AbstractC8373a.C8375b(a, null, 2, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder
    @Nullable
    public InputStream findBuiltInsData(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "packageFqName");
        if (hp0Var.i(C8277c.BUILT_INS_PACKAGE_NAME)) {
            return this.b.a(C8906ae.INSTANCE.n(hp0Var));
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.AbstractC8373a findKotlinClassOrContent(@NotNull hj hjVar) {
        String b;
        b41.i(hjVar, "classId");
        b = v02.b(hjVar);
        return a(b);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder
    @Nullable
    public KotlinClassFinder.AbstractC8373a findKotlinClassOrContent(@NotNull JavaClass javaClass) {
        b41.i(javaClass, "javaClass");
        hp0 fqName = javaClass.getFqName();
        String b = fqName == null ? null : fqName.b();
        if (b == null) {
            return null;
        }
        return a(b);
    }
}
