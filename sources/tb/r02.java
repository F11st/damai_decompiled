package tb;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import kotlin.collections.C8202e;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class r02 extends o02 implements JavaWildcardType {
    @NotNull
    private final WildcardType a;
    @NotNull
    private final Collection<JavaAnnotation> b;
    private final boolean c;

    public r02(@NotNull WildcardType wildcardType) {
        List g;
        b41.i(wildcardType, "reflectType");
        this.a = wildcardType;
        g = C8214m.g();
        this.b = g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    @Nullable
    /* renamed from: b */
    public o02 getBound() {
        Type[] upperBounds = a().getUpperBounds();
        Type[] lowerBounds = a().getLowerBounds();
        if (upperBounds.length <= 1 && lowerBounds.length <= 1) {
            if (lowerBounds.length == 1) {
                o02.C9490a c9490a = o02.Factory;
                b41.h(lowerBounds, "lowerBounds");
                Object L = C8202e.L(lowerBounds);
                b41.h(L, "lowerBounds.single()");
                return c9490a.a((Type) L);
            } else if (upperBounds.length == 1) {
                b41.h(upperBounds, "upperBounds");
                Type type = (Type) C8202e.L(upperBounds);
                if (b41.d(type, Object.class)) {
                    return null;
                }
                o02.C9490a c9490a2 = o02.Factory;
                b41.h(type, "ub");
                return c9490a2.a(type);
            } else {
                return null;
            }
        }
        throw new UnsupportedOperationException(b41.r("Wildcard types with many bounds are not yet supported: ", a()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tb.o02
    @NotNull
    /* renamed from: c */
    public WildcardType a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] upperBounds = a().getUpperBounds();
        b41.h(upperBounds, "reflectType.upperBounds");
        return !b41.d(C8202e.v(upperBounds), Object.class);
    }
}
