package tb;

import java.util.Collection;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public final class mp1 implements ClassBasedDeclarationContainer {
    @NotNull
    private final Class<?> a;

    public mp1(@NotNull Class<?> cls, @NotNull String str) {
        b41.i(cls, "jClass");
        b41.i(str, "moduleName");
        this.a = cls;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof mp1) && b41.d(getJClass(), ((mp1) obj).getJClass());
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    @NotNull
    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
