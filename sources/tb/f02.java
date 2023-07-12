package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8202e;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class f02 extends k02 implements JavaConstructor {
    @NotNull
    private final Constructor<?> a;

    public f02(@NotNull Constructor<?> constructor) {
        b41.i(constructor, "member");
        this.a = constructor;
    }

    @Override // tb.k02
    @NotNull
    /* renamed from: f */
    public Constructor<?> d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<p02> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = d().getTypeParameters();
        b41.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new p02(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        List<JavaValueParameter> g;
        Type[] genericParameterTypes = d().getGenericParameterTypes();
        b41.h(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            g = C8214m.g();
            return g;
        }
        Class<?> declaringClass = d().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) C8202e.h(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = d().getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                b41.h(parameterAnnotations, "annotations");
                parameterAnnotations = (Annotation[][]) C8202e.h(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            b41.h(genericParameterTypes, "realTypes");
            b41.h(parameterAnnotations, "realAnnotations");
            return e(genericParameterTypes, parameterAnnotations, d().isVarArgs());
        }
        throw new IllegalStateException(b41.r("Illegal generic signature: ", d()));
    }
}
