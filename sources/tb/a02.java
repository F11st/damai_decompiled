package tb;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import org.jetbrains.annotations.NotNull;
import tb.o02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a02 extends o02 implements JavaArrayType {
    @NotNull
    private final Type a;
    @NotNull
    private final o02 b;
    @NotNull
    private final Collection<JavaAnnotation> c;
    private final boolean d;

    public a02(@NotNull Type type) {
        o02 a;
        List g;
        b41.i(type, "reflectType");
        this.a = type;
        Type a2 = a();
        if (!(a2 instanceof GenericArrayType)) {
            if (a2 instanceof Class) {
                Class cls = (Class) a2;
                if (cls.isArray()) {
                    o02.C9490a c9490a = o02.Factory;
                    Class<?> componentType = cls.getComponentType();
                    b41.h(componentType, "getComponentType()");
                    a = c9490a.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + a().getClass() + "): " + a());
        }
        o02.C9490a c9490a2 = o02.Factory;
        Type genericComponentType = ((GenericArrayType) a2).getGenericComponentType();
        b41.h(genericComponentType, "genericComponentType");
        a = c9490a2.a(genericComponentType);
        this.b = a;
        g = C8214m.g();
        this.c = g;
    }

    @Override // tb.o02
    @NotNull
    protected Type a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    @NotNull
    /* renamed from: b */
    public o02 getComponentType() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.d;
    }
}
