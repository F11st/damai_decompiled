package tb;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n02 extends o02 implements JavaPrimitiveType {
    @NotNull
    private final Class<?> a;
    @NotNull
    private final Collection<JavaAnnotation> b;
    private final boolean c;

    public n02(@NotNull Class<?> cls) {
        List g;
        b41.i(cls, "reflectType");
        this.a = cls;
        g = kotlin.collections.m.g();
        this.b = g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.o02
    @NotNull
    /* renamed from: b */
    public Class<?> a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType
    @Nullable
    public PrimitiveType getType() {
        if (b41.d(a(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(a().getName()).getPrimitiveType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.c;
    }
}
