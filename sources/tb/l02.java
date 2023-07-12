package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o02;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class l02 extends k02 implements JavaMethod {
    @NotNull
    private final Method a;

    public l02(@NotNull Method method) {
        b41.i(method, "member");
        this.a = method;
    }

    @Override // tb.k02
    @NotNull
    /* renamed from: f */
    public Method d() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    @NotNull
    /* renamed from: g */
    public o02 getReturnType() {
        o02.a aVar = o02.Factory;
        Type genericReturnType = d().getGenericReturnType();
        b41.h(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    @Nullable
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = d().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return wz1.Factory.a(defaultValue, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    @NotNull
    public List<p02> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = d().getTypeParameters();
        b41.h(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new p02(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = d().getGenericParameterTypes();
        b41.h(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = d().getParameterAnnotations();
        b41.h(parameterAnnotations, "member.parameterAnnotations");
        return e(genericParameterTypes, parameterAnnotations, d().isVarArgs());
    }
}
