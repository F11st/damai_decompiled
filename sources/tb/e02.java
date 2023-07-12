package tb;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e02 extends o02 implements JavaClassifierType {
    @NotNull
    private final Type a;
    @NotNull
    private final JavaClassifier b;

    public e02(@NotNull Type type) {
        JavaClassifier reflectJavaClass;
        b41.i(type, "reflectType");
        this.a = type;
        Type a = a();
        if (a instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) a);
        } else if (a instanceof TypeVariable) {
            reflectJavaClass = new p02((TypeVariable) a);
        } else if (!(a instanceof ParameterizedType)) {
            throw new IllegalStateException("Not a classifier type (" + a.getClass() + "): " + a);
        } else {
            Type rawType = ((ParameterizedType) a).getRawType();
            Objects.requireNonNull(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.b = reflectJavaClass;
    }

    @Override // tb.o02
    @NotNull
    public Type a() {
        return this.a;
    }

    @Override // tb.o02, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        List g;
        g = kotlin.collections.m.g();
        return g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public JavaClassifier getClassifier() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(b41.r("Type not found: ", a()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public String getPresentableText() {
        return a().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    @NotNull
    public List<JavaType> getTypeArguments() {
        int q;
        List<Type> d = ReflectClassUtilKt.d(a());
        o02.a aVar = o02.Factory;
        q = kotlin.collections.n.q(d, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Type type : d) {
            arrayList.add(aVar.a(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type a = a();
        if (a instanceof Class) {
            TypeVariable[] typeParameters = ((Class) a).getTypeParameters();
            b41.h(typeParameters, "getTypeParameters()");
            return (typeParameters.length == 0) ^ true;
        }
        return false;
    }
}
